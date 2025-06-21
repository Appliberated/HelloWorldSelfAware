plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.appliberated.helloworldselfaware"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.appliberated.helloworldselfaware"
        minSdk = 9
        targetSdk = 35
        versionCode = 2
        versionName = "1.1"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
}