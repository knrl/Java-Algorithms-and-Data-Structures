public class ROTXClass{
	ROTXClass() { }

	final int X = 13;
	final int alphabetlen = 26;
	public String encryption(String plainText){
		String encryptedText = "";
		plainText = preProcess(plainText);
		int n = plainText.length();
		for (int i=0;i<n;i++)
			encryptedText += (char) ((((int) plainText.charAt(i)) - 97 + X) % alphabetlen + 97);
		return encryptedText;
	}

	public String decryption(String encryptedText){
		String decryptedText = "";
		int n = encryptedText.length();
		for (int i=0;i<n;i++)
			decryptedText += (char) ((((int) encryptedText.charAt(i)) - 97 - X + alphabetlen) % alphabetlen + 97);
		return decryptedText;
	}

	private String preProcess(String input){
		input = input.replace(" ", "");
		return input.toLowerCase();
	}
}
