import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_3289_김준우 {
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T;
		T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++)   {
			sb.append("#"+ test_case +" ");
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int n  = Integer.parseInt(st.nextToken());
			int m  = Integer.parseInt(st.nextToken());
			int[][] arr = new int[n+1][n+1];
			//int[][] ins = new int[m][3];
			for(int i = 0;i<m;i++){
				st = new StringTokenizer(br.readLine()," ");
	            int s = Integer.parseInt(st.nextToken());
	            int a = Integer.parseInt(st.nextToken());
	            int b = Integer.parseInt(st.nextToken());
	            if(s == 0){
	            	arr[a][b] = 1;
	                arr[b][a] = 1;
	                for(int j = 1; j<=n;j++){
	                	if(arr[a][j] == 1){
	                		arr[j][b] = 1;
	                        arr[b][j] = 1;
	                    }
	                	if(arr[b][j] == 1){
	                		arr[j][a] = 1;
	                        arr[a][j] = 1;
	                    }
	                }
	            }
	            else if(s==1){
	            	sb.append(arr[a][b]);
	            	
	            }
	        }
			

			for(int i = 0;i<=n;i++){
				System.out.println(Arrays.toString(arr[i]));
			}
		}
		System.out.println(sb);
		
		
	}
}