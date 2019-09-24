package basic.Selenium;

import java.util.Iterator;
import java.util.Scanner;

public class StringManipulation {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		reverseStringWithRemoveDuplication();
	}
       //reverseWith  duplication
	public static void reverseStringWithRemoveDuplication() {
		String rev = "";
		String temp="";
		System.out.println("Enter String :");
		String input = sc.nextLine();
		for (int i = input.length() - 1; i >= 0; i--) {
			rev = rev + input.charAt(i);
		}
		for(int i=0;i<input.length()/2;i++) {
			temp=temp+input.charAt(i);
			rev=rev+input.charAt(input.length()-1-i);
			
		}
		
		System.out.println(rev);
	}
}
