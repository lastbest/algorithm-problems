package class4;

import java.util.Arrays;
import java.util.Scanner;

public class Main_15652_김준우 {
	static int N, M;
	static StringBuilder sb = new StringBuilder();
	
	public static void combination(int n, int cnt, int[] list_org) {
		
		int[] list = Arrays.copyOf(list_org, list_org.length);
		list[cnt] = n;
		
		if(cnt == M-1) {
			for (int i = 0; i < M; i++) {
				sb.append(list[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = n; i <= N; i++) {
			combination(i, cnt+1, list);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		for (int i = 1; i <= N; i++) {
			combination(i, 0, new int[M]);
		}
		
		
		System.out.println(sb);
	}

}
