# 🐱 Virtual Cat App

A simple virtual pet app built with **Jetpack Compose** for Android, where you can feed, play, and put your virtual cat to sleep. Manage your cat’s hunger, happiness, and energy levels while watching its mood change!

---

## 🚀 Overview

This app simulates a virtual cat with three core states:

- 🍗 **Hunger**  
- 😊 **Happiness**  
- ⚡ **Energy**

Each state ranges from 0 to 10 and affects the cat’s mood and behavior shown via different images.

---

## 📱 Features

### 🏠 Home Screen

- Displays the cat’s mood with images based on hunger and energy levels  
- Shows progress bars for hunger, energy, and happiness  
- Navigation buttons to **Feed**, **Play**, or **Sleep**

### 🍽️ Food Screen

- Feed your cat to decrease hunger  
- Button to feed and return to home

### 🎮 Game Screen

- Play mini-games to increase your cat’s happiness  
- Button to play and return to home

### 🛌 Sleep Screen

- Let your cat rest and regain energy  
- Button to sleep and return to home

---

## 🛠️ Code Structure

- `CatState` — data class holding hunger, happiness, and energy values  
- Screens as **Composable** functions: `HomeScreen`, `FoodScreen`, `GameScreen`, `SleepScreen`  
- Uses `CatViewModel` for state management  
- Navigation handled with `NavController`

---

## 📋 Usage

1. Run the app on an Android device or emulator  
2. Interact with your cat via the buttons on the Home screen  
3. Feed, play, or put the cat to sleep to keep it happy and healthy!

---

## ⚙️ Dependencies

- Jetpack Compose (Material3)  
- Navigation component for Compose  
- Kotlin language

---

> _“Taking care of a virtual pet is fun and teaches responsibility!”_
