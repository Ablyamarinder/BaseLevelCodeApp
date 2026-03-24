# BaseLevelCodeApp
This is a Repository which contains a base level code to start a new app. It includes - MVVM, Clean Architecture, Compose and XML support, Hilt, Room DB, Data Store, Flow API, Basic Network setup and some generic utilities


 <img src="images/logo.png" alt="ArchiTecture logo"/>


The goal of this Template is to be our starting point for new projects, following the best development practices. It's our interpretation and adaptation of the official [architecture](https://developer.android.com/topic/architecture) guidelines provided by Google. And it's inspired by Google's [NowInAndroid](https://github.com/android/nowinandroid).

## Clean architecture with 3 main modules
- Data (for database, API and preferences code)
- Domain (for business logic and models)
- AndroidApp (for UI logic, with MVVM)

 <img src="images/AndroidTemplate-CleanArchitecture.jpg" alt="ArchiTecture logo"/>



## Other useful features
- This version brings [Modularization](https://developer.android.com/topic/modularization)
- Version Management (with [Version catalog](https://docs.gradle.org/current/userguide/platforms.html))
- Shared Build Logic (with [Convention plugins](https://docs.gradle.org/current/samples/sample_convention_plugins.html))