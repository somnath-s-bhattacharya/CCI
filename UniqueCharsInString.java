package com.cci;

import java.util.*;
/**
 * Determine whether a String provided by the user
 * contains unique characters
 * WhiteSpaces, punctuations will not be considered
 */

public class UniqueCharsInString {

	public static void main(String[] args) 
	{
		System.out.println("Please Enter a String of your Choice: ");
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		if(isUniqueChars3(input)==true) System.out.println("Unique Characters only");
		else System.out.println("Duplicate Characters Present");
	}
	
	/**
	 * asssuming the character set contains only ASCII supported characters
	 * Time Complexity for below method is O(n) 
	 */
	public static boolean isUniqueChars1(String str)
	{
		boolean[] char_set = new boolean[256];
		for(int i=0; i<str.length();i++)
		{
			int val = str.charAt(i);
			if(char_set[val]) return false;
			char_set[val] =true;
		}
		return true;
	}
	
	/**
	 * To reduce the space usage a little bit we can use a bit vector
	 * This will allow us to deal with int value during the operation
	 * Time Complexity for below method is O(n) 
	 */
	public static boolean isUniqueChars2(String str)
	{
		int checker = 0;
		for(int i=0; i<str.length();++i)
		{
			int val = str.charAt(i) - 'a';
			if((checker & (1<<val)) > 0) return false;
			checker |= (1<<val);
		}
		return true;
	}
	
	
	/**
	 * HashSet 
	 */
	public static boolean isUniqueChars3(String str)
	{
		HashSet<Character> h = new HashSet<Character>();
		for (char c : str.toCharArray()) {
		if (!h.add(Character.toUpperCase(c))) // break if already present
		   return false;
		  }
		  return true;
	}
	
}
