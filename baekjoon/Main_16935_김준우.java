//BOJ 배열 돌리기3
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16935_김준우 {
	static int N, M, R;
	static int[][] arr;
	static int[] inst;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," "); 
		
		N = Integer.parseInt(st.nextToken());	//배열 행 개수
		M = Integer.parseInt(st.nextToken()); 	//배열 열 개수
		R = Integer.parseInt(st.nextToken());	//연산 수
		arr = new int[N][M];
		inst = new int[R];
		
		//배열 입력
		for(int n=0;n<N;n++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int m=0;m<M;m++) {
				arr[n][m] = Integer.parseInt(st.nextToken());
			}
		}
		
		//명령어 입력
		st = new StringTokenizer(br.readLine()," ");
		for(int r=0;r<R;r++) {
			inst[r]= Integer.parseInt(st.nextToken());
		}
		
		for(int r=0;r<R;r++) {
			switch(inst[r]) {
			case 1:
				TopBottom();
				break;
			case 2:
				RightLeft();
				break;
			case 3:
				Rotation();
				break;
			case 4:
				Rotation_r();
				break;
			case 5:
				number5();
				break;
			case 6:
				number6();
				break;
			}
		}
		print();
	}
	
	public static void TopBottom() {
		int temp = 0;
		for(int i = 0; i<N/2; i++) {
			for(int j = 0; j<M;j++) {
				temp = arr[N-i-1][j];	//아래쪽 대칭점 값 임시 보관
				arr[N-i-1][j] = arr[i][j];	//아래쪽 대칭점에 위쪽 대칭점 값 삽입
				arr[i][j] = temp; 		//위쪽 대칭점에 임시보관한 값 삽입
			}
		}
	}
	
	public static void RightLeft() {
		int temp = 0;
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M/2;j++) {
				temp = arr[i][M-j-1];	//오른쪽 대칭점 값 임시 보관
				arr[i][M-j-1] = arr[i][j];	//오른쪽 대칭점에 왼쪽 대칭점 값 삽입
				arr[i][j] = temp; 		//왼쪽 대칭점에 임시보관한 값 삽입
			}
		}
	}
	
	public static void Rotation() {
		int[][] temp = new int[M][N];
		int t;
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M;j++) {
				temp[j][N-i-1] = arr[i][j];
			}
		}
		t = M; M = N; N=t;
		arr = temp;
	}
	
	public static void Rotation_r() {
		int[][] temp = new int[M][N];
		int t;
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M;j++) {
				temp[M-j-1][i] = arr[i][j];
			}
		}
		t = M; M = N; N=t;
		arr = temp;
	}
	
	public static void number5() {
		int[][] temp = new int[N/2][M/2];
		int[][] temp2 = new int[N/2][M/2];
		int[][] dimension = {{0,M/2},{N/2,M/2},{N/2,0},{0,0}};
		int cur_dim = 0;
		for(int i = 0; i<N/2;i++) {
			for(int j = 0; j<M/2;j++) {
				temp[i][j] = arr[i][j];
			}
		}
		for(int r =0;r<4;r++) {
			for(int i = 0; i<N/2;i++) {
				for(int j = 0; j<M/2;j++) {
					int nexti = i+dimension[cur_dim][0];
					int nextj = j+dimension[cur_dim][1];
					temp2[i][j] = arr[nexti][nextj];
					arr[nexti][nextj] = temp[i][j];
					temp[i][j] = temp2[i][j];
				}
			}
			cur_dim++;
		}
		
	}
	
	public static void number6() {
		int[][] temp = new int[N/2][M/2];
		int[][] temp2 = new int[N/2][M/2];
		int[][] dimension = {{N/2,0},{N/2,M/2},{0,M/2},{0,0}};
		int cur_dim = 0;
		for(int i = 0; i<N/2;i++) {
			for(int j = 0; j<M/2;j++) {
				temp[i][j] = arr[i][j];
			}
		}
		for(int r =0;r<4;r++) {
			for(int i = 0; i<N/2;i++) {
				for(int j = 0; j<M/2;j++) {
					int nexti = i+dimension[cur_dim][0];
					int nextj = j+dimension[cur_dim][1];
					temp2[i][j] = arr[nexti][nextj];
					arr[nexti][nextj] = temp[i][j];
					temp[i][j] = temp2[i][j];
				}
			}
			cur_dim++;
		}
		
	}
	
	//StringBuilder 생성해서 배열 출력
	public static void print() {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<N;i++) {
			for(int j = 0; j<M;j++) {
				sb.append(arr[i][j]);
				sb.append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
