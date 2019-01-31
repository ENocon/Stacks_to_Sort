//Programmer: Elizabeth Nocon
//Class: CS 1450.001 MW
//Assignment Number: 5
//Due Date: 9/26/2018
//Description: 
//This program reads information from four different text files, and assigns the information to four different stacks. 
//The program then prints the read values. Then, the program merges two stacks into one, sorts the stack, and reprints the stack. 
//When, the program prints the sorted stack, the stack is sorted/printed in the order of smallest to largest.

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.lang.Comparable;
import java.util.List;


public class EHortonAssignment5 
{
	public static void main (String[] args) throws Exception 
	{
		//Create two GenericStack objects of type integer. 
		GenericStack<Integer> integerFile1 = new GenericStack<Integer>();
		GenericStack<Integer> integerFile2 = new GenericStack<Integer>();
		
		//Create a file instance for first integers text file. 
		java.io.File integers1File = new java.io.File("integers1.txt");
				
		//Print heading. 
		System.out.println("\nValues read from integers1.txt and pushed onto stack1");
		System.out.println("-------------------------------------------------------");
		
		//Create a scanner for the first integers text file. 
		Scanner integersFile1Input = new Scanner(integers1File);
		while (integersFile1Input.hasNext()) 
		{
			int value = integersFile1Input.nextInt();
			integerFile1.push(value);
			System.out.println(value);
		}
		integersFile1Input.close();
		
		//Create a file instance for second integers text file. 
		java.io.File integers2File = new java.io.File("integers2.txt");
		
		//Print heading. 
		System.out.println("\nValues read from integers2.txt and pushed onto stack2");
		System.out.println("-------------------------------------------------------");
		
		//Create a scanner for the second integers text file. 
		Scanner integersFile2Input = new Scanner(integers2File);
		while (integersFile2Input.hasNext()) 
		{
			int value = integersFile2Input.nextInt();
			integerFile2.push(value);
			System.out.println(value);
		}
		integersFile2Input.close();
		//Create merged stack. 
		GenericStack<Integer> mergedIntegerStack = new GenericStack<Integer>();
		
		//Call mergeStacks method. 
		mergeStacks(integerFile1, integerFile2, mergedIntegerStack);
		
		//Print heading
		System.out.println("\nMerged Stack with lowest value on top:");
		System.out.println("---------------------------------------");
		
		//Create reverseIntegerStack.
		GenericStack<Integer> reverseIntegerStack = new GenericStack<Integer>();
				
		//Call and print reverseStack. 
		reverseStack(mergedIntegerStack, reverseIntegerStack);
		printList(reverseIntegerStack);
		
		//Create two GenericStack objects of string type. 
		GenericStack<String> statesFile1 = new GenericStack<String>();
		GenericStack<String> statesFile2 = new GenericStack<String>();
				
		//Create a file instance for first integers text file. 
		java.io.File states1File = new java.io.File("states1.txt");
						
		//Print heading. 
		System.out.println("\nValues read from states1.txt and pushed onto stack1");
		System.out.println("-------------------------------------------------------");
		
		//Create a scanner for the first integers text file. 
		Scanner statesFile1Input = new Scanner(states1File);
		while (statesFile1Input.hasNext()) 
		{
			String value = statesFile1Input.next();
			statesFile1.push(value);
			System.out.println(value);
		}
		statesFile1Input.close();
		
			
		//Create a file instance for second integers text file. 
		java.io.File states2File = new java.io.File("states2.txt");
		
		//Print heading. 
		System.out.println("\nValues read from states2.txt and pushed onto stack2");
		System.out.println("-------------------------------------------------------");
		
		//Create a scanner for the second integers text file. 
		Scanner statesFile2Input = new Scanner(states2File);
		while (statesFile2Input.hasNext()) 
		{
			String value = statesFile2Input.next();
			statesFile2.push(value);
			System.out.println(value);
		}
		statesFile2Input.close();
		
		//Create merged stack. 
		GenericStack<String> mergedStateStack = new GenericStack<String>();
				
		//Call mergeStacks method. 
		mergeStacks(statesFile1, statesFile2, mergedStateStack);
		
		//Print heading
		System.out.println("\nMerged Stack with lowest value on top:");
		System.out.println("---------------------------------------");
		
		//Create reverseStateStack.
		GenericStack<String> reverseStateStack = new GenericStack<String>();
		
		//Call and print reverseStack. 
		reverseStack(mergedStateStack, reverseStateStack);
		printList(reverseStateStack);
		
	}
	
	//Create generic method mergeStacks. 
	public static <E extends Comparable<E>> void mergeStacks(GenericStack<E> stack1, GenericStack<E> stack2, GenericStack<E> mergedStack) 
	{
		//Add list 1 and list 2 to mergeStack in correct order. 
		//While list1 and list2 are not empty. They have values.
		while (! stack1.isEmpty() && ! stack2.isEmpty()) 
		{
			E element1 = stack1.peek();
			E element2 = stack2.peek();
			
			//If element 1 is smaller than element 2, then it will return a negative value. 
			//So, then we are putting the smallest value on top. 
			if (element1.compareTo(element2) < 0) 
			{
				mergedStack.push(stack1.pop());
			}
			else if (element1.compareTo(element2) > 0) 
			{
				mergedStack.push(stack2.pop());
			}
			else 
			{
				mergedStack.push(stack2.pop());
			}
		}
		
		
	}
		
	//Create a method that reverses the order of the mergedStack.
	public static <E> void reverseStack(GenericStack<E> mergeStack, GenericStack<E> reverseStack) 
	{
		while (! mergeStack.isEmpty()) 
		{
			reverseStack.push(mergeStack.pop());
		}
	}
		
			
		//Create a method that prints the values of a genericStack.
		public static <E> void printList(GenericStack<E> stackToPrint) 
		{
			while(! stackToPrint.isEmpty())
			{
				System.out.println(stackToPrint.pop());
			}
		}
		
} //Assignment 5

//Create GenericStack Class. 
class GenericStack<E> 
{
	//Create Private Data Fields. 
	private ArrayList<E> list;
	private int index = 0;
	
	//Create GenericStack constructor. 
	public GenericStack() 
	{
		list = new ArrayList<>();
	}
	
	//Create getSize method. Returns the number of objects currently on the stack. 
	public int getSize() 
	{
		return list.size();
	}
	
	//Create isEmpty method. Indicates if the stack is currently empty. 
	public boolean isEmpty() 
	{
		return list.isEmpty();
	}
	
	//Create peek method. Returns object on the top off the Stack. 
	public E peek() 
	{
		//Get object from top of stack.
		return list.get(getSize()-1);
	}
	
	//Create push method. Adds an object to the top of the stack. (End of ArrayList in this assignment.)
	public void push (E object) 
	{
		//Add object to top of stack.
		list.add(index, object);
		index++;
	}
	
	//Create a pop method. Removes the object on the top of the stack. (End of ArrayList in this assignment.)
	public E pop() 
	{
		//Object on top of stack.
		E object = list.get(getSize()-1);
		list.remove(getSize()-1);
		return object;
	}
}//GenericStack Class.
