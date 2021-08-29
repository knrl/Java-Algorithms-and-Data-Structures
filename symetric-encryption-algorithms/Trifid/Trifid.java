import java.util.Scanner;

class Trifid{
	public static void main(String [] args){
		Scanner scan = new Scanner(System.in);
		String plainText = scan.nextLine();
		TrifidClass trifObj = new TrifidClass();
		String encryptedText = trifObj.encryption(plainText);
		String decryptedText = trifObj.decryption(encryptedText);
		System.out.println(encryptedText + "\n" + decryptedText);
	}
}
