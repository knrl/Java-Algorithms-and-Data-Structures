import java.util.Scanner;

class Bifid{
	public static void main(String [] args){
		Scanner scan = new Scanner(System.in);
		String plainText = scan.nextLine();
		String key = scan.nextLine();
		BifidClass bifObJ = new BifidClass();
		String encryptedText = bifObj.encryption(plainText, key);
		String decryptedText = bifObj.decryption(encryptedText, key);
		System.out.println(encryptedText + "\n" + decryptedText);
	}
}
