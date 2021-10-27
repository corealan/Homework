public class LinkList {
    private Node head;
    private Node tail;
    private int size;

    public LinkList() {
        size = 0;
        head = null;
        tail = null;
    }

    public void add(int data){
        Node newNode = new Node(data);

        if(tail == null){
            head = newNode;
            tail = newNode;
        }
        else {
            tail.setNext(newNode);
            tail = newNode;
        }
        size++;
    }

    public int getSize(){
        return size;
    }

    public Node get(int ind){
        int i = 0;
        Node current = this.head;
        while (i != ind){
            current = current.getNext();
            i++;
        }
        return current;
    }

    public void print(){
        Node temp = head;
        while (temp != null){
            System.out.println(temp.getData());
            temp = temp.getNext();
        }
    }
    public Node getHead(){
        return this.head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getTail(){
        return tail;
    }
}
