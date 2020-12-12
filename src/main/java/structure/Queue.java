package structure;

public class Queue {
	static class Node {
        int value;
        Node next;
    
        public Node(int value) {
            this.value = value;
        }
    }
    
    private Node first = null;
    private Node last = null;

    public void enqueue(Node node) {
        if(last == null) {
            first = last = node;
        } else {
            last.next = node;
            last = node;
        }
    }
    
    public void dequeue() {
        first = first.next;
        if(first == null)
            last = null;
    }

    public void print() {
        Node node = first;
        while(node != null) {
            System.out.print(node.value+" ");
            node = node.next;
        }
    }
        
    public static void main(String[] args) {
        Queue q = new Queue();
    
        q.enqueue(new Node(1));
        q.enqueue(new Node(2));
        q.enqueue(new Node(4));
        q.enqueue(new Node(8));
        q.print();
        
        System.out.println("\n");
        q.dequeue();
        q.print();

    }
}
