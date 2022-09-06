import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_18222_김준우 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long k = Long.parseLong(br.readLine());
		long i = 1;
		long reverse = 0;
		
		while(k>2) {
			i = 1;
			while(true) {
				if(k/i == 1 || (k/i == 2 && k%i == 0)) {
					break;
				}
				else {
					i = i*2;
				}
			}
		
			reverse++;
			k -= i;
		}
		
		long result = k-1;
		if(reverse%2 == 1) {
			if(result == 1) result--;
			else result++;
		}
		System.out.println(result);
		
	}

}
