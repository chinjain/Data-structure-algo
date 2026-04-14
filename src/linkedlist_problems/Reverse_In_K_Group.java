package linkedlist_problems;

public class Reverse_In_K_Group {

	public static void main(String[] args) {

        Node head = build(new int[]{1, 2, 3, 4, 5,});
        System.out.print("Input:  ");
        print(head);

        head = reverseGroup(head, 4);
        System.out.print("Output: ");
        print(head);

        System.out.println();
	}

    static Node reverseKNodes(Node head, int k) {
        Node prev = null;
        Node curr = head;

        for (int i = 0; i < k; i++) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev; // new head after reversal
    }

    private static Node reverseGroup(Node head, int k) {

        Node dummy = new Node(0);
        dummy.next = head;
        Node previousGroupTail = dummy;

        while (hasKNodes(previousGroupTail.next,k)){

            Node groupStart = previousGroupTail.next;

            Node groupEnd = previousGroupTail;
            for(int i = 0; i < k; i++){
                groupEnd = groupEnd.next;
            }

            Node newGroupStart = groupEnd.next;
            groupEnd.next = null;

            Node newHead = reverseKNodes(groupStart, k);
            previousGroupTail.next = newHead;
            groupStart.next = newGroupStart;
            previousGroupTail = groupStart;

        }
        return  dummy.next;

    }

    private static boolean hasKNodes(Node node, int k) {
        int count = 0;
        while (node != null && count < k) {
            node = node.next;
            count++;
        }
        return count == k;
    }

    private static Node build(int[] arr) {
        Node dummy = new Node(0);
        Node curr = dummy;
        for (int val : arr) {
            curr.next = new Node(val);
            curr = curr.next;
        }
        return dummy.next;
    }

    static void print(Node head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) System.out.print(" → ");
            head = head.next;
        }
        System.out.println();
    }

    private static Node reverseKGroup(Node head, int k) {

		if(head == null){
			return head;
		}

		Node curr = head;
		Node newHead = null;
		Node tail = null;

		while (curr != null){
			Node grpHead = curr;
			Node next = null;
			Node prev = null;
			int cnt = 0;

			while (curr != null && cnt < k){
				next = curr.next;
				curr.next = prev;
				prev = curr;
				curr = next;
				cnt++;
			}

			if(newHead == null){
				newHead = prev;
			}

			if(tail != null){
				tail.next = prev;
			}

			tail = grpHead;
		}

		curr = newHead;

		while (curr != null){
			System.out.print(curr.val + "->");
			curr = curr.next;
		}

		return newHead;

	}

}
