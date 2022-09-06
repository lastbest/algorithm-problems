package _0413;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_9205_김준우 {
	static int n;
	static int[][] loc, a;
	
	public static void floydWarshall() {
		int N = n+2;
		// k = 거쳐가는 노드
		for(int k = 0; k < N; k++) {
			// i = 출발 노드
			for(int i = 0; i < N; i++) {
				// j = 도착 노드 
				for(int j = 0; j < N; j++) {
					if(a[i][k] == 1 && a[k][j] == 1) {
						a[i][j] = 1;
					}
				}
			}
		}
	}
	
	public static int getDist(int a, int b) {
		int dist = Math.abs(loc[a][0] - loc[b][0]) + Math.abs(loc[a][1] - loc[b][1]);
		return dist;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1;t<=T;t++) {
			n = Integer.parseInt(br.readLine());
			loc = new int[n+2][2];
			a = new int[n+2][n+2];
			
			for(int i = 0;i<n+2;i++) {
				st = new StringTokenizer(br.readLine());
				loc[i][0] = Integer.parseInt(st.nextToken());
				loc[i][1] = Integer.parseInt(st.nextToken());
			}
			
			for(int i = 0; i<n+2; i++) {
				for (int j = 0; j < n+2; j++) {
					if(getDist(i, j)<=1000 && i != j) {
						a[i][j] = 1;
					}
				}
			}
			
			floydWarshall();
			
			if(a[0][n+1] == 1)sb.append("happy\n");
			else sb.append("sad\n");
		}
		
		System.out.println(sb);
	}
}
