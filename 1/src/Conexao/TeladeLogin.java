package Conexao;

/**
 *
 * @author Tiago
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

public class TeladeLogin extends JFrame {

    JPanel jPanel3 = new JPanel();
    Users DAO = new Users();

    ImageIcon imagem = new ImageIcon(getClass().getResource("/icones/seguranca.png"));
    
    JLabel label = new JLabel(imagem);
    JLabel nome = new JLabel("Login");
    JTextField nome1 = new JTextField();
    
    JLabel senha = new JLabel("Senha");
    JPasswordField senha1 = new JPasswordField();
    
    JLabel curs = new JLabel("Curso");
    JComboBox Curso = new JComboBox();
    
    JButton OK = new JButton("OK");
    JButton cancelar = new JButton("Cancelar");
    
    JProgressBar bar = new JProgressBar();

    
    public TeladeLogin() {

        jPanel3.setLayout(null);
        jPanel3.setBounds(0, 0, 509, 405);


        label.setBounds(10, 70, 150, 150);
        nome.setBounds(140, 70, 150, 30);
        nome1.setBounds(190, 70, 150, 30);

        senha.setBounds(140, 110, 150, 30);
        senha1.setBounds(190, 110, 150, 30);

        curs.setBounds(140, 170, 150, 30);
        Curso.setBounds(190, 170, 170, 30);

        Curso.addItem(" ");
        Curso.addItem("Sistemas de Informação");


        OK.setBounds(140, 240, 110, 40);
        cancelar.setBounds(280, 240, 110, 40);

        bar.setBounds(30, 300, 420, 30);
        bar.setStringPainted(true);

        jPanel3.add(OK);
        jPanel3.add(cancelar);
        jPanel3.add(label);
        jPanel3.add(senha);
        jPanel3.add(senha1);
        jPanel3.add(curs);
    jPanel3.add(Curso);
        jPanel3.add(nome);
        jPanel3.add(nome1);
        jPanel3.add(bar);


        add(jPanel3);

        cancelar.setIcon(new ImageIcon(getClass().getResource("/icones/cancel.png")));
        OK.setIcon(new ImageIcon(getClass().getResource("/icones/door_in.png")));

        OK.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                OKActionPerformed(e);
            }
        });

        cancelar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                CancelarActionPerformed(e);
            }
        });
        setLayout(null);
        setTitle("Tela de Login");
        setSize(509, 405);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false); 
        setVisible(true);

    }

    public void OKActionPerformed(ActionEvent evt) {
        if (nome1.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "O campo LOGIN deve ser preenchido !");
            nome1.requestFocus();
        } else if (senha1.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "O campo SENHA deve ser preenchido !");
            nome1.requestFocus();

        } else if (Curso.getSelectedItem() == " ") {
            JOptionPane.showMessageDialog(null, "O campo Curso deve ser preenchido !");
            Curso.requestFocus();

        } else {
            new Thread() {

                public void run() {

                    for (int i = 0; i < 101; i=i+2) {
                        try {

                            sleep(100);
                            bar.setValue(i);

                        } catch (InterruptedException ex) {
                        }

                    }
                    
                    DAO.listarLogin(nome1.getText(), senha1.getText(), (String) Curso.getSelectedItem());

                    new TeladeLogin().setVisible(false);
                    dispose();
                }
            }.start();
        }
    }

    public void CancelarActionPerformed(ActionEvent evt) {
        System.exit(0);
    }

    public static void main(String[] args) {
        new TeladeLogin();
    }
}
