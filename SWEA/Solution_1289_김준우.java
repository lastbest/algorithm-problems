import java.util.Scanner;
import java.io.FileInputStream;

public class Solution_1289_���ؿ� {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++){
			String s = sc.next();
			int len = s.length();	//�Է¹��� ��Ʈ�� ����
			int count = 0;	//����Ƚ�� ����
			int[] bits = new int[len];	//�Է¹��� ��Ʈ�� ������ �迭 ����
			int[] bits_init = new int[len]; 	//�ʱ�ȭ�� ��Ʈ�迭 ����
			for(int i = 0;i<len;i++) {
				bits[i] = s.charAt(i)-'0';	//�Է¹��� ���� ����ȯ�Ͽ� ����
				//System.out.println(bits[i]+1);
			}
			for(int i = 0;i<len;i++) {
				//�Է¹��� ���� �ٸ��� ������ ������
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
