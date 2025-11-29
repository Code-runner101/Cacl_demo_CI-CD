package com.example.calculator_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/calc")
public class CalculatorDemoApplication {

	@GetMapping
	public String calculate(@RequestParam double a, @RequestParam double b, @RequestParam String op) {
		double result;
		switch (op) {
			case "add":
				result = a + b;
				break;
			case "sub":
				result = a - b;
				break;
			case "mul":
				result = a * b;
				break;
			case "div":
				if (b == 0) throw new ArithmeticException("Division by zero");
				result = a / b;
				break;
			default:
				return "Неизвестная операция! Используйте add, sub, mul, div.";
		}
		return "Результат: " + result + "\n";
	}

	public static void main(String[] args) {
		SpringApplication.run(CalculatorDemoApplication.class, args);
	}
}
