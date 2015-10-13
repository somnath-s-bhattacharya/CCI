package com.cci;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Check if two given Strings are anagrams or not
 */
public class isAnagram {

	public static void main(String[] args) 
	{
		System.out.println("Enter String 1: ");
		Scanner scanner = new Scanner(System.in);
		String str1 = scanner.nextLine();
		System.out.println("Enter String 2: ");
		String str2 = scanner.nextLine();
		if(isAnagram(str1,str2)==true)
		{
			System.out.println("The two Strings are Anagrams");
		}
		else
		{
			System.out.println("The two Strings are not Anagrams");
		}
	}
	
	public static boolean isAnagram(String firstStr, String secondStr) {
	     char[] str1 = firstStr.replaceAll("[\\s]", "").toCharArray();
	     char[] str2 = secondStr.replaceAll("[\\s]", "").toCharArray();
	     Arrays.sort(str1);
	     Arrays.sort(str2);
	     return Arrays.equals(str1, str2);
	}
}
