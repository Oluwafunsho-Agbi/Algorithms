package linked_list;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    private static int n = 1;
    private static Node median = null;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/main/resources/input.txt"));
        LList lList = new LList();
        while (scanner.hasNext()) {
            int studentNumber = scanner.nextInt();
            double grade = scanner.nextDouble();
            lList.add(studentNumber, grade);
        }
        printContents(lList);
        calculateMedian(lList.getHead());
        System.out.println("The median marks is " + median.getGrade() +
                " by student " + median.getStudentNumber());
    }

    public static String centerString(int width, String s) {
        return String.format("%-" + width + "s",
                String.format("%" + (s.length() + (width - s.length()) / 2) + "s", s));
    }

    private static void printContents(LList lList) {
        System.out.println("Student Number:      Mark:");
        System.out.println("=================    ======");

        Node node = lList.getHead();
        while (node != null) {
            System.out.println(centerString(20, node.getStudentNumber() + "") +
                    centerString(10, node.getGrade() + ""));
            node = node.getNextNode();
        }
    }

    private static void calculateMedian(Node node) {
        if (node == null) {
            n = (n) / 2;
            return;
        }
        n = n + 1;
        calculateMedian(node.getNextNode());
        n = n - 1;
        if (n == 0) {
            median = node;
        }
    }


}
