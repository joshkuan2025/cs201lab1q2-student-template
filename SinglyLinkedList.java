
public class SinglyLinkedList<E> {

    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    public SinglyLinkedList() {

    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E first() {
        if (isEmpty()) {
            return null;
        }
        return head.getElement();
    }

    public E last() {
        if (isEmpty()) {
            return null;
        }
        return tail.getElement();
    }

    public void addFirst(E e) {
        head = new Node<>(e, head);

        if (isEmpty()) {
            tail = head;
        }
        size++;
    }

    public void addLast(E e) {
        Node<E> newest = new Node<>(e, null);
        if (isEmpty()) {
            head = newest;
        } else {
            tail.setNext(newest);
        }
        tail = newest;
        size++;
    }

    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }

        E answer = head.getElement();
        head = head.getNext();
        size--;

        if (isEmpty()) {
            tail = null;
        }
        return answer;
    }

    // Write your codes below
    public String toString() {
        if (isEmpty() || head == null) {
            return null;
        }

        String result = "";

        Node ptr = head;
        while (ptr.getNext() != null) {
            result += ptr.getElement();
            ptr = ptr.getNext();
        }

        result += ptr.getElement();
        return result;
    }

    public E removeLast() {
        if (isEmpty()) {
            return null;
        }

        E last = tail.getElement();

        if (head == tail) {
            head = null;
            tail = null;
        } else {
            Node ptr = head;
            while (ptr.getNext() != tail) {
                ptr = ptr.getNext();

            }
            ptr.setNext(null);
            tail = ptr;
        }

        size--;
        return last;
    }

    public void reverse() {
        if (isEmpty()) {
            return;
        }

        Node[] stack = new Node[size()];
        int indx = 0;
        Node ptr = head;

        while (ptr.getNext() != null) {
            stack[indx++] = ptr;
            ptr = ptr.getNext();
        }

        stack[indx] = ptr;


        head = stack[indx];
        ptr = head;
        
        for (int i = indx - 1; i >= 0; i--) {
            ptr.setNext(stack[i]);
            ptr = ptr.getNext();

        }

        ptr.setNext(null);
        tail = ptr;
    }
}