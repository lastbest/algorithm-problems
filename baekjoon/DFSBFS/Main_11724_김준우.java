package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11724_김준우 {
	static int N, M;
	static int[][] map;
	static boolean[] visited;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	public static void dfs(int n) {
		visited[n] = true;
		
		for (int i = 1; i <= N; i++) {
			if(visited[i]) continue;
			if(map[n][i] == 0)continue;
			dfs(i);
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N+1][N+1];
		visited = new boolean[N+1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			map[u][v]++;
			map[v][u]++;
		}
		
		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			if(visited[i]) continue;
			dfs(i);
			cnt ++;
		}
		System.out.println(cnt);
	}

}
