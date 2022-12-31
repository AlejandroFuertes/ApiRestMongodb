package com.capacitacion.apirestmongodb.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.capacitacion.apirestmongodb.model.Expense;
import com.capacitacion.apirestmongodb.repository.ExpenseRepository;
import com.capacitacion.apirestmongodb.service.ExpenseService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ExpenseServiceImpl implements ExpenseService {

	private final ExpenseRepository expenseRepository;

	@Override
	public void addExpense(Expense expense) {
		expenseRepository.insert(expense);
	}

	@Override
	public void updateExpense(Expense expense) {
		Expense savedExpense = expenseRepository.findById(expense.getId()).orElseThrow(
				() -> new RuntimeException(String.format("Cannot find expense by ID %s", expense.getId())));

		savedExpense.setExpenseName(expense.getExpenseName());
		savedExpense.setExpenseCategory(expense.getExpenseCategory());
		savedExpense.setExpenseAmount(expense.getExpenseAmount());

		expenseRepository.save(savedExpense);
	}

	@Override
	public List<Expense> getAllExpenses() {
		return expenseRepository.findAll();

	}

	@Override
	public Expense getExpenseByName(String name) {
		return expenseRepository.findByName(name)
				.orElseThrow(() -> new RuntimeException(String.format("Cannot find expense by name %s", name)));

	}

	@Override
	public void deleteExpense(String id) {
		expenseRepository.deleteById(id);
	}
}
