package _0407;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1953_김준우 {
	static int N,M,R,C,L, cnt;
	static int[][] map, visited[];
	static int dr[] = {0,-1,1,0,0};	//정지0, 상1, 하2, 좌3, 우4
	static int dc[] = {0,0,0,-1,1};	//정지0, 상1, 하2, 좌3, 우4
	static int[][] type = {{},	{0,1,2,3,4},	{0,1,2},	{0,3,4},//터널구조물 별 타입	0, 상하좌우, 상하, 좌우
							{0,1,4},	{0,2,4},	{0,2,3},	{0,1,3}}; 		//상우, 하우, 하좌, 상좌

	public static boolean isConnected(int nr, int nc, int d) {
		int next_type = map[nr][nc];
		if (next_type == 0) return false;
		
		int[] connected_dir = {0,2,1,4,3};	//인덱스로 현재방향을 넣으면 반대방향을 리턴
		for(int i: type[next_type]) {	//이동 예정 위치에서 가능한 방향을  type배열에서 i로 꺼내서 반복함
			if(i == connected_dir[d]) return true;
		}
		
		return false;	//이동이 불가능
	}
	
	public static void move(int r, int c, int t) {
		if(visited[r][c][t] > 0) return;
		visited[r][c][t] ++;
		
		if(t == L) {
			cnt++;
			return;
		}
		int cur_type = map[r][c];
		
		for(int i: type[cur_type]) {	//type배열에서 가능한 방향을 i로 꺼내서 반복함
			int nr = r + dr[i];	
			int nc = c + dc[i];
			if(nr<0 || nr>= N || nc<0 || nc>= M) continue;	//경계 벗어나면  컨티뉴
			if(!isConnected(nr, nc, i)) continue;	//터널이 끊기는 곳이면 컨티뉴
			
			move(nr,nc,t+1);
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t<=T;t++) {
			st= new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());	//터널 세로크기	인덱스 0부터
			M = Integer.parseInt(st.nextToken());	//터널 가로크기 인덱스 0부터
			R = Integer.parseInt(st.nextToken());	//탈주자 세로좌표
			C = Integer.parseInt(st.nextToken());	//탈주자 가로좌표
			L = Integer.parseInt(st.nextToken());	//이동시간
			cnt = 0;	//장소 갯수 카운트
			map = new int[N][M];
			visited = new int[N][M][L+1];
			
			for (int r = 0; r < N; r++) {
				st= new StringTokenizer(br.readLine());
				for (int c = 0; c < M; c++) {
					int val = Integer.parseInt(st.nextToken());
					map[r][c] = val;
				}
			}
			
			move(R, C, 1);
			
			sb.append("#");sb.append(t);sb.append(" ");
			sb.append(cnt);//sb.append(set.size());
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
