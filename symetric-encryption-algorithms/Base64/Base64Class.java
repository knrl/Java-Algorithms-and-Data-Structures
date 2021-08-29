import java.lang.Math;

public class Base64Class{
	private char [] b64Table = new char [64];
	Base64Class() { 
		generateTable();
	}

	public String encryption(String plainText){
		String encryptedText = "", subStr = "", binaries = "";
		plainText = preProcess(plainText);
		int n = plainText.length(), k = 0;
		for (int i=0;i<n;i++){
			for (k=0;i<n && k<3;i++){ subStr += plainText.charAt(i); k++; }//select 3 character
			binaries = getBinaries(subStr, 8); // convert them 24 bit
			encryptedText += getCharacter(binaries, 4); // get 4 character
			subStr = "";
			i--;
		}
		System.out.println("Encryption finish");
		return encryptedText;
	}
	
	public String decryption(String encryptedText){
		String decryptedText = "", subStr = "", binaries = "";
		int n = encryptedText.length(), k = 0;
		for (int i=0;i<n;i++){
			for (k=0;k<4 && i<n;i++) { subStr += encryptedText.charAt(i); k++; }//select 4 character
			binaries = getBinaries(subStr, 6); // convert them 24 bit
			decryptedText += getCharacter(binaries, 3); // get 3 character
			subStr = "";
			i--;
		}
		return decryptedText;
	}

	private String getCharacter(String binaries, int n){
		String Characters = "";
		int m = binaries.length() / n, c = 0;
		for (int i=0;i<m*n;i++){
			if (i != 0 && i % m == 0){
				if (n == 4) Characters += b64Table[c];
				else Characters += (char) (c);
				c = 0;
			}
			else if (binaries.charAt(i) == '1') c += 1 * Math.pow(2, i%m);
		}
		return Characters;
	}

	private String getBinaries(String subStr, int n){
		int sublen = subStr.length(), c = 0;
		char [] binArr = new char [n];
		String binaries = "";
		for (int i=0;i<sublen;i++){
			if (n == 4) c = getIndex(subStr.charAt(i));
			else c = (int) (subStr.charAt(i));
			for (int k=0;k<n;k++){
				binArr[n-1-k] = (char) (48 + (c % 2));
				c = (int) (c / 2);
			}
			binaries += String.valueOf(binArr);
		}
		return binaries;
	}

	private int getIndex(char c){
		for (int i=0;i<64;i++)
			if (c == b64Table[i]) return i;
		return 63;
	}
	
	private void generateTable(){
		for (int i=0;i<26;i++) b64Table[i] = (char) (65 + i);
		for (int i=26;i<52;i++) b64Table[i] = (char) (97 + (i % 26));
		for (int i=52;i<62;i++) b64Table[i] = (char) (48 + (i % 10));
		b64Table[62] = '+'; b64Table[63] = '/';
	}

	private String preProcess(String input){
		input = input.replace(" ", "");
		return input.toLowerCase();
	}
}
