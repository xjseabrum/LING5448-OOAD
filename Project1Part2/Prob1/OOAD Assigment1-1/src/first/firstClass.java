package first;

import java.util.Arrays;
import java.util.Scanner;

public class firstClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner= new Scanner(System.in);
		String s;
		do {
			s = scanner.nextLine();
			s=s.toUpperCase();
			char charArray[]=s.toCharArray();
			Arrays.sort(charArray);
			System.out.println(charArray);
		}
		while(!s.isEmpty());

	}

}
