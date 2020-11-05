package ex0;

import java.util.Collection;
import java.util.HashMap;

public class NodeData implements node_data {
   // Collection<node_data> Neighbors = new ArrayList<>();
    static int k=0;
    private int Tag,key;
    private String Info ;
    HashMap<Integer,node_data> ni;

    public NodeData(){
        this.key=k++;
        ni=new HashMap<Integer,node_data>();

    }

    @Override
    public int getKey() {
        return this.key;
    }

    @Override
    public Collection<node_data> getNi() {
        return this.ni.values();
    }

    @Override
    public boolean hasNi(int key) {
//        for(node_data cur : this.ni.values())
//            if(cur.getKey() == key){
//                return true;
//            }
//        return false;
        return ni.containsKey(key);
    }

    @Override
    public void addNi(node_data t) {
        this.ni.put(t.getKey(),t);
        if(t.hasNi(this.key)==false){
            t.addNi(this);
        }
    }

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


    //    public static void main(String[] args) {
//        NodeData a = new NodeData();
//        NodeData b = new NodeData();
//        NodeData c = new NodeData();
//        NodeData d;
//        System.out.println(a.getKey());
//        System.out.println(a.getNi());
//        a.addNi(b);
//        a.addNi(c);
//        for(node_data cur : a.getNi()){
//            System.out.print(cur.getKey()+",");
//        }
//        System.out.println();
//        System.out.println(a.hasNi(1));
//        a.removeNode(c);
//
//    }
}