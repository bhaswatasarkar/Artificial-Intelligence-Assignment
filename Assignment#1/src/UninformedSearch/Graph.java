package UninformedSearch;

import java.util.LinkedList;
import java.util.Scanner;

public class Graph {
	public LinkedList<Integer>[] adjlist;
	private int numofvertices;
	
	public Graph(int numofvertices){
		int i;
		this.numofvertices = numofvertices;
		adjlist  = new LinkedList[numofvertices+1];
		for(i=0;i<numofvertices+1;i++) {
			adjlist[i] = null;
		}
	}
	
	public void userInput() {
		String str = "";
		String vertex_edge[] = new String[2];
		int vertex,vertex2;
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("Enter vertex,edge pair");
			str = sc.nextLine();
			if(str.equals("end"))
				break;
			vertex_edge = str.split(",");
			vertex = Integer.parseInt(vertex_edge[0]);
			vertex2 = Integer.parseInt(vertex_edge[1]);
			
			LinkedList<Integer> edgelist = null;
			
			if(adjlist[vertex]!=null)edgelist=adjlist[vertex];
			else edgelist=new LinkedList<Integer>();
			if(!edgelist.contains(vertex2))
				edgelist.add(vertex2);
			adjlist[vertex] = edgelist;
			
/*For making it unweighted	
 * 		
			if(adjlist[vertex2]!=null)edgelist=adjlist[vertex2];
			else edgelist=new LinkedList<Integer>();
			if(!edgelist.contains(vertex))
				edgelist.add(vertex);
			adjlist[vertex2]= edgelist;
*/			
		}
			
	}
	
	public int getnumofvertices() {
		return numofvertices;
	}
	
}
