object Versions {
    val coil = "0.11.0"
    val kotlin_stdlib = "1.3.72"
    val core_ktx = "1.3.1"
    var appcompat = "1.1.0"
    val constraint_layout = "2.0.0-beta8"
    val hilt = "2.28-alpha"
    val material = "1.3.0-alpha02"
    val navigation = "2.3.0"
    val fragment = "1.2.4"
    val retrofit = "2.6.2"
    val okhttp = "4.0.1"
    val viewpager = "1.0.0"
    val room = "2.2.5"
    val hilt_androidx_viewmodel = "1.0.0-alpha01"
    val coroutin = "1.3.5"
    val lifecycle_version = "2.2.0"
    val activity = "1.1.0"
    val glide = "4.11.0"
    val paging_version = "3.0.0-alpha07"
}

object Deps {
    val kotlin_stdlib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin_stdlib}"
    val core_ktx = "androidx.core:core-ktx:${Versions.core_ktx}"
    val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    val constraint_layout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraint_layout}"
    val hilt = "com.google.dagger:hilt-android:${Versions.hilt}"
    val hilt_complier = "com.google.dagger:hilt-android-compiler:${Versions.hilt}"
    val hilt_androidx = "androidx.hilt:hilt-lifecycle-viewmodel:${Versions.hilt_androidx_viewmodel}"
    val hilt_androidx_compiler = "androidx.hilt:hilt-compiler:${Versions.hilt_androidx_viewmodel}"
    val material = "com.google.android.material:material:${Versions.material}"
    val coroutin_core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutin}"
    val coroutin_android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutin}"


    val navigation_ui = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
    val navigation_fragment = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    val navigation_dynamic =
        ("androidx.navigation:navigation-dynamic-features-fragment:${Versions.navigation}")

    val fragment = "androidx.fragment:fragment:${Versions.fragment}"
    val activity = "androidx.activity:activity-ktx:${Versions.activity}"

    val lifecycle_viewmodel =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle_version}"
    val lifecycle_livedata =
        "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle_version}"
    val lifecycle_compiler = "androidx.lifecycle:lifecycle-compiler:${Versions.lifecycle_version}"

    val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    val gson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    val okhttp = "com.squareup.okhttp3:okhttp:${Versions.okhttp}"

    val http_logging_interceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp}"

    val viewpager = "androidx.viewpager2:viewpager2:${Versions.viewpager}"
    val room_runtime = "androidx.room:room-runtime:${Versions.room}"
    val room_compiler = "androidx.room:room-compiler:${Versions.room}"
    val room = "androidx.room:room-ktx:${Versions.room}"
    val coil = "io.coil-kt:coil:${Versions.coil}"

    val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    val glideCompiler = "com.github.bumptech.glide:compiler:${Versions.glide}"

    val paging =  "androidx.paging:paging-runtime:${Versions.paging_version}"
}