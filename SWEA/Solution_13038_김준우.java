import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_13038_김준우 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1;t<=T;t++) {
			int n = Integer.parseInt(br.readLine());
			boolean[] classes = new boolean[7];
			int day = 0;
			int cpw = 0;
			int min =0;
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int i = 0;i<7;i++) {
				if(Integer.parseInt(st.nextToken()) == 1) {
					classes[i] = true;
					cpw++;
				}
			}
			
			if(n % cpw == 0) {
				min = (n/cpw-1)*7+1;
				System.out.println("#" +t + " "+ min );
				continue;
			}
			
			/*while(n>cpw) {
				n = n-cpw;
				day += 7;
			}*/
			day = n/cpw*7;
			n = n%cpw;
			
			
			//System.out.println(day);
			//System.out.println(n);
			
			
			for(int i = 0;i<7;i++) {
				int n_t = n;
				int day_t = day;
				if(classes[i]) {
					for(int j = i;j<i+7;i++) {
						day_t++;
						if(classes[j%7]) n_t--;
						if(n_t == 0) break;
					}
					//System.out.println(day_t);
					if(min>day_t || min == 0) min = day_t;
				}
			}
			
			System.out.println("#" +t + " "+ min );
		}
		
	}

}
