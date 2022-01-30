public class Node {
    int size;
    String string;
    Node lNode;
    Node rNode;
    public Node(int size,String string){
        this.size=size;
        this.string=string;
        lNode=null;
        rNode=null;
    }
}