import java.util.Scanner;

class Vigenere{
	public static void main(String [] args){
		Scanner scan = new Scanner(System.in);
		String plainText = scan.nextLine();
		String key = scan.nextLine();
		VernamClass verObj = new VernamClass();
		String encryptedText = verObj.encryption(plainText, key);
		String decryptedText = verObj.decryption(encryptedText, key);
		System.out.println(encryptedText + "\n" + decryptedText);
	}
}
