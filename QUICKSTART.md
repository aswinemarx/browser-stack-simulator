# QUICKSTART.md - Pro Browser Stack v2.0

## ⚡ 5-Minute Quick Start Guide

Get the Pro Browser Stack running in minutes!

---

## Prerequisites Check

```bash
# Check Java installation
java -version
# Should show: Java 17 or higher

# Check Maven installation
mvn -version
# Should show: Maven 3.6 or higher
```

If either is missing, install them first:
- **Java**: https://www.oracle.com/java/technologies/downloads/
- **Maven**: https://maven.apache.org/download.cgi

---

## Step 1: Clone & Navigate (1 min)

```bash
# Clone the repository
git clone https://github.com/yourusername/pro-browser-stack.git

# Navigate to project directory
cd pro-browser-stack

# Verify project structure
ls -la
# You should see: pom.xml, src/, README.md
```

---

## Step 2: Build the Project (2 min)

```bash
# Clean previous builds and download dependencies
mvn clean install

# Expected output:
# [INFO] BUILD SUCCESS
# [INFO] Total time: XX.XXs
```

If you see `BUILD SUCCESS`, move to Step 3! ✅

**Troubleshooting**:
- If build fails, ensure you have internet connection (Maven needs to download dependencies)
- On corporate networks, you may need to configure Maven proxy settings

---

## Step 3: Run the Application (1 min)

```bash
# Start the Spring Boot application
mvn spring-boot:run

# Expected output:
# 2025-12-18 11:20:00.000  INFO 12345 --- [main] c.e.d.DemoApplication : 
#   Starting DemoApplication using Java 17.0.1...
# ...
# 2025-12-18 11:20:02.000  INFO 12345 --- [main] c.e.d.DemoApplication : 
#   Started DemoApplication in 2.345 seconds (JVM running for 3.456)
# 
# ✅ Tomcat started on port(s): 8080
```

---

## Step 4: Open in Browser (1 min)

Open your favorite browser and go to:

```
http://localhost:8080
```

You should see:

```
┌─────────────────────────────────────────┐
│  Pro Browser Stack v2.0                 │
│                                         │
│ ← → [URL Input Area]                    │
│                                         │
│           GOOGLE.COM                    │
│       (in large blue text)              │
│                                         │
│  ✓ Secure Connection Verified           │
└─────────────────────────────────────────┘

Sidebar shows:
- Back Stack (LIFO)
- Forward Stack
- [Clear All History]
```

---

## Common Commands

### Build & Run

```bash
# Build only (no run)
mvn clean package

# Run with logs
mvn spring-boot:run -X

# Run JAR directly
java -jar target/demo-0.0.1-SNAPSHOT.jar

# Run on different port
mvn spring-boot:run -Dspring-boot.run.arguments="--server.port=8081"
```

### Stop Application

```bash
# In the terminal where it's running:
Ctrl + C

# Or kill the process:
lsof -i :8080          # Find process on port 8080
kill -9 <PID>          # Kill the process
```

### View Live Logs

```bash
# Real-time logs while running
mvn spring-boot:run

# Or from running JAR
tail -f logs/application.log
```

---

## Quick Navigation Test

Try this workflow to test the application:

```
1. Page Loads
   Current: "Google.com"
   Back Stack: (empty)
   Forward Stack: (empty)

2. Type "GitHub.com" in the URL input and press Enter
   Current: "GitHub.com"
   Back Stack: ["Google.com"]
   Forward Stack: (empty)

3. Type "LinkedIn.com" and press Enter
   Current: "LinkedIn.com"
   Back Stack: ["Google.com", "GitHub.com"]
   Forward Stack: (empty)

4. Click Back Button (←)
   Current: "GitHub.com"
   Back Stack: ["Google.com"]
   Forward Stack: ["LinkedIn.com"]

5. Click Back Button Again (←)
   Current: "Google.com"
   Back Stack: (empty)
   Forward Stack: ["GitHub.com", "LinkedIn.com"]

6. Click Forward Button (→)
   Current: "GitHub.com"
   Back Stack: ["Google.com"]
   Forward Stack: ["LinkedIn.com"]

7. Click Clear All History Button
   Current: "Home"
   Back Stack: (empty)
   Forward Stack: (empty)
```

---

## Project Structure (30 seconds)

```
pro-browser-stack/
│
├── pom.xml                          ← Maven configuration
├── README.md                        ← Full documentation
├── ARCHITECTURE.md                  ← Architecture details
│
└── src/main/
    ├── java/com/example/demo/
    │   ├── BrowserController.java   ← Main controller
    │   └── DemoApplication.java     ← Entry point
    │
    └── resources/
        ├── templates/
        │   └── index.html           ← UI Template
        └── application.properties   ← Configuration
```

---

## Files You Interact With

### 1. BrowserController.java
**Purpose**: Handles all navigation logic  
**Key Methods**:
- `visit()` - Navigate to new URL
- `back()` - Go back
- `forward()` - Go forward
- `clear()` - Clear history

### 2. index.html
**Purpose**: User interface  
**Contains**:
- Navigation buttons
- URL input field
- Stack display
- Styling

### 3. pom.xml
**Purpose**: Maven build configuration  
**Contains**:
- Project metadata
- Dependencies (Spring Boot, Thymeleaf)
- Build plugins

---

## Common Issues & Solutions

| Issue | Solution |
|-------|----------|
| **Port 8080 in use** | Change port: Add `server.port=8081` to `application.properties` |
| **Build fails** | Run `mvn clean install -U` to force dependency update |
| **Template not found** | Ensure `index.html` is in `src/main/resources/templates/` |
| **Application won't start** | Check logs for errors, verify Java 17+ installed |
| **Buttons disabled** | This is normal - they enable when stacks have data |
| **No styling** | Clear browser cache (Ctrl+Shift+Delete) and reload |

---

## IDE Setup (Optional)

### IntelliJ IDEA

```
1. File → Open → Select project folder
2. Maven should auto-detect pom.xml
3. Wait for dependencies to download
4. Right-click DemoApplication.java → Run 'DemoApplication.main()'
```

### Eclipse

```
1. File → Import → Existing Maven Projects
2. Browse to project folder
3. Select pom.xml
4. Right-click project → Run As → Spring Boot App
```

### VS Code

```
1. Install "Extension Pack for Java"
2. Open project folder
3. It will detect Maven project
4. Use Run menu to start application
```

---

## What to Try Next

### 1. Modify the UI
Open `src/main/resources/templates/index.html`:
- Change colors in `<style>` section
- Modify button text
- Adjust layout

### 2. Add More Features
Edit `src/main/java/com/example/demo/BrowserController.java`:
```java
// Add a bookmark feature
@PostMapping("/bookmark")
public String bookmark(@RequestParam String url, Model model) {
    // Your code here
    updateView(model);
    return "index";
}
```

### 3. Test the Stack Logic
Create unit tests in `src/test/java/`:
```java
@SpringBootTest
public class BrowserControllerTest {
    @Test
    public void testBackNavigation() {
        // Your test here
    }
}
```

### 4. Deploy to Cloud
Package as JAR and deploy to:
- Heroku
- AWS
- Docker
- GitHub Pages

---

## Next Steps

1. **Read Full Documentation**: Open `README.md` for complete guide
2. **Understand Architecture**: Check `ARCHITECTURE.md` for deep dive
3. **Modify & Experiment**: Change colors, add features, deploy
4. **Create Your Own**: Use this as template for your projects

---

## Quick Reference Commands

```bash
# Development
mvn clean install               # Build project
mvn spring-boot:run            # Run application
mvn clean package              # Create JAR file

# Testing
mvn test                        # Run all tests
mvn test -Dtest=ClassName      # Run specific test

# Deployment
mvn clean package -DskipTests   # Build without tests
java -jar target/demo-*.jar    # Run JAR

# Cleaning
mvn clean                       # Remove target/ folder
mvn dependency:purge-local-repository  # Clear Maven cache
```

---

## Keyboard Shortcuts

| Action | Shortcut |
|--------|----------|
| Build | `Ctrl+B` (IDE dependent) |
| Run | `Shift+F10` (IDE dependent) |
| Stop | `Ctrl+C` (Terminal) |
| Reload Page | `F5` or `Ctrl+R` (Browser) |
| Clear Cache | `Ctrl+Shift+Delete` (Browser) |
| Open DevTools | `F12` (Browser) |

---

## Performance Tips

- **First Run**: May take 30-60 seconds to download all Maven dependencies
- **Subsequent Runs**: Start in ~2-5 seconds
- **Memory Usage**: ~400-500 MB for development
- **Browser Performance**: Works on all modern browsers (Chrome, Firefox, Safari, Edge)

---

## Getting Help

1. **Check Logs**: Look at console output for error messages
2. **Read Documentation**: Full details in README.md and ARCHITECTURE.md
3. **Check GitHub Issues**: See if others had same problem
4. **Search Online**: Use error message to search solutions

---

## Success Indicators

✅ Maven build completes with `BUILD SUCCESS`  
✅ Application starts with `Started DemoApplication`  
✅ Can access `http://localhost:8080` in browser  
✅ Can type URLs and navigate  
✅ Back/Forward buttons work  
✅ Clear History button works  

If you have all of these, **you're ready to go!** 🎉

---

**Ready?** Start with Step 1 above and you'll have the application running in 5 minutes!

**Questions?** Check README.md or ARCHITECTURE.md for detailed information.

**Last Updated**: December 18, 2025

