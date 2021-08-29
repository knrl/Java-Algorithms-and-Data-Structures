import java.util.Random;

public class TrifidClass{
	TrifidClass() { }

	private final char [][][] keyTable = { { {'a','b','c'}, {'d','e','f'}, {'g','h','i'} },
					      { {'j','k','l'}, {'m','n','o'}, {'p','q','r'} },
					      { {'s','t','u'}, {'v','w','x'}, {'y','z','/'} } };
	private final int SIZE_OF_TABLE = 27;
	private final int SIZE_OF_ROW = 3, SIZE_OF_COL = 3, BOX_SIZE = 3;
	private int [][] matrix;
	public String encryption(String plainText){
		plainText = preProcess(plainText);
		int n = plainText.length(), index = 0;
		int [][] matrix = new int [3][n];
		for (int i=0;i<n;i++){
			index = getIndex(plainText.charAt(i));
			matrix[0][i] = (int) (index/100); matrix[1][i] = (int) (index/10) % 10; matrix[2][i] = index % 10;
		}
		String encryptedText = convertText(matrix, 3, n);
		return encryptedText;
	}

	public String decryption(String encryptedText){
		String decryptedText = "";
		int n = encryptedText.length(), index = 0, k = 0;
		int [] oneDMatrix = new int [3*n];
		int [][] matrix = new int [3][n];
		for (int i=0;i<n*3;i+=3){
			index = getIndex(encryptedText.charAt(k++));
			oneDMatrix[i] = (int) (index/100); oneDMatrix[i+1] = (int) (index/10) % 10; oneDMatrix[i+2] = index % 10;
		}
		for (int i=0;i<n*3;i++)
			matrix[(int) i/n][i%n] = oneDMatrix[i];
		for (int i=0;i<n;i++)
			decryptedText += keyTable[matrix[0][i]][matrix[1][i]][matrix[2][i]];
		return decryptedText;
	}

	private int getIndex(char c){
		for (int i=0;i<BOX_SIZE;i++) for (int k=0;k<SIZE_OF_ROW;k++) for (int j=0;j<SIZE_OF_COL;j++)
			if (keyTable[i][k][j] == c) return i*100 + k*10 + j;
		return 0;
	}
	
	private String convertText (int [][] matrix, int w, int h){
		String text = "";
		int [] oneDMatrix = new int [w*h];
		int j = 0;
		for (int i=0;i<w;i++) for (int k=0;k<h;k++) oneDMatrix[j++] = matrix[i][k];
		for (int i=0;i<w*h;i+=3) 
			text += keyTable[oneDMatrix[i]][oneDMatrix[i+1]][oneDMatrix[i+2]];
		return text;
	}

	private String preProcess(String input){
		input = input.replace(" ", "");
		return input.toLowerCase();
	}
}

