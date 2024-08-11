package ass01;

import java.util.Scanner;

public class oddEven {

	public static void main(String[] args) {

int no;
	
	try (Scanner s = new Scanner(System.in)) {
		System.out.println("Enter any number");
		
		no = s.nextInt();
	}
	
	if(no%2==0)
	{
		System.out.println("even");
	}
	
	else
	{
		System.out.println("Odd");
	}
	
	}
}


	

