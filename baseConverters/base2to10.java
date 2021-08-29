import java.util.Scanner;
import java.lang.Math;

class baseConverters{//base 2 to base 10
	public static void main(String [] args){
		Scanner scan = new Scanner(System.in);
		String strBytes = scan.nextLine();
		int base10Number = baseConverter(strBytes);
		System.out.println("Number: "+ base10Number);
	}

	static int baseConverter(String strBytes){
		char [] charArr = strBytes.toCharArray();
		int top = 0, i = 0;
		for (int k=strBytes.length()-1;k>=0;k--)
			top += ((int) charArr[k] - 48)*Math.pow(2, i++);
		return top;
	}
}
