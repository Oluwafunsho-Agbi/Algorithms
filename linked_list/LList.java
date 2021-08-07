package linked_list;

public class LList {

    private Node head;

    public LList() {
        this.head = null;
    }

    public Node getHead() {
        return head;
    }

    public void add(int studentNumber, double grade) {
        Node node = new Node(studentNumber, grade);
        if (head == null || head.getGrade() < node.getGrade()) {
            node.setNextNode(head);
            head = node;
        } else {
            Node currentNode = head;
            while (currentNode.getNextNode() != null && currentNode.getNextNode().getGrade() > node.getGrade()) {
                currentNode = currentNode.getNextNode();
            }
            node.setNextNode(currentNode.getNextNode());
            currentNode.setNextNode(node);
        }
    }


}
