# Notes App – Compose Multiplatform

## Features

* Cross-platform support: Android, iOS, Desktop, and Web
* Built using JetBrains Compose Multiplatform
* Persistent local storage using Room (Android) and SQLite for other platforms
* Create, update, and delete notes functionality
* Editable note list with live updates
* Timestamp display using Kotlinx.datetime
* Light and dark theme support
* Toast messages for invalid input (Android only)
* Simple and clean UI following Material Design guidelines

## Tech Stack

* Kotlin Multiplatform (KMP)
* Jetpack Compose Multiplatform
* Room Database (Android)
* SQLite with bundled driver (iOS/Desktop)
* Koin for dependency injection
* Coroutines for asynchronous operations
* Material Design 3 components

## Project Structure

* `commonMain`: Shared UI and logic
* `androidMain`: Android-specific code such as Room DB, toast, and themes
* `iosMain`: iOS-specific SQLite setup
* `desktopMain`: Desktop configurations

## Getting Started

1. Clone the repository:

   ```bash
   git clone https://github.com/yourusername/notes-app-kmp.git
   ```

2. Open the project in Android Studio (Giraffe or newer)

3. Select the desired target:

   * Android Emulator
   * iOS Simulator (requires macOS)
   * Desktop (run from desktopMain)

4. Build and run the app


<p align="center">
  <img src="https://github.com/ankitkumar5049/NotesApp_ComposeMultiplatform/blob/main/composeApp/src/androidMain/kotlin/org/example/project/assets/ss1.png" alt="Chat 1" width="200">
  <img src="https://github.com/ankitkumar5049/NotesApp_ComposeMultiplatform/blob/main/composeApp/src/androidMain/kotlin/org/example/project/assets/ss2.png" alt="Chat 1" width="200">
  <img src="https://github.com/ankitkumar5049/NotesApp_ComposeMultiplatform/blob/main/composeApp/src/androidMain/kotlin/org/example/project/assets/ss3.png" alt="Chat 1" width="200">
</p>
