
import java.util.Scanner;

class Base64{
	public static void main(String [] args){
		Scanner scan = new Scanner(System.in);
		String plainText = scan.nextLine();
		Base64Class baseObj = new Base64Class();
		String encryptedText = baseObj.encryption(plainText);
		System.out.println(encryptedText);
		String decryptedText = baseObj.decryption(encryptedText);
		System.out.println(decryptedText);
	}
}
