/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente_distribuido;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Tacio Moreira
 */
public class Cliente_distribuido extends JFrame {

    JLabel Jsenha = new JLabel("Senha");
    JLabel Jlogin = new JLabel("Login");

    JTextField login = new JTextField();
    JPasswordField senha = new JPasswordField();

    JButton Iniciar = new JButton("Entrar");

    public Cliente_distribuido() {
        JPanel tela = new JPanel();
        tela.setLayout(null);
        tela.setBackground(Color.white);

        tela.add(Jlogin);
        Jlogin.setBounds(50, 60, 350, 40);

        tela.add(login);
        login.setBounds(150, 64, 150, 30);

        tela.add(Jsenha);
        Jsenha.setBounds(50, 120, 350, 40);

        tela.add(senha);
        senha.setBounds(150, 124, 150, 30);

        tela.add(Iniciar);
        Iniciar.setBounds(150, 250, 150, 40);
        Iniciar.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Thread tsensor3 = new Thread(new Runnable() {
                    @Override
                    public void run() {

                        DAO dao = new DAO();

                        System.out.println("Teste1");
                        try {

                            ServerSocket servidor3 = new ServerSocket(9010);
                            System.out.println("Server Rodando!");
                            Socket cliente3 = servidor3.accept();
                            Scanner entrada = new Scanner(cliente3.getInputStream());
                            String a = entrada.nextLine();
                            System.out.println("Recebido de Liberar Uso: " + a);

                            if (!login.getText().equals("")) {
                                //System.out.println("Senha: "+senha.getText());
                                //Socket cliente = new Socket("192.168.0.112",9010);
                                //System.out.println("Esperando cliente se conectar ao servidor pela porta 9008");

                                //rintStream saida = new PrintStream(cliente.getOutputStream());
                                String user = login.getText();
                                String pass = senha.getText();
                                System.out.println("Teste2");
                                dao.verificaUsuario(user, pass);
                                System.out.println("Teste3");
                                //Scanner entrada = new Scanner(cliente.getInputStream());  
                                //String b = entrada.nextLine();
                                //tfsoma.setText(b);
                                //saida.println(user+pass);
                                //saida.close();

                                /*
                                         if(a == "0"){
                                             JOptionPane.showMessageDialog(null,"Aluno não cadastrado!!", "ERRO!",JOptionPane.WARNING_MESSAGE);
 
                                         } else if(a == "1"){
                                            JOptionPane.showMessageDialog(null,"Tenha um otimo acesoo !!", "OK!",JOptionPane.WARNING_MESSAGE);
                                             
                                         }

                                 */
                            } else {//CASO ALGUM CAMPO ESTEJA VAZIO
                                JOptionPane.showMessageDialog(null, "Preencha todos os campos !!", "ERRO!", JOptionPane.WARNING_MESSAGE);
                            }

                        } catch (Exception a) {
                            System.out.println("Ocorreu um problema com cliente\n" + a.getMessage());

                        }
                    }
                });
                tsensor3.start();
            }

        }
        );

        add(tela);
        setVisible(true);
        setSize(440, 440);
        setLocation(440, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Cliente_distribuido();
    }

}
