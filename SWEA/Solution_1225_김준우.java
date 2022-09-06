import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1225_±èÁØ¿ì {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		StringBuilder sb= new StringBuilder();
		
		for(int t= 0;t<10;t++) {
			Queue<Integer> queue = new LinkedList<Integer>();
			int i =1;
			int T = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine()," ");
			for(int n = 0; n<8; n++) {
				queue.offer(Integer.parseInt(st.nextToken()));
			}
			
			while(i >= 0) {
				int temp = queue.poll() - i++;
				if(temp<=0) {
					i=-1;
					temp = 0;
				}
				queue.offer(temp);
				if(i>5) i = 1;
			}
			
			sb.append("#");sb.append(T);sb.append(" ");
			for(int j=0;j<8;j++) {
				sb.append(queue.poll());
				sb.append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}

}
