/*
	a b c d e
	3 2 5 9 8
	4 1 1 8 3
	 encrypt
	3 5 8 1 8
	2 9 4 1 3
	f e q a d
         decrypt
	3 2 5 9 8
	4 1 1 8 3

*/
import java.util.Random;

public class BifidClass{
	BifidClass() { 
		shuffleKeyTable();
	}

	private static char [][] keyTable = { {'a','b','c','d','e'}, 
					      {'f','g','h','i','j'}, 
					      {'k','l','m','n','o'}, 
					      {'p','r','t','u','v'}, 
					      {'w','x','y','z','-'} };
	final int SIZE_OF_TABLE = 25;
	final in SIZE_OF_ROW = 5, SIZE_OF_COL = 5;

	public String encryption(String plainText){
		String encryptedText = "";
		plainText = preProcess(plainText);
		int n = plainTex.length();
		int [][] matrix = new int [2][n];
		matrix = createMatrix(plainText);
		matrix = transformMatrix(matrix, n);
		for (int i=0;i<n/2;i++){
			encryptedText += Character.toString(keyTable[matrix[0][i]][matrix[1][i]]);
		}
		return encryptedText;
	}
	
	public String decryption(String encryptedText){
		String decryptedText = "";
		int index1 = 0, index2 = 0, n = encryptedText.length();
		int [][] matrix = new int [2][n];
		matrix = createMatrix(encryptedText);
		matrix = transform(matrix, n);
		for (int i=0;i<n/2;i++){
			decryptedText += Character.toString(keyTable[matrix[0][i]][matrix[1][i]]);
		}
		return decryptedText;
	}

	private int [][] transformMatrix(int [][] matrix, int n){
		int [][] tempMatrix = new int [n][2];
		int k = 0, s = (int) (n / 2);
		for (int i=0;i<n;i+=2){
			tempMatrix[(int) (i / s)][i % s] = matrix[0][k];
			tempMatrix[(int) ((i+1) / s)][(i+1) % s] = matrix[1][k];
			k++;
		}
		for (int i=0;i<s;i++)
			matrix[0][i] = tempMatrix[0][i];
			matrix[1][i] = tempMatrix[1][i];
		return matrix;
	}
	
	private int [][] createMatrix(String input){
		int n = input.length();
		char [] charArr = input.toCharArray();
		int [][] matrix = new int [n][2];
		for (char c : charArr) 
			for (int i=0;i<SIZE_OF_TABLE;i++)
				if (c == keyTable[(int) (i / SIZE_OF_COL)][i % SIZE_OF_ROW]){
					matrix[i][0] = (int) (i / SIZE_OF_COL);
					matrix[i][1] = i / SIZE_OF_ROW;
					break;
				}
		return matrix;
	}

	private void shuffleKeyTable(){
		Random rand = new Random();
		int randIndex1 = 0, randIndex2 = 0;
		char temp = '';
		for (int i=0;i<SIZE_OF_TABLE / 2;i++){
			randIndex1 = rand.nextInt(0, SIZE_OF_TABLE + 1);
			randIndex2 = rand.nextInt(0, SIZE_OF_TABLE + 1);
			temp = keyTable[(int) (randIndex1 / 5)][randIndex1 % 5];
			keyTable[(int) (randIndex1 / 5)][randIndex1 % 5] = keyTable[(int) (randIndex2 / 5)][randIndex2 % 5];
			keyTable[(int) (randIndex2 / 5)][randIndex2 % 5] = temp;
		}

	}

	private String preProcess(String input){
		input = input.replace(" ", "");
		return input.toLowerCase();
	}
}
