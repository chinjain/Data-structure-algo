package linkedlist_problems;

public class StartingPointOfLoop {

    public static void main(String[] args) {
        Node head = new Node(3);
        head.next = new Node(2);
        head.next.next = new Node(0);
        head.next.next.next = new Node(-4);

        head.next.next.next.next = head.next;


       Node node = optimal_loop(head);
        System.out.println(node.val);

    }

    private static Node optimal_loop(Node head) {

        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null){

            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                slow = head;

                while (slow != fast){
                    slow = slow.next;
                    fast = fast.next;
                }

                return slow;
            }
        }
        return null;
    }
}
