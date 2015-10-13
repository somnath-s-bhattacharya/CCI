package com.cci;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * Removal of duplicate characters in a String without using additional Characters 
 */

public class RemoveDupsInString {

	public static void main(String[] args) 
	{
		final Set<Character> charaters = new TreeSet<Character>();
		userInput(charaters);
		output(charaters);
	}

	private static void userInput(final Set<Character> characters) 
	{
		System.out.println("Enter a String of your choice: ");
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		for(int i=0; i<str.length(); i++)
		{	
			characters.add(str.charAt(i));
		}
	}	

	private static void output(final Set<Character> characters) {
		System.out.println("Below is the set which is sorted and without duplicate characters");
		for (Character str : characters) {
			System.out.println(str);
		}
	}
}
