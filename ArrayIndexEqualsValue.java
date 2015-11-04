package com.cci;

import java.util.*;

public class ArrayIndexEqualsValue {

	public static void main(String[] args) 
	{
		Integer [] arr = new Integer[6];
		arr[0] = -1;
		arr[1] = 5;
		arr[2] = 3;
		arr[3] = -4;
		arr[4] = 0;
		arr[5] = 6;
		for(int i=0; i<arr.length; i++)
		{
			System.out.println(arr[i]);
		}
		System.out.println(indexValueFinder(arr));
		
	}
	
	public static TreeSet<Integer> indexValueFinder(Integer[] arr )
	{
		TreeSet<Integer> Result = new TreeSet<Integer>();
		for(int i=0; i<arr.length; i++)
		{
			if(i==arr[i])
			{
				Result.add(arr[i]);
			}
			else
			{
				Result.add(-1);
			}
		}
		
		return Result;
	}
	
	

}
