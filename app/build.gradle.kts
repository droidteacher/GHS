plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
}

android {
    namespace = "hu.zsoltkiss.githubsearch"
    compileSdk = 35

    defaultConfig {
        applicationId = "hu.zsoltkiss.githubsearch"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

val okHttpVersion = "4.12.0"
val retrofitVersion = "2.11.0"
val gsonVersion = "2.12.1"
val gsonConverterVersion = "2.11.0"
val coilVersion = "2.7.0"
val glideVersion = "4.14.2"
val glideComposeVersion = "1.0.0-beta01"

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)

    // Retrofit
    implementation("com.squareup.retrofit2:retrofit:$retrofitVersion")

    // Gson
    implementation("com.google.code.gson:gson:$gsonVersion")

    // Retrofit Gson Converter
    implementation("com.squareup.retrofit2:converter-gson:$gsonConverterVersion")

    // OKHttp
    implementation("com.squareup.okhttp3:okhttp:$okHttpVersion")
    implementation("com.squareup.okhttp3:logging-interceptor:$okHttpVersion")

    // Coil
//    implementation("io.coil-kt.coil3:coil-compose:$coilVersion")
//    implementation("io.coil-kt.coil3:coil-network-okhttp:$coilVersion")

    implementation("com.github.bumptech.glide:glide:4.14.2")
    implementation ("com.github.bumptech.glide:compose:$glideComposeVersion")

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}