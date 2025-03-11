package linkedlist_problems;

public class LengthOfLinkedList {

    public static void main(String[] args) {
        Node head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        Node fifth = new Node(5);


        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        // This creates a loop
        fifth.next = second;

        optimal_FindLength(head);

    }

    private static void optimal_FindLength(Node head) {

        Node slow = head;
        Node fast = head;
        int cnt = 1;

        while(fast != null && fast.next != null){

            slow = slow.next;
            fast = fast.next.next;


            if(slow == fast){
                fast = fast.next;
                while (fast != slow){
                    cnt++;
                    fast = fast.next;
                }
                break;
            }
        }

        System.out.println("LengthOfLinkedList.optimal_FindLength : {}" + cnt );

    }
}
