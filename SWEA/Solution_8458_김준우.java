package _0411;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_8458_김준우 {
	static int N, dist = 0;
	static int[][] points;
	static int dr[] = {-1,1,0,0};	//상하좌우
	static int dc[] = {0,0,-1,1};	//상하좌우
	
	static boolean isEnd = false;
	
	static void bfs(int[] movement, int cnt) {
		if(isEnd) return;
		
		//copy array
		int[][] copiedPoints = new int[N][2];
		for (int i = 0; i < N; i++) {
			copiedPoints[i][0] = points[i][0];
			copiedPoints[i][1] = points[i][1];
		}
		
		//검증
		boolean valid = true;
		int cur_dist = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 4; j++) {	//상하좌우 더하기
				copiedPoints[i][0] += dr[j] * movement[j];
				copiedPoints[i][1] += dc[j] * movement[j];
			}
			cur_dist += Math.abs(copiedPoints[i][0]) + Math.abs(copiedPoints[i][1]);
			//System.out.println(Arrays.toString(copiedPoints[i]));
			if(copiedPoints[i][0] != 0 || copiedPoints[i][1] != 0) {
				valid = false;
			}
		}
		//System.out.println(cur_dist);
		if(cur_dist>dist*40) return;
		if(valid) {
			System.out.println(cnt);
			isEnd = true;
			return;
		}
		
		for(int i = 0; i<=cnt+1; i++) {
			for(int j = i; j<=cnt+1; j++) {
				for(int k = j; k<=cnt+1; k++) {
					for(int l = k; l<=cnt+1; l++) {
						if(l < cnt+1) continue;
						int[] movement_copied = new int[4];
						movement_copied[0] = movement_copied[0] + i;
						movement_copied[1] = movement_copied[1] + j - i;
						movement_copied[2] = movement_copied[2] + k - j;
						movement_copied[3] = movement_copied[3] + l - k;
						bfs(movement_copied, cnt+1);
					}
				}d
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		//int T = Integer.parseInt(br.readLine());
		
		//==input=============
		N = Integer.parseInt(br.readLine());
		points = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			points[i][0] = r;
			points[i][1] = c;
			dist += Math.abs(r) + Math.abs(c);
		}
		System.out.println(dist);
		
		int[] arr = {0,0,0,0};
		bfs(arr,0);
		
		System.out.println(sb);
	}

}
