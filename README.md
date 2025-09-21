# 🐱 Virtual Cat App

A virtual pet application built with **Clean Architecture** and **SOLID principles** using Kotlin for Android.

## 📋 Project Overview

This project implements a virtual cat simulation where users can:
- 🍽️ **Feed** their virtual cat
- 🎮 **Play** games with the cat
- 😴 **Put the cat to sleep**
- 🏠 **Monitor** the cat's overall status

## 🏗️ Architecture

The project follows **Clean Architecture** principles with three distinct layers:

### 🎯 Domain Layer
- **Entities**: Core business objects
- **Use Cases**: Business logic operations
- **Repository Interfaces**: Data access contracts

### 💾 Data Layer
- **Repositories**: Data access implementations
- **Data Sources**: Multiple storage strategies
  - **Memory**: Fast in-memory caching
  - **XML**: Local persistent storage
  - **API**: Remote data synchronization

### 🎨 Presentation Layer
- **MVVM Pattern**: Model-View-ViewModel architecture
- **Compose UI**: Modern declarative UI
- **ViewModels**: UI state management
- **Navigation**: Screen flow management

## 📁 Project Structure

```
com.example.virtualcatapp
├── data/
│   ├── local/
│   │   ├── CatMemLocalDataSource.kt
│   │   └── CatXmlLocalDataSource.kt
│   ├── remote/
│   │   └── CatApiRemoteDataSource.kt
│   └── CatDataRepository.kt
├── domain/
│   ├── entities/
│   │   └── Cat.kt
│   ├── repositories/
│   │   └── CatRepository.kt
│   └── usecases/
│       ├── FeedCatUseCase.kt
│       ├── PlayWithCatUseCase.kt
│       └── GetCatStateUseCase.kt
└── presentation/
    ├── screens/
    │   ├── food/
    │   │   ├── FoodScreen.kt
    │   │   └── FoodViewModel.kt
    │   ├── game/
    │   │   ├── GameScreen.kt
    │   │   └── GameViewModel.kt
    │   ├── home/
    │   │   ├── HomeScreen.kt
    │   │   └── HomeViewModel.kt
    │   └── sleep/
    │       ├── SleepScreen.kt
    │       └── SleepViewModel.kt
    ├── navigation/
    │   └── Navigation.kt
    ├── theme/
    │   ├── Color.kt
    │   ├── Theme.kt
    │   └── Type.kt
    ├── models/
    │   └── CatUiState.kt
    └── MainActivity.kt
```

## 🐱 Cat Entity

The virtual cat has the following properties:
- **ID**: Unique identifier
- **Name**: Cat's name
- **Hunger**: Hunger level (0-100)
- **Happiness**: Mood level (0-100)
- **Energy**: Energy level (0-100)

## 🛠️ Technology Stack

- **Language**: Kotlin
- **UI Framework**: Jetpack Compose
- **Architecture**: Clean Architecture + MVVM
- **Design Patterns**: Repository Pattern, Dependency Injection
- **Local Storage**: XML files, In-memory caching
- **Remote**: REST API (future implementation)

## ✨ SOLID Principles Implementation

- **S**ingle Responsibility: Each class has one specific purpose
- **O**pen/Closed: Extensible through interfaces
- **L**iskov Substitution: Interface implementations are interchangeable
- **I**nterface Segregation: Specific, focused interfaces
- **D**ependency Inversion: High-level modules depend on abstractions

## 🚀 Features

### Current Implementation
- ✅ Clean Architecture setup
- ✅ Domain entities and use cases
- ✅ Multiple data sources (Memory, XML, API interfaces)
- ✅ MVVM presentation layer
- ✅ Navigation between screens

### Planned Features
- 🔄 Complete XML persistence implementation
- 🌐 REST API integration
- 📊 Cat statistics and history
- 🎨 Enhanced UI animations
- 🧪 Unit and integration tests
- 💉 Dependency injection with Hilt

## 📱 Screens

1. **Home Screen**: Main cat status display
2. **Food Screen**: Feed the virtual cat
3. **Game Screen**: Play mini-games with the cat
4. **Sleep Screen**: Rest mode for the cat

## 🧪 Testing Strategy

- **Unit Tests**: Domain layer use cases
- **Integration Tests**: Repository implementations
- **UI Tests**: Screen functionality and navigation

## 🔧 Setup & Installation

1. Clone the repository
```bash
git clone https://github.com/yourusername/virtual-cat-app.git
```

2. Open in Android Studio

3. Build and run the project

## 📈 Development Status

🚧 **Work in Progress** - This is an educational project demonstrating Clean Architecture principles in Android development.

## 🤝 Contributing

This is a learning project. Feel free to fork and experiment with your own implementations!

## 📄 License

This project is for educational purposes.

---

*Built with ❤️ using Clean Architecture and SOLID principles*
