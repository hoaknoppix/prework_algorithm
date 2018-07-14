/*
time complexity can be O(n) by using stack
Stack<Node> stack = new Stack<>();
    int i = -1;
    while (current != null) {
        i++;

        if (i <= lastLeftIndex) {
            stack.push(current);
        }
        if (i >= firstRightIndex) {
            Node node = stack.pop();
            int newValue = current.getValue() - node.getValue();
            node.setValue(newValue);
        }
        current = current.getNext();
    }
 */

public class SubtractLinkedList {
    /*
     * Since this problem needs to be solved using constant extra space, so time complexity is O(n^2), space complexity O(6)
     * linkedList should be cloned in order to prevent the changes. //TODO: the clone method implementation for my singlylinkedlist class
     */
    public static SinglyLinkedList getSubstractLinkedList(SinglyLinkedList linkedList) {
        int size = linkedList.getSize();
        if (size <= 1) {
            return linkedList;
        }
        int lastLeftIndex = size / 2 - 1;
        Node current = linkedList.getHead();
        int i = -1;
        int rightIndex = 0;
        Node rightNode = null;
        while (current != null) {
            i++;
            if (i <= lastLeftIndex) {
                rightIndex = size - 1 - i;
                rightNode = current;
                for (int j = i; j < rightIndex; j++) {
                    rightNode = rightNode.getNext();
                }
                current.setValue(rightNode.getValue() - current.getValue());
            }
            current = current.getNext();
        }
        return linkedList;
    }
    
    public static void main(String args[]) {
        SinglyLinkedList linkedList = new SinglyLinkedList();
        for (int i = 1; i <=5; i++) {
            linkedList.add(i);
        }
        SinglyLinkedList substractLinkedList = getSubstractLinkedList(linkedList);
        Node current = substractLinkedList.getHead();
        while (current != null) {
            System.out.print(current.getValue() + " ");
            current = current.getNext();
        }
    }

    private static class Node {
        private int value;
        private Node next;

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getNext() {
            return next;
        }

        public boolean hasNext() {
            return next != null;
        }
    }
    private static class SinglyLinkedList {
        private int size;
        private Node head;

        public Node getHead() {
            return head;
        }

        public void add(int value) {
            Node node = new Node();
            node.setValue(value);
            node.setNext(null);
            if (head == null) {
                head = node;
                size = 1;
                return;
            }
            Node current = head;
            while (current.hasNext()) {
                current = current.getNext();
            }
            current.setNext(node);
            size++;
        }

        public int getSize() {
            return size;
        }
    }
}
