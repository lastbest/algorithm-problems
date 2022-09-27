package _0330;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_9205_김준우 {
	static int n;
	static int[][] loc;
	static boolean[] visited;
	static boolean happy;
	
	public static void bfs(int k) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(k);
		visited[k] = true;
		
		int level = 0;
		
		while(!q.isEmpty()) {
			int x = q.poll();
			System.out.println(level + " : " + x);
			
			if(level == n && getDist(x, n+1) <= 1000) {
				happy = true;
				return;
			}
			
			for (int i = 1; i <= n; i++) {
				if(getDist(x,i) <= 1000 && !visited[i]) {
					q.offer(i);
					//visited[i] = true;
				}
			}
			level++;
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
			visited = new boolean[n+2];
			happy = false;
			
			for(int i = 0;i<n+2;i++) {
				st = new StringTokenizer(br.readLine());
				loc[i][0] = Integer.parseInt(st.nextToken());
				loc[i][1] = Integer.parseInt(st.nextToken());
			}
			
			bfs(0);
			
			if(happy) {
				sb.append("happy\n");
			}
			else {
				sb.append("sad\n");
			}
		}
		
		System.out.println(sb);
	}
}
