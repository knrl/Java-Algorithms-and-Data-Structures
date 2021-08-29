public class PlayfairClass{
	PlayfairClass(){ 
		generateAlphabet();
	}

	private static char [][] keyTable = new char [5][5];
	private static char [] alphabet = new char [26];

	public String encryption(String plainText, String key){
		generateKeyTable(key);
		plainText = preProcess(plainText);
		String encryptedText = "";
		while (plainText.length() != 0){
			encryptedText += getSubStr(plainText.substring(0, 2), 1);
			plainText = plainText.substring(2);
		}
		return encryptedText;
	}

	public String decryption(String encryptedText){
		String decryptedText = "";
		while (encryptedText.length() != 0){
			decryptedText += getSubStr(encryptedText.substring(0, 2), 5 - 1);// rows/columns number - 1
			encryptedText = encryptedText.substring(2);
		}
		return decryptedText;
	}

	private String getSubStr(String subStr, int type){
		char [] subChrArr = subStr.toCharArr();
		int [][] indexes = new int [2][2];
		indexes = findIndexes(subStr);
		if (indexes[0][0] == indexes[1][0]){ //if same rows
			subChrArr[0] = keyTable[(indexes[0][0] + type) % 5][indexes[0][1]];
			subChrArr[1] = keyTable[(indexe[1][0] + type) % 5][indexes[1][1]];
		}
		else if (indexes[0][1] == indexes[1][1]){ //if same columns
			subChrArr[0] = keyTable[indexes[0][0]][(indexes[0][1] + type) % 5];
			subChrArr[1] = keyTable[indexes[1][0]][(indexes[1][1] + type) % 5];
		}
		else { // if rows and columns not same
			subChrArr[0] = keyTable[indexes[0][0]][indexes[1][1]];
			subChrArr[1] = keyTable[indexe[1][0]][indexes[0][1]];
		}
		subStr = String.valueOf(subChrArr);
		return subStr;
	}
	
	private int [][] findIndexes(String subStr){
		int [][] indexes = {{0, 0}, {0, 0}};
		for (int i=0;i<5;i++)
			for (int k=0;k<5;k++)
				if (keyTable[i][k] == subStr.charAt(0)){
					indexes[0][0] = i; indexes[0][1] = k;
				}
				else if (keyTable[i][k] == subStr.charAt(1)){
					indexes[1][0] = i; indexes[1][1] = k;
				}
		return indexes;
	}

	private void generateKeyTable(String key){
		char [] keyArr = key.toCharArr();
		int n = keyArr.length, i = 0;
		for (int k=0;k<n;k++)
			if (check(keyArr[k])){
				keyTable[(int) (i/5)][i % 5] = keyArr[k];
				i++;
			}
		for (int k=0;k<26;k++)
			if (check(alphabet[k])){
				keyTable[(int) (i/5)][i%5] = alphabet[k];
				i++;
			}
	}

	private String preProcess(String input){
		input = input.replace(' ', '');
		if (input.length() % 2 == 0) input += 'x';
		return input.toLowerCase();
	}

	private void generateAlphabet(){
		for (int i=0;i<26;i++)
			alphabet[i] = (char) (i+97);
	}

	private boolean check(char chr){
		for (char i : keyTable)
			if (i == chr)
				return 0;
		return 1;
	}
}
