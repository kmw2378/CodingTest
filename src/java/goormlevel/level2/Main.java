import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Map<Integer, int[]> map = new HashMap<>();
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			String[] split = br.readLine().split(" ");
			int v = Integer.parseInt(split[0]);
			int w = Integer.parseInt(split[1]);
			
			if (!map.containsKey(v) || (map.containsKey(v) && map.get(v)[1] <= w)) {
				map.put(v, new int[]{i + 1, w});
			}
		}
		
		int answer = 0;
		for (int k : map.keySet()) {
			answer += map.get(k)[0];
		}
		
		System.out.println(answer);
	}
}
