package com.cci;

import java.util.Arrays;
import java.util.Scanner;

public class ReverseArraybyBlocks {

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a Random String without Whitespace: ");
		String str = sc.nextLine();
		System.out.print("Enter Reversal block(integer value less than the length of the string):");
		int n = Integer.parseInt(sc.nextLine());
		String temp = "";
		char[] ch = str.toCharArray();

		int index = n-1;
		int counter=0;
		for(int j=0; j<ch.length/n;j++)
		{
			for (int i=index; i>=counter; i--)
			{
				char c = ch[i];
				temp = temp + Character.toString(c);
				
			}
			counter=counter+n;
			index=index+n;
			
		}
		if(ch.length%n !=0)
		{
			int m=ch.length%n;
			index=index-n+m;
			for (int i=index; i>=counter; i--)
			{
				char c = ch[i];
				temp = temp + Character.toString(c);
			}
			ch = temp.toCharArray();
			System.out.println(Arrays.toString(ch));
		}
		else{
		ch = temp.toCharArray();
		System.out.println(Arrays.toString(ch));
		}
	}

}
