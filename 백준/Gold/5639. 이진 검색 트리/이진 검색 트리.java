import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tmp = Integer.parseInt(br.readLine());
		int idx = 0;
		int root = tmp;
		Node rNode = new Node(tmp);
		sb = new StringBuilder();
		while(true) {
			String number;
			if ((number = br.readLine()) == null || number == "" ) break;
			tmp = Integer.parseInt(number);
			addTree(rNode, tmp);
		}
		order(rNode);
		System.out.print(sb);
	}
	
	public static void order(Node node) {
		if (node.left != null) {
			order(node.left);
		}
		if (node.right != null) {
			order(node.right);
		}
		sb.append(node.num+"\n");
	}
	
	public static void addTree(Node start, int num) {
		Node node = start;
		if (node.num < num) {
			if (start.right != null) {
				addTree(start.right, num);
			} else {
				Node tmp = new Node(num);
				node.right = tmp;
				return;
			}
		}
		else {
			if (start.left != null) {
				addTree(start.left, num);
			} else {
				Node tmp = new Node(num);
				node.left = tmp;
				return;
			}
			
		}
	}
	
	static class Node {
		int num;
		Node left;
		Node right;
		
		Node(int num) {
			this.num = num;
		}
	}
}
