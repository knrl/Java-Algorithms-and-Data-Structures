import java.util.Scanner;
import java.lang.Math;

class baseConverters{//base 2 to base 8
	public static void main(String [] args){
		Scanner scan = new Scanner(System.in);
		String strBytes = scan.nextLine();
		int base10Number = convertToBase10(strBytes);
		System.out.println("Base 10 number: "+ base10Number);
		int base8Number = convertToBase8(base10Number);
		System.out.println("Base 8 number: "+ base8Number);
	}

	static int convertToBase8(int base10Number){
		int b = base10Number, i = 0, sum = 0;
		int n = (int) (Math.log(base10Number) / Math.log(8)) + 1;
		byte [] octals = new byte [n];
		do {
			octals[n - i++ - 1] = (byte) (b % 8);
			b /= 8;
		} while(b > 8);
		octals[0] = (byte) b;
		i = 0;
		for (byte k : octals) sum += k * Math.pow(10, (n-1-i++));
		return sum;
	}

	static int convertToBase10(String strBytes){
		char [] charArr = strBytes.toCharArray();
		int top = 0, i = 0;
		for (int k=strBytes.length()-1;k>=0;k--)
			top += ((int) charArr[k] - 48)*Math.pow(2, i++);
		return top;
	}

}
