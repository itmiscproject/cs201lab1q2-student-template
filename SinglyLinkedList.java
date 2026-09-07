public class SinglyLinkedList<E> {
    private Node head;
    private Node tail;
    private int size;

    public SinglyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    private class Node {
        E element;
        Node next;

        Node(E element) {
            this.element = element;
            this.next = null;
        }
    }

    public void addFirst(E element) {
        Node newNode = new Node(element);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    public void addLast(E element) {
        Node newNode = new Node(element);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public E first() {
        if (head == null) return null;
        return head.element;
    }

    public E last() {
        if (tail == null) return null;
        return tail.element;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node current = head;
        while (current != null) {
            sb.append(current.element);
            current = current.next;
        }
    
        return sb.toString();
    }

    public void removeLast() {
        if (head == null) return;  // Empty list

        if (head == tail) {  // Only one element
            head = tail = null;
            size--;
            return;
        }

        // Traverse to second-to-last node
        Node current = head;
        while (current.next != tail) {
            current = current.next;
        }

        current.next = null;  // Remove last node
        tail = current;       // Update tail
        size--;
    }

    public void reverse() {
        if (head == null || head == tail) return;  // Empty or single element

        Node prev = null;
        Node current = head;
        Node nextNode;

        while (current != null) {
            nextNode = current.next;  // Save next node
            current.next = prev;      // Reverse the link
            prev = current;           // Move prev forward
            current = nextNode;       // Move current forward
        }

        tail = head;      // Old head becomes new tail
        head = prev;      // Old tail becomes new head
    }
}
