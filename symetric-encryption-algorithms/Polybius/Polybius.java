import java.util.Scanner;

public class Polybius{
	public static void main (String [] args){
		Scanner scan = new Scanner(System.in);
		String plainText = scan.nextLine();
		System.out.println("Plain Text: " + plainText);
		PolybiusClass polybiusObject = new PolybiusClass();
		String encryptedText = polybiusObject.encryption(plainText);
		System.out.println(encryptedText);
		String decryptedText = polybiusObject.decryption(encryptedText);
		System.out.println(decryptedText);
	}
}

