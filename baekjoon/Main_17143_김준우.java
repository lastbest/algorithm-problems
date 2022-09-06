import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_17143_김준우 {
	static int R, C, M;	//R,C : 격자판크기, M : 상어 마리수
	static int[][][] arr;	// arr[r][c][0] = s(속력), arr[r][c][0] = d(방향), arr[r][c][0] = z(크기)
	static int[] dr = {0,-1,1,0,0};	//정지 상하좌우
	static int[] dc = {0,0,0,-1,1};	//정지 상하좌우
	
	public static int[] nextLocation(int r, int c, int s, int d) {
		int cr = r; int cc = c;
		int mr = dr[d];
		int mc = dc[d];
		for(int i = 0; i<s; i++) {
			if(mr+cr <=0 || mr+cr >R || mc+cc <=0 || mc+cc >C) {
				mr = mr*-1;
				mc = mc*-1;
			}
			cr += mr;
			cc += mc;
		}
		int[] ret = {cr,cc};
		return ret;
	}
	
	public static void moveShark() {
		boolean[][] visit = new boolean[R+1][C+1];
		for (int i = 0; i <= R; i++) {
			for (int j = 0; j <= C; j++) {
				if(visit[i][j]) continue;
				if(arr[i][j][2] != 0) {
					int s = arr[i][j][0];
					int d = arr[i][j][1];
					int z = arr[i][j][2];
					arr[i][j] = new int[3];	//현재위치는 초기화
					
					int[] nl = nextLocation(i,j,s,d);
					int nr = nl[0];
					int nc = nl[1];
					System.out.println(nr + "  " + nc +" i:" + i +", " + j + " *" + dr[d]*s +", " + dc[d]*s +" " + s + " " + dc[d]);
					if(arr[nr][nc][2] < z) {
						arr[nr][nc][0] = s;
						arr[nr][nc][1] = d;
						arr[nr][nc][2] = z;
						visit[nr][nc] = true;
					}
				}
			}
		}
	}
	
	public static void getCloseShark(int n) {
		for(int i =1; i<=R; i++) {
			if(arr[i][n][2] == 0) continue;
			System.out.println("ss				ss" + arr[i][n][2]);
			arr[i][n] = new int[3];	//상어 제거
			
			return;
		}
	}
	
	public static void solution() {
		for(int fisher = 1; fisher <= C; fisher++) {
			//System.out.println(fisher);
			getCloseShark(fisher);	//상어 제거 함수
			moveShark();	//상어 이동 함수
			System.out.println(fisher + "초뒤");
			print();
		}
	}
	
	public static void print() {
		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				System.out.print(arr[i][j][2] + "	");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[R+1][C+1][3];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			
			arr[r][c][0] = s;
			arr[r][c][1] = d;
			arr[r][c][2] = z;
		}
		
		//
		
		print();
		
		moveShark();
		
		//solution();
		
		
		print();
		
		
		
	}

}
