plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.room)
    alias(libs.plugins.ksp)
    alias(libs.plugins.kotlin.hilt)
    alias(libs.plugins.kotlin.android)
}

android {
    compileSdk = 36
    namespace = "com.google.samples.apps.nowinandroid.core.database"
    room {
        // Specifies the directory for Room schema files.
        // The path uses $projectDir to reference the root directory of your project.
        schemaDirectory("$projectDir/schemas")
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlin {
        jvmToolchain(17)
    }
}

dependencies {
    api(libs.androidx.room.ktx)
    implementation(libs.hilt.android)
    ksp(libs.hilt.android.compiler)
    ksp(libs.androidx.room.compiler)
    api(libs.kotlinx.datetime)
}
