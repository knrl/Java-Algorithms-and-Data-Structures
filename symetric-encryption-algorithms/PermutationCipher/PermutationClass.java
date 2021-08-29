import java.util.Random;

public class PermutationClass{
	private final int blocklen = 4;
	private final int alphabetlen = 26;
	private int [] key = new int [blocklen];
	private int [] deKey = new int [blocklen];

	PermutationClass() { 
		generateKey();
		generateDeKey();
	}

	public String encryption(String plainText){
		plainText = preProcess(plainText);
		String encryptedText = "";
		int n = plainText.length();
		char [] currentBlock = new char [blocklen];
		for (int i=0;i<n;i+=blocklen){
			for (int k=i;k<blocklen+i;k++) currentBlock[k-i] = plainText.charAt(k);
			for (int k=i;k<blocklen+i;k++) encryptedText += currentBlock[key[k % blocklen]];
		}
		return encryptedText;
	}

	public String decryption(String encryptedText){
		String decryptedText = "";
		int n = encryptedText.length();
		char [] currentBlock = new char [blocklen];
		for (int i=0;i<n;i+=blocklen){
			for (int k=i;k<blocklen+i;k++) currentBlock[k-i] = encryptedText.charAt(k);
			for (int k=i;k<blocklen+i;k++) decryptedText += currentBlock[deKey[k % blocklen]];
		}
		return decryptedText;
	}

	private void generateKey(){
		Random rand = new Random();
		int temp = 0, check = 1, i = 0;
		while (i < blocklen){
			temp = rand.nextInt(blocklen);
			for (int k=0;k<i;k++) if (key[k] == temp) check = 0;
			if (check != 0) key[i++] = temp;
			check = 1;
		}
		for (int a : key) System.out.println(a + " ");
	}
	
	private void generateDeKey(){
		String tempStr = "";
		for (int i=0;i<blocklen;i++) tempStr += (char) (97 + i);
		String encryptedText = encryption(tempStr);
		for (int i=0;i<blocklen;i++)
			for (int k=0;k<blocklen;k++)
				if (tempStr.charAt(i) == encryptedText.charAt(k)) { this.deKey[i] = k; break; }
		for (int a : this.deKey) System.out.print(a + " ");
	}

	private String preProcess(String input){
		input = input.replace(" ", "");
		int remain = input.length() % 4;
		if (remain != 0) remain = 4 - remain;
		for (int i=0;i<remain;i++) input += 'a';
		return input.toLowerCase();
	}
}
