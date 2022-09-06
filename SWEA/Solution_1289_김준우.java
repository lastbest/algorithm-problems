import java.util.Scanner;
import java.io.FileInputStream;

public class Solution_1289_김준우 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++){
			String s = sc.next();
			int len = s.length();	//입력받은 비트의 길이
			int count = 0;	//수정횟수 저장
			int[] bits = new int[len];	//입력받은 비트를 저장할 배열 생성
			int[] bits_init = new int[len]; 	//초기화된 비트배열 생성
			for(int i = 0;i<len;i++) {
				bits[i] = s.charAt(i)-'0';	//입력받은 값을 형변환하여 저장
				//System.out.println(bits[i]+1);
			}
			for(int i = 0;i<len;i++) {
				//입력받은 값과 다르면 끝까지 덮어씌우기
				if(bits_init[i] != bits[i]) {
					for(int j = i;j<len;j++) {
						bits_init[j] = bits[i];
					}
					count++;
				}
			}
			System.out.println("#"+test_case+" "+count);
		}
	}
}
