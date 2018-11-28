/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SI;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
import java.util.StringTokenizer;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author nupasd-ufpi
 */
public class maquina_utilizada extends JFrame {

    JLabel nome = new JLabel("Matrícula Aluno:");
    JLabel matricula = new JLabel("Máquina:");
    JLabel situacao = new JLabel("Situação da Máquina: Não Liberado");
    
    JTextField mostraNome = new JTextField();
    JTextField mostraMatricula = new JTextField();

    String hora_entrada;
    String[] palavras;

    PreparedStatement st;
    ResultSet rs;

    public maquina_utilizada() {

        JPanel tela = new JPanel();
        tela.setLayout(null);

        
        tela.add(nome);
        nome.setBounds(20,20,200,30);
        
        tela.add(mostraNome);
        mostraNome.setBounds(20,50,400,30);
        
        
        tela.add(matricula);
        matricula.setBounds(20,120,230,20);
        
        tela.add(mostraMatricula);
        mostraMatricula.setBounds(20,150,400,30);
        
        tela.add(situacao);
        situacao.setBounds(20,200,500,30);
        
        
        
        Thread tsensor3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {

                    ServerSocket servidor3 = new ServerSocket(9008);
                    System.out.println("Esperando cliente se conectar ao servidor pela porta 9008");
                    while (true) {

                        Socket cliente3 = servidor3.accept();
                        System.out.println("Cliente " + cliente3.getInetAddress().getHostAddress() + "conectado...");

                        //ObjectOutputStream saida = new ObjectOutputStream(cliente3.getOutputStream());
                        //ObjectInputStream inFromClient = new ObjectInputStream(cliente3.getInputStream());
                        System.out.println("Esperando dados do cliente");
                        Scanner entrada = new Scanner(cliente3.getInputStream());

                        String recebe = entrada.nextLine();

                        System.out.println("Recebido: " + recebe);

                        //CRIANDO TRATAMENTO PARA O TEXTO
                        palavras = recebe.split(",");

                        for (int i = 0; i < palavras.length; i++) {
                            System.out.println(palavras[i]);
                        }
                        
                        mostraNome.setText(palavras[0]);
                        mostraMatricula.setText(palavras[1]);
                        situacao.setText("Situação da Máquina: Liberado");

                        cliente3.close();

                    }

                } catch (Exception a) {
                    System.out.println("Ocorreu um problema com cliente 3" + a.getMessage());

                }
            }
        });
        tsensor3.start();

        add(tela);

        setVisible(true);
        setSize(440, 280);
        setLocation(540, 300);
        //setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Máquina Laboratório");
        setResizable(true);

    }

    public static void main(String[] args) {

        new maquina_utilizada();
    }
}
