import java.util.Scanner;

public class Solution_1954_김준우 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case =0; test_case<T; test_case++) {
			int N = sc.nextInt();
			int[][] arr = new int[N][N];	//달팽이 배열
			int nums = N*N;	//총 숫자의 갯수
			int[][] dir = {{0,0},{0,1},{1,0},{0,-1},{-1,0}};	//숫자 기록 방향, 우하좌상 순서로 돌아감
			int cur_r =0; int cur_c =0; int cur_dir = 0;	//현재 기록 위치 및 현재 방향 
			for(int i =0; i < nums; i++) {
				int temp_r = cur_r + dir[cur_dir][0];
				int temp_c = cur_c + dir[cur_dir][1];
				//배열을 넘어가거나 이미 값이 기록된 경우 순서대로 방향을 변경
				if(temp_r < 0 || temp_c < 0 || temp_r >= N || temp_c >= N || arr[temp_r][temp_c] != 0) {	
					if(cur_dir>=4) 
						cur_dir = 1;
					else
						cur_dir++;
					temp_r = cur_r + dir[cur_dir][0];
					temp_c = cur_c + dir[cur_dir][1];
				}
				cur_r = temp_r;
				cur_c = temp_c;
				arr[cur_r][cur_c] = (i+1);
				if(cur_dir == 0)cur_dir++;
				//System.out.println(cur_r);System.out.println(cur_c);
			}
			System.out.println("#"+(test_case+1));
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(arr[i][j]+" ");
				}
				System.out.println();
			}
			
		}
	}
}
