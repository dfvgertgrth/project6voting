package cedov6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author студент
 */
public class Cedov6 extends JFrame {
    private int votesA = 0, votesB = 0, votesC = 0;

    private JLabel lblVotesA, lblVotesB, lblVotesC;

    public Cedov6() {
        setTitle("🗳️ Симулятор голосования");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JLabel heading = new JLabel("🗳️ Электронная машина для голосования", JLabel.CENTER);
        heading.setFont(new Font("Verdana", Font.BOLD, 24));
        heading.setOpaque(true);
        heading.setBackground(new Color(52, 73, 94));
        heading.setForeground(Color.white);
        heading.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        add(heading, BorderLayout.NORTH);

        JPanel votePanel = new JPanel(new GridLayout(1, 3, 20, 20));
        votePanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        votePanel.setBackground(new Color(236, 240, 241));

        votePanel.add(createVoteButton("Кандидат А", new Color(41, 128, 185)));
        votePanel.add(createVoteButton("Кандидат Б", new Color(39, 174, 96)));
        votePanel.add(createVoteButton("Кандидат В", new Color(192, 57, 43)));

        add(votePanel, BorderLayout.CENTER);

        JPanel resultPanel = new JPanel(new GridLayout(1, 3, 20, 20));
        resultPanel.setBorder(BorderFactory.createEmptyBorder(10, 30, 20, 30));
        resultPanel.setBackground(new Color(236, 240, 241));

        lblVotesA = createResultLabel("Голосов А: 0");
        lblVotesB = createResultLabel("Голосов Б: 0");
        lblVotesC = createResultLabel("Голосов В: 0");

        resultPanel.add(lblVotesA);
        resultPanel.add(lblVotesB);
        resultPanel.add(lblVotesC);

        add(resultPanel, BorderLayout.SOUTH);
    }

    private JPanel createVoteButton(String name, Color color) {
        JButton btn = new JButton("Голосовать за " + name);
        btn.setFont(new Font("Arial", Font.BOLD, 14));
        btn.setBackground(color);
        btn.setForeground(Color.white);
        btn.setFocusPainted(false);

        btn.addActionListener(e -> {
            if (name.contains("А")) votesA++;
            else if (name.contains("Б")) votesB++;
            else if (name.contains("В")) votesC++;
            updateResults();
        });

        JPanel panel = new JPanel(new BorderLayout());
        JLabel label = new JLabel(name, JLabel.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 18));
        label.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));

        panel.setBackground(Color.white);
        panel.setBorder(BorderFactory.createLineBorder(color, 3));
        panel.add(label, BorderLayout.NORTH);
        panel.add(btn, BorderLayout.CENTER);

        return panel;
    }

    private JLabel createResultLabel(String text) {
        JLabel label = new JLabel(text, JLabel.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 16));
        label.setOpaque(true);
        label.setBackground(Color.white);
        label.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2));
        return label;
    }

    private void updateResults() {
        lblVotesA.setText("Голосов А: " + votesA);
        lblVotesB.setText("Голосов Б: " + votesB);
        lblVotesC.setText("Голосов В: " + votesC);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Cedov6().setVisible(true));
    }
}