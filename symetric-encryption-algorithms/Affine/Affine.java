import java.util.Scanner;

class Affine{
	public static void main(String [] args){
		Scanner scan = new Scanner(System.in);
		String plainText = scan.nextLine();
		AffineClass affineObj = new AffineClass();
		String encryptedText = affineObj.encryption(plainText);
		System.out.println(encryptedText);
		String decryptedText = affineObj.decryption(encryptedText);
		System.out.println(decryptedText);
	}
}
