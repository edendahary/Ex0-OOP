Ex0-oop

This is an object oriented programmin project which his main idea is based on functions.

This Project Made by Eden Dahary Student in Ariel University.

This project contains a undirectional unweighted graph with vertexs and edges.

in this project we implements data structure, algorithms.

Node Class
This Class represents the set of operations applicable on a node (vertex) in a undirectional unweighted graph.

Edge Class
This Class represents the set of operations applicable on a undirectional edge(src,dest) in a undirectional unweighted graph.

DGraph Class
This Class represents a undirectional unweighted graph.

this class contains serval methods:

Graph_DS(){
create a new graph.

node_data getNode(int key)
give  the cuurent node.

boolean hasEdge(int node1, int node2)
check if there is an edge between with given nodes.

connect(int node1, int node2)
add an edge with the given nodes.

node_data removeNode(int key) 
delete the given node and delete him from all his neighbors.

void removeEdge(int node1, int node2)
remove the edge.

Graph_Algo
This Class represents the "regular" Graph Theory algorithms.

this class contains serval methods:

boolean isConnected()
check if every there is a valid path from every node to each other.

int shortestPathDist(int src, int dest)
give the length of the shortest path between src to dest.

List<node_data> shortestPath(int src, int dest)
give the the shortest path between src to dest - as an ordered List of nodes.


