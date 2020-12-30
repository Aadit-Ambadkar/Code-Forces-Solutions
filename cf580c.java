import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class cf580c {
	public static boolean[] cats;
	public static boolean[] vis;
	public static ArrayList<Integer>[] adj;
	public static int m;
	public static int ans=0;
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		cats = new boolean[n];
		vis = new boolean[n];
		adj = new ArrayList[n];
		st = new StringTokenizer(f.readLine());
		for (int i = 0; i < n; i++) {
			cats[i] = st.nextToken().equals("1");
			adj[i] = new ArrayList<>();
		}
		for (int i = 0; i < n-1; i++) {
			st = new StringTokenizer(f.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			adj[x].add(y);
			adj[y].add(x);
		}
		dfs(0, 0);
		System.out.println(ans);
	}
	public static void dfs(int node, int cons) {
		if (cats[node]) cons++;
		else cons=0;
		if (cons>m) return;
		vis[node]=true;
		boolean isLeaf=true;
		for (int next: adj[node]) {
			if (!vis[next]) {
				dfs(next, cons);
				isLeaf=false;
			}
		}
		if (isLeaf) ans++;
	}
}
