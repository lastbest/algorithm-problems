package _0330;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_17144_김준우 {
	static int R,C,T, purifier = -1;
	static int[][] map, puri_dir;
	static int[] dr = {-1,0, 1, 0};	//상 우 하 좌  방향
	static int[] dc = {0, 1, 0,-1};	//상 우 하 좌 방향
	
	public static int countDust() {
		int count = 0;
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if(map[r][c] > 0) {
					count+= map[r][c];
				}
			}
		}
		return count;
	}
	
	public static void difusion() {
		int[][] nextmap = new int[R][C];
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if(map[r][c] > 0) {
					int difused = map[r][c]/5;
					for(int d=0; d<4;d++) {
						int nr = r + dr[d];
						int nc = c + dc[d];
						if(nr < 0 || nr >= R || nc < 0 || nc >= C || map[nr][nc] == -1) {
							continue;
						}else {
							nextmap[nr][nc] += difused;
							map[r][c] -= difused;
						}
						
					}
				}
				
			}
		}
		
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				map[r][c] += nextmap[r][c];
			}
		}
	}
	
	public static void purify() {
		int cr = purifier-1;
		int cc = 0;
		int d = 0;
		while(true) {
			int nr = cr + dr[d];
			int nc = cc + dc[d];
			if(nr == purifier && nc == 0) break;
			if(nr < 0 || nr > purifier || nc < 0 || nc >= C ) {
				d = (d+1)%4;
				continue;
			}else {
				map[cr][cc] = map[nr][nc];
				cr = nr; cc = nc;
			}
		}
		cr = purifier+2;
		cc = 0;
		d = 2;
		while(true) {
			int nr = cr + dr[d];
			int nc = cc + dc[d];
			if(nr == purifier+1 && nc == 0) break;
			if(nr < purifier+1 || nr > R-1 || nc < 0 || nc >= C ) {
				d = (d+3)%4;
				continue;
			}else {
				map[cr][cc] = map[nr][nc];
				cr = nr; cc = nc;
			}
		}
		map[purifier][1] = 0;map[purifier+1][1] = 0;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//input R : 행,C : 열,T : 시간
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		//input map
		map = new int[R][C];
		for (int r = 0; r < R; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < C; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if(map[r][c] == -1 && purifier == -1) {
					purifier = r;
				}
			}
		}
		
		for(int t= 0;t<T;t++) {
			difusion();
			purify();
			/*
			for (int r = 0; r < R; r++) {
				System.out.println(Arrays.toString(map[r]));
			}
			System.out.println();
			*/
		}
		
		System.out.println(countDust());
		
	}

}
