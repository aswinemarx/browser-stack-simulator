package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Stack;

@Controller
public class BrowserController {

    private Stack<String> backStack = new Stack<>();
    private Stack<String> forwardStack = new Stack<>();
    private String currentPage = "Google.com";

    @GetMapping("/")
    public String index(Model model) {
        updateView(model);
        return "index";
    }

    @PostMapping("/visit")
    public String visit(@RequestParam String url, Model model) {
        if (currentPage != null) backStack.push(currentPage);
        currentPage = url;
        forwardStack.clear();
        updateView(model);
        return "index";
    }

    @PostMapping("/back")
    public String back(Model model) {
        if (!backStack.isEmpty()) {
            forwardStack.push(currentPage);
            currentPage = backStack.pop();
        }
        updateView(model);
        return "index";
    }

    @PostMapping("/forward")
    public String forward(Model model) {
        if (!forwardStack.isEmpty()) {
            backStack.push(currentPage);
            currentPage = forwardStack.pop();
        }
        updateView(model);
        return "index";
    }

    // NEW: Clear History Method
    @PostMapping("/clear")
    public String clear(Model model) {
        backStack.clear();
        forwardStack.clear();
        currentPage = "Home";
        updateView(model);
        return "index";
    }

    private void updateView(Model model) {
        model.addAttribute("current", currentPage);
        model.addAttribute("backHistory", backStack);
        model.addAttribute("forwardHistory", forwardStack);
        // Added boolean checks for button styling
        model.addAttribute("hasBack", !backStack.isEmpty());
        model.addAttribute("hasForward", !forwardStack.isEmpty());
    }
}