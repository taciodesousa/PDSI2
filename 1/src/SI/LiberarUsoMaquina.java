/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SI;

import Conexao.ConexaoBD;
import Conexao.Users;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author nupasd-ufpi
 */
public class LiberarUsoMaquina extends JFrame {

    JLabel insAluno = new JLabel("Inserir nome do Aluno");
    JLabel insMaquina = new JLabel("Escolher Máquina");
    JComboBox maquina = new JComboBox();
    JButton liberar = new JButton("Liberar Máquina");
    JTextField nomeAluno = new JTextField();
    JButton pesquisarAluno = new JButton("Buscar Aluno");

    //conexão Banco de Dados
    ConexaoBD connection = new ConexaoBD();

    String nome = "";

    public LiberarUsoMaquina() {

        JPanel tela = new JPanel();
        tela.setLayout(null);

        tela.add(insAluno);
        insAluno.setBounds(20, 20, 200, 30);

        tela.add(nomeAluno);
        nomeAluno.setBounds(20, 50, 350, 30);

        tela.add(pesquisarAluno);
        pesquisarAluno.setBounds(20, 85, 200, 30);
        pesquisarAluno.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String cmd = "select nome from alunos where matricula='" + nomeAluno.getText() + "';";
                Statement stmt;
                ResultSet dados = null;

                try {
                    stmt = connection.con.prepareStatement(cmd);

                    dados = stmt.executeQuery(cmd);

                    while (dados.next()) {
                        nome = dados.getString("Nome");
                    }

                    //Verificando se existe aluno encontrado
                    if (nome.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Aluno não encontrado!");
                    }

                } catch (SQLException ex) {
                    Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
                }
                connection.Desconecta();

            }
        });

        tela.add(insMaquina);
        insMaquina.setBounds(20, 150, 200, 30);

        tela.add(maquina);
        maquina.setBounds(20, 180, 250, 30);

        for (int i = 1; i <= 10; i++) {
            maquina.addItem("Computador 0" + i);
        }

        tela.add(liberar);
        liberar.setBounds(20, 220, 200, 30);
        liberar.addActionListener(
                new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                //Thread Para inicialização do socket
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {

                        try {

                            Socket cliente = new Socket("127.0.0.1", 9008);

                            PrintStream saida = new PrintStream(cliente.getOutputStream());
                            String a = "unlock";

                            //Enviando String para desbloqueio da máquina
                            saida.println(a);
                            saida.close();

                        } catch (IOException ex) {
                            Logger.getLogger(LiberarUsoMaquina.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    }

                });

                thread.start();

            }
        });

        add(tela);

        setVisible(
                true);
        setSize(
                440, 400);
        setLocation(
                540, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setTitle(
                "Liberação de Máquina");

        setResizable(
                true);

    }

    public static void main(String[] args) {
        new LiberarUsoMaquina();
    }
}
