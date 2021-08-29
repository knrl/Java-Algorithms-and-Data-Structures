/*
	Affine Cipher
	(a.x + b) mod len of alphabet = f(x)
	inverse(a).(x - b) mod len of alphabet = g(x)
*/
import java.lang.Math;

public class AffineClass{
	final int a = 7, b = 3;
	final String alphabets = "abcdefghijklmnopqrstuvwxyz";
	AffineClass() { }

	public String encryption(String plainText){
		String encryptedText = "";
		plainText = preProcess(plainText);
		int index = 0, lenofalphabet = alphabets.length(), n = plainText.length();
		for (int i=0;i<n;i++){
			index = alphabets.indexOf(plainText.charAt(i));
			index = (a * index + b) % lenofalphabet;
			encryptedText += alphabets.charAt(index);
		}
		return encryptedText;
	}
	
	public String decryption(String encryptedText){
		String decryptedText = "";
		int index = 0, lenofalphabet = alphabets.length(), n = encryptedText.length();
		int inverseA = inverseModulo(a, lenofalphabet);
		for (int i=0;i<n;i++){
			index = alphabets.indexOf(encryptedText.charAt(i));
			index = ((inverseA * (index - b)) % lenofalphabet);
			index = (index < 0) ? index + lenofalphabet : index; 
			decryptedText += alphabets.charAt(index);
		}
		return decryptedText;
	}

	private int inverseModulo(int a1, int m){
		a1 %= m;
		for (int i=0;i<m;i++)
			if ((a1 * i) % m == 1) return i;
		return 1;
	}

	private String preProcess(String input){
		input = input.replace(" ", "");
		return input.toLowerCase();
	}
}
