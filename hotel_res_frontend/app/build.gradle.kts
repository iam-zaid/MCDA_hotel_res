plugins {
    id("com.android.application")
}

android {
    namespace = "com.example.hotel_reservation_system"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.hotel_reservation_system"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation ("androidx.recyclerview:recyclerview:1.2.0") //Recycler View Dependecny
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    implementation("com.squareup.retrofit:retrofit:1.9.0")// dependency for Retrofit//add dependecny here for retrofit
    // Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
        // Gson Converter
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")

    
}