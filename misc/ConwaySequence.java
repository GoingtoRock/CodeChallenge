package test;

import java.util.Scanner;

public class ConwaySequence {


	public static String conwaySequence(String n){
		
		String finalString = new String();
	 
		char c = n.charAt(0);
		
		String endLine = "@";
		n= n.substring(1) + endLine;
		
		int occurrence = 1;
		
		char space = 32;
	 
		for(char actual: n.toCharArray()) {
			if(actual != space) {
				if(actual != c) {				
					finalString += occurrence + " " + c + " ";
					occurrence= 1;
					c= actual;
				} else {
					occurrence += 1;
				}
			}
		}
		
		return finalString;
	}
	
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		
		/* num range : 1 to 100 */
		int num = sc.nextInt();
		String n = String.valueOf(num);
		
		/* line range : 1 to 25 */
		int line = sc.nextInt();
	 
		for (int i = 1; i < line; i++) {
			n = conwaySequence(n);             
		}
		System.out.println(n);
	}
	
}
