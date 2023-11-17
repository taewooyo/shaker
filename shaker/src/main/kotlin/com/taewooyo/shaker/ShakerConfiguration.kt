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

public data class ShakerConfiguration(
  val iterations: Int = 0,
  val stiffness: Float = 100_000f,
  val rotate: Float = 0f,
  val rotateX: Float = 0f,
  val rotateY: Float = 0f,
  val scaleX: Float = 0f,
  val scaleY: Float = 0f,
  val translateX: Float = 0f,
  val translateY: Float = 0f,
  val trigger: Long = System.currentTimeMillis(),
)
