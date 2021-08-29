import java.lang.StringBuilder;

public class BaseClass{
	BaseClass() { }

	final int STEP = 8;
	public String convertToBinary(char chr){
		// ascii character 0 - 255 -> 2^8
		int n = EXP - 1, i = 0, chrN = (int) chr;
		StringBuilder binary = new StringBuilder("00000000");
		while (chrN > 1) {
			binary.setCharAt(n-i, Integer.toString(chrN % 2));
			chrN = (int) (chrN / 2);
			i++;
		}
		binary.setCharAt(n-i, Integer.toString(chrN));
		return binary;
	}
	
	public char xor(String binary1, String binary2){
		char [] b1 = binary1.toCharArray();
		char [] b2 = binary2.toCharArray();
		int decimalBase = 0;
		for (int i=0;i<STEP;i++)
			if (b1[i] != b2[i]) decimalBase += 1 * Math.pow(2, STEP - 1 - i);
		return (char) (decimalBase); // 0 - 255 decimal base number to ascii character
	}
}
