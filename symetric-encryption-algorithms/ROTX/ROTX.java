import java.util.Scanner;

class ROTX{
	public static void main(String [] args){
		Scanner scan = new Scanner(System.in);
		String plainText = scan.nextLine();
		ROTXClass rotxObj = new ROTXClass();
		String encryptedText = rotxObj.encryption(plainText);
		System.out.println(encryptedText);
		String decryptedText = rotxObj.decryption(encryptedText);
		System.out.println(decryptedText);
	}
}
