package _0406;

import java.io.BufferedReader;
import java.io.IOException;ㅇ
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_5643_김준우 {
	static int N, M;	//학생수, 비교 수
	static int[][] direct, indir;	//index 0은 사용 안함
	static boolean visited[];
	
	public static void comp(int n, int[] list_o, int c) {
		int[] list = Arrays.copyOf(list_o, list_o.length+1);
		list[list_o.length] = n;
		loop:
		for(int i = 1; i<= N; i++) {
			if(indir[n][i] != 0) continue;	//이미 방문한 경우 스킵
			if(direct[n][i] != c) continue;	//비교 연산 결과가 없거나 다른 방향인 경우 스킵	
			//이미 방문한 값이면 스킵
			for(int j : list) {
				if(j == i) continue loop;
				indir[j][i] += c;
				indir[i][j] -= c;
			}
			
			//System.out.println(n + " " + i);
			
			comp(i, list, c);
		}
	}
	
	public static void comp(int n) {
		//LinkedList<Integer> list = new LinkedList<>();
		//list.add(n);
		int[] list = {n};
		
		for(int i = 1; i<= N; i++) {
			if(direct[n][i] == 0) continue;	//직접 비교결과가 없는 경우 스킵

			int nc = direct[n][i];	//1이면 i가 더 큼, -1이면 i가 더 작음
			indir[n][i] += nc;
			indir[i][n] -= nc;
			comp(i, list, nc);
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			
			direct = new int[N+1][N+1];
			indir = new int[N+1][N+1];
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				//직접 비교결과가 있을 경우 direct 배열값을 1로 정함
				direct[a][b] = 1;	//b가 a보다 크다
				direct[b][a] = -1;	//a가 b보다 작다, b가 a보다 크다
			}
			
			for(int i = 1; i<= N; i++) {
				comp(i);
				//System.out.println();
			}
			
			int result = 0;
			for(int i = 1; i<= N; i++) {
				int cnt = 0;
				for(int j = 1; j<= N; j++) {
					if(indir[i][j] != 0) {
						cnt++;
					}
				}
				if(cnt == N-1) result++;
			}
			
			sb.append("#");sb.append(t);sb.append(" ");
			if(result == 0) sb.append(-1);
			else sb.append(result);
			sb.append("\n");
		}
		
		System.out.println(sb);
		
	}

}
