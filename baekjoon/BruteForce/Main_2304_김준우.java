import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
/*
public class Main_2304_김준우 {
	public static class col implements Comparable<col>{
		int L;
		int H;
		
		public col(int L, int H) {
			this.L = L;
			this.H = H;
		}
		
		@Override
		public int compareTo(col o) {
			// TODO Auto-generated method stub
			return this.L-o.L;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append(L);
			builder.append(" ");
			builder.append(H);
			return builder.toString();
		}
		
	}
	public static void main(String[] args) throws IOException {
		//==========input============================
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] column = new int[N][2];	//기둥의 위치, 높이 배열
		PriorityQueue<col> cols = new PriorityQueue<col>();
		int left = 0; int right = 0;	//맨 왼쪽, 오른쪽 기둥의 위치
		int result = 0;
		int top = 0;	//가장 높은 기둥의 높이
		int tl = 0;		//가장 높은 기둥의 위치
		
		for(int i = 0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int L = Integer.parseInt(st.nextToken());
			int H = Integer.parseInt(st.nextToken());
			cols.add(new col(L,H));
			if(top == 0 || H>top) {
				top = H;
				tl = L;
			}
			if(left == 0 && right == 0) {left =L; right =L;}
			if(left>L) left = L;
			if(right<L) right = L;
		}
		
		while(!cols.isEmpty()) {
			System.out.println(cols.poll());
		}
		
		//int j = 0;
		//int temp = column[0][1];
		//col temp = cols.poll();
		int height = cols.poll().H;
		for(int i = left;i<tl;i++) {	//왼쪽에서 오른쪽으로 탐색
			col temp = cols.poll();
			if(temp.L == i) {
				if (temp.H>height) {
					height = temp.H;
				}
			}
			result += height;
		}

		//j=N-1;
		//temp = column[j][1];
		
		for(int i = right;i>=tl;i--) {	//오른쪽에서 왼쪽으로 탐색
			if(column[j][0] == i) {
				if (column[j][1]>temp) {
					temp = column[j][1];
				}
				j--;
			}
			result += temp;
		}
		
		System.out.println(result);
		
	}

	
}
*/
public class Main_2304_김준우 {
	public static void main(String[] args) throws IOException {
		//==========input============================
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] column = new int[N][2];	//기둥의 위치, 높이 배열
		int left, right;	//맨 왼쪽, 오른쪽 기둥의 위치
		int result = 0;
		int top = 0;	//가장 높은 기둥의 높이
		int tl = 0;		//가장 높은 기둥의 위치
		
		for(int i = 0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int L = Integer.parseInt(st.nextToken());
			int H = Integer.parseInt(st.nextToken());
			column[i][0] = L;
			column[i][1] = H;
			if(top == 0 || H>top) {
				top = H;
				tl = L;
			}
		}
		
		Arrays.sort(column, new Comparator<int[]>() {
			public int compare(int[] s1, int[] s2) {
				return s1[0] - s2[0];
			}
		});
		
		left = column[0][0];
		right = column[N-1][0];
		
		int j = 0;
		int temp = column[j][1];
		for(int i = left;i<tl;i++) {	//왼쪽에서 오른쪽으로 탐색
			if(column[j][0] == i) {
				if (column[j][1]>temp) {
					temp = column[j][1];
				}
				j++;
			}
			result += temp;
		}

		j=N-1;
		temp = column[j][1];
		for(int i = right;i>=tl;i--) {	//오른쪽에서 왼쪽으로 탐색
			if(column[j][0] == i) {
				if (column[j][1]>temp) {
					temp = column[j][1];
				}
				j--;
			}
			result += temp;
		}
		
		System.out.println(result);
	}

}