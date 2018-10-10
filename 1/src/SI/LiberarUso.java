/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author nupasd-ufpi
 */
public class LiberarUso extends JFrame {

    JComboBox Curso = new JComboBox();
    JLabel computadores = new JLabel("Computadores Disponiveis");
    JLabel titulo = new JLabel("Liberaçao de Acesso as Maquinas");
    JButton liberar = new JButton("Liberar Maquina");

    public LiberarUso() {
        JPanel tela = new JPanel();
        tela.setLayout(null);
        tela.setBackground(Color.white);

        tela.add(titulo);
        titulo.setBounds(30, 30, 300, 40);

        tela.add(computadores);
        computadores.setBounds(30, 80, 250, 30);

        tela.add(Curso);
        Curso.setBounds(30, 110, 200, 30);
        Curso.addItem("");
        Curso.addItem("Computador 01");

        tela.add(liberar);
        liberar.setBounds(30, 150, 200, 30);
        liberar.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Thread tsensor3 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            //Enviar Requisicao de conexao Cliente
                            Socket cliente = new Socket("127.0.0.1", 9010);
                            PrintStream saida = new PrintStream(cliente.getOutputStream());
                            saida.println();
                            saida.close();

                        } catch (IOException ex) {
                            Logger.getLogger(LiberarUso.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        System.out.println("Esperando cliente se conectar ao servidor pela porta 9008");

                        //rintStream saida = new PrintStream(cliente.getOutputStream());
                    }
                });
            }
        });

        add(tela);
        setVisible(true);
        setSize(440, 440);
        setLocation(440, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new LiberarUso();
    }

}
