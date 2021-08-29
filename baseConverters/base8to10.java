import java.util.Scanner;
import java.lang.Math;

class baseConverters{//base 8 to base 2
	public static void main(String [] args){
		Scanner scan = new Scanner(System.in);
		int base8Number = scan.nextInt();
		int base10Number = convertToBase10(base8Number);
		System.out.println("Base 10:" + base10Number);
	}

	static int convertToBase10(int base8Number){
		int b = base8Number, sum = 0, i = 0;
		while (b > 0){
			sum += (b % 10) * Math.pow(8, i++);
			b /= 10;
		}
		return sum;
	}

}
