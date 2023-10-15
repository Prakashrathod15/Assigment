package com.textaCulture.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.textaCulture.Entity.Expense;

@Repository
public interface ExpenseRepo extends JpaRepository<Expense,Integer>{

	List<Expense> findByCategory(String category);

}
