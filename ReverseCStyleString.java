package com.cci;

import java.util.Scanner;

/**
 * C-Style means that 'abcd' is represented as five characters, including the null character
 */


public class ReverseCStyleString {

	public static void main(String[] args) 
	{
		String input =null;
		while(true)
		{	
		System.out.println("Please Enter a String of your Choice: ");
		Scanner sc = new Scanner(System.in);
		input = sc.nextLine();
		if (input == null) 
		{
	        System.out.println("Please enter valid String");
	        break;
	    }
	    continue;
		}
		System.out.println(reverse(input));
	}
	
	public static String reverse(String input){
		char[] data = input.toCharArray();
		int i = 0;
		int j = data.length - 1;
		char temp;
		
		while(i < j){
			temp = data[i];
			data[i] = data[j];
			data[j] = temp;
			i++;
			j--;
		}
		
		String s = new String(data);
		return s;
	}

}
