package class4;

import java.util.Arrays;
import java.util.Scanner;

public class Main_15654_김준우 {
	static int N, M, arr[];
	static boolean visit[];
	static StringBuilder sb = new StringBuilder();
	
	public static void combination(int n, int cnt, int[] list_org) {
		visit[n] = true;
		int[] list = Arrays.copyOf(list_org, list_org.length);
		list[cnt] = n;
		
		if(cnt == M-1) {
			for (int i = 0; i < M; i++) {
				sb.append(arr[list[i]] + " ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if(visit[i]) continue;
			combination(i, cnt+1, list);
			visit[i] = false;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N];
		visit = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		
		
		for (int i = 0; i < N; i++) {
			combination(i, 0, new int[M]);
			visit[i] = false;
		}
		
		
		System.out.println(sb);
	}

}
