package com.textaCulture.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.textaCulture.service.ExpenseService;
import com.textaCulture.Entity.Expense;

@RestController
@RequestMapping("/api/expenses")
public class restController {
    @Autowired
    private ExpenseService expenseService;
    
    @GetMapping("/hello")
    public String hello()
    {
    	return "hello";
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadExpense(@RequestBody Expense expense) {
        expenseService.createExpense(expense);
        return ResponseEntity.ok("Expense uploaded successfully");
    }

    @GetMapping("/list")
    public ResponseEntity<List<Expense>> getAllExpenses() {
        List<Expense> expenses = expenseService.getAllExpenses();
        return ResponseEntity.ok(expenses);
    }

    @GetMapping("/total/{category}")
    public ResponseEntity<Double> getTotalExpensesByCategory(@PathVariable String category) {
        Double totalExpense = expenseService.calculateTotalExpensesByCategory(category);
        return ResponseEntity.ok(totalExpense);
    }
}
