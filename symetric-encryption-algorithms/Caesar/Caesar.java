import java.util.Scanner;

class Caesar{
	public static void main(String [] args){
		Scanner scan = new Scanner(System.in);
		String plainText = scan.nextLine();
		int step = scan.nextInt();
		CaesarClass caesarObj = new CaesarClass();
		String encryptedText = caesarObj.encryption(plainText, step);
		System.out.println(encryptedText);
		String decryptedText = caesarObj.decryption(encryptedText, step);
		System.out.println(decryptedText);
	}
}
