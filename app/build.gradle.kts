plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlin.plugin.compose")
    id("org.jetbrains.kotlin.plugin.serialization")
}

android {
    namespace = "com.example.fridgeapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.fridgeapp"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        buildConfigField("String", "FOOD_BASE_URL", "\"https://apis.data.go.kr/1471000/FoodNtrCpntDbInfo01/\"")
        buildConfigField("String", "FOOD_API_KEY", "\"${project.properties["FOOD_API_KEY_ENC"] ?: ""}\"")
        buildConfigField("String", "YOUTUBE_BASE_URL", "\"https://www.googleapis.com/youtube/v3/\"")
        buildConfigField("String", "YOUTUBE_API_KEY", "\"${project.properties["YOUTUBE_API_KEY"] ?: ""}\"")
    }

    buildFeatures {
        compose = true
        buildConfig = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.6.11"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("com.google.android.material:material:1.12.0")


    implementation("androidx.activity:activity-compose:1.9.2")
    implementation("androidx.compose.ui:ui:1.6.11")
    implementation("androidx.compose.ui:ui-tooling-preview:1.6.11")
    debugImplementation("androidx.compose.ui:ui-tooling:1.6.11")
    implementation("androidx.compose.material3:material3:1.3.0")
    implementation("androidx.compose.foundation:foundation:1.6.11")
    implementation("androidx.lifecycle:lifecycle-runtime-compose:2.8.4")

    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.7.3")


    implementation("com.squareup.retrofit2:retrofit:2.11.0")
    implementation("com.squareup.okhttp3:okhttp:4.12.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.12.0")
    implementation("com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:1.0.0")

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.2.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")
}
