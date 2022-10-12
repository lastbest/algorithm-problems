package class3;

import java.util.Scanner;

public class Main_11727 {
	static int n, cnt;
	static int[] ways;
	
	public static void dfs(int cur) {
		if(n == cur) {
			cnt = (cnt+1)%10007;
		}
		if(n >= cur + 2) {
			dfs(cur+2);
			dfs(cur+2);
		}
		if(n >= cur + 1) {
			dfs(cur+1);
		}
		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		ways = new int[n+1];
		
		if(n == 1) { System.out.println(1); return;}
		
		ways[0] = 0;
		ways[1] = 1;
		ways[2] = 3;
		
		for (int i = 3; i <= n; i++) {
			ways[i] = (ways[i-2] * 2 + ways[i-1])%10007;
		}
		
		System.out.println(ways[n]);
		
		/*cnt = 0;
		dfs(0);
		System.out.println(cnt);
		*/
	}

}
