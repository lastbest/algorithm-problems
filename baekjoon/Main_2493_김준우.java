import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_2493_±èÁØ¿ì {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];int[] arr_rec = new int[N];
		Stack<Integer> stack = new Stack<Integer>();
		Stack<Integer> stack_i = new Stack<Integer>();
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		stack.push(arr[0]);
		stack_i.push(0);
		
		for(int i = 1; i<N;i++) {
			if(stack.isEmpty()) {
				stack.push(arr[i]);
				stack_i.push(i);
			}
			else if(stack.peek()<arr[i]) {
				while(true) {
					if(stack.isEmpty()) {
						break;
					}
					else if(stack.peek()<arr[i]) {
						stack.pop();
						stack_i.pop();
					}
					else if(stack.peek()>arr[i]) {
						arr_rec[i] = stack_i.peek()+1;
						break;
					}
					
				}
				stack.push(arr[i]);
				stack_i.push(i);
			}
			else if(stack.peek()>arr[i]) {
				arr_rec[i] = stack_i.peek()+1;
				stack.push(arr[i]);
				stack_i.push(i);
			}
		}
		
		for(int i = 0; i<N;i++) {
			sb.append(arr_rec[i]);
			sb.append(" ");
		}
		System.out.println(sb);
	}

}
