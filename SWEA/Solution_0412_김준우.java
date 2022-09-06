package _0412;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_0412_김준우 {

	public static int solution(int n) {
		int sum = 0;
		
		int size = 0;	//몇자리수인지(10~99 : 1)
		int copy = n;	//n값 복사
		while(copy>9) {
			copy = copy/10;
			size++;
			System.out.println("df");
		}
		
		System.out.println(size);
		System.out.println(copy);
		for(int i = 0; i<size; i++) {
			int temp = 45;
			for(int j = 1; j<=i; j++) {
				temp = temp*10;
			}
			sum = sum*10 + temp;
		}
		return sum;
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			System.out.println(solution(B));
			
		}
		
		System.out.println(sb);d
	}

}
