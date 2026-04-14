package linkedlist_problems;

import java.util.HashSet;
import java.util.Set;

public class IntersectionsOfYLinkedList {

    public static void main(String[] args) {

        Node head1 = new Node(10);
        head1.next = new Node(15);
        head1.next.next = new Node(30);

        Node head2 = new Node(3);
        head2.next = new Node(6);
        head2.next.next = new Node(9);

        head2.next.next.next = head1.next;

        bruteForce(head1, head2);
        hashing(head1, head2
        );


        optimal(head1, head2);
    }

    static int getCount(Node head){
        int cnt = 0;
        Node temp = head;

        while (temp != null){
            cnt++;
            temp = temp.next;
        }
        return cnt;
    }

    static void optimal(Node h1, Node h2){
        int count1 = getCount(h1);
        int count2 = getCount(h2);
        int diff = 0;

        if(count1 > count2){
            diff = count1 - count2;
            System.out.println(findIntersection(diff,h1, h2));
        }else{
            diff = count2 - count1;
            System.out.println(findIntersection(diff,h2, h1));
        }
    }

    private static Integer findIntersection(int diff,Node h1, Node h2) {
        Node curr1 = h1;
        Node curr2 = h2;

        for (int i = 0; i < diff; i++){
            if (curr1 == null)
                return null;
            curr1 = curr1.next;
        }

        while (curr1 != null && curr2 != null){
            if(curr1 == curr2)
                return curr2.val;
            curr1 = curr1.next;
            curr2 = curr2.next;
        }

        return  -1;
    }


    static void hashing(Node h1, Node h2){
        Set<Node> nodes = new HashSet<>();
        Node t1 = h1;
        Node t2 = h2;


        while (t1 != null){
            nodes.add(t1);
            t1 = t1.next;
        }

        while (t2 != null){
            if(nodes.contains(t2)){
                System.out.println(t2.val);
                return;
            }
            nodes.add(t2);
            t2 = t2.next;
        }
    }

    static void bruteForce(Node h1, Node h2){
        while (h2 != null){
            Node temp = h1;
            while (temp != null){
                if(temp == h2){
                    System.out.println(temp.val);
                    return;
                }
                temp = temp.next;
            }
            h2 = h2.next;
        }
    }
}
