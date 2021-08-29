import java.util.Scanner;

class PermutationCipher{
	public static void main(String [] args){
		Scanner scan = new Scanner(System.in);
		String plainText = scan.nextLine();
		PermutationClass perObj = new PermutationClass();
		String encryptedText = perObj.encryption(plainText);
		String decryptedText = perObj.decryption(encryptedText);
		System.out.println(encryptedText + " " + decryptedText);
	}
}
