# 🧮 Java Calculator Application

A fully functional GUI calculator built with **Java Swing**, featuring both **Standard** and **Scientific** modes with dynamic switching and modular architecture.

---

## 📁 Project Structure

```
CalculatorProject/
│
├── src/
│   ├── app/
│   │   └── CalculatorApp.java            # Entry point
│   │
│   ├── logic/
│   │   ├── CalculatorLogic.java          # Shared interface
│   │   ├── StandardCalculatorLogic.java  # Basic arithmetic logic
│   │   └── ScientificCalculatorLogic.java# Scientific expression logic
│   │
│   └── ui/
│       ├── CalculatorUI.java             # Main UI Frame
│       ├── ButtonLayout.java             # Button grid layout generator
│       └── ModeSwitcher.java             # Toggle button for modes
│
├── out/                                  # Compiled class output
│
├── compile.bat                           # Script to compile Java files
└── run.bat                               # Script to run the application
```

---

## ✨ Features

- ✅ **Standard Mode:** Supports `+`, `-`, `*`, `/` operations.
- ✅ **Scientific Mode:** Adds `sin`, `cos`, `tan`, `log`, `ln`, `sqrt`, `^`, parentheses, and more.
- ✅ **Live Mode Switching:** Change between calculator modes without restarting.
- ✅ **User-Friendly UI:** Clean layout and responsive controls.
- ✅ **Modular Code:** Separated logic, UI, and app launcher for maintainability.

---

## 🛠 How to Compile and Run

### 📌 Requirements

- Java Development Kit (JDK) 8 or higher installed
- `JAVA_HOME` properly set in environment variables

1. **Clone the repository**
   ```bash
   git clone https://github.com/Swayam4717/Java-Calculator.git
   cd Java-Calculator
   ```

Double-click or run in terminal:

```bash
compile.bat
```

This compiles all `.java` files into the `out/` directory.

### ▶ Run

```bash
run.bat
```

This runs the application using compiled classes in `out/`.

---

## 🧪 Example Expressions

| Mode       | Expression            | Output  |
|------------|------------------------|---------|
| Standard   | `3 + 5 * 2`            | `13`    |
| Scientific | `sqrt(16)`             | `4.0`   |
| Scientific | `sin(30)`              | `0.5`   |
| Scientific | `log(100)`             | `2.0`   |
| Scientific | `2^3 + 1`              | `9.0`   |

---

## 🧠 Internal Design

- **Logic Layer:**  
  `CalculatorLogic` interface enables dynamic replacement of logic handlers.

- **UI Layer:**  
  `CalculatorUI` creates the window and delegates layout to `ButtonLayout`.  
  `ModeSwitcher` allows toggling between logic types at runtime.

- **Layout Builder:**  
  `ButtonLayout` builds buttons dynamically based on the selected mode.

---

## 💡 Tip

To run without `.bat` files (Linux/Mac/Manual):

```bash
javac -d out src/**/*.java
java -cp out app.CalculatorApp
```

---

## 👨‍💻 Contribute / Extend

Want to add history, themes, or custom key bindings?  
Just extend `ButtonLayout`, update logic interfaces, or inject more UI modules into `CalculatorUI`.

---

## 💡 What I Learned

- Building GUI applications with Java AWT
- Event-driven programming and button action listeners
- Layout management and component organization
- Handling user inputs and validations

## 👨‍💻 Author

**Swayam Jain**  
📫 [LinkedIn](https://www.linkedin.com/in/swayamjain06/)  
🌐 [GitHub](https://github.com/Swayam4717)

---

## ⭐️ Show Your Support

If you like this project, feel free to star the repo and connect with me on LinkedIn!

---

## 🏗️ Future Improvements

- [ ] Scientific functions (sin, cos, log)
- [ ] Keyboard input support
- [ ] Theme toggle (dark/light mode)
- [ ] History log of operations

---
