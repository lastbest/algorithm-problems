import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1210_김준우 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for(int t= 0; t<10;t++) {
			int test_case = Integer.parseInt(br.readLine());
			int[][] ladder = new int[100][100];
			boolean[][] visit = new boolean[100][100];
			int cur_c=0; int arrival =-1;
			
			for(int r = 0; r<100; r++) {
				st = new StringTokenizer(br.readLine()," ");
				for(int c = 0; c<100; c++) {
					ladder[r][c] = Integer.parseInt(st.nextToken());
					if(ladder[r][c] == 2) cur_c = c;
				}
			}
			
			for(int r = 99; r>=0; r--) {
				while(true) {
					//if(ladder[r][cur_c] == 2) break;
					if(r == 0) break;
					int left = -1; int right = -1;
					visit[r][cur_c] = true;
					if(cur_c > 0) {
						if(!visit[r][cur_c-1]) {
							left = ladder[r][cur_c-1];
						}
					}
					if(cur_c < 99) {
						if(!visit[r][cur_c+1]) {
							right = ladder[r][cur_c+1];
						}
					}
					if(left == 1) {
						cur_c--;
						//System.out.println(r+"열"+cur_c+"행 left");
					}
					else if(right == 1) {
						cur_c++;
						//System.out.println(r+"열"+cur_c+"행 right");
					}
					else {
						//System.out.println(r+"열"+cur_c+"행 내려가용");
						break;
					}
					
				}
			}
			//System.out.println(cur_c);
			sb.append("#");sb.append(test_case);sb.append(" ");
			sb.append(cur_c);sb.append("\n");
		}
		
		System.out.println(sb);
		
	}
}
