# 🌐 Pro Browser Stack v2.0

A modern web-based browser simulator that demonstrates **Stack Data Structure (LIFO)** principles using Spring Boot and Thymeleaf. Navigate through web URLs with intuitive back/forward functionality powered by dual stacks.

![Platform](https://img.shields.io/badge/Platform-Spring%20Boot%203.2-brightgreen)
![License](https://img.shields.io/badge/License-MIT-blue)
![Java](https://img.shields.io/badge/Java-17%2B-orange)
![Status](https://img.shields.io/badge/Status-Active-success)

---

## 📋 Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Technology Stack](#technology-stack)
- [Architecture](#architecture)
- [Installation & Setup](#installation--setup)
- [Project Structure](#project-structure)
- [Usage Guide](#usage-guide)
- [System Diagrams](#system-diagrams)
- [Code Examples](#code-examples)
- [How It Works](#how-it-works)
- [Contributing](#contributing)
- [License](#license)

---

## 📌 Overview

**Pro Browser Stack v2.0** is an educational demonstration of the **Stack Data Structure (LIFO - Last In First Out)** implemented in a real-world web application context. It simulates a web browser's navigation history using two stacks:

- **Back Stack**: Stores previously visited URLs
- **Forward Stack**: Stores URLs visited after using the back button

This project showcases:
✅ Full-stack web application development  
✅ Data structure implementation in Java  
✅ Spring Boot MVC pattern  
✅ Template rendering with Thymeleaf  
✅ Modern responsive UI design  

---

## ✨ Features

| Feature | Description |
|---------|-------------|
| **URL Navigation** | Visit any URL and maintain browsing history |
| **Back Navigation** | Go back to previous URLs using the back stack |
| **Forward Navigation** | Move forward through the forward stack after going back |
| **Clear History** | Reset all stacks and return to home page |
| **Visual Stack Display** | Real-time display of back and forward stacks in the sidebar |
| **Disabled State Buttons** | Smart button disabling when stacks are empty |
| **Responsive UI** | Dark theme modern interface that works on all devices |
| **Secure Verification** | Visual security badge for enhanced UX |

---

## 🛠️ Technology Stack

```
Frontend:
├── HTML5
├── CSS3 (Custom Styling, CSS Variables, Flexbox)
├── Thymeleaf (Server-side Template Engine)

Backend:
├── Java 17+
├── Spring Boot 3.2.0
├── Spring MVC
└── Spring Web Starter

Build:
├── Maven
└── Spring Boot Maven Plugin

Architecture:
├── Model-View-Controller (MVC)
└── Java Collections (Stack API)
```

---

## 🏗️ Architecture

### Block Diagram

```
┌─────────────────────────────────────────────────────────────┐
│                    Spring Boot Application                   │
├─────────────────────────────────────────────────────────────┤
│                                                               │
│  ┌──────────────────────────────────────────────────────┐   │
│  │             BrowserController                        │   │
│  │  (Spring MVC Controller - Handles HTTP Requests)     │   │
│  ├──────────────────────────────────────────────────────┤   │
│  │ • POST /visit      → Visit URL                       │   │
│  │ • POST /back       → Navigate Back                   │   │
│  │ • POST /forward    → Navigate Forward                │   │
│  │ • POST /clear      → Clear History                   │   │
│  │ • GET  /           → Display Home Page               │   │
│  └──────────────────────────────────────────────────────┘   │
│                           ↕                                   │
│  ┌──────────────────────────────────────────────────────┐   │
│  │         Application State (Memory)                    │   │
│  │  ┌─────────────────────────────────────────────────┐ │   │
│  │  │ Stack<String> backStack    (LIFO)              │ │   │
│  │  │ Stack<String> forwardStack (LIFO)              │ │   │
│  │  │ String currentPage (Active URL)                │ │   │
│  │  └─────────────────────────────────────────────────┘ │   │
│  └──────────────────────────────────────────────────────┘   │
│                           ↕                                   │
│  ┌──────────────────────────────────────────────────────┐   │
│  │         Model (Data Transfer to View)                │   │
│  │  ├─ current          (String: Current URL)           │   │
│  │  ├─ backHistory      (Stack: Back URLs)              │   │
│  │  ├─ forwardHistory   (Stack: Forward URLs)           │   │
│  │  ├─ hasBack          (Boolean: Enable back button)   │   │
│  │  └─ hasForward       (Boolean: Enable forward button)│   │
│  └──────────────────────────────────────────────────────┘   │
│                           ↕                                   │
│  ┌──────────────────────────────────────────────────────┐   │
│  │      Thymeleaf Template (index.html)                 │   │
│  │  • Renders UI with Model Attributes                  │   │
│  │  • Displays Back/Forward Stacks                       │   │
│  │  • Manages Form Submissions                           │   │
│  └──────────────────────────────────────────────────────┘   │
│                                                               │
└─────────────────────────────────────────────────────────────┘
                            ↕
┌─────────────────────────────────────────────────────────────┐
│                    User's Web Browser                         │
│  (HTML Rendering + CSS Styling + User Interactions)         │
└─────────────────────────────────────────────────────────────┘
```

### Data Flow Diagram

```
USER ACTION (Browser)
       ↓
    HTML Form Submission
       ↓
 Spring DispatcherServlet
       ↓
   Route Mapping (@PostMapping/@GetMapping)
       ↓
 BrowserController Method
       ↓
 ┌─────────────────────────────────────────┐
 │  Stack Operations                       │
 │  • Push to back/forward stack           │
 │  • Pop from stacks                      │
 │  • Clear stacks                         │
 └─────────────────────────────────────────┘
       ↓
 updateView() - Populate Model Attributes
       ↓
 Thymeleaf Renders index.html
       ↓
 HTML Response Sent to Browser
       ↓
  User Sees Updated UI
```

---

## 💻 Installation & Setup

### Prerequisites

Ensure you have the following installed:

```bash
- Java 17 or higher (JDK)
- Maven 3.6+
- Git
```

### Step 1: Clone the Repository

```bash
git clone https://github.com/yourusername/pro-browser-stack.git
cd pro-browser-stack
```

### Step 2: Verify Project Structure

```
pro-browser-stack/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/example/demo/
│       │       ├── BrowserController.java
│       │       └── DemoApplication.java
│       └── resources/
│           ├── templates/
│           │   └── index.html
│           └── application.properties
├── pom.xml
├── README.md
└── .gitignore
```

### Step 3: Build the Project

```bash
mvn clean install
```

This command:
- Cleans previous builds
- Downloads dependencies from `pom.xml`
- Compiles Java code
- Packages the application

### Step 4: Run the Application

```bash
mvn spring-boot:run
```

Or run the JAR directly:

```bash
java -jar target/demo-0.0.1-SNAPSHOT.jar
```

### Step 5: Access the Application

Open your browser and navigate to:

```
http://localhost:8080
```

You should see the Pro Browser Stack interface with:
- Back and Forward navigation stacks (left sidebar)
- Toolbar with navigation buttons and URL input
- Current URL display in the viewport
- Clear history button

---

## 📁 Project Structure

```
src/main/java/com/example/demo/
│
├── BrowserController.java          # Main Application Logic
│   ├── backStack (Stack<String>)   # Store back navigation
│   ├── forwardStack (Stack<String>)# Store forward navigation
│   ├── currentPage (String)        # Active URL
│   │
│   ├── @GetMapping("/")             # Home endpoint
│   ├── @PostMapping("/visit")       # Visit URL
│   ├── @PostMapping("/back")        # Back navigation
│   ├── @PostMapping("/forward")     # Forward navigation
│   ├── @PostMapping("/clear")       # Clear history
│   └── updateView()                 # Update model
│
└── DemoApplication.java            # Spring Boot Entry Point
    └── main(String[] args)         # Application startup

resources/templates/
│
└── index.html                       # Thymeleaf Template
    ├── Styling (CSS Variables, Dark Theme)
    ├── Sidebar (History Display)
    ├── Toolbar (Navigation Buttons)
    └── Viewport (URL Display)

resources/
│
└── application.properties          # Spring Configuration
```

---

## 🎮 Usage Guide

### Basic Navigation

1. **Visit a URL**:
   - Type a URL in the input field (e.g., "Google.com", "GitHub.com")
   - Press Enter or click the input
   - The URL appears in the viewport
   - The previous URL moves to the back stack

2. **Go Back**:
   - Click the "←" button to return to the previous URL
   - Current URL moves to forward stack
   - Previous URL becomes active

3. **Go Forward**:
   - Click the "→" button to return to a URL after going back
   - Current URL moves to back stack
   - Forward URL becomes active

4. **Clear History**:
   - Click the "Clear All History" button
   - All stacks are cleared
   - Returns to "Home" page

### Example Workflow

```
1. Start:          currentPage = "Google.com"
   backStack = []  forwardStack = []

2. Visit "GitHub.com":
   currentPage = "GitHub.com"
   backStack = ["Google.com"]
   forwardStack = []

3. Visit "LinkedIn.com":
   currentPage = "LinkedIn.com"
   backStack = ["Google.com", "GitHub.com"]
   forwardStack = []

4. Click Back:
   currentPage = "GitHub.com"
   backStack = ["Google.com"]
   forwardStack = ["LinkedIn.com"]

5. Click Forward:
   currentPage = "LinkedIn.com"
   backStack = ["Google.com", "GitHub.com"]
   forwardStack = []

6. Click Clear:
   currentPage = "Home"
   backStack = []
   forwardStack = []
```

---

## 📊 System Diagrams

### Application Flow Diagram

```
┌─────────────┐
│   Start     │
└──────┬──────┘
       │
       ↓
┌─────────────────────┐
│ Load Home Page      │
│ Display "Google.com"│
└──────┬──────────────┘
       │
       ↓
┌──────────────────────────────────┐
│ User Input (Choose Action)       │
├──────────────────────────────────┤
│ ├─ Enter URL                     │
│ ├─ Click Back Button             │
│ ├─ Click Forward Button          │
│ └─ Click Clear History           │
└──────────────────────────────────┘
       │
   ┌───┴───┬──────────┬──────────┐
   │       │          │          │
   ↓       ↓          ↓          ↓
┌────┐ ┌────┐    ┌────┐    ┌────┐
│Visit│ │Back│    │Frwd│    │Clr │
└─┬──┘ └─┬──┘    └─┬──┘    └─┬──┘
  │      │        │        │
  ↓      ↓        ↓        ↓
┌──────────────────────────────────┐
│ Update Stack Operations          │
├──────────────────────────────────┤
│ ├─ Visit: backStack.push()       │
│ ├─ Back:  pop() & push to fwd    │
│ ├─ Fwd:   pop() & push to back   │
│ └─ Clear: stacks.clear()         │
└──────────────────────────────────┘
       │
       ↓
┌──────────────────────────────────┐
│ updateView() - Refresh UI        │
│ • Set current page               │
│ • Set history visibility         │
│ • Enable/disable buttons         │
└──────────────────────────────────┘
       │
       ↓
┌──────────────────────────────────┐
│ Render HTML (Thymeleaf)          │
│ • Display current URL            │
│ • Show back history stack        │
│ • Show forward history stack     │
└──────────────────────────────────┘
       │
       ↓
┌──────────────────────────────────┐
│ Display Updated UI to User       │
└──────────────────────────────────┘
       │
       └─────────────┬─────────────┐
                     │             │
              Continue Loop    Exit App
```

### Stack Operations Sequence

```
Timeline: Navigation Through URLs

T0:  Start
     Current: "Google.com"
     Back: []
     Forward: []
     
T1:  Visit "GitHub.com"
     Push "Google.com" → Back
     Clear Forward
     Current: "GitHub.com"
     Back: ["Google.com"]
     Forward: []

T2:  Visit "LinkedIn.com"
     Push "GitHub.com" → Back
     Clear Forward
     Current: "LinkedIn.com"
     Back: ["Google.com", "GitHub.com"]
     Forward: []

T3:  Click Back
     Push "LinkedIn.com" → Forward
     Pop "GitHub.com" from Back → Current
     Current: "GitHub.com"
     Back: ["Google.com"]
     Forward: ["LinkedIn.com"]

T4:  Visit "Twitter.com"
     Push "GitHub.com" → Back
     Clear Forward ⚠️
     Current: "Twitter.com"
     Back: ["Google.com", "GitHub.com"]
     Forward: []

T5:  Click Back
     Push "Twitter.com" → Forward
     Pop "GitHub.com" from Back → Current
     Current: "GitHub.com"
     Back: ["Google.com"]
     Forward: ["Twitter.com"]

T6:  Click Clear
     Clear All Stacks
     Reset to "Home"
     Current: "Home"
     Back: []
     Forward: []
```

---

## 💡 Code Examples

### Example 1: Visit URL

```java
@PostMapping("/visit")
public String visit(@RequestParam String url, Model model) {
    if (currentPage != null) {
        backStack.push(currentPage);    // Save current to back
    }
    currentPage = url;                  // Update current
    forwardStack.clear();               // Clear forward history
    updateView(model);
    return "index";
}

// Usage:
// Enter "GitHub.com" in URL bar
// → backStack contains ["Google.com"]
// → currentPage becomes "GitHub.com"
// → forwardStack is now empty
```

### Example 2: Back Navigation

```java
@PostMapping("/back")
public String back(Model model) {
    if (!backStack.isEmpty()) {
        forwardStack.push(currentPage);     // Save current to forward
        currentPage = backStack.pop();      // Get previous from back
    }
    updateView(model);
    return "index";
}

// Usage:
// Click back button
// → forwardStack contains ["GitHub.com"]
// → currentPage becomes "Google.com"
// → backStack is now empty
```

### Example 3: Forward Navigation

```java
@PostMapping("/forward")
public String forward(Model model) {
    if (!forwardStack.isEmpty()) {
        backStack.push(currentPage);        // Save current to back
        currentPage = forwardStack.pop();   // Get from forward
    }
    updateView(model);
    return "index";
}

// Usage:
// After going back, click forward
// → backStack contains ["Google.com", "GitHub.com"]
// → currentPage becomes "GitHub.com"
// → forwardStack is now empty
```

### Example 4: Clear History

```java
@PostMapping("/clear")
public String clear(Model model) {
    backStack.clear();                  // Empty back history
    forwardStack.clear();               // Empty forward history
    currentPage = "Home";               // Reset to home
    updateView(model);
    return "index";
}

// Usage:
// Click "Clear All History" button
// → All stacks become empty
// → currentPage resets to "Home"
// → UI shows fresh state
```

---

## 🔍 How It Works

### Stack Data Structure (LIFO - Last In First Out)

The browser implements two stacks to manage navigation history:

```
Back Stack:                Forward Stack:
┌──────────────┐          ┌──────────────┐
│ LinkedIn.com │ ← Top    │ LinkedIn.com │ ← Top
├──────────────┤          ├──────────────┤
│  GitHub.com  │          │  Twitter.com │
├──────────────┤          ├──────────────┤
│  Google.com  │          │              │
└──────────────┘          └──────────────┘

LIFO Operation:
┌───────────────────────────────────┐
│ Push: Add to top                  │
│ Pop:  Remove from top             │
│ Peek: View top without removing   │
│ isEmpty(): Check if stack empty   │
└───────────────────────────────────┘
```

### Key Operations

| Operation | Back Stack | Forward Stack | Current Page | Logic |
|-----------|-----------|---------------|--------------|-------|
| **Visit URL** | Push current | Clear | Update to new | Save state, start fresh forward |
| **Back** | Pop to current | Push current | Get from back | Reverse, prepare forward |
| **Forward** | Push current | Pop to current | Get from forward | Advance, prepare back |
| **Clear** | Empty | Empty | Set to "Home" | Reset everything |

---

## 🚀 How to Deploy

### Deploy to Heroku

```bash
# Create Heroku app
heroku create your-app-name

# Deploy
git push heroku main

# View logs
heroku logs --tail
```

### Deploy to AWS

```bash
# Build JAR
mvn clean package

# Upload to AWS (EC2/Elastic Beanstalk)
# Follow AWS documentation for deployment
```

### Docker Deployment

Create `Dockerfile`:

```dockerfile
FROM openjdk:17
COPY target/demo-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
```

Build and run:

```bash
docker build -t browser-stack .
docker run -p 8080:8080 browser-stack
```

---

## 📝 Code Standards

### Controller Methods

```java
@PostMapping("/action")
public String actionName(@RequestParam String param, Model model) {
    // 1. Validate input
    if (param == null || param.isEmpty()) return "index";
    
    // 2. Perform business logic
    // ... stack operations ...
    
    // 3. Update model
    updateView(model);
    
    // 4. Return view
    return "index";
}
```

### Stack Operations

```java
// Always check isEmpty() before pop()
if (!backStack.isEmpty()) {
    String previous = backStack.pop();
}

// Push before updating current
if (currentPage != null) {
    backStack.push(currentPage);
}

// Clear when needed to reset state
forwardStack.clear();
```

---

## 🔧 Troubleshooting

| Issue | Solution |
|-------|----------|
| **Port 8080 already in use** | Change port in `application.properties`: `server.port=8081` |
| **Maven build fails** | Run `mvn clean` then `mvn install` |
| **Thymeleaf template not found** | Ensure `index.html` is in `src/main/resources/templates/` |
| **Buttons not working** | Check browser console for JavaScript errors |
| **Stack operations broken** | Verify null checks before `pop()` operations |
| **Styling not loading** | Clear browser cache (Ctrl+Shift+Delete) |

---

## 📚 Learning Resources

### Understanding Stacks

- [GeeksforGeeks - Stack Data Structure](https://www.geeksforgeeks.org/stack-data-structure/)
- [JavaTpoint - Stack Tutorial](https://www.javatpoint.com/data-structure-stack)
- [Java Stack Class Documentation](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/Stack.html)

### Spring Boot Resources

- [Spring Boot Official Documentation](https://spring.io/projects/spring-boot)
- [Spring MVC Tutorial](https://www.baeldung.com/spring-mvc)
- [Thymeleaf Documentation](https://www.thymeleaf.org/documentation.html)

### Java Resources

- [Java 17 Features](https://www.oracle.com/java/technologies/javase/17-relnotes.html)
- [Maven Documentation](https://maven.apache.org/guides/)

---

## 🤝 Contributing

Contributions are welcome! Please follow these steps:

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

### Contribution Guidelines

- Write clean, readable code
- Add comments for complex logic
- Update this README for new features
- Test thoroughly before submitting PR
- Follow Java naming conventions

---

## 📄 License

This project is licensed under the MIT License - see the LICENSE file for details.

```
MIT License

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, and distribute, subject to whom the
Software is furnished to do so, subject to the following conditions:
...
```

---

## 👨‍💻 Author

**Your Name**  
- GitHub: [@yourusername](https://github.com/yourusername)
- Email: your.email@example.com
- LinkedIn: [Your LinkedIn Profile](https://linkedin.com/in/yourprofile)

---

## 🙏 Acknowledgments

- Inspired by real-world browser navigation patterns
- Built with Spring Boot and modern web technologies
- Thanks to the Java and Spring communities

---

## 📞 Support

For support, email support@example.com or open an issue in the repository.

---

**Last Updated**: December 18, 2025  
**Version**: 2.0  
**Status**: ✅ Active & Maintained

