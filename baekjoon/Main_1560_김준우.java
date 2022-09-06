import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main_1560_김준우 {
	static int N;
	static int[][] bishop, board;	//column of bishop : x,y좌표
	static boolean[][] unavailable;
	static int max = 0;
	
	public static void makeboard(int cnt, int R, int C) {
		if(R >= 0) {
			board[R][C] = 1;
			makeUnavaliable(R, C);
		}
		for(int r = 0;r<N;r++) {
			for(int c = 0;c<N;c++) {
				if(!unavailable[r][c]) {
					makeboard(cnt+1,r,c);
				}
				else if(r==N-1 && c==N-1) {
					if(cnt>max) max =cnt;
					return;
				}
			}
		}
	}
	
	public static void makeUnavaliable(int r, int c) {
		int[] dr = {-1,-1,1,1};
		int[] dc = {-1,1,-1,1};//z모양
		int[] sr = {r+(N-1-c),	r+c,	r-(N-1-c),	r-c};
		int[] sc = {N-1,	0,	N-1,	0};
		
		for(int d = 0; d<4; d++) {
			for(int i = 0; i<N; i++) {
				int cr = sr[d]+(dr[d]*i);
				int cc = sc[d]+(dc[d]*i);
				if(cr>=0 && cr<N && cc>=0 && cc<N)
					unavailable[cr][cc] = true;
			}
		}
	}
	
	public static boolean abletokill(int x1,int y1,int x2,int y2) {
		int gap_x = Math.abs(x1-x2);
		int gap_y = Math.abs(y1-y2);
		if(gap_x == gap_y)return true;
		else return false;
	}
	
	public static void main(String[] args) throws IOException {
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		//N = Integer.parseInt(br.readLine());
		
		bishop = new int[N][2];
		board = new int[N][N];
		unavailable = new boolean[N][N];
		makeboard(0, -1, -1);
		System.out.println(max);
		
		
	}

}
