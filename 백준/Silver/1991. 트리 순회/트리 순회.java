import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
	
	static class node {
		node left;
		char name;
		node right;
		
		public node(char name) {
			this.left = null;
			this.name = name;
			this.right = null;
		}
		
		public node() {}
	}
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		HashMap<Character, node> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			String read = br.readLine();
			char par = read.charAt(0);
			char left = read.charAt(2);
			char right = read.charAt(4);
			if (!map.containsKey(par)) 
				map.put(par, new node(par));
			if (left != '.') {
				map.put(left, new node(left));
				map.get(par).left = map.get(left);
			}
			if (right != '.') {
				map.put(right, new node(right));
				map.get(par).right = map.get(right);
			}
		}
		preorder(map.get('A'));
		sb.append("\n");
		inorder(map.get('A'));
		sb.append("\n");
		postorder(map.get('A'));
		
		System.out.print(sb);
	}
	
	public static void preorder(node root) {
		if (root == null) return;
		sb.append(root.name);
		preorder(root.left);
		preorder(root.right);
	}
	
	public static void inorder(node root) {
		if (root == null) return;
		inorder(root.left);
		sb.append(root.name);
		inorder(root.right);
	}
	
	public static void postorder(node root) {
		if (root == null) return;
		postorder(root.left);
		postorder(root.right);
		sb.append(root.name);
	}
}
