import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1600_김준우 {
	static int K, R, C, result = -1;
	static int[][] map;
	static int[] dr = {-2,-2,-1,1,2,2,1,-1,
						-1,1,0,0};
	static int[] dc = {-1,1,2,2,1,-1,-2,-2,
						0,0,-1,1};
	
	static class monkey{
		int r, c, cnt, knight;
		int getR() {
			return r;
		}
		int getC() {
			return c;
		}
		int getCnt() {
			return cnt;
		}
		int getKnight() {
			return knight;
		}
		monkey(int r, int c, int cnt, int knight){
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.knight = knight;
		}
	}
	
	public static void bfs() {
		Queue<monkey> q = new LinkedList<monkey>();
		//boolean[][][] visited = new boolean[R][C][20000];
		int[][] visited = new int[R][C];
		for (int i = 0; i < R; i++) {
			Arrays.fill(visited[i], -1);
		}
		
		visited[0][0] = 0;
		q.add(new monkey(0, 0, 0, 0));
		
		while(!q.isEmpty()) {
			monkey m = q.poll();
			int r = m.getR();
			int c = m.getC();
			
			if(r == R-1 && c == C-1) {
				result = m.getCnt();
				break;
			}
			
			loop:
			for (int d = 0; d < 12; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				int cnt = m.getCnt()+1;
				int knight = m.getKnight(); if(d<8)knight++;
				
				if(knight > K) continue;
				if(nr<0 || nc<0 || nr>=R || nc>=C) continue;
				if(map[nr][nc] == 1) continue;
				if(visited[nr][nc] >= 0 && visited[nr][nc] <= cnt) continue loop;
				if(visited[nr][nc]>=0 && visited[nr][nc] > cnt)visited[nr][nc] = cnt;
				
				q.add(new monkey(nr, nc, cnt, knight));
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st;
		
		K = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		bfs();
		
		System.out.println(result);
	}

}
