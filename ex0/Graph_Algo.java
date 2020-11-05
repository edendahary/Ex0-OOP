package ex0;

import java.util.*;

public class Graph_Algo implements graph_algorithms {
    private graph graph;
    @Override
    public void init(graph g) {
        this.graph=g;
    }

    @Override
    public graph copy() {
        graph g = new Graph_DS();
        init(g);
        return graph;
    }

    @Override
    public boolean isConnected() {
        for(node_data curr : this.graph.getV()){
            if(curr != null){
                return BFS(curr);
            }
        }
        return BFS(null);
    }

    @Override
    public int shortestPathDist(int src, int dest) {
        return BFS(src, dest);
    }

    @Override
    public List<node_data> shortestPath(int src, int dest) {
        if(src == dest){
           return null;
        }
        node_data s =this.graph.getNode(src);
        node_data d =this.graph.getNode(dest);
        int[] Dis = new int[graph.nodeSize()];
        node_data[] Parent = new node_data[graph.nodeSize()];
        for(int i=0;i<graph.nodeSize();i++){
            Dis[i]=-1;
            Parent[i]=null;
        }
        for (node_data curr: this.graph.getV()){
            curr.setInfo("false");
        }
        // Mark all the vertices as not visited(By default
        // set as false)

        // Create a queue for BFS
        LinkedList<node_data> queue = new LinkedList<>();

        // Mark the current node as visited and enqueue it
        s.setInfo("true");
        Dis[s.getKey()%graph.nodeSize()]=0;
        Parent[s.getKey()%graph.nodeSize()]=null;
        queue.add(s);

        while (queue.size() != 0)
        {
            // Dequeue a vertex from queue and print it
            s = queue.poll();
            //System.out.print(s.getKey()+" ");

            // Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
            node_data curr = s;
            Iterator<node_data> i =curr.getNi().iterator();
            while (i.hasNext())
            {
                node_data n = i.next();

                if(n.getInfo().equals("false"))
                {

                    n.setInfo("true");
                    Dis[n.getKey()%graph.nodeSize()]=Dis[s.getKey()%graph.nodeSize()]+1;
                    Parent[n.getKey()%graph.nodeSize()]=s;
                    queue.add(n);
                }
            }
        }
        List<node_data> a= new ArrayList<>();
        int i=Dis[dest%graph.nodeSize()];
        a.add(d);
        while(i>0){
        a.add(Parent[i%graph.nodeSize()]);
        i--;
        }
        return a;
    }



    boolean BFS(node_data s)
    {
        if(s==null){return true;}
        for (node_data curr: this.graph.getV()){
            curr.setInfo("false");
        }
        // Mark all the vertices as not visited(By default
        // set as false)


        // Create a queue for BFS
        LinkedList<node_data> queue = new LinkedList<>();

        // Mark the current node as visited and enqueue it
        s.setInfo("true");

        queue.add(s);

        while (queue.size() != 0)
        {
            // Dequeue a vertex from queue and print it
            s = queue.poll();


            // Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
            node_data curr = s;
            Iterator<node_data> i =curr.getNi().iterator();
            while (i.hasNext())
            {
                node_data n = i.next();

                if(n.getInfo().equals("false"))
                {

                    n.setInfo("true");

                    queue.add(n);
                }
            }
        }
        for (node_data curr: this.graph.getV()){
           if(!curr.getInfo().equals("true")){
               return false;
           }
        }
        return true;

    }
    int BFS(int src, int dest){
        node_data s =this.graph.getNode(src);
        int[] Dis = new int[graph.nodeSize()];
        node_data[] Parent = new node_data[graph.nodeSize()];
        for(int i=0;i<graph.nodeSize();i++){
            Dis[i]=-1;
            Parent[i]=null;
        }
        for (node_data curr: this.graph.getV()){
            curr.setInfo("false");
        }
        // Mark all the vertices as not visited(By default
        // set as false)

        // Create a queue for BFS
        LinkedList<node_data> queue = new LinkedList<>();

        // Mark the current node as visited and enqueue it
        s.setInfo("true");
        Dis[s.getKey()%graph.nodeSize()]=0;
        Parent[s.getKey()%graph.nodeSize()]=null;
        queue.add(s);

        while (queue.size() != 0)
        {
            // Dequeue a vertex from queue and print it
            s = queue.poll();
            //System.out.print(s.getKey()+" ");

            // Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
            node_data curr = s;
            Iterator<node_data> i =curr.getNi().iterator();
            while (i.hasNext())
            {
                node_data n = i.next();
                if(n.getInfo().equals("false"))
                {
                    n.setInfo("true");
                    Dis[n.getKey()%graph.nodeSize()]=Dis[s.getKey()%graph.nodeSize()]+1;
                    Parent[n.getKey()%graph.nodeSize()]=s;
                    queue.add(n);
                }
            }
        }
        if(this.graph.getNode(dest).getInfo().equals("false")){
            return -1;
        }
        return Dis[dest%Dis.length];
    }
}
