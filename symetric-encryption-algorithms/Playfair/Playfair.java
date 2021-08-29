import java.util.Scanner;

class Playfair{
	public static void main(String [] args){
		Scanner scan = new Scanner(System.in);
		String plainText = scan.nextLine();
		PlayfairClass pfObj = new PlayfairClass();
		String encrypted = pfObj.encryption();
		System.out.println(encrypted);
		String decrypted = pfObj.decryption();
		System.out.println(decrypted);
	}
}
