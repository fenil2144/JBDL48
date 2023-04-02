package org.geeksforgeeks.calculator;

import java.util.Scanner;

import org.geeksforgeeks.utils.MathOperations;

public class CalculatorApplication {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		System.out.println("Addition of a and b = "+MathOperations.add(a, b));
		
		System.out.println("Addition of a and b = "+MathOperations.multiply(a, b));

	}

}
