import java.util.Random;

public class SpecClass{
	SpecClass() { }

	private String randomText;
	private int lenoftext;
	final int alphabetlen = 26;
	public String encryption(String plainText, int step){
		plainText = preProcess(plainText);
		this.lenoftext = plainText.length() * (step + 1);
		this.randomText = generateRandomText();
		StringBuilder sb = new StringBuilder(this.randomText);
		int k = 0;
		for (int i=0;i<this.lenoftext && k < plainText.length() ;i+=step)
			sb.setCharAt(i, plainText.charAt(k++));
		return sb.toString();
	}

	public String decryption(String encryptedText, int step){
		String decryptedText = "";
		for (int i=0;i+step<this.lenoftext;i+=step)
			decryptedText += encryptedText.charAt(i);
		return decryptedText;
	}

	private String generateRandomText(){
		Random rand = new Random();
		String text = "";
		for (int i=0;i<this.lenoftext;i++)
			text += Character.toString((char) (rand.nextInt(alphabetlen) + 97));
		System.out.println(text);
		return text;
	}

	private String preProcess(String input){
		input = input.replace(" ", "");
		return input.toLowerCase();
	}
}
