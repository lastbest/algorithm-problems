import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_10026_김준우 {
	static int N, v1, v2, area1, area2;
	static char[][] pic, pic2;
	static boolean[][] visited, visited2;
	static int[] dr = {-1,1,0,0};	//up down left right
	static int[] dc = {0,0,-1,1};	//up down left right

	public static void solution() {
		loop:
		for(int i = 0;i<N;i++) {
			for(int j = 0;j<N;j++) {
				if(!visited[i][j]) {
					dfs(i,j);
					area1++;
				}
				
				if(!visited2[i][j]) {
					dfs2(i,j);
					area2++;
				}
				if(v1 == (N*N) && v2 == (N*N) ) {
					break loop;
				}
			}
		}
	}
	
	public static void dfs(int r, int c) {
		visited[r][c] = true;
		v1++;
		for(int i = 0;i<4;i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if(nr>=0 && nr<N && nc>=0 && nc<N && !visited[nr][nc]) {
				if(pic[nr][nc] == pic[r][c]) {
					dfs(nr,nc);
				}
			}
		}
	}
	
	public static void dfs2(int r, int c) {
		visited2[r][c] = true;
		v2++;
		for(int i = 0;i<4;i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if(nr>=0 && nr<N && nc>=0 && nc<N && !visited2[nr][nc]) {
				if(pic2[nr][nc] == pic2[r][c]) {
					dfs2(nr,nc);
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		pic = new char[N][N];
		pic2 = new char[N][N];
		visited = new boolean[N][N];
		visited2 = new boolean[N][N];
		
		for(int i = 0;i<N;i++) {
			String str = br.readLine();
			for(int j = 0;j<N;j++) {
				char temp = str.charAt(j);
				pic[i][j] = temp;
				if(temp == 'G') pic2[i][j] = 'R';
				else pic2[i][j] = temp;
			}
		}
		
		solution();
		System.out.println(area1+" "+area2);
		
		
	}

}
