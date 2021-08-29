/*	Polybius Square

	   1 2 3 4   5 
	1  a b c d   e
	2  f g h i,j k
	3  l m n o   p
	4  q r s t   u
	5  v w x y   z

*/

public class PolybiusClass{
	PolybiusClass() {}

	public String encryption(String input){
		input = preProcess(input);
		String encryptedText = "";
		char [] chrArr = input.toCharArray();
		int i=0, k=0, temp=0;
		for (char c : chrArr){
			i = (int) (((int) c) - 97) / 5 + 1;
			k = (((int) c) - 97) - (i-1)*5 + 1;
			encryptedText += Integer.toString(i) + Integer.toString(k);
		}
		return encryptedText;
	}	
	
	public String decryption(String input){
		String decryptedText = "";
		char [] chrArr = input.toCharArray();
		int n = input.length(), temp = 0;
		for (int i=0;i<n;i+=2){
			temp = ((int) chrArr[i] - 1 - 48)*5 + ((int) chrArr[i+1] - 1 - 48) + 97;
			decryptedText += (char) temp;
		}
		return decryptedText;
	}

	private String preProcess(String input){
		input = input.replace(" ", "");
		return input.toLowerCase();
	}
}
