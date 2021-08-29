import java.util.Scanner;
import java.lang.Math;

class baseConverters{//base 16 to base 10
	public static void main(String [] args){
		Scanner scan = new Scanner(System.in);
		String strBase16 = scan.nextLine();
		int base10Number = convertToBase10(strBase16);
		System.out.println("Base 10: " + base10Number);
	}

	static int convertToBase10(String strBase16){
		char [] charArr = strBase16.toCharArray();
		int sum = 0, i = 0, a = 0, n = charArr.length-1;
		for (char c : charArr){
			if (((int) c >= 65 && (int) c <= 70) || ((int) c >= 97 && (int) c <= 102))
				a = ((int) c >= 97) ? (int) c - 32 : (int) c;
			else if ((int) c >= 48 && (int) c <= 57)
				a  = (int) c - 48;
			sum += a * Math.pow(16, (n-i++));
		}
		return sum;
	}
}
