package GraphTraversals;
import java.util.ArrayList;
import java.util.LinkedList;

import UninformedSearch.Graph;
public class Traversal {
		
	  
	 static ArrayList<Integer> dfstraversalofgraph(int start,int target,Graph g) {
		  int i;
		  int[] visited = new int[g.getnumofvertices()+1];
		  ArrayList<Integer> arrstore = new ArrayList<Integer>();
		  dfshelper(target,start,arrstore,g.adjlist,visited);
		  for(i=1;i<=g.getnumofvertices();i++) {
			  if(visited[i]==0) {
				  dfshelper(target,i,arrstore,g.adjlist,visited);
			  }
		  }
		  return arrstore;
	  }

	private static void dfshelper(int target, int i, ArrayList<Integer> arrstore, LinkedList<Integer>[] adjlist, int[] visited) {
		arrstore.add(i);
		visited[i]=1;
		if(i==target) {
			for(int j=1;j<adjlist.length;j++) {
				visited[j] = 1;
			}
			return;
		}
		if(adjlist[i]!=null) {
			for(Integer it : adjlist[i]) {
				if(visited[it]==0)
					dfshelper(target,it,arrstore,adjlist,visited);
			}
		}
	}
	  
	public static void main(String[]args) {
		Graph g = new Graph(5);
		g.userInput();
		System.out.println("The graph is : ");
		for(int i=0;i<g.adjlist.length;i++) {
			if(g.adjlist[i]!=null)
				System.out.println(i+","+g.adjlist[i].toString());
		}
		System.out.println("Order of nodes visited : "+Traversal.dfstraversalofgraph(5, 1 , g));
	}
}
