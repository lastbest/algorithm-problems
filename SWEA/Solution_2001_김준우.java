import java.util.Scanner;

public class Solution_2001_김준우 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int T = sc.nextInt();
		for(int t= 1;t<=T;t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			int[][] arr = new int[N][N];
			int maxkill = 0;
			
			for(int r = 0; r<N; r++) {
				for(int c = 0; c<N; c++) {
					arr[r][c] = sc.nextInt();
				}
			}
			
			for(int r = 0; r<(N-M+1); r++) {
				for(int c = 0; c<(N-M+1); c++) {
					int temp = 0;	//죽인 파리 개수 임시보관
					for(int mr = 0; mr<M; mr++) {
						for(int mc = 0; mc<M; mc++) {
							temp += arr[r+mr][c+mc];
						}
					}
					if(temp>maxkill) maxkill=temp;
				}
			}
			sb.append("#");sb.append(t);sb.append(" ");sb.append(maxkill);sb.append("\n");
		}
		System.out.println(sb);
	}

}
