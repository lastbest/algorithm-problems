import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution_0207_±èÁØ¿ì {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(int t =1;t<=10;t++) {
			String str = br.readLine();
			int len = str.length();
			char[] arr = new char[len];
			boolean valid = true;
			Stack<Character> stack = new Stack<Character>();
			for(int i =0; i<len;i++) {
				arr[i] = str.charAt(i);
			}
			for(int i =0; i<len;i++) {
				char ch = str.charAt(i);
				if(ch == '{' || ch == '(' || ch == '[' || ch == '<') {
					stack.push(arr[i]);
				}
				else {
					if(stack.empty()) {
						valid = false;
					}
					else if(stack.peek() != '{' && ch == '}') {
						valid = false;
					}
					else if(stack.peek() != '[' && ch == ']') {
						valid = false;
					}
					else if(stack.peek() != '(' && ch == ')') {
						valid = false;
					}
					else if(stack.peek() != '<' && ch == '>') {
						valid = false;
					}
				}
				
			}
			
			sb.append('#');
			sb.append(t);
			sb.append(' ');
			if(valid) {
				sb.append(1);
			}else {
				sb.append(0);
			}
			
			sb.append('\n');
		}
		System.out.println(sb);
			

	}

}
