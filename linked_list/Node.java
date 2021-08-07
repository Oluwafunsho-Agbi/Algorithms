package linked_list;

public class Node {
    private int studentNumber;
    private double grade;
    private Node nextNode;

    public Node(int studentNumber, double grade) {
        this.studentNumber = studentNumber;
        this.grade = grade;
        this.nextNode = null;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }
}