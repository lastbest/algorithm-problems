package _0408;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_14502_김준우 {
	static int N, M, Max = 0;
	static int[][] omap, map;	//0: 빈공간, 1: 벽, 2: 탐색안된 초기바이러스위치, 3: 새로 퍼지거나 탐색된 바이러스 위치
	static int[] dr = {-1,1,0,0};	//상하좌우
	static int[] dc = {0,0,-1,1};	//상하좌우
	
	
	
	public static void infection(int r, int c) {
		map[r][c] = 3;	//현재 탐색 위치에 전염
		
		for (int d = 0; d < dr.length; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(nr<0 || nr>= N || nc<0 || nc>= M) continue;	//경계체크
			if(map[nr][nc] != 0) continue;		//다음 탐색할 값이 비어있는지 체크
			infection(nr,nc);
		}
		
	}
	
	public static int getSafezone() {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 0) cnt++;
			}
		}
		return cnt;
	}
	
	public static void printMap() {
		for (int i = 0; i < N; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
		System.out.println();
	}
	
	public static void copyMap() {
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			map[i] = Arrays.copyOf(omap[i], M);
		}
	}
	
	public static void doInfection() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 2) infection(i,j);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//input 1st line
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		//input map
		omap = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int val = Integer.parseInt(st.nextToken());
				omap[i][j] = val;
			}
		}
		
		for (int i = 0; i < N*M; i++) {
			for (int j = i+1; j < N*M; j++) {
				for (int k = j+1; k < N*M; k++) {
					int ir = i/M;	int ic = i%M;
					int jr = j/M;	int jc = j%M;
					int kr = k/M;	int kc = k%M;
					if(omap[ir][ic] != 0 || omap[jr][jc] != 0 || omap[kr][kc] != 0) continue;
					copyMap();
					map[ir][ic] = 1;
					map[jr][jc] = 1;
					map[kr][kc] = 1;
					
					doInfection();
					
					int cnt = getSafezone();
					//if (cnt>10)	System.out.println(cnt);
					if(cnt>Max) Max = cnt;
				}
			}
		}
		
		System.out.println(Max);
	}

}
