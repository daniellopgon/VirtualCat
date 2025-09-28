# VirtualCatApp
An interactive Android virtual pet application developed in Kotlin with Jetpack Compose.

# Description
VirtualCatApp is an application that allows you to care for and interact with a virtual cat. The application includes different activities such as feeding, playing, and putting your virtual pet to sleep.

# Architecture
The project follows a clean architecture with the following layers:

Data: Management of local data sources (memory and XML)
Domain: Business logic, use cases, and models
Presentation: User interface with Jetpack Compose and ViewModels

# Technologies Used

Kotlin - Programming language
Jetpack Compose - Declarative UI
ViewModel - UI state management
Gradle - Build system
Android Studio - Development IDE

# Project Structure

app/src/main/
├── kotlin/com/example/virtualcatapp/features/cats/
│   ├── data/
│   │   ├── local/          # Local data sources
│   │   └── repository/     # Repository implementations
│   ├── domain/
│   │   ├── exceptions/     # Custom exceptions
│   │   ├── models/         # Domain models
│   │   ├── repository/     # Repository interfaces
│   │   └── usecase/       # Use cases
│   └── presentation/
│       ├── di/            # Dependency injection
│       ├── models/        # UI models
│       ├── navigation/    # Navigation
│       ├── screens/       # Composable screens
│       │   ├── food/      # Feeding screen
│       │   ├── game/      # Game screen
│       │   ├── home/      # Home screen
│       │   └── sleep/     # Sleep screen
│       ├── shared/        # Shared state
│       └── theme/         # Themes and styles
├── res/
│   ├── drawable/          # Images (happy cat, sad cat, sleeping cat)
│   ├── mipmap/           # App icons
│   ├── values/           # Colors, strings, themes
│   └── xml/              # Backup and data extraction rules

# Features

Modern interface with Jetpack Compose
Multiple activities to interact with the cat
Local data persistence
Navigation between screens
Cat emotional states (happy, sad, sleeping)
Clean and maintainable architecture

# How to Run
Clone the repository
Open the project in Android Studio
Sync the project with Gradle files
Run on an emulator or physical device

# Requirements
Android Studio Hedgehog or higher
Android SDK 34 (Android 14)
Gradle 8.11.1

# Testing
The project includes unit tests for use cases in app/src/test/java/

License
This project is under the MIT License.
