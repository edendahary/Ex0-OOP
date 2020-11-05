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
//        node_data nodeData = null;
//        for(node_data cur : this.nodeDataList) {
//            if(cur.getKey() == key) {
//                nodeData = cur;
//                break;
//            }
//        }
//        return nodeData;
 //   }

    @Override
    public boolean hasEdge(int node1, int node2) {
       node_data curr = this.MapNode.get(node1);
       return curr.getNi().contains(this.MapNode.get(node2));
    }
//        node_data cur = getNode(node1);
//        if(cur!= null && cur.hasNi(node2)==true){
//            return true;
//        }
//        return false;
//    }

    @Override
    public void addNode(node_data n) {
        if(n!=null) {
            this.MapNode.put(n.getKey(), n);
            MC++;
        }
    }
//        this.nodeDataList.add(n);
//    }

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
//        if(node1!=node2 ) {
//            node_data cur = getNode(node1);
//            node_data cur1 = getNode(node2);
//            if (cur != null && cur1 != null) {
//                if (cur.hasNi(cur1.getKey()) == false) {
//                    cur.addNi(cur1);
//                    ES++;
//
//                }
//            }
//        }
//    }

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

//        node_data cur = getNode(node_id);
//        return cur.getNi();
//    }

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

//        node_data nodeDataToRemove = getNode(key);
//
//
//        if(nodeDataToRemove == null) {
//            return null;
//        }else{
//            for(node_data cur : nodeDataToRemove.getNi()){
//                cur.removeNode(nodeDataToRemove);
//                ES--;
//            }
//            this.nodeDataList.remove(nodeDataToRemove);
//            return nodeDataToRemove;
//        }
//
//    }

    @Override
    public void removeEdge(int node1, int node2) {
        if(this.MapNode.get(node1).getNi().contains(this.MapNode.get(node2))){
            this.MapNode.get(node1).removeNode(this.MapNode.get(node2));
            this.MapNode.get(node2).removeNode(this.MapNode.get(node1));
            ES--;
            MC++;
        }
    }
//        node_data curr = this.getNode(node1);
//        if(curr.hasNi(node2)==true){
//            node_data EdgetoRemove= this.getNode(node2);
//            curr.getNi().remove(EdgetoRemove);
//            EdgetoRemove.getNi().remove(curr);
//            ES--;
//
//        }
//    }

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
