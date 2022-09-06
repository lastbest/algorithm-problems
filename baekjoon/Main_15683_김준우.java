import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_15683_김준우 {
	static int N,M,cctvs, min;
	static int[][] map;
	static boolean[][] watchable;
	//static int[] object;	//1~5 : cctv, 6: wall
	static LinkedList<Integer[]> cctv1, cctv2, cctv3, cctv4, cctv5;
	static int[][] cctv;
	
	static boolean[][] visit;
	
	public static void solution(int cnt) {
		if(cnt == cctvs) {
			print();
			//System.out.println("sdf");
			//watchable = new boolean[N][M];
			return;
		}
		int n = 0;
		switch (cctv[cnt][2]) {
		case 1 :
			n = 4;
			break;
		case 2 :
			n = 2;
			break;
		case 3 :
			n = 4;
			break;
		case 4 :
			n = 4;
			break;
		case 5 :
			n = 1;
			break;
		}
		for(int i= 0; i<n;i++) {
			if(visit[cnt][i]) continue;
			area(cctv[cnt][0], cctv[cnt][1], i, cctv[cnt][2]);
			solution(cnt+1);
		}
	}
	
	public static void area(int r, int c, int dir, int n) {
		int[] dr = {-1,1,0,0};	//상하좌우
		int[] dc = {0,0,-1,1};	//상하좌우
		int[][] d;
		int nofd;	//number of directions
		switch (n) {
		case 1 :
			int[][] d1 = {{0},{1},{2},{3}};
			d = d1;
			nofd = 1;
			break;
		case 2 :
			int[][] d2 = {{0,1},{2,3}};
			d = d2;
			nofd = 2;
			break;
		case 3 :
			int[][] d3 = {{0,3},{3,1},{1,2},{2,0}};
			d = d3;
			nofd = 2;
			break;
		case 4 :
			int[][] d4 = {{2,0,3},{0,3,1},{3,1,2},{1,2,0}};
			d = d4;
			nofd = 3;
			break;
		case 5 :
			int[][] d5 = {{0,1,2,3}};
			d = d5;
			nofd = 4;
			break;
		default :
			int[][] de = {};
			d = de;
			nofd = 0;
			break;
		}
		
		
		for(int i = 0;i<nofd;i++) {
			int cr = r; int cc = c;
			while(true) {
				if(cr<0 || cr>=N || cc<0 || cc>=M	|| map[cr][cc]==6) {	//경계를 벗어나거나 벽을 만남
					break;
				}
				watchable[cr][cc] = true;
				int dirs = d[dir][i]; 
				cr += dr[dirs];
				cc += dc[dirs];
			}
		}
		
	}
	
	public static void print() {
		int a = 0;
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				//System.out.print(watchable[i][j]+" ");
				if(!watchable[i][j] && map[i][j] < 6)
					a++;
			}
			//System.out.println();
		}
		if(min>a || min == -1) min = a;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		watchable = new boolean[N][M];
		cctvs = 0;
		cctv = new int[8][3];
		visit = new boolean[8][4];
		min = -1;
		
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0; j<M; j++) {
				int temp = Integer.parseInt(st.nextToken());
				map[i][j] = temp;
				if(temp>0 && temp<6) {
					cctv[cctvs][0] = i;
					cctv[cctvs][1] = j;
					cctv[cctvs][2] = temp;
					cctvs++;
				}
				else if(temp==6){
					
				}
				
				
				
			}
		}
		
		solution(0);
		//print();
		System.out.println(min);
		
	}
}
