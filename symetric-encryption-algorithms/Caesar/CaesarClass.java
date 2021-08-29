/*
      Caesar Cipher
	step -> 4
	a -> a + step -> e
	b -> b + step -> f
	...
	z -> z + step -> d
*/
public class CaesarClass{
	CaesarClass() { }

	public String encryption(String plainText, int step){
		String encryptedText = "";
		plainText = preProcess(plainText);
		char [] chrArr = plainText.toCharArray();
		for (char c : chrArr) 
			encryptedText += (char) ((int) c + step);
		return encryptedText;
	}

	public String decryption(String encryptedText, int step){
		String decryptedText = "";
		char [] chrArr = encryptedText.toCharArray();
		int a = 0;
		for (char c : chrArr) {
			a = ((int) c) - 97 - step;
			decryptedText += a >= 0 ? (char) (a + 97) : (char) (97 + 26 + a);
		}
		return decryptedText;
	}

	private String preProcess(String input){
		input = input.replace(" ", "");
		return input.toLowerCase();
	}
}
