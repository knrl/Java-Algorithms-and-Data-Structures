import java.util.Scanner;
import java.lang.*;

class baseConverters{//base 10 to base 2
        public static void main(String [] args){
                Scanner scan = new Scanner(System.in);
                int number = scan.nextInt();
                int n = (int) (Math.log(number) / Math.log(2)) + 1;
                byte [] bytes = new byte[n];
                bytes = baseConverter(number);
                for (byte i : bytes) System.out.print(" " + i);
        }

        static byte [] baseConverter(int number){
                int n = (int) (Math.log(number) / Math.log(2));
                byte [] bytes = new byte [n+1];
                int b = number;
                while (b > 1){
                        bytes[n--] = (byte) (b % 2);
                        b /= 2;
                }
		bytes[0] = (byte) (b % 2);
                return bytes;
        }
}
