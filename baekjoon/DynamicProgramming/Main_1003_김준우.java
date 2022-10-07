package class3;

import java.util.Scanner;

public class Main_1003_김준우 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			int n = sc.nextInt();
			if(n == 0) {System.out.println("1 0"); continue;}
			
			int[][] arr = new int[n+1][2];
			
			arr[0][0] = 1; arr[0][1] = 0;
			if(n >= 1) {arr[1][0] = 0; arr[1][1] = 1;}
			
			for (int i = 2; i <= n; i++) {
				arr[i][0] = arr[i-1][0] + arr[i-2][0];
				arr[i][1] = arr[i-1][1] + arr[i-2][1];
			}
			
			System.out.println(arr[n][0] + " " + arr[n][1]);
		}
	}

}
