import java.util.Scanner;

class Hill{
	public static void main(String [] args){
		Scanner scan = new Scanner(System.in);
		String plainText = scan.nextLine();
		HillClass hillObj = new HillClass();
		String encryptedText = hillObj.encryption(plainText);
		String decryptedText = hillObj.decryption(encryptedText);
		System.out.println(encryptedText + "\n" + decryptedText);
	}
}
