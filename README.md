# BaseLevelCodeApp

<img src="images/logo.png" alt="ArchiTecture logo"/>

The goal of this Template is to be our starting point for new projects, following the best
development practices. It's our interpretation and adaptation of the
official [architecture](https://developer.android.com/topic/architecture) guidelines provided by
Google.

## Clean architecture with 3 main modules

- Data (for database, API and preferences code)
- Domain (for business logic and models)
- AndroidApp (for UI logic, with MVVM)

 <img src="images/AndroidTemplate-CleanArchitecture.jpg" alt="ArchiTecture logo"/>

## Other useful features

- This version brings [Modularization](https://developer.android.com/topic/modularization)
- Shared Build Logic (
  with [Convention plugins](https://docs.gradle.org/current/samples/sample_convention_plugins.html))
- Dependency injection (with [Hilt](http://google.github.io/hilt/))
- Network calls (with [Ktor](https://ktor.io/docs/http-client-engines.html#minimal-version))
- Reactive programming (
  with [Kotlin Flows](https://kotlinlang.org/docs/reference/coroutines/flow.html))
- Android architecture components to share ViewModels during configuration changes
- [Splash Screen](https://developer.android.com/develop/ui/views/launch/splash-screen) Support
- Google [Material Design](https://material.io/blog/android-material-theme-color) library
- Declarative UI (with [Jetpack Compose](https://developer.android.com/jetpack/compose))
    - Compose Navigation (
      with [Hilt Support](https://developer.android.com/jetpack/compose/libraries#hilt-navigation)
      and Assisted Inject Example)
- Edge To Edge Configuration

# Getting started

1. Download this repository extract and open on Android Studio
2. Rename the app package
3. Check if the manifest package was renamed along with the package
4. On `androidApp/build.gradle`, change the applicationId to the new app package
5. On `androidApp/build.gradle`, update the dependencies Android Studio suggests
6. On `string.xml`, set your application name
7. On `Theme.kt` & `Color.kt` set your application style
8. Replace the App Icons
9. Delete unwanted example files - files under `package com.example.newsampleapp.ui.posts`,
   `class files under domain package`, `DummyDao, Mapper and PostModel in data package`. Or you can
   replace them with your code.
10. Clean up code after removing files
11. Run `./gradlew dependencyUpdates` and check for dependencies
12. Ready to Use

And you're ready to start working on your new app.