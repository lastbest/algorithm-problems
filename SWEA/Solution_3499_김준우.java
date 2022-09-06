import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_3499_±èÁØ¿ì {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1 ; t<=T; t++) {
			int N = Integer.parseInt(br.readLine());
			LinkedList<String> queue1 = new LinkedList<String>();
			LinkedList<String> queue2 = new LinkedList<String>();
			LinkedList<String> shuffled = new LinkedList<String>();
			st = new StringTokenizer(br.readLine()," ");
			int cnt =0;
			while(st.hasMoreTokens()) {
				if(cnt++ < Math.round((double)N/2))
					queue1.offer(st.nextToken());
				else
					queue2.offer(st.nextToken());
			}
			//System.out.println(queue1);System.out.println(queue2);
			cnt =0;
			sb.append("#");sb.append(t);sb.append(" ");
			while(!queue1.isEmpty() || !queue2.isEmpty()) {
				if(cnt++%2 == 0) {
					sb.append(queue1.poll());
					sb.append(" ");
				}
				else {
					sb.append(queue2.poll());
					sb.append(" ");
				}
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}

}
