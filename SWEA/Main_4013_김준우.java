package _0413;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_4013_김준우 {
	static int K;
	static int[][] arr;
	
	public static int getScore() {
		int score = 0;
		if(arr[1][0] == 1) score +=1 ;
		if(arr[2][0] == 1) score +=2 ;
		if(arr[3][0] == 1) score +=4 ;
		if(arr[4][0] == 1) score +=8 ;
		
		return score;
	}
	
	public static void solution_left(int target, int dir) {
		//왼쪽
		if(target>1) {	//왼쪽에 바퀴가 있다면
			if(arr[target-1][2] != arr[target][6]) {	//왼쪽의 3시방향과, 타겟바퀴의 9시방향 비교
				solution_left(target-1, dir*-1);
			}
		}
		
		rotate(target, dir);
		
	}
	
	public static void solution_right(int target, int dir) {
		//오른쪽
		if(target<4) {	//오른쪽에 바퀴가 있다면
			if(arr[target][2] != arr[target+1][6]) {	//타겟의 3시방향과, 우측바퀴의 9시방향 비교
				//rotate(target+1, dir*-1);
				solution_right(target+1, dir*-1);
			}
		}
		
		rotate(target, dir);
		
	}
	
	public static void solution(int target, int dir) {
		//왼쪽
		if(target>1) {	//왼쪽에 바퀴가 있다면
			if(arr[target-1][2] != arr[target][6]) {	//왼쪽의 3시방향과, 타겟바퀴의 9시방향 비교
				solution_left(target-1, dir*-1);
			}
		}
		
		//오른쪽
		if(target<4) {	//오른쪽에 바퀴가 있다면
			if(arr[target][2] != arr[target+1][6]) {	//타겟의 3시방향과, 우측바퀴의 9시방향 비교
				//rotate(target+1, dir*-1);
				solution_right(target+1, dir*-1);
			}
		}
		
		rotate(target, dir);
		
	}
	
	//회전시키기
	public static void rotate(int n, int dir) {	//dir : 시계방향 1, 반시계방향 -1
		int[] copy = new int[arr[n].length];
		for(int i = 0; i<arr[n].length;i++) {
			copy[i] = arr[n][(i+arr[n].length-dir)%8];
		}
		for(int i = 0; i<arr[n].length;i++) {
			arr[n][i] = copy[i];
		}
		return;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1;t<=T; t++) {
			K = Integer.parseInt(br.readLine());
			arr = new int[5][8];	//바퀴의 넘버링 인덱스는 0스킵하고 사용
			for(int i =1; i<=4;i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 8; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i = 0;i<K; i++) {
				st = new StringTokenizer(br.readLine());
				int target = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());
				solution(target,dir);
			}
			
			sb.append("#");sb.append(t);sb.append(" "); 
			sb.append(getScore());sb.append("\n");
		}
		
		System.out.println(sb);
	}

}
