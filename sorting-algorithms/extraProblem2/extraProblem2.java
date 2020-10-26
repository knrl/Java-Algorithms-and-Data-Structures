import java.util.Scanner;

class extraProblem2{
	public static void main(String [] args){
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		char [] result = getThem(str);
	}

	static char [] getThem (String str){
		char min = str.charAt(0), max = str.charAt(0);
		int a = 0;
		for (char chr : str){
			a = ((int) chr > 96) ? (int) chr - 32 : (int) chr;
			if (a < (int) min) min = chr;
			else if (a > (int) max) max = chr;
		}
		char [] arr = {min, max};
		return arr;
	}
}
