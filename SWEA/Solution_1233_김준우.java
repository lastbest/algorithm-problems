import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1233_±èÁØ¿ì {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for(int test_case = 1; test_case<=10; test_case++) {
		
			int N = Integer.parseInt(br.readLine()); //int half = N/2;
			//L
			boolean vaild = true;
			for(int i = 0; i<N; i++) {
				st = new StringTokenizer(br.readLine()," ");
				st.nextToken();
				String temp = st.nextToken();
				if(temp.equals("+") || temp.equals("-") ||temp.equals("*") ||temp.equals("/")) {
					for(int s = 0; s<2;s++) {
						if(st.hasMoreTokens()) {
							temp = st.nextToken();
							if(temp.equals("+") || temp.equals("-") ||temp.equals("*") ||temp.equals("/")) {
								vaild = false;
							}
						}
						else {
							vaild = false;
						}
					}
				}
				else if(st.hasMoreTokens()) {
					vaild = false;
				}
				
				
			}
			sb.append("#"+test_case+" ");
			if(vaild)
				sb.append(1);
			else
				sb.append(0);
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
