import java.util.Scanner;
import java.lang.Math;

class baseConverters{//base 8 to base 2
	public static void main(String [] args){
		Scanner scan = new Scanner(System.in);
		int base8Number = scan.nextInt();
		int base10Number = convertToBase10(base8Number);
		int n = (int) (Math.log(base10Number) / Math.log(2)) + 1;
		byte [] bytes = new byte [n];
		bytes = convertToBase2(base10Number);
		for (byte i : bytes) System.out.print(" "+i);
	}

	static byte [] convertToBase2(int base10Number){
		int n = (int) (Math.log(base10Number) / Math.log(2)) ;
		byte [] bytes = new byte[n+1];
                int b = base10Number;
                while (b > 1){
                        bytes[n--] = (byte) (b % 2);
                        b /= 2;
                }
		bytes[0] = (byte) (b % 2);
                return bytes;
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

