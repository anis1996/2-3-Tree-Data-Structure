import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class TwoThreeTree  {

	private Node root;

	public TwoThreeTree() {
		root = null;
	}
	
	public boolean insert(int val) {
		if (root == null) {
			root = new Node(val);
			return true;
		}
		Node n = root.search(val);
	
		if (n.getKeys().contains(val)) {
			return false;
		}
		
		n.addKey(val);
		if(n.getKeys().size() == 3)
		{
			n.split();
		}
		return true;
	}
	
	public String search(int var)
	{
		String s = "";
		Node n = root.search(var);
		s+= n.getKeys().get(0);
		if(n.getKeys().size() == 2)
		{
			s+= " "+ n.getKeys().get(1);
		}

			return s;
	}

	class Node implements Comparable {
		ArrayList<Integer> keys;
		ArrayList<Node> children;
		Node parent;

		Node(int x) {
			keys = new ArrayList<Integer>(1);
			children = new ArrayList<Node>();
			keys.add(x);
			parent = null;

		}

		void addKey(int x) {
			keys.add(x);
			Collections.sort(keys);
		}
		
		void addChildren(Node x)
		{
			if(x != null)
			{
			children.add(x);
			Collections.sort(children);
			x.parent = this;
			}
		}

		ArrayList<Integer> getKeys() {
			return keys;
		}
		
		
		ArrayList<Node> getChildren() {
			return children;

		}

		boolean isLeaf() {
			return children.isEmpty();

		}
		
		public void split()
		{
			Node center = new Node(this.getKeys().get(1));
			Node left = new Node(getKeys().get(0));
			Node right = new Node(getKeys().get(2));
			
			if(!getChildren().isEmpty())
			{	
				left.addChildren(getChildren().get(0));
				left.addChildren(getChildren().get(1));
				right.addChildren(getChildren().get(2));
				right.addChildren(getChildren().get(3));
			}
			if(this == root)
			{
				center.addChildren(left); 
				center.addChildren(right);
				root = center;
				return;
			}else 
			{
				parent.addKey(center.getKeys().get(0));
				parent.addChildren(left);
				parent.addChildren(right);
				parent.children.remove(this);
				
				if(parent.getKeys().size() == 3)
				{
					this.parent.split();
				}
			}
		}
		
		
		
		 Node search(int val) {

			if (this == null) {
				return null;
			}
			if (this.getKeys().contains(val) || this.isLeaf()) {
				return this;
			} 
			
			for(int i = 0 ; i < this.getKeys().size(); i++)
			{
					if(val < this.getKeys().get(i))
					{
						return this.getChildren().get(i).search(val);
					}
			}
			return this.getChildren().get(this.getChildren().size()-1).search(val);
		
		}

		@Override
		public int compareTo(Object o) {
			Node r = (Node) o;
			return this.getKeys().get(0).compareTo(r.getKeys().get(0));
			
		}
	}

	
	
}
