package _0408;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_17135_김준우 {
	static int N, M, D, Max;	//N : 행 수, M : 열 수, D: 공격거리제한, Max: 최대 제거 수
	static int enemy = 0;	//enemy : 적의 수
	static int map[][], cmap[][];	//격자판, 0은 빈칸, 1은 적이 있는 칸, -1은 죽은 적이 있는 칸
	
	public static int moveEnemy() {
		int cnt = 0;
		for (int i = N-1; i >= 0; i--) {
			for (int j = 0; j < M; j++) {
				if(cmap[i][j] != 1) continue;	//1인경우만 옮기기
				if(i==N-1) {	//성에 들어간 경우
					cmap[i][j] = 0;
					cnt ++;
				}
				else {
					cmap[i+1][j] = cmap[i][j];	//위에서 아래로 복사하고
					cmap[i][j] = 0;				//위에 값은 제거
				}
				
			}
		}
		
		return cnt;
	}
	
	public static int[] findTarget(int c) {
		int r = N;
		int cur_d = D+1;	//현재까지 가장 가까운  타겟과의 거리
		int tr = -1, tc = -1;	//현재까지 가장 가까운 타겟 위치
		roop:
		for (int j = 0; j < M; j++) {
			for (int i = N-1; i >= 0; i--) {
				if(cmap[i][j] != 1) continue;
				int d = Math.abs(i-r) + Math.abs(j-c);
				if(d>D) continue;
				if(d<cur_d) {
					cur_d = d;
					tr = i;
					tc = j;
				}
				if(d == 1) {break roop;}	//거리가 1인경우 적합하므로 바로 탈출 
			}
		}
		
		int[] result = {tr, tc};
		return result;
	}
	
	public static int playGame(int[] c, int high) {
		int r = N;
		int cnt = 0;
		int disappear = 0;
		
		while(high < N) {
			int[][] e_loc = new int[3][2];
			//int[] ec = new int[3];
			
			int[] e0 = Arrays.copyOf(findTarget(c[0]),2);
			int[] e1 = Arrays.copyOf(findTarget(c[1]),2);
			int[] e2 = Arrays.copyOf(findTarget(c[2]),2);

			if(e0[0] >= 0) {
				if(cmap[e0[0]][e0[1]] == 1) {
					cmap[e0[0]][e0[1]] = -1;
					cnt ++;
				}
			}
			if(e1[0] >= 0) {
				if(cmap[e1[0]][e1[1]] == 1) {
					cmap[e1[0]][e1[1]] = -1;
					cnt ++;
				}
			}
			if(e2[0] >= 0) {
				if(cmap[e2[0]][e2[1]] == 1) {
					cmap[e2[0]][e2[1]] = -1;
					cnt ++;
				}
			}
			if(cnt+disappear >= enemy) break;	//모든 적을 중이면 바로 탈출
			
			disappear += moveEnemy();
			
			high++;
			
		}
		
		return cnt;
		
	}
	
	public static void copyMap() {
		cmap = new int[N][M];
		for (int i = 0; i < map.length; i++) {
			cmap[i] = Arrays.copyOf(map[i], map[i].length);
		}
	}
	
	public static void printMap() {
		for (int i = 0; i < map.length; i++) {
			System.out.println(Arrays.toString(cmap[i]));
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//==input 1st line=========
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		//==input map==========
		map = new int[N][M];	int high = N;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int val = Integer.parseInt(st.nextToken());
				map[i][j] = val;
				if(val == 1) {
					enemy++;
					if(i<high) high = i;
				}
			}
		}
		
		//==find location=======
		for (int i = 0; i < M; i++) {
			for (int j = i+1; j < M; j++) {
				for (int k = j+1; k < M; k++) {
					copyMap();
					int[] columns = {i,j,k};
					int result = playGame(columns, high);
					if (result>Max) Max = result;
				}
			}
		}
		
		System.out.println(Max);
		
		
		
	}

}
