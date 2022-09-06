import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

//첫번째 열에서 마지막 열로 가는 방법. 오른쪽 혹은 오른쪽대각선으로 한칸씪 이동 가능 - > 한칸씪 이동하므로 이동 경로 배열은 int[C]로 생성 가능
//

public class Main_3109_김준우 {
	static int R,C;
	static int[][] map;	//파이프 사이 건물 위치
	static int[] cases, case_index;	//각 가스관별 가능한 케이스 개수, 인덱스 시작 번호
	static Integer[] arr;
	static LinkedList<Integer[]> pipecase = new LinkedList<Integer[]>();	//가능한 파이프 배치 
	
	//static boolean[] visit;
	static int[] select;
	
	public static void Solution() {
		for(int r =0; r<R; r++) {
			makeCase(r, 0);
			if(r>0)case_index[r] = cases[r-1]+case_index[r-1];
		}
		choose();
	}
	
	public static void choose() {
		for(int i =0 ; i<R; i++) {
			for(int j =0 ; j<cases[i]; j++) {
				Integer[] temp = pipecase.get(case_index[i]+j); 
				for(int c = 0 ; c<C;c++) {
					select[c] += temp[c];
				}
			}
		}
		int min = C;
		for(int c = 0 ; c<C;c++) {
			if(min>select[c]) {
				System.out.println("최대"+c);
			}
		}
		
		
	}
	
	public static void makeCase(int r, int c) {
		if(map[r][c] == 'x') {
			return;
		}
		arr[c] = r;
		
		if(c == C-1) {
			Integer[] arrs = new Integer[C];
			
			for(int i = 0;i<C; i++) {
				arrs[i] = arr[i];
			}
			
			pipecase.add(arrs);
			cases[arrs[0]] ++;
			
			return;
		}
		
		makeCase(r,c+1);
		if(r>0)makeCase(r-1,c+1);
		if(r<R-1)makeCase(r+1,c+1);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		arr = new Integer[C];
		cases = new int[R];
		case_index = new int[R];
		select = new int[R];
		
		for(int r = 0;r<R; r++) {
			String str = br.readLine();
			for(int c = 0;c<C; c++) {
				map[r][c] = str.charAt(c);
			}
		}
		
		Solution();
		
		/*
		while(!pipecase.isEmpty()) {
			System.out.println(Arrays.toString(pipecase.remove()));
		}
		*/
		System.out.println();
		System.out.println(Arrays.toString(cases));
		System.out.println(Arrays.toString(case_index));

	}

}
