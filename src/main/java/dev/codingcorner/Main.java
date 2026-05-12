package dev.codingcorner;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.swing.*;

class Main {

    public static void main(String[] args) {
        JFrame frame = initFrame("Bible Quiz!");
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        startScreen(panel, gbc);

        frame.add(panel);
        panel.setBackground(Colors.BASE);

        frame.setVisible(true);
    }

    private static List<Question> loadQuestions() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        List<Question> questions = objectMapper.readValue(
            new File("questions.json"),
            new TypeReference<List<Question>>() {}
        );
        return questions;
    }

    private static void quiz(JPanel panel, GridBagConstraints gbc) {
        List<Question> questions;
        try {
            questions = loadQuestions();
        } catch (IOException e) {
            System.out.println("Error loading question file.");
            throw new RuntimeException("Error loading question file.", e);
        }

        int qNum = 0;

        JLabel questionLabel = new JLabel(questions.get(qNum).question);
        questionLabel.setForeground(Colors.TEXT);

        JTextField answerField = new JTextField(10);

        JButton markButton = new JButton("Check");
        markButton.setBackground(Colors.MAUVE);
        markButton.setOpaque(true);
        markButton.setBorderPainted(false);
        markButton.setFocusPainted(false);

        markButton.addActionListener(e -> {
           String ans = answerField.getText();
           String realAns = questions.get(qNum).answer;
           if (ans.equals(realAns)) {

           }
        });

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(questionLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(answerField, gbc);

        gbc.gridx = 1;
        panel.add(markButton, gbc);
    }

    private static JFrame initFrame(String windowTitle) {
        JFrame frame = new JFrame();

        frame.setTitle(windowTitle);
        frame.setSize(800, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        return frame;
    }

    private static void startScreen(JPanel panel, GridBagConstraints gbc) {
        JLabel label = new JLabel("Bible Quiz");
        JButton button = new JButton("START!");

        label.setForeground(Colors.TEXT);

        button.setBackground(Colors.MAUVE);
        button.setOpaque(true);
        button.setBorderPainted(false);
        button.setFocusPainted(false);

        button.addActionListener(e -> {
            panel.removeAll();
            quiz(panel, gbc);
            panel.revalidate();
            panel.repaint();
        });

        panel.add(label, gbc);

        gbc.gridy = 1;
        panel.add(button, gbc);
    }
}
