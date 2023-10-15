package com.textaCulture.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.textaCulture.Entity.Expense;
import com.textaCulture.repo.ExpenseRepo;

@Service
public class ExpenseService {
    @Autowired
    private ExpenseRepo expenseRepository;

    public Expense createExpense(Expense expense) {
       return expenseRepository.save(expense);
    }

    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    public Double calculateTotalExpensesByCategory(String category) {
        List<Expense> expenses = expenseRepository.findByCategory(category);
        return expenses.stream().mapToDouble(Expense::getAmount).sum();
    }
}
