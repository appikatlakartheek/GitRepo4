import java.util.Scanner;

public class StringReversal {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter any text");
		String name=scan.next();
		System.out.println("The name entered is "+ name);	
		char  arr[]= name.toCharArray();
		System.out.println(arr);
		System.out.println(arr[arr.length-1]);

		for(int i=0;i<(arr.length)/2;i++)

				
		{
			char c;
			c=arr[i];
			arr[i]=arr[arr.length-(i+1)];
			arr[arr.length-(i+1)]=c;
			
		}
			

		System.out.println(arr);
		
	}
}

