import org.gradle.kotlin.dsl.*
plugins {
    id("makemusic.android.application")
    id("makemusic.android.application.compose")
   // id("makemusic.android.application.firebase")
    id("makemusic.android.hilt")
}

android {
    namespace = "com.grace.makemusic"

    defaultConfig {
        applicationId = "com.grace.makemusic"
        versionCode = 1
        versionName = "1.0"
        // Enabling multidex support.
        multiDexEnabled = true
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }

        getByName("debug") {
            applicationIdSuffix = ".debug"
            isDebuggable = true
        }
    }



    buildFeatures {
        compose = true
        dataBinding = true
    }
}

dependencies {


    implementation(libs.androidx.startup)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.core)
    implementation(libs.androidx.core.splashscreen)
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.navigation.ui)
    implementation(libs.androidx.navigation.fragment)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.core)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.runtime)

    implementation(libs.material)

    implementation(libs.okhttp3)
    implementation(libs.okhttp3.interceptor)
    implementation(libs.retrofit.core)

    implementation(libs.coil.kt)
    implementation(libs.coil.kt.svg)


    //implementation(libs.firebase.cloud.messaging)

    implementation(libs.timber)
    implementation(libs.androidx.compose.ui.tooling.preview)
    debugImplementation(libs.androidx.compose.ui.tooling)

}
// Allow references to generated code
kapt {
    correctErrorTypes = true
}