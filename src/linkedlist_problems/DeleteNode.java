package linkedlist_problems;

public class DeleteNode {

    public static void main(String[] args) {
        Node n1 = new Node(10);
        n1.next = new Node(20);
        n1.next.next = new Node(30);
        n1.next.next.next = new Node(40);
        n1.next.next.next.next = new Node(50);

        deleteNodeAtN(30);
    }

    private static void deleteNodeAtN(int n) {


    }

}
