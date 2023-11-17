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

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
public fun rememberShakerState(): ShakerState = remember { ShakerState() }

public class ShakerState {
  public var shakerConfiguration: ShakerConfiguration? by mutableStateOf(null)
    private set

  public fun shaker(shakeConfiguration: ShakerConfiguration) {
    this.shakerConfiguration = shakeConfiguration
  }
}
