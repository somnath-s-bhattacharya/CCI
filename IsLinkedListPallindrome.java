package com.cci;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class IsLinkedListPallindrome {

	public static void main(String[] args) 
	{
		userinputHandler();		
	}

	public static void userinputHandler()
	{
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the number of characters you want to enter: ");
		int size = Integer.parseInt(input.nextLine());
		LinkedList<Character> list = new LinkedList<Character>();
		for(int i=0; i<size; i++)
		{
			System.out.print("Enter a lower case charater alphabet(only): ");
			Character ch = input.next().charAt(0);
			list.add(ch);
		}
		boolean b = isListPalindrome(list, size);
		if(isListPalindrome(list, size) == true) 
		{System.out.println("Linked List is a Palindrome");}
		else {System.out.println("Linked List is not a Palindrome");}
		//System.out.println(list);
	}

	public static boolean isListPalindrome(LinkedList<Character> list, int size)
	{
		boolean flag = false;
		ListIterator<Character> listIterator = list.listIterator();

		for(int i=0;i<size;i++)
		{
			if((list.get(i)) == list.get(size-1-i))
			{
				flag = true;
				continue;
			}
			else
			{
				flag = false;
				break;
			}

		}

		return flag;
	}

}

