/*
* Copyright (C) 2023 taewooyo
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
* http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package com.taewooyo.shaker

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.IntOffset
import kotlin.math.roundToInt

private fun Int.isEven(): Boolean = (this % 2 == 0)

public fun Modifier.shaker(shakerState: ShakerState): Modifier = composed {
  shakerState.shakerConfiguration?.let { configuration ->
    val shake = remember { Animatable(0f) }

    LaunchedEffect(shakerState.shakerConfiguration) {
      repeat(configuration.iterations) { index ->
        if (index.isEven()) {
          shake.animateTo(1f, spring(stiffness = configuration.stiffness))
        } else {
          shake.animateTo(-1f, spring(stiffness = configuration.stiffness))
        }
      }
      shake.animateTo(0f)
    }

    this
      .rotate(shake.value * configuration.rotate)
      .graphicsLayer {
        rotationX = shake.value * configuration.rotateX
        rotationY = shake.value * configuration.rotateY
      }
      .scale(
        scaleX = 1f + (shake.value * configuration.scaleX),
        scaleY = 1f + (shake.value * configuration.scaleY),
      )
      .offset {
        IntOffset(
          (shake.value * configuration.translateX).roundToInt(),
          (shake.value * configuration.translateY).roundToInt(),
        )
      }
  } ?: this@shaker
}
