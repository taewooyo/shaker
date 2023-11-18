<h1 align="center">Shaker</h1></br>

<p align="center">
👋 Modifier's optimally created rotation, translation, and zoom animations are fully customizable for Android. Only Jetpack Compose is supported. 🫨
</p>

<p align="center">
<img src="https://github.com/taewooyo/shaker/assets/66770613/b41e7ab8-6a65-45d4-99a0-652a0940946a" width="280"/>
</p>


## Shaker in Jetpack Compose

If you want to use Shaker in your Jetpack Compose project, check out the **[Shaker in Jetpack Compose](https://github.com/taewooyo/Shaker#shaker-in-jetpack-compose-1)** guidelines.

## How to Use

Shaker supports Kotlin projects, so you can reference it by your language.  

All you need to do is call the composable function rememberShaker, throw ShakerConfiguration data through the shaker function to determine which action to use, and pass it as an argument to the shaker in the Modifier.

```kotlin
val shakeState = rememberShakerState()
Box(
  modifier = Modifier
    .shaker(shakeState)
    .padding(15.dp)
    .clip(RoundedCornerShape(30.dp))
    .clickable {
      shakeState.shaker(
        ShakerConfiguration(
          iterations = 1,
          stiffness = 400f,
          translateX = 50f,
          translateY = -50f,
        ),
      )
    },
  contentAlignment = Alignment.Center,
) {
  Text(text = "Example Button", color = Color.White)
}
```

## Shaker in Jetpack Compose

Shaker allows you to display scale, rotate, translate animation in Jetpack Compose easily.

![Maven Central Badge](https://img.shields.io/maven-central/v/io.github.taewooyo/shaker)

Add the dependency below to your **module**'s `build.gradle` file

```build.gradle
dependencies {
    implementation "io.github.taewooyo:shaker:${version}"
}
```

### Shaker Configuration

Shaker Configuration allows you to set the number of repetitions, rotation angle, direction of rotation, direction of movement, enlargement, reduction, and intensity.  

```kotlin
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
```


# License

```xml
Copyright 2023 taewooyo

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
