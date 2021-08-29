/*
	   Vigenere Chiper
	c = length of alphabet
	"plain text plain text"
	"key key key key ..   "
	+______________________
	(a+b) mod c (a+b) mod c ...
*/
public class VigenereClass{
	VigenereClass() { }
	final String alphabet = "abcdefghijklmnoprstuvwxyz";

	public String encryption(String plainText, String key){
		plainText = preProcess(plainText);
		String encryptedText = "";
		int index = 0, n = plainText.length(), lenofalphabet = alphabet.length();
		int k = 0;
		for (int i=0;i<n;i++){
			index = alphabet.indexOf(plainText.charAt(i)) + alphabet.indexOf(key.charAt(k));
			index = index % lenofalphabet;
			encryptedText += alphabet.charAt(index);
			k = (k + 1) % key.length();
		}
		return encryptedText;
	}

	public String decryption(String encryptedText, String key){
		String decryptedText = "";
		int index = 0, n = encryptedText.length(), lenofalphabet=alphabet.length(), k = 0;
		for (int i=0;i<n;i++){
			index = alphabet.indexOf(encryptedText.charAt(i)) - alphabet.indexOf(key.charAt(k));
			index = (index < 0) ? index + lenofalphabet : index;
			decryptedText += alphabet.charAt(index);
			k = (k + 1) % key.length();
		}
		return decryptedText;
	}

	private String preProcess(String input){
		input = input.replace(" ", "");
		return input.toLowerCase();
	}
}
