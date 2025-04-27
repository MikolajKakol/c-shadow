# c-shadow
[![](https://img.shields.io/badge/Kotlin-Multiplatform-%237f52ff?logo=kotlin)](https://kotlinlang.org/docs/multiplatform.html)
[![](https://img.shields.io/maven-central/v/dev.mikkak.c-shadow/c-shadow)](https://mvnrepository.com/artifact/dev.mikkak.c-shadow/c-shadow)
[![](https://img.shields.io/github/license/MikolajKakol/c-shadow)](https://github.com/MikolajKakol/c-shadow/blob/main/LICENSE)

![](https://github.com/MikolajKakol/c-shadow/blob/main/sample/peak.png)

## What is c-shadow?

Is it `compose shadow`, `css shadow`, or `see shadow`? Pick your favorite! Aim of this library is to:
* fill the gap with missing shadow feature that should be part of the compose framework
* allow to implement shadows the way that UI designers are used to create for web or iOS
* provide a way to add concave shadows, as elevation only allows convex shadows

Hopefully one day this library will be obsolete and [issue](https://issuetracker.google.com/issues/160665122) will be resolved.

## Compose multiplatform!

Yey, it's compatible. Right now you can use it on Android, iOS, Desktop.

## Why minSdk 28

Unfortunately, the `BlurMaskFilter` doesn't work with hardware acceleration on Android versions below 28. Using software layer is a mess and doesn't work well. Hopefully it is not an obstacle in 2023.

#### [Made by Mikołaj Kąkol 🚀](http://mikolaj-kakol.me/)
