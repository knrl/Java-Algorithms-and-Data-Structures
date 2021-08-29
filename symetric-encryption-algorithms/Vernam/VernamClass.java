/*
	plain text plain text
	key key key 
     (xor)____________ 
	encrypted text

*/
import java.util.Random;

public class VernamClass{
	VernamClass() { }

	private String key;

	public String encryption(String plainText){
		plainText = preProcess(plainText);
		String encryptedText = "";
		char [] plainCharArr = plainText.toCharArray();
		char [] keyCharArr = key.toCharArray();
		int n = plainText.length();
		this.key = generateKey(n);
		String binary1 "", binary2 = "";
		BaseClass baseObject = new BaseClass();
		for (int i=0;i<n;i++){
			binary1 = baseObject.convertToBinary((int) (plainCharArr[i]));
			binary2 = baseObject.convertToBinary((int) (keyCharArr[i]));
			encryptedText += Character.toString(baseObject.xor(binary1, binary2));
		}
		return encryptedText;
	}

	public String decryption(String encryptedText){
		String decryptedText = "";
		char [] encryptedCharArr = encryptedText.toCharArray();
		char [] keyCharArr = this.key.toCharArray();
		int n = encryptedText.length();
		String binary1 = "", binary2 = "";
		BaseClass baseObject = new BaseClass();
		for (int i=0;i<n;i++){
			binary1 = baseObject.convertToBinary((int) (encryptedCharArr[i]));
			binary2 = baseObject.convertToBinary((int) (keyCharArr[i]));
			decryptedText += Character.toString(baseObject.xor(binary1, binary2));
		}
		return decryptedText;
	}

	private String generateKey(int n){
		Random rand = new Random();
		String newKey = "";
		for (int i=0;i<n;i++) newKey += Character.toString((char) (rand.nextInt(0, 26) + 97 ));
		return newKey;
	}

	private String preProcess(String input){
		input = input.replace(" ", "");
		return input.toLowerCase();
	}
}
