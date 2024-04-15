import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class LoteriaIVAN extends JFrame {
    private Random random = new Random();
    private JTextField apostaField;
    private JLabel resultadoLabel;
    private JPanel mainPanel;

    public LoteriaIVAN() {
        setTitle("Loteria");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(4, 1));

        JButton btnApostar0a100 = new JButton("Apostar de 0 a 100");
        btnApostar0a100.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                goToApostarDe0a100();
            }
        });
        mainPanel.add(btnApostar0a100);

        JButton btnApostarAaZ = new JButton("Apostar de A a Z");
        btnApostarAaZ.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                goToApostarDeAaZ();
            }
        });
        mainPanel.add(btnApostarAaZ);

        JButton btnApostarParImpar = new JButton("Apostar em par ou ímpar");
        btnApostarParImpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                goToApostarParOuImpar();
            }
        });
        mainPanel.add(btnApostarParImpar);

        JButton btnSair = new JButton("Sair");
        btnSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        mainPanel.add(btnSair);

        add(mainPanel);
    }

    private void goToApostarDe0a100() {
        JPanel panel = new JPanel(new GridLayout(4, 1));
        JLabel lblAposta = new JLabel("Digite um número de 0 a 100:");
        apostaField = new JTextField();
        JButton btnApostar = new JButton("Apostar");
        resultadoLabel = new JLabel();
        JButton btnVoltar = new JButton("Voltar");

        btnApostar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int aposta = Integer.parseInt(apostaField.getText());
                int numeroSorteado = random.nextInt(101);
                if (aposta == numeroSorteado) {
                    resultadoLabel.setText("Você ganhou R$ 1.000,00 reais.");
                } else {
                    resultadoLabel.setText("Que pena! O número sorteado foi: " + numeroSorteado + ".");
                }
            }
        });

        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getContentPane().removeAll();
                getContentPane().add(mainPanel);
                revalidate();
                repaint();
            }
        });

        panel.add(lblAposta);
        panel.add(apostaField);
        panel.add(btnApostar);
        panel.add(resultadoLabel);
        panel.add(btnVoltar);

        getContentPane().removeAll();
        getContentPane().add(panel);
        revalidate();
        repaint();
    }

    private void goToApostarDeAaZ() {
        JPanel panel = new JPanel(new GridLayout(4, 1));
        JLabel lblAposta = new JLabel("Digite uma letra de A à Z:");
        apostaField = new JTextField();
        JButton btnApostar = new JButton("Apostar");
        resultadoLabel = new JLabel();
        JButton btnVoltar = new JButton("Voltar");

        btnApostar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                char aposta = Character.toUpperCase(apostaField.getText().charAt(0));
                char letraPremiada = 'I';
                if (aposta == letraPremiada) {
                    resultadoLabel.setText("Você ganhou R$ 500,00 reais.");
                } else {
                    resultadoLabel.setText("Que pena! A letra sorteada foi: " + letraPremiada + ".");
                }
            }
        });

        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getContentPane().removeAll();
                getContentPane().add(mainPanel);
                revalidate();
                repaint();
            }
        });

        panel.add(lblAposta);
        panel.add(apostaField);
        panel.add(btnApostar);
        panel.add(resultadoLabel);
        panel.add(btnVoltar);

        getContentPane().removeAll();
        getContentPane().add(panel);
        revalidate();
        repaint();
    }

    private void goToApostarParOuImpar() {
        JPanel panel = new JPanel(new GridLayout(4, 1));
        JLabel lblAposta = new JLabel("Digite um número inteiro:");
        apostaField = new JTextField();
        JButton btnApostar = new JButton("Apostar");
        resultadoLabel = new JLabel();
        JButton btnVoltar = new JButton("Voltar");

        btnApostar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int numero = Integer.parseInt(apostaField.getText());
                if (numero % 2 == 0) {
                    resultadoLabel.setText("Você ganhou R$ 100,00 reais.");
                } else {
                    resultadoLabel.setText("Que pena! O número digitado é ímpar e a premiação foi para números pares.");
                }
            }
        });

        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getContentPane().removeAll();
                getContentPane().add(mainPanel);
                revalidate();
                repaint();
            }
        });

        panel.add(lblAposta);
        panel.add(apostaField);
        panel.add(btnApostar);
        panel.add(resultadoLabel);
        panel.add(btnVoltar);

        getContentPane().removeAll();
        getContentPane().add(panel);
        revalidate();
        repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoteriaIVAN().setVisible(true);
            }
        });
    }
}
