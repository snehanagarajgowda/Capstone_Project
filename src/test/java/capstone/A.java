package capstone;

import java.util.Arrays;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;

public class A{
	public static void main(String args[]) {
		
		//Reverse number
	/*	int num=1234;
		int reverse=0;
		while(num!=0) {
			int digit = num%10;
			reverse = reverse*10+digit;
			num = num/10;
		}
		System.out.println("Reversed no is:" +reverse); 
		
		//Palindrome number
		int num=121;
		int palindromeNo = 121;
		int reverse=0;
		while(num!=0) {
			int digit = num%10;
			reverse = reverse*10+digit;
			num/=10;
		}
		if(palindromeNo==reverse) {
			System.out.println("Number is palindrome");
			
		}
		else {
			System.out.println("Number is not palindrome");
		}   
		
		//Count number of digits
		int num = 123456;
		int count=0;
		int reverse=0;
		while(num!=0) {
			int digit = num%10;
			 reverse = reverse*10+digit;
			 num/=10;
			 count++;
		}
		System.out.println(count);       
		
		//2D Array
		int a[][] = { {100,200}, 
				{300, 400}, 
				{500,600}
				};
		for(int r=0;r<a.length;r++) {
			for(int c=0;c<a[r].length;c++) {
				System.out.print(a[r][c]+ " ");
			}
			System.out.println();
		}      
		
		//Enhanced 2D Array
		for(int arr[]: a) {
			for(int x:arr) {
				System.out.print(x+ " ");
			}
			System.out.println();		
		}             
		
		//Sum of elements in array
	//	a= {1,2,3,4,5}
	//	sum=15;
		
		int a[] = {1,2,3,4,5};
		int sum=0;
		for(int x:a) {
			sum +=x;
			}
		System.out.println("The sum of numbers is:" +sum); 
		
		//Print even and odd
		int a[] = {1,2,3,4,5,6};
//		for(int i=0;i<a.length;i++) {
//			if(i%2==0) {
//				System.out.println(a[i]+ "Even");
//			}
//			else {
//				System.out.println(a[i]+ "Odd");
//				
//			}
//			
//		}
		for(int x:a) {
			if(x%2==0) {
				System.out.println(x+ "Even");
			}
			else {
				System.out.println(x+ "Odd");

				
			}
		}     
		
		//Search element in array
		
		int a[]= {10,20,30,40,50};
		int search_element=70;
		boolean status=false;
		for(int i=0;i<a.length;i++) {
			if(a[i]==search_element) {
				System.out.println("Element is found");
				status=true;
				break;

			}
		}
		if(status!=true) {
			System.out.println("Element not found");
			
		}  
		
		//Count duplicate values
		int a[] = {100,200,300,100,400,100,500,100,100};
		int num = 100;
		int count=0;
		for(int i=0;i<a.length;i++) {
			if(a[i]==num) {
				count++;
			}
		}
		System.out.println(count); 
		
		//To sort the array
		int a[] = {100,500,300,200,400};
		System.out.println("Before sorting...");
		System.out.println(Arrays.toString(a));
		
		Arrays.sort(a);
		System.out.println("After sorting...");
		System.out.println(Arrays.toString(a));      
		
		//Sort characters
		
		char ch[] = {'D', 'B', 'C', 'A'};
		System.out.println("Before sorting......." +Arrays.toString(ch));
		Arrays.sort(ch);
		System.out.println("After sorting........" +Arrays.toString(ch)); 
		
		//Reversing the array;
		int rev[] = {1,2,3,4,5};
		for(int i=rev.length-1;i>0;i--) {
			System.out.println(i);  
			} 
		
		//String 
		//To remove spaces
		String s= "   Welcome   ";
		System.out.println(s.trim());  
		
		//Reverse a  string
		String s = "Welcome";
		String rev="";
		for(int i=s.length()-1;i>=0;i--){
			rev=rev+s.charAt(i);
		}
		System.out.println(rev);         */
		
		//Converting string to char array
		String s = "Welcome";
		String rev="";
		char a[]=s.toCharArray();
		for(int i=a.length-1;i>=0;i--) {
			rev=rev+a[i];	
		}
		System.out.println(rev);
		
			
		}
	}

