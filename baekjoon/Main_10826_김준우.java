import java.math.BigInteger;
import java.util.Scanner;

public class Main_10826_김준우 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		BigInteger[] arr = new BigInteger[n+1];
		
		arr[0] = new BigInteger("0");
		if(n >= 1)arr[1] = new BigInteger("1");;
		
		for (int i = 2; i <= n; i++) {
			arr[i] = arr[i-2].add(arr[i-1]);
		}
		
		System.out.println(arr[n]);
	}

}
