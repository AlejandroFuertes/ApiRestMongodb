package com.capacitacion.apirestmongodb.service;

import java.util.List;

import com.capacitacion.apirestmongodb.model.Expense;

public interface ExpenseService {

	public void addExpense(Expense expense);
	
	public void updateExpense(Expense expense);
	
	public List<Expense> getAllExpenses();
	
	public Expense getExpenseByName(String name);
	
	public void deleteExpense(String id);
}
