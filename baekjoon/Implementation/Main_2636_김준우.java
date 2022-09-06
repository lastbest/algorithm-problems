package _0330;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2636_김준우 {
	static int R, C, cnt;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};	//12시부터 시계방향
	static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};	//12시부터 시계방향

	public static void findEdge(int e) {
		int d = 4;
		int cr = 1; int cc = 1;
		int sr = -1, sc = -1;
		visited = new boolean[R][C];
		while(true) {
			if(cr == sr && cc == sc) break;
			
			if(arr[cr][cc] == 0) {
				int nr = cr+dr[d];
				int nc = cc+dc[d];
				if(nr<1) {
					nr = cr;
					nc = cc+1;
					d = 4;
				}
				if(nr>=R-1) {
					nr = cr;
					nc = cc+1;
					d = 2;
				}
				cr= nr; cc = nc;
				
			}else if(arr[cr][cc] == 1 || arr[cr][cc] == e) {
				if(sr<0) {sr = cr; sc = cc;}
				int nd =0, nr = 0, nc = 0 ;
				for(int i = 0;i<8;i++) {	//치즈가 1x1인경우 샏ㅇ각해보자
					
					nd = (d+i+5)%8;
					nr = cr+dr[nd];
					nc = cc+dc[nd];
					
					if(arr[nr][nc] > 0) {
						d = nd; cr= nr; cc=nc;
						break;
					}
				}
				arr[cr][cc] = e;
				cnt--;
			}
		}
		
		System.out.println(cnt);
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if(arr[r][c] == e) arr[r][c] = 0;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		cnt = 0;
		arr = new int[R][C];
		//visited = new boolean[R][C];
		for (int r = 0; r < R; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < C; c++) {
				arr[r][c] = Integer.parseInt(st.nextToken());
				if(arr[r][c] == 1) cnt++;
			}
		}
		//System.out.println(cnt);
		findEdge(2);
		//findEdge(2);
		//System.out.println(cnt);
		for (int r = 0; r < R; r++) {
			System.out.println(Arrays.toString(arr[r]));
		}
		
		findEdge(2);
		
	}

}
