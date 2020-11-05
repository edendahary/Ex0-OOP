package ex0;

import java.util.*;

public class Graph_DS implements graph {
    private int ES;
    private int MC;
  //  private final List<node_data> nodeDataList = new ArrayList<>();
    private  Map<Integer,node_data> MapNode;
    public Graph_DS(){
        ES = 0;
        MC = 0;
       MapNode= new HashMap<>();
    }
    @Override
    public node_data getNode(int key) {
        if (this.MapNode.containsKey(key)) {
            return this.MapNode.get(key);
        }
        return null;
    }

    @Override
    public boolean hasEdge(int node1, int node2) {
       node_data curr = this.MapNode.get(node1);
       return curr.getNi().contains(this.MapNode.get(node2));
    }

    @Override
    public void addNode(node_data n) {
        if(n!=null) {
            this.MapNode.put(n.getKey(), n);
            MC++;
        }
    }


    @Override
    public void connect(int node1, int node2) {
        if(node1!= node2 && this.MapNode.containsKey(node1)&& this.MapNode.containsKey(node2)){
            if(!this.MapNode.get(node1).getNi().contains(this.MapNode.get(node2))) {
                this.MapNode.get(node1).addNi(this.MapNode.get(node2));
                ES++;
                MC++;
            }
        }
    }


    @Override
    public Collection<node_data> getV() {
       return  this.MapNode.values();
    }
//        return this.nodeDataList;
//    }

    @Override
    public Collection<node_data> getV(int node_id) {
        return this.MapNode.get(node_id).getNi();
    }



    @Override
    public node_data removeNode(int key) {
        if(!this.MapNode.containsKey(key)){
            return null;
        }
        node_data nodeDataToRemove = this.MapNode.get(key);
        for(node_data cur : nodeDataToRemove.getNi()){
                cur.removeNode(nodeDataToRemove);
                ES--;
                MC++;
            }
        this.MapNode.remove(key);
        return nodeDataToRemove;
    }



    @Override
    public void removeEdge(int node1, int node2) {
        if(this.MapNode.get(node1).getNi().contains(this.MapNode.get(node2))){
            this.MapNode.get(node1).removeNode(this.MapNode.get(node2));
            this.MapNode.get(node2).removeNode(this.MapNode.get(node1));
            ES--;
            MC++;
        }
    }


    @Override
    public int nodeSize() {
        return MapNode.size();
    }

    @Override
    public int edgeSize() {
            return ES;
    }


    @Override
    public int getMC() {
        return MC;
    }

}
