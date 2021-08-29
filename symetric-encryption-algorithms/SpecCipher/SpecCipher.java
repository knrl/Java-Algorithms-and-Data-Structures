import java.util.Scanner;

class SpecCipher{
	public static void main(String [] args){
		Scanner scan = new Scanner(System.in);
		String plainText = scan.nextLine();
		int step = scan.nextInt();
		SpecClass specObj = new SpecClass();
		String encryptedText = specObj.encryption(plainText, step);
		String decryptedText = specObj.decryption(encryptedText, step);
		System.out.println(encryptedText + "\n" + decryptedText);
	}
}
