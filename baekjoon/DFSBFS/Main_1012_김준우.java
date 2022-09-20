package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1012_김준우 {
	static int R, C, K;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	public static void dfs(int r, int c) {
		visited[r][c] = true;
		
		for (int d = 0; d < 4; d++) {
			int nr = r+ dr[d];
			int nc = c + dc[d];
			if(nr<0 || nc<0 || nr>=R || nc>= C) continue;
			if(visited[nr][nc]) continue;
			if(map[nr][nc] == 0) continue;
			dfs(nr,nc);
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) 
		{
			st = new StringTokenizer(br.readLine());
			C = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[R][C];
			visited = new boolean[R][C];
			
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int c = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				map[r][c]++;
			}
			
			/*print=========================
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					System.out.print(map[i][j] + " ");
				}
				System.out.println();
			}*/
			
			int cnt = 0;
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if(visited[i][j]) continue;
					if(map[i][j] == 0) continue;
					dfs(i,j);
					cnt ++;
				}
			}
			System.out.println(cnt);
		}
	}

}
