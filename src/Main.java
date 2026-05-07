package src;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.*;

class Main {

    public static void main(String[] args) {
        JFrame frame = initFrame("Bible Quiz!");
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel questionLabel = new JLabel("QUESTION GOES HERE");

        JTextField answerField = new JTextField(10);
        JButton markButton = new JButton("Check");

        // ensure the LAF paints the custom background color
        markButton.setBackground(Colors.MAUVE);
        markButton.setOpaque(true);
        markButton.setBorderPainted(false);

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(questionLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(answerField, gbc);

        gbc.gridx = 1;
        panel.add(markButton, gbc);

        frame.add(panel);
        panel.setBackground(Colors.BASE);

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
