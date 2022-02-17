package class4;

import java.util.Arrays;
import java.util.Scanner;

public class Main_15657_김준우 {
	static int N,M;
	static int[] arr;
	
	static void solution(int n, int cnt, int[] list_org) {
		//System.out.println("sefilds  "+n+"  SDf  "+cnt);
		int[] list = Arrays.copyOf(list_org, M);
		list[cnt] = n;
		if(cnt == M -1) {
			for (int i = 0; i < list.length; i++) {
				System.out.print(arr[list[i]]+" ");
			}
			System.out.println();
			return;
		}
		
		for (int i = n; i < N; i++) {
			solution(i, cnt+1, list);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		arr = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		
		for (int i = 0; i < N; i++) {
			//System.out.println("dd"+i);
			solution(i, 0, new int[M]);
		}
		
	}

}
