object ApplicationId {
    val application_id = "com.yipl.label_step"
}

object Releases {
    val version_code = 1
    val version_name = "1.0"
}

object Versions {
    val kotlin = "1.1.51"
    val supportLib = "27.1.1"
    val constraint_layout = "1.1.0"
    val design = "27.1.1"
    val junit = "4.12"
    val support_test = "1.0.1"
    val espresso = "3.0.1"
    val room = "1.1.0-beta3"
    val lifecycle = "1.1.1"
    val stetho = "1.5.0"
    val databinding = "2.3.1"
    val glide = "4.7.1"
    val dagger = "2.15"
    val compile_sdk = 27
    val min = 17
    val target_sdk = 27
    val retrofit = "2.4.0"
    val logging_interceptor= "3.8.0"
    val rxjava="2.1.9"
    val rxkotlin="2.2.0"
    val rxandroid="2.0.2"
    val retrofit_adapter = "2.3.0"
}

object Libraries {
    val kotlin_stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jre7:${Versions.kotlin}"
    val room = "android.arch.persistence.room:runtime:${Versions.room}"
    val room_compiler = "android.arch.persistence.room:compiler:${Versions.room}"
    val lifecycle = "android.arch.lifecycle:extensions:${Versions.lifecycle}"
    val stetho = "com.facebook.stetho:stetho:${Versions.stetho}"
    val databinding_compiler = "com.android.databinding:compiler:${Versions.databinding}"
    val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    val glide_compiler = "com.github.bumptech.glide:compiler:${Versions.glide}"
    val dagger = "com.google.dagger:dagger-android:${Versions.dagger}"
    val dagger_support = "com.google.dagger:dagger-android-support:${Versions.dagger}" // if you use the support libraries
    val dagger_android_processor = "com.google.dagger:dagger-android-processor:${Versions.dagger}"
    val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    val gson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    val logginginterceptor= "com.squareup.okhttp3:logging-interceptor:${Versions.logging_interceptor}"
    val rxjava= "io.reactivex.rxjava2:rxjava:${Versions.rxjava}"
    val rxkotlin="io.reactivex.rxjava2:rxkotlin:${Versions.rxkotlin}"
    val rxandroid="io.reactivex.rxjava2:rxandroid:${Versions.rxandroid}"
    val retrofit_adapter = "com.squareup.retrofit2:adapter-rxjava2:${Versions.retrofit_adapter}"
    val dagger_android = "com.google.dagger:dagger-android:${Versions.dagger}"

}

object SupportLibraries {
    val appcompat = "com.android.support:appcompat-v7:${Versions.supportLib}"
    val constraint_layout = "com.android.support.constraint:constraint-layout:${Versions.constraint_layout}"
    val design = "com.android.support:design:${Versions.design}"

}

object TestLibraries {
    val junit = "junit:junit:${Versions.junit}"
    val support_test = "com.android.support.test:runner:${Versions.support_test}"
    val espresso = "com.android.support.test.espresso:espresso-core:${Versions.espresso}"
}