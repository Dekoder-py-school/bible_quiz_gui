package src;

import javax.swing.*;

class Main {

    public static void main(String[] args) {
        JFrame frame = initFrame("Bible Quiz!");

        frame.getContentPane().setBackground(Colors.BASE);

        frame.setVisible(true);
    }

    private static JFrame initFrame(String windowTitle) {
        JFrame frame = new JFrame();

        frame.setTitle(windowTitle);
        frame.setSize(800, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        return frame;
    }
}
