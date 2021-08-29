import java.util.Random;

public class HillClass{
	HillClass() {
		this.n = 2;
		generateKeyMatrix(n);
	}

	HillClass(int n) { 
		generateKeyMatrix(n);
		this.n = n;
	}
	
	final int alphabetlen = 26;
	private int [][] keyMatrix;
	private int [][] invKeyMatrix;
	private int n;

	public String encryption(String plainText){
		plainText = preProcess(plainText);
		String encryptedText = "";
		char [] charArr = plainText.toCharArray();
		int lenoftext = plainText.length();
		int [] currentBlock = new int [this.n];
		LinearAlgebra alg = new LinearAlgebra();
		for (int i=0;i<lenoftext;i+=n){
			for (int k=i;k<i+n;k++) currentBlock[k-i] = ((int) (charArr[k] - 97));
			currentBlock = alg.myDot(keyMatrix, currentBlock);
			for (int k=0;k<n;k++) 
				encryptedText += Character.toString((char) ((currentBlock[k]%alphabetlen)+ 97));
		}
		return encryptedText;
	}

	public String decryption(String encryptedText){
		String decryptedText = "";
		LinearAlgebra alg = new LinearAlgebra();
		invKeyMatrix = new int [n][n];
		invKeyMatrix = checkNegative(alg.inverse(keyMatrix));// Check is there any negative number if there exist add alphabetlen
		char [] charArr = encryptedText.toCharArray();
		int lenoftext = encryptedText.length();
		int [] currentBlock = new int [this.n];
		for (int i=0;i<lenoftext;i++){
			for (int k=i;k<i+n;k++) currentBlock[k-i] = ((int) (charArr[k] - 97));
			currentBlock = alg.myDot(invKeyMatrix, currentBlock);
			for (int k=0;k<n;k++)
				decryptedText += Character.toString((char) ((currentBlock[k]%alphabetlen) + 97));
		}
		return decryptedText;
	}

	private void generateKeyMatrix(int n){
		Random rand = new Random();
		keyMatrix = new int [n][n];
		for (int i=0;i<n;i++)
			for (int k=0;k<n;k++)
				keyMatrix[i][k] = rand.nextInt(alphabetlen);
	}

	private int [][] checkNegative(int [][] matrix){
		for (int i=0;i<n;i++) for(int k=0;k<n;k++) if (matrix[i][k] < 0) matrix[i][k] += alphabetlen;
		return matrix;
	}

	private String preProcess(String input){
		input = input.replace(" ", "");
		return input.toLowerCase();
	}
}
