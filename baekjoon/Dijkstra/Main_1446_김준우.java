package _0308_다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_1446_김준우 {
	static int N, D;
	static int[][] shortcut;
	static int[] distance;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		shortcut = new int[N][3];
		distance = new int[D+1];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < shortcut[i].length; j++) {
				shortcut[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Arrays.sort(shortcut, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0] == o2[0]) return o1[1] - o2[1];
				return o1[0] - o2[0];
			}
			
		});
		
		for (int i = 0; i <= D; i++) {
			distance[i] = i;	//지름길이 아닌 거리로 초기화
		}
		
		for (int i = 0; i < N; i++) {
			int start = shortcut[i][0];
			int end = shortcut[i][1];
			
			if(end > D) continue;
			
			int dist = shortcut[i][2] + distance[start];
			
			
			
			if(dist<distance[end]) {
				for (int j = 0; j <= D - end; j++) {
					if(distance[end+j] < dist+j) break;
					distance[end+j] = dist+j;
				}
			}
			
		}
		
		
		System.out.println(distance[D]);
		
		
	}

}
