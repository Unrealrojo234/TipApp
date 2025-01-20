# Tip Calculator App

A simple and elegant tip calculator application built with Jetpack Compose. The app allows users to calculate a 15% tip based on their bill amount, featuring error handling and a clean user interface.

## Features

- **Bill Amount Input**: User-friendly text field with currency symbol
- **Automatic Tip Calculation**: Calculates 15% tip instantly
- **Input Validation**: Comprehensive error handling for:
  - Empty inputs
  - Invalid numbers
  - Negative amounts
  - Zero amounts
- **Visual Feedback**: Clear error messages and styled UI elements
- **Custom Styling**: Custom colors and borders using Material Design 3

## Project Configuration

### Build Configuration
```gradle
plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
}

android {
    namespace = "com.example.tip"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.tip"
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
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
}
```

### Dependencies
```gradle
dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}
```

## UI Components

### Header
- Custom styled header card
- App title
- Donald Duck image for visual appeal

### Input Section
- Outlined text field with custom styling
- Currency symbol ($) leading icon
- Decimal keyboard type
- Input validation with error messages

### Display Section
- Tip amount display with custom formatting
- Styled amount display for better visibility

### Calculate Button
- Outlined button with custom styling
- Error handling and validation on click

## Technical Details

### State Management
- `amountInput`: String state for text field input
- `tip`: Double state for calculated tip amount
- `hasError`: Boolean state for error tracking
- `errorMessage`: String state for error message display

### Error Handling
The app validates:
1. Empty inputs
2. Non-numeric values
3. Negative amounts
4. Zero amounts
5. General exceptions

## System Requirements
- Minimum SDK: 24 (Android 7.0)
- Target SDK: 34 (Android 14)
- Compile SDK: 35
- Kotlin Version: Compatible with JVM 1.8

## Future Improvements
- Add customizable tip percentages
- Include bill splitting functionality
- Add dark mode support
- Save previous calculations
- Add total amount calculation (bill + tip)
