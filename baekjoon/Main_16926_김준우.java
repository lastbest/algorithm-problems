
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_16926_김준우 {
	static int N, M, R;
	static int[][] arr, copy;
	
	//사방탐색 : 하우상좌 순서
	static int[] dr = {1,0,-1,0};
	static int[] dc = {0,1,0,-1};
	
	public static void rotation() {
		copy= new int[N][M];
		
		for (int dep = 0; dep < Math.round(Math.min(N, M) /2); dep++) {
			int r = dep; int c = dep; int d = 0;
			
			loop:
			while(true) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				int cnt = 0;
				
				//경계벗어나거나 이미 방문한 값이면 방향 바꿈
				while(nr < 0 || nc<0 || nr>= N-dep || nc>= M-dep || copy[nr][nc] > 0) {
					//4번 방향을 바꿔도 안되면 탐색 완료
					if(cnt >= 4) break loop;
					cnt ++;
					
					d = (d+1)%4;
					nr = r + dr[d];
					nc = c + dc[d];
				}
				copy[nr][nc] = arr[r][c];
				
				r= nr; c= nc;
			}
		}
		
		copyArr();	//카피한 배열을
	}
	
	public static void copyArr() {
		for(int n=0;n<N;n++) {
			for (int m = 0; m < M; m++) {
				if(copy[n][m]>0)arr[n][m] = copy[n][m];
			}
		}
	}
	
	public static void print() {
		for(int n=0;n<N;n++) {
			for (int m = 0; m < M; m++) {
				System.out.print(arr[n][m]+" ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());	
		M = Integer.parseInt(st.nextToken());	
		R = Integer.parseInt(st.nextToken());	
		
		arr = new int[N][M];
		
		//배열 입력
		for(int n=0;n<N;n++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int m=0;m<M;m++) {
				arr[n][m] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		for (int i = 0; i < R; i++) {
			rotation();
		}
		
		print();
		
		
		
		System.out.println(sb);
		
	}

}
