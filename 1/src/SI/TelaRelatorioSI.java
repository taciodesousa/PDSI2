/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SI;

import Conexao.Users;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Tiago
 */
public class TelaRelatorioSI extends JFrame {
    
    RelatorioatbSI atb;
    Users DAO = new Users();
    String data;
    JPanel jPanel1 = new JPanel();
    JPanel jPanel2 = new JPanel();

    JLabel nome = new JLabel("Monitor, Informe o seu nome");
    JTextField nome1 = new JTextField();

    JButton gerar = new JButton("Gerar Relatório");
    JButton cancelar = new JButton("Cancelar");

    public TelaRelatorioSI() {

        setLayout(null);
        setTitle("Gerar Relatório");
        setSize(620, 300);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);

        jPanel1.setLayout(null);
        jPanel1.setBorder(BorderFactory.createTitledBorder(null, " Informações ", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Tahoma", Font.BOLD, 14)));
        jPanel1.setForeground(Color.BLACK);
        jPanel1.setBounds(5, 2, 596, 150);

        nome.setBounds(20, 30, 190, 30);
        nome1.setBounds(190, 30, 350, 28);

        jPanel1.add(nome);
        jPanel1.add(nome1);
        jPanel2.setLayout(null);

        jPanel2.setBorder(BorderFactory.createTitledBorder(null, " Confirmação ", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Tahoma", Font.BOLD, 14)));
        jPanel2.setForeground(Color.BLACK);

        jPanel2.setBounds(5, 150, 596, 105);

        gerar.setBounds(120, 35, 160, 40);
        cancelar.setBounds(360, 35, 160, 40);

        jPanel2.add(gerar);

        jPanel2.add(cancelar);

        add(jPanel1);
        add(jPanel2);
        
        gerar.setIcon(new ImageIcon(getClass().getResource("/icones/gerar.png")));
        cancelar.setIcon(new ImageIcon(getClass().getResource("/icones/cancel.png")));

        gerar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GerarActionPerformed(e);
            }

        });

        cancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CancelarActionPerformed(e);
            }

        });

    }

    public void GerarActionPerformed(ActionEvent evt) {
        if (nome1.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "O campo Nome ser preenchido !");
                        nome1.requestFocus();
                    } else {
                                                                      
                        atb = new RelatorioatbSI(nome1.getText());

                          DAO.RelatorioDiarioSI(nome1.getText());
                          dispose();
                          
                    }
                }
            
        
    public void CancelarActionPerformed(ActionEvent evt) {
        dispose();
    }
    
}