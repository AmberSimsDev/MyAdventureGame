# Adventure Path – Android Choose-Your-Own-Adventure Game

An interactive **choose-your-own-adventure Android game** built with **Kotlin and Jetpack Compose**, where user decisions influence story outcomes and scoring.

This project applies a **layered (Clean-inspired) architecture**, separating concerns between data handling, domain logic, and UI presentation.

---

## Features

*  Branching narrative gameplay (multiple outcomes based on user choices)
*  Luck-based event system (dynamic storytelling variations)
*  Score tracking and progression system
*  Personalized experience using stored user data
*  Replayability with different decision paths

---

##  Architecture

This project follows a **Clean Architecture-inspired structure (~70–80%)**:

```
data/
 ├── local/
 │    ├── entity/
 │    ├── source/
 │    ├── mapper/
 │    └── event/
 └── repository/

domain/
 ├── model/
 ├── repository/
 └── usecase/ (partially implemented)

presentation/
 ├── navigation/
 ├── screens/
 ├── viewmodel/
 └── ui/
```

### 🔹 Data Layer

Responsible for data sourcing and transformation:

* Local data sources simulate game content (questions, events)
* Entities represent raw data models
* Mappers convert data → domain models
* Repository implementation prepares data for the domain layer

Example:

```kotlin
return localDataSource.getPrepQuestions().map { it.toDomain() }
```

---

### 🔹 Domain Layer

Defines core business structures:

* Domain models (e.g., `PrepQuestions`, `UserData`)
* Repository contracts
* Use cases (partially implemented)

> Note: Use cases are scaffolded but not fully utilized. This was a deliberate simplification during development, with plans to fully encapsulate business logic in future iterations.

---

### 🔹 Presentation Layer

Built entirely with **Jetpack Compose**:

* State managed via `ViewModel` + `StateFlow`
* Navigation handled using `NavHost`
* UI reacts to state changes (score, name, events)

Example:

```kotlin
val name by viewModel.name.collectAsState()
```

---

##  Key Technical Decisions

### 1. Separation of Concerns

Data mapping is handled via extension functions instead of inside repositories:

```kotlin
internal fun PrepQuestionsLocalEntity.toDomain(): PrepQuestions
```

### 2. Event System Design

Game events are structured using:

* `LuckLevel` enum
* Mapped descriptions and outcomes

This allows scalable branching without hardcoding UI logic.

---

### 3. State Management

* `StateFlow` used for reactive UI updates
* ViewModels handle user input, validation, and persistence

---

##  Limitations & Future Improvements

* ❗ Use cases not fully implemented (planned refactor)
* ❗ Dependency injection (e.g., Hilt) not yet integrated
* ❗ Data currently local (no remote/API layer)

### Planned Enhancements:

* Full use case layer integration
* Introduce DI (Hilt)
* Expand story paths and persistence
* Add unit testing for domain and data layers

---

##  Tech Stack

* Kotlin
* Jetpack Compose
* Android Navigation Component
* StateFlow / Coroutines
* MVVM + Clean Architecture (partial)

---

##  Screenshots

<img width="360" height="586" alt="Screenshot_20260426-114755" src="https://github.com/user-attachments/assets/7313a68a-bd45-4276-8f3f-4445b079ce3d" /> 
<img width="360" height="800" alt="Screenshot_20260426-114829" src="https://github.com/user-attachments/assets/81ea270a-6a37-42a2-9719-cf2df2dbb9a7" />
<img width="360" height="800" alt="Screenshot_20260426-114849" src="https://github.com/user-attachments/assets/b35b7336-0f8b-465a-b825-1642d2e8e371" />
<img width="360" height="800" alt="Screenshot_20260426-114930" src="https://github.com/user-attachments/assets/b16d3d6b-5265-4d43-83a5-3e241f07ed64" />

---

##  Getting Started

1. Clone the repository
2. Open in Android Studio
3. Run on emulator or physical device

---

##  What I Learned

* Structuring scalable Android apps using layered architecture
* Managing UI state with Compose and reactive flows
* Designing flexible game logic systems
* Separating data transformation from business logic

---

## 📌 Author

Developed by Amber Sims

---
