import java.util.Scanner;

class extraProblem1{
	public static void main(String [] args){
		Scanner scan = new Scanner(System.in);
		String text = scan.nextLine();
		text = convertIt(text);
		System.out.print(text);
	}

	static String convertIt(String text){
		char [] chArray = text.toCharArray();
		chArray = sort(chArray, chArray.length);
		String lastText = new String(chArray);
		return lastText;
	}

	static char [] sort(char [] arr, int n){
		char temp = ' ', a=0, b=0;
		for (int i=0;i<n;i++){
			for (int k=i;k>0;k--){
				a = ((int) arr[k] > 96) ? (int) arr[k]-32 : (int) arr[k];
				b = ((int) arr[k-1] > 96) ? (int) arr[k-1]-32 : (int) arr[k-1];
				if (b > a){
					temp = arr[k];
					arr[k] = arr[k-1];
					arr[k-1] = temp;
				}
			}
		}
		return arr;
	}
}
