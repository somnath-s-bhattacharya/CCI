package com.cci;

import java.util.*;


public class RemDupsFrmUnsortedLinkedList {

	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter the number of Strings you want to enter: ");
		int num = input.nextInt();   
		LinkedList<String> list = new LinkedList<String>();
		String str=null;
		System.out.println("Please enter the Strings: ");
		for(int i=0;i<num;i++)
		{
			str = input.next();
			list.add(str);
		}
		System.out.println(list);
		System.out.println(deleteDups1(list));
	}
	
	/**
	 * This method uses an additional buffer 
	 */
	public static LinkedList<String> deleteDups1(LinkedList<String> list) {
        Set s = new TreeSet<String>();
        s.addAll(list);
        list.clear();
        list.addAll(s);
		return list;
	}
	
	/**
	 * This method does not use an additional buffer 
	 */
	public void deleteDups(LinkedListNode head)
	{
		if(head == null)
		    return;

		LinkedListNode currentNode = head;       
		while(currentNode!=null){
		    LinkedListNode runner = currentNode;
		    while(runner.next!=null){
		        if(runner.next.data == currentNode.data)
		            runner.next = runner.next.next;
		        else
		            runner = runner.next;
		    }
		    currentNode = currentNode.next;
		}
	}
}
