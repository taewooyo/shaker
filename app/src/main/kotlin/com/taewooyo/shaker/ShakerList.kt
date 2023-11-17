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

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

val color1 = Color(0xFF009688)
val color2 = Color(0xFF4CAF50)

@Composable
internal fun ShakerList() {
  Column(
    modifier = Modifier
      .padding(vertical = 20.dp, horizontal = 20.dp),
    verticalArrangement = Arrangement.Center,
  ) {
    ShakerButton(
      gradientColors = listOf(color1, color2),
      onClick = { shakeState ->
        shakeState.shaker(
          ShakerConfiguration(
            iterations = 1,
            scaleX = -0.2f,
            scaleY = -0.2f,
            stiffness = 200f,
          ),
        )
      },
    )
    ShakerButton(
      gradientColors = listOf(color1, color2),
      onClick = { shakeState ->
        shakeState.shaker(
          ShakerConfiguration(
            iterations = 4,
            stiffness = 2_000f,
            rotateY = 15f,
            translateX = 40f,
          ),
        )
      },
    )
    ShakerButton(
      gradientColors = listOf(color1, color2),
      onClick = { shakeState ->
        shakeState.shaker(
          ShakerConfiguration(
            iterations = 4,
            stiffness = 1_000f,
            rotateX = -20f,
            translateY = 20f,
          ),
        )
      },
    )
    ShakerButton(
      gradientColors = listOf(color1, color2),
      onClick = { shakeState ->
        shakeState.shaker(
          ShakerConfiguration(
            iterations = 3,
            stiffness = 1_000f,
            rotate = 15f,
            rotateX = 20f,
          ),
        )
      },
    )
    ShakerButton(
      gradientColors = listOf(color1, color2),
      onClick = { shakeState ->
        shakeState.shaker(
          ShakerConfiguration(
            iterations = 1,
            stiffness = 400f,
            scaleX = 2f,
            scaleY = 2f,
          ),
        )
      },
    )
    ShakerButton(
      gradientColors = listOf(color1, color2),
      onClick = { shakeState ->
        shakeState.shaker(
          ShakerConfiguration(
            iterations = 1,
            stiffness = 400f,
            rotate = 360f,
          ),
        )
      },
    )
    ShakerButton(
      gradientColors = listOf(color1, color2),
      onClick = { shakeState ->
        shakeState.shaker(
          ShakerConfiguration(
            iterations = 1,
            stiffness = 400f,
            translateX = 1000f,
          ),
        )
      },
    )
    ShakerButton(
      gradientColors = listOf(color1, color2),
      onClick = { shakeState ->
        shakeState.shaker(
          ShakerConfiguration(
            iterations = 1,
            stiffness = 400f,
            translateX = 50f,
            translateY = -50f,
          ),
        )
      },
    )
  }
}

@Composable
private fun ShakerButton(
  gradientColors: List<Color>,
  onClick: (ShakerState) -> Unit,
) {
  val shakeState = rememberShakerState()
  Box(
    modifier = Modifier
      .shaker(shakeState)
      .padding(15.dp)
      .clip(RoundedCornerShape(30.dp))
      .clickable { onClick(shakeState) },
    contentAlignment = Alignment.Center,
  ) {
    Column(
      modifier = Modifier
        .clip(RoundedCornerShape(30.dp))
        .background(Brush.horizontalGradient(colors = gradientColors))
        .padding(horizontal = 24.dp, vertical = 12.dp),
    ) {
      Text(text = "Example Button", color = Color.White)
    }
  }
}
