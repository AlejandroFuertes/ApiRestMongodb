package com.capacitacion.apirestmongodb.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capacitacion.apirestmongodb.model.Expense;
import com.capacitacion.apirestmongodb.service.impl.ExpenseServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/expense")
@RequiredArgsConstructor
public class ExpenseController {

	private final ExpenseServiceImpl expenseServiceImpl;

	@PostMapping(value = "/add")
	public ResponseEntity<String> addExpense(@RequestBody Expense expense) {
		expenseServiceImpl.addExpense(expense);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@GetMapping(value = "/all")
	public ResponseEntity<List<Expense>> getAllExpenses() {
		return new ResponseEntity<>(expenseServiceImpl.getAllExpenses(), HttpStatus.OK);
	}

	@PutMapping(value = "/update")
	public ResponseEntity<String> updateExpenseById(@RequestBody Expense expense) {
		expenseServiceImpl.updateExpense(expense);
		return new ResponseEntity<String>(HttpStatus.OK);
	}

	@GetMapping(value = "/{name}")
	public ResponseEntity<Expense> getExpenseByName(@PathVariable(name = "name") String name) {
		return new ResponseEntity<Expense>(expenseServiceImpl.getExpenseByName(name), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<String> deleteExpenseById(@PathVariable(name = "id") String id) {
		expenseServiceImpl.deleteExpense(id);
		return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
	}
}
