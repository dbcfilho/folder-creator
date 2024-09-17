import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class CriadorDePastas {

    private JFrame frame;
    private JTextField entryNome;
    private JTextField entryCaminho;
    private JLabel labelStatus;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                CriadorDePastas window = new CriadorDePastas();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public CriadorDePastas() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Criador de Pastas");
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new FlowLayout());

        JLabel labelInstrucaoNome = new JLabel("Digite o nome da pasta:");
        frame.getContentPane().add(labelInstrucaoNome);

        entryNome = new JTextField();
        entryNome.setColumns(30);
        frame.getContentPane().add(entryNome);

        JLabel labelInstrucaoCaminho = new JLabel("Escolha o caminho para a pasta:");
        frame.getContentPane().add(labelInstrucaoCaminho);

        entryCaminho = new JTextField();
        entryCaminho.setColumns(30);
        frame.getContentPane().add(entryCaminho);

        JButton buttonEscolherCaminho = new JButton("Escolher Caminho");
        buttonEscolherCaminho.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                escolherCaminho();
            }
        });
        frame.getContentPane().add(buttonEscolherCaminho);

        JButton buttonCriar = new JButton("Criar Pasta");
        buttonCriar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                criarPasta();
            }
        });
        frame.getContentPane().add(buttonCriar);

        labelStatus = new JLabel("");
        labelStatus.setForeground(Color.BLACK);
        frame.getContentPane().add(labelStatus);
    }

    private void escolherCaminho() {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int escolha = chooser.showOpenDialog(frame);
        if (escolha == JFileChooser.APPROVE_OPTION) {
            File pastaSelecionada = chooser.getSelectedFile();
            entryCaminho.setText(pastaSelecionada.getAbsolutePath());
        }
    }

    private void criarPasta() {
        String nomePasta = entryNome.getText();
        String caminhoPasta = entryCaminho.getText();

        if (!nomePasta.isEmpty() && !caminhoPasta.isEmpty()) {
            File caminhoCompleto = new File(caminhoPasta, nomePasta);

            if (caminhoCompleto.exists()) {
                labelStatus.setText("A pasta '" + nomePasta + "' já existe.");
                labelStatus.setForeground(Color.RED);
            } else {
                try {
                    boolean sucesso = caminhoCompleto.mkdirs();
                    if (sucesso) {
                        labelStatus.setText("Pasta '" + nomePasta + "' criada com sucesso!");
                        labelStatus.setForeground(Color.GREEN);
                    } else {
                        labelStatus.setText("Erro ao criar a pasta.");
                        labelStatus.setForeground(Color.RED);
                    }
                } catch (Exception e) {
                    labelStatus.setText("Erro ao criar a pasta: " + e.getMessage());
                    labelStatus.setForeground(Color.RED);
                }
            }
        } else {
            labelStatus.setText("Digite um nome para a pasta e escolha um caminho.");
            labelStatus.setForeground(Color.RED);
        }
    }
}
