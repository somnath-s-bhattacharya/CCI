package com.cci;

import java.util.*;

public class PermutationsandSubstrings {

	public static void main(String[] args) 
	{
		userinputHandler();
	}

	public static void userinputHandler()
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Enter Master String: ");
		String master_string = input.nextLine();
		System.out.println("Enter Child String: ");
		String child_string = input.nextLine();
		System.out.println("Parent Substrings of Permutations of valid length: " + Master_String_Manipulator(master_string.toUpperCase(), child_string.toUpperCase()));
		System.out.println("Child Permutations: " + Child_String_Manipulator(child_string.toUpperCase()));
		dataAnalyser(master_string,child_string);
	}

	public static void dataAnalyser(String master_string, String child_string)
	{
		TreeSet<String> Result = new TreeSet<String>();
		Iterator<String> itr1 = Master_String_Manipulator(master_string.toUpperCase(), child_string.toUpperCase()).iterator();
		while(itr1.hasNext())
		{
			String master = itr1.next();
			Iterator<String> itr2 = Child_String_Manipulator(child_string.toUpperCase()).iterator();
			while(itr2.hasNext())
			{
				String child = itr2.next();
				if(master.equals(child))
				{
					Result.add(child);
				}
			}
		}
		System.out.println("Count: " + Result.size());
		System.out.println("Compared Data: " + Result);
	}


	public static TreeSet<String> Master_String_Manipulator(String master_string, String child_string)
	{
		TreeSet<String> Result = new TreeSet<String>();
		Iterator<String> itr1 = Permutation(master_string).iterator();
		while(itr1.hasNext())
		{
			String perm_str = itr1.next();
			Iterator<String> itr2 = Substring(perm_str).iterator();
			while(itr2.hasNext())
			{
				String sub_str = itr2.next();
				if(sub_str.length()== child_string.length())
				{	
					Result.add(sub_str);
				}
			}

		}
		return Result;
	}

	public static TreeSet<String> Child_String_Manipulator(String child_string)
	{
		TreeSet<String> Result = new TreeSet<String>();
		Iterator<String> itr1 = Permutation(child_string).iterator();
		while(itr1.hasNext())
		{
			String perm_str = itr1.next();
			Result.add(perm_str);
		}
		return Result;
	}

	public static TreeSet<String> Substring(String string)
	{
		TreeSet<String> Result = new TreeSet<String>();
		for(int c = 0 ; c < string.length() ; c++ )
		{
			for(int i = 1 ; i <= string.length() - c ; i++ )
			{
				String sub = string.substring(c, c+i);
				Result.add(sub);
			}
		}
		return Result;
	}

	public static TreeSet<String> Permutation(String str) {
		TreeSet<String> Result = new TreeSet<String>();
		if (str == null) {
			return null;
		} else if (str.length() == 0) {
			Result.add("");
			return Result;
		}

		char firstChar = str.charAt(0);
		String rem = str.substring(1);
		Set<String> words = Permutation(rem);
		for (String newString : words) {
			for (int i = 0; i <= newString.length(); i++) {
				Result.add(CharAdd(newString, firstChar, i));
			}
		}
		return Result;
	}

	public static String CharAdd(String str, char c, int j) {
		String first = str.substring(0, j);
		String last = str.substring(j);
		return first + c + last;
	}



}
