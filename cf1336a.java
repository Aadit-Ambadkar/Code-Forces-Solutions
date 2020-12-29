import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class cf1336a {
	public static ArrayList<Integer>[] adj;
	public static boolean[] vis;
	public static State[] states;
	public static int t;
	public static int n;
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(f.readLine());
		n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		t = n-k;
		vis = new boolean[n];
		adj = new ArrayList[n];
		states = new State[n];
		for (int i = 0; i < n; i++) {
			adj[i] = new ArrayList<>();
			states[i] = new State();
		}
		for (int i = 0; i < n-1; i++) {
			st = new StringTokenizer(f.readLine());
			int u = Integer.parseInt(st.nextToken())-1;
			int v = Integer.parseInt(st.nextToken())-1;
			adj[u].add(v);
			adj[v].add(u);
		}
		dfs(0, 0);
		Arrays.sort(states);
		long ans = 0;
		for (int i = 0; i < t; i++) {
			ans+=states[i].b-states[i].a;
		}
		System.out.println(ans);
	}
	public static long dfs(int node, long above) {
		//returns #below+1
		vis[node]=true;
		states[node].a=above;
		
		for (int next: adj[node]) {
			if (!vis[next]) {
				states[node].b+=dfs(next, above+1);
			}
		}
		return states[node].b+1;
	}
	public static class State implements Comparable<State>{
		public long a;
		public long b;
		public State(int a, int b) {
			this.a = a;
			this.b = b;
		}
		public State() {
			a=0;
			b=0;
		}
		
		@Override
		public String toString() {
			return "State{" +
					"a=" + a +
					", b=" + b +
					'}';
		}
		
		@Override
		public int compareTo(State o) {
			return Long.compare(o.b - o.a, b - a);
		}
	}
}
