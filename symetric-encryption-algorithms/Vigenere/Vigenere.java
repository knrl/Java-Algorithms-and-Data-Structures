import java.util.Scanner;

class Vigenere{
	public static void main(String [] args){
		Scanner scan = new Scanner(System.in);
		String plainText = scan.nextLine();
		String key = scan.nextLine();
		VigenereClass vigObj = new VigenereClass();
		String encryptedText = vigObj.encryption(plainText, key);
		String decryptedText = vigObj.decryption(encryptedText, key);
		System.out.println(encryptedText + "\n" + decryptedText);
	}
}
