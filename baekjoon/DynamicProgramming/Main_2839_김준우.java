import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2839_김준우 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int five = 0;	//5키로 봉지
		int three = 0;	//3키로 봉지
		int rest = N;	//남은 설탕양
		
		while(rest>=5) {
			five++;
			rest -= 5;
		}
		
		while(rest != 0) {
			if(five == 0 && rest<3)break;
			if(rest>=3) {
				three++;
				rest -=3;
			}
			else if(five>0) {
				five--;
				three++;
				rest += 2;
			}
			else {
				break;
			}
		}
		
		if(rest > 0) {
			System.out.println(-1);
		}
		else {
			System.out.println(five+three);
		}
		
	}
}
