package ex0;

import java.util.Collection;
import java.util.HashMap;

public class NodeData implements node_data {
    static int k=0;
    private int Tag,key;
    private String Info ;
    HashMap<Integer,node_data> ni;


     // create a new node with a unique key
    public NodeData(){
        this.key=k++;
        ni=new HashMap<Integer,node_data>();

    }


    @Override
    public int getKey() {
        return this.key;
    }


     //return the neighbors for the nodes
    @Override
    public Collection<node_data> getNi() {
        return this.ni.values();
    }


     // return  if he contains the neighbor key retrun true else false
    @Override
    public boolean hasNi(int key) {
        return ni.containsKey(key);
    }


     // add the node t to its neighbors
    @Override
    public void addNi(node_data t) {
        this.ni.put(t.getKey(),t);
        if(t.hasNi(this.key)==false){
            t.addNi(this);
        }
    }


    // remove the given node from his neighbors
    @Override
    public void removeNode(node_data node) {
        if(this.hasNi(node.getKey())== true){
            this.ni.remove(node.getKey());
       }
    }

    @Override
    public String getInfo() {
        return this.Info;
    }

    @Override
    public void setInfo(String s) {
        this.Info=s;
    }

    @Override
    public int getTag() {
        return this.Tag;
    }

    @Override
    public void setTag(int t) {
        this.Tag=t;
    }
}
