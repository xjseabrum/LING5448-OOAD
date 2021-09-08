package question1;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner= new Scanner(System.in);
		String s;
		
		
		do {
			//reads a string from the console input
			s = scanner.nextLine();
			
			//change the input string to upper case
			s=s.toUpperCase();
			
			//sort the letters in the string into alphabetic order
			char charArray[]=s.toCharArray();
			Arrays.sort(charArray);
			
			//print the sorted string to the console
			System.out.println(charArray);
		}
		//program will end if a null string is submitted as input
		while(!s.isEmpty());

	}

}
