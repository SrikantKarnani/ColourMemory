plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
    kotlin("android.extensions")
}
android {
    compileSdkVersion(BuildAndroidConfig.COMPILE_SDK_VERSION)
    buildToolsVersion(BuildAndroidConfig.BUILD_TOOLS_VERSION)

    buildFeatures {
        dataBinding = true
    }

    androidExtensions {
        isExperimental = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    defaultConfig {
        minSdkVersion(BuildAndroidConfig.MIN_SDK_VERSION)
        targetSdkVersion(BuildAndroidConfig.TARGET_SDK_VERSION)
        versionCode = BuildAndroidConfig.VERSION_CODE
        versionName = BuildAndroidConfig.VERSION_NAME
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            isDebuggable = false
        }
        getByName("debug") {
            isDebuggable = true
        }
    }
}

dependencies {
    implementation(fileTree("dir" to "libs", "include" to listOf("*.jar")))
    api(Deps.kotlin_stdlib)
    api(Deps.core_ktx)
    api(Deps.appcompat)
    api(Deps.constraint_layout)
    api(Deps.fragment)
    api(Deps.activity)
    api(Deps.hilt)
    api(Deps.lifecycle_viewmodel)
    api(Deps.lifecycle_livedata)
    implementation(Deps.hilt_androidx)
    api(Deps.material)
    kapt(Deps.hilt_androidx_compiler)
    kapt(Deps.hilt_complier)
    kapt(Deps.lifecycle_compiler)
    api(Deps.coroutin_core)
    api(Deps.coroutin_android)
    implementation(Deps.room)
    kapt(Deps.room_compiler)
}