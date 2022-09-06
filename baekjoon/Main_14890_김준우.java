import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_14890_김준우 {
	static int N,L;
	static int[][] map, incline;
	
	//인덱스가 '0~N-1'이면 세로줄, '1~N*2-1'이면 가로줄	// 값이 -1이면 못지나감, 값이 1이면 경사로 없이 지나감, 값이 2이면 경사로 있으면 지나감
	static int[] passable;	
	
	static void isPassable() {
		isFlat();
//		for (int i = 0; i < N*2; i++) {
//			System.out.println(passable[i]);
//		}
		
		for (int i = 0; i < N; i++) {
			if(passable[i]>0) continue;	//지나갈수 있다고 이미 판별된 경우 지나감
			verticalCheck(i);
		}
		for (int i = 0; i < N; i++) {
			if(passable[i+N]>0) continue;	//지나갈수 있다고 이미 판별된 경우 지나감
			horizontalCheck(i);
		}
		
	}
	
	
	static void verticalCheck(int n) {
		boolean[] temp_inc = new boolean[N];	//경사로 놓을 곳 임시 저장배열
		
		for (int i = 0; i < N-1; i++) {
			if(map[i][n] == map[i+1][n]) continue;	//평평하면 지나감
			if(i+L >= N) {passable[n] = -1; return;}	//현재 위치에 경사로를 놓았는데 넘어가면 못지나가는거임
			if(Math.abs(map[i+1][n] - map[i][n]) != 1) {passable[n] = -1; return;}	//높이차이가 1이 아니면 못지나가는거임
			for (int j = 1; j <= L; j++) {
				if(map[i+j][n] != map[i+1][n]) {passable[n] = -1; return;}	//경사로를 놓을 곳들끼리 높이가 다르면 못지나가는거임
			}
			
			//여기까지오면 i+1~i+L까지 칸까지 경사로 놓을수 있음
			
			//마지막 칸인 경우 경사로 위치 체크하고 넘어가기
			if(i+L == N-1) {
				for (int j = 1; j <= L; j++) {
					temp_inc[i+j] = true;
				}
				i += L-1;
			}
			//다음 칸(i+L+1)이 경사로를 놓은 칸들과 높이 같으면 경사로 위치 체크하고 넘어가기
			//System.out.println(i + " " + L);
			else if(map[i+L][n] == map[i+L+1][n]) {
				for (int j = 1; j <= L; j++) {
					//incline[i+j][n] ++;
					temp_inc[i+j] = true;
				}
				i += L-1;
			}
			//같은 방향의 경사로가 있는 경우에도 경사로 위치 체크하고 넘어가기
			else if(map[i+L][n] - map[i+L+1][n] == map[i][n] - map[i+L][n]) {
				for (int j = 1; j <= L; j++) {
					//incline[i+j][n] ++;
					temp_inc[i+j] = true;
				}
				i += L-1;
			}
			else {
				passable[n] = -1; return;
			}
		}
		//경사로를 이용하면 지나갈 수 있구나!
		passable[n] = 2;
		
		//임시 체크해놨던 경사로 위치들 incline 배열에 체크
		System.out.print("세로" + n + " : ");
		for (int i = 0; i < N; i++) {
			if(temp_inc[i]) {incline[i][n] ++; System.out.print(i + ", ");}
		}
		System.out.println();
	}
	static void horizontalCheck(int n) {
		boolean[] temp_inc = new boolean[N];	//경사로 놓을 곳 임시 저장배열
		
		for (int i = 0; i < N-1; i++) {
			if(map[n][i] == map[n][i+1]) continue;	//평평하면 지나감
			if(i+L >= N) {passable[n+N] = -1; return;}	//현재 위치에 경사로를 놓았는데 넘어가면 못지나가는거임
			if(Math.abs(map[n][i+1] - map[n][i]) != 1) {passable[n+N] = -1; return;}	//높이차이가 1이 아니면 못지나가는거임
			for (int j = 1; j <= L; j++) {
				if(map[n][i+j] != map[n][i+1]) {passable[n+N] = -1; return;}	//경사로를 놓을 곳들끼리 높이가 다르면 못지나가는거임
			}
			
			//여기까지오면 i+1~i+L까지 칸까지 경사로 놓을수 있음 
			
			//마지막 칸인 경우 경사로 위치 체크하고 넘어가기
			if(i+L == N-1) {
				for (int j = 1; j <= L; j++) {
					temp_inc[i+j] = true;
				}
				i += L-1;
			}
			//다음 칸(i+L+1)이 경사로를 놓은 칸들과 높이 같으면 경사로 위치 체크하고 넘어가기
			else if(map[n][i+L] == map[n][i+L+1]) {
				for (int j = 1; j <= L; j++) {
					temp_inc[i+j] = true;
				}
				i += L-1;
			}
			//같은 방향의 경사로가 있는 경우에도 경사로 위치 체크하고 넘어가기
			else if(map[n][i+L] - map[n][i+L+1] == map[n][i] - map[n][i+L]) {
				for (int j = 1; j <= L; j++) {
					temp_inc[i+j] = true;
				}
				i += L-1;
			}
			else {
				passable[n+N] = -1; return;
			}
		}
		//경사로를 이용하면 지나갈 수 있구나!
		passable[n+N] = 2;
		
		//임시 체크해놨던 경사로 위치들 incline 배열에 체크
		System.out.print("가로" + n + " : ");
		for (int i = 0; i < N; i++) {
			if(temp_inc[i]) {incline[n][i] ++; System.out.print(i + ", ");}
		}
		System.out.println();
	}
	
	//경사로 없이 지나갈 수 있는지 체크
	static void isFlat() {
		vertical:
		for (int i = 0; i < N; i++) {
			int val = map[0][i]; 
			for (int j = 0; j < N; j++) {
				if(map[j][i] != val) continue vertical;
			}
			passable[i] = 1;
		}
		horizontal:
		for (int i = 0; i < N; i++) {
			int val = map[i][0]; 
			for (int j = 0; j < N; j++) {
				if(map[i][j] != val) continue horizontal;
			}
			passable[i+N] = 1;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//input N,L
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		incline = new int[N][N];
		passable = new int[N*2];
		
		//input map
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		isPassable();
		
		//print
		System.out.println("passable : ");
		System.out.println(Arrays.toString(passable));
		System.out.println();
		System.out.println("incline : ");
		for (int i = 0; i < N; i++) {
			System.out.println(Arrays.toString(incline[i]));
		}
		
	}

}
