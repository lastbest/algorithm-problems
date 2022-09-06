package _0330;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1767_김준우 {
	static int N, cores, min_len, max_con;	//cell의 가로세로 길이, 연결할 수 있는 코어의 갯수, 최소길이, 최다연결코어수 
	static int[][] map;		//값이 0이면 빈공간, 1이면 코어, 2이면 전선
	static int[][] core_loc;	//행, 열 좌표
	static int[] dr = {-1,1,0,0};	//상하좌우
	static int[] dc = {0,0,-1,1};	//상하좌우
	static boolean[] visited_core;
	
	public static void makeCase(int dir, int offset, int len, int curlen, int con, int core, int cnt, int[][] omap) {
		//dir : 현재이동방향, offset : 코어로부터 떨어진거리, len : 누적 길이, curlen : 현재 연결중 전선 길이, 
		//con : 연결된코어수,  core : 몇번째 코어인지, cnt : 탐색된 코어수 체크
		
		if(con + cores - cnt < max_con-1) {
			return;
		}
		if(con > cores) {
			return;
		}
		
		int[][] cmap = copyMap(omap);
		
		if(offset == 0) {
			if(cnt == cores) {	//전부 탐색완료
				if(con>max_con) {
					max_con = con;
					min_len = len;
				}
				else if(con == max_con){
					if(min_len > len)	min_len = len;
				}
				return;
			}
			
			for (int i = 0; i < cores; i++) {
				if(visited_core[i]) continue;
				visited_core[i] = true;
				
				for(int d = 0;d<4;d++) {
					int cr = core_loc[i][0];
					int cc = core_loc[i][1];
					int nr = cr + dr[d];
					int nc = cc + dc[d];
					
					if(nr >= 0 && nr<N && nc >= 0 && nc<N) {
						if(cmap[nr][nc] > 0) continue;
						
						makeCase(d, 1, len+1, 1, con, i, cnt+1, cmap);
					}
				}
				
				visited_core[i] = false;
			}
			return;
		}
		
		
		
		int cr = core_loc[core][0] + dr[dir] * offset;
		int cc = core_loc[core][1] + dc[dir] * offset;
		int nr = cr + dr[dir];
		int nc = cc + dc[dir];
		
		System.out.println(dir + " (" + cr + ", " + cc + ") " + offset + " " + len + " " + con + " " + core + " " + cnt );
		
		
		
		cmap[cr][cc] = 2;
		
		if(nr >= 0 && nr<N && nc >= 0 && nc<N) {	//다음 좌표가 경계 안이면 계속 진행
			if(cmap[nr][nc] > 0) {	//진행방향에 다른 전선이나 cpu가 있으면 안됨
				int fr = cr;
				int fc = cc;
				while(cmap[fr][fc] == 2) {
					cmap[fr][fc] = 0;
					fr -= dr[dir];
					fc -= dc[dir];
				}
				makeCase(0, 0, len-curlen, 0, con, core, cnt, cmap);
				return;
			}
			
			makeCase(dir, offset+1, len+1, curlen+1, con, core, cnt, cmap);
		}
		else {	//경계 벗어난 경우
			makeCase(0, 0, len, 0, con+1, core, cnt, cmap);
			return;
		}
		
	}
	
	public static int[][] copyMap(int[][] omap){
		int[][] cmap = new int[N][N];
		for (int i = 0; i < N; i++) {
			cmap[i] = Arrays.copyOf(omap[i], N);
		}
		return cmap;
	}
	
	public static void printMap() {
		for (int i = 0; i < N; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringBuilder sb = new StringBuilder();
		
		//int T = Integer.parseInt(br.readLine());
		//for(int t = 1; t<=T; t++) {
			//System.out.println(t+ "dddddddddd");
			N = Integer.parseInt(br.readLine());
			
			cores =0; min_len = Integer.MAX_VALUE; max_con = 0;
			core_loc = new int[12][2];
			visited_core = new boolean[N];
			
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					int value = Integer.parseInt(st.nextToken());
					map[i][j] = value;
					if(value == 1) {	
						if(i==0 || i== N-1 || j==0 || j== N-1)	{}
						else {
							core_loc[cores][0] = i;
							core_loc[cores][1] = j;
							cores++;
						}
					}
				}
			}
			
			makeCase(0, 0, 0, 0, 0, 0, 0, map);
			//printMap();
			
			System.out.println(min_len);
			System.out.println(max_con);
			
			//sb.append("#");sb.append(t);sb.append(" ");
			//sb.append(min_len);sb.append("\n");
		//}
		
		//System.out.println(sb);
	}

}
