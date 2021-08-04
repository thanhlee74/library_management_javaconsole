package csd_ass1_library_.management;




public class Node {

    public Object info;
    public Node next;

    public Node() {
    }

    public Node(Object x, Node p) {
        info = x;
        next = p;
    }

    public Node(Object x) {
        this(x, null);
    }

    public Node getNode() {
        return next;
    }

    public Object getInfo() {
        return info;
    }
}
