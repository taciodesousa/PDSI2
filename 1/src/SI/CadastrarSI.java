package SI;

import Alunos.Alunos;
import Conexao.Users;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
public class CadastrarSI extends JFrame {

    Users DAO = new Users();
    String data;
    Alunos al;

    JPanel jPanel1 = new JPanel();
    JPanel jPanel2 = new JPanel();

    JLabel nome = new JLabel("Nome ");
    JTextField nome1 = new JTextField();

    JLabel sexo = new JLabel("Sexo ");
    JComboBox<String> sexo1 = new JComboBox<String>();

    JLabel DataNascimento = new JLabel("Data de Nascimento ");
    JComboBox<String> dia = new JComboBox<String>();
    JComboBox<String> mes = new JComboBox<String>();
    JComboBox<String> ano = new JComboBox<String>();
    
    JLabel Curso = new JLabel("Curso ");
    JComboBox<String> cur = new JComboBox<String>();

    JLabel rg = new JLabel("RG");
    JTextField rg1 = new JTextField();

    JLabel cpf = new JLabel("CPF");
    JTextField cpf1 = new JTextField();

    JLabel mat = new JLabel("Matrícula ");
    JTextField mat1 = new JTextField();

    JButton cadastra = new JButton("Salvar");
    JButton limpar = new JButton("Limpar");
    JButton cancelar = new JButton("Cancelar");

   
    public CadastrarSI() {

        

        jPanel1.setLayout(null);
        jPanel1.setBorder(BorderFactory.createTitledBorder(null, "Informações Pessoais", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Tahoma", Font.BOLD, 14)));
        jPanel1.setForeground(Color.BLACK);
        jPanel1.setBounds(5, 2, 596, 200);

        nome.setBounds(20, 30, 150, 30);
        nome1.setBounds(70, 30, 300, 28);

        sexo.setBounds(380, 30, 50, 30);
        sexo1.setBounds(420, 30, 100, 28);

        sexo1.addItem("");
        sexo1.addItem("Masculino");
        sexo1.addItem("Feminino");

        DataNascimento.setBounds(20, 80, 200, 30);
        dia.setBounds(140, 80, 65, 30);
        mes.setBounds(220, 80, 65, 30);
        ano.setBounds(300, 80, 65, 30);

        dia.addItem("Dia");
        dia.addItem("01");        dia.addItem("02");
        dia.addItem("03");        dia.addItem("04");
        dia.addItem("05");        dia.addItem("06");
        dia.addItem("07");        dia.addItem("08");
        dia.addItem("09");        dia.addItem("10");
        dia.addItem("11");        dia.addItem("12");
        dia.addItem("13");        dia.addItem("14");
        dia.addItem("15");        dia.addItem("16");
        dia.addItem("17");        dia.addItem("18");
        dia.addItem("19");        dia.addItem("20");
        dia.addItem("21");        dia.addItem("22");
        dia.addItem("23");        dia.addItem("24");
        dia.addItem("25");        dia.addItem("26");
        dia.addItem("27");        dia.addItem("28");
        dia.addItem("29");        dia.addItem("30");
        dia.addItem("31");

        mes.addItem("Mês");
        mes.addItem("01");        mes.addItem("02");
        mes.addItem("03");        mes.addItem("04");
        mes.addItem("05");        mes.addItem("06");
        mes.addItem("07");        mes.addItem("08");
        mes.addItem("09");        mes.addItem("10");
        mes.addItem("11");        mes.addItem("12");

        ano.addItem("Ano");
        
        ano.addItem("1997");        ano.addItem("1996");
        ano.addItem("1995");        ano.addItem("1994");
        ano.addItem("1993");        ano.addItem("1992");
        ano.addItem("1991");        ano.addItem("1990");
        ano.addItem("1989");        ano.addItem("1988");
        ano.addItem("1987");        ano.addItem("1986");
        ano.addItem("1985");        ano.addItem("1984");
        ano.addItem("1983");        ano.addItem("1982");
        ano.addItem("1981");        ano.addItem("1980");
        ano.addItem("1979");        ano.addItem("1978");
        ano.addItem("1977");        ano.addItem("1976");
        ano.addItem("1975");        ano.addItem("1974");
        ano.addItem("1973");        ano.addItem("1972");
        ano.addItem("1971");        ano.addItem("1970");
        ano.addItem("1969");        ano.addItem("1968");
        ano.addItem("1967");        ano.addItem("1966");
        ano.addItem("1965");        ano.addItem("1964");
        ano.addItem("1963");        ano.addItem("1962");
        ano.addItem("1961");        ano.addItem("1960");
        ano.addItem("1959");        ano.addItem("1958");
        ano.addItem("1957");        ano.addItem("1956");
        ano.addItem("1955");        ano.addItem("1954");
        ano.addItem("1953");        ano.addItem("1952");
        ano.addItem("1951");        ano.addItem("1950");

        Curso.setBounds(380, 80, 65, 30);
        cur.setBounds(420, 80, 165, 30);
        
        cur.addItem(" ");
        cur.addItem("Administração");
        cur.addItem("Biologia");
        cur.addItem("Enfermagem");
        cur.addItem("História");
        cur.addItem("Letras");
        cur.addItem("Matemática");
        cur.addItem("Medicina");
        cur.addItem("Nutrição");
        cur.addItem("Pedagogia");
        cur.addItem("Sistemas de Informação");
        
        rg.setBounds(20, 135, 20, 28);
        rg1.setBounds(60, 135, 100, 28);

        cpf.setBounds(180, 135, 100, 28);
        cpf1.setBounds(220, 135, 100, 28);

        mat.setBounds(340, 135, 100, 30);
        mat1.setBounds(410, 135, 120, 30);
        
        

        jPanel1.add(nome);
        jPanel1.add(nome1);
        jPanel1.add(sexo);
        jPanel1.add(sexo1);
        jPanel1.add(DataNascimento);
        jPanel1.add(dia);
        jPanel1.add(mes);
        jPanel1.add(ano);
        jPanel1.add(rg);
        jPanel1.add(Curso);
        jPanel1.add(cur);
        jPanel1.add(rg1);
        jPanel1.add(cpf);
        jPanel1.add(cpf1);
        jPanel1.add(mat);
        jPanel1.add(mat1);

        jPanel2.setLayout(null);

        jPanel2.setBorder(BorderFactory.createTitledBorder(null, "Confirmação", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Tahoma", Font.BOLD, 14)));
        jPanel2.setForeground(Color.BLACK);

        jPanel2.setBounds(5, 200, 596, 105);

        cadastra.setBounds(80, 35, 120, 40);
        limpar.setBounds(240, 35, 120, 40);
        cancelar.setBounds(400, 35, 120, 40);

        jPanel2.add(cadastra);
        jPanel2.add(limpar);
        jPanel2.add(cancelar);

        add(jPanel1);
        add(jPanel2);

        cadastra.setIcon(new ImageIcon(getClass().getResource("/icones/disk.png")));
        cancelar.setIcon(new ImageIcon(getClass().getResource("/icones/cancel.png")));

        limpar.setIcon(new ImageIcon(getClass().getResource("/icones/clear.png")));
        cadastra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CadastrarActionPerformed(e);
            }

        });

        limpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LimparActionPerformed(e);
            }

        });

        cancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CancelarActionPerformed(e);
            }

        });
        
        setLayout(null);
        setTitle("Cadastrar Usuários");
        setSize(620, 350);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    public void CadastrarActionPerformed(ActionEvent evt) {
        if (nome1.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "O campo NOME deve ser preenchido !");
            nome1.requestFocus();
        } else  if (sexo1.getSelectedItem() == "") {
                JOptionPane.showMessageDialog(null, "O campo SEXO deve ser preenchido !");
                sexo1.requestFocus();
            } else if (dia.getSelectedItem() == "Dia") {
                    JOptionPane.showMessageDialog(null, "O campo DIA deve ser preenchido !");
                    dia.requestFocus();
                } else if (mes.getSelectedItem() == "Mês") {
                        JOptionPane.showMessageDialog(null, "O campo Mês deve ser preenchido !");
                        mes.requestFocus();
                    } else if (ano.getSelectedItem() == "Ano") {
                            JOptionPane.showMessageDialog(null, "O campo Ano deve ser preenchido !");
                            ano.requestFocus();
                        } else if (rg1.getText().isEmpty()) {
                                JOptionPane.showMessageDialog(null, "O campo RG deve ser preenchido !");
                                rg1.requestFocus();
                            } else if (cpf1.getText().isEmpty()) {
                                    JOptionPane.showMessageDialog(null, "O campo CPF deve ser preenchido !");
                                    cpf1.requestFocus();
                                } else if (mat1.getText().isEmpty()) {
                                        JOptionPane.showMessageDialog(null, "O campo Matrícula deve ser preenchido !");
                                        mat1.requestFocus();
                                    } else if(cur.getSelectedItem() == " "){
                                     JOptionPane.showMessageDialog(null, "O campo Curso deve ser preenchido !");
                                      cur.requestFocus();
                                    } else {

                                        data = dia.getSelectedItem() + "/" + mes.getSelectedItem() + "/" + ano.getSelectedItem();

                                        al = new Alunos(nome1.getText(), (String) sexo1.getSelectedItem(),
                                                data, rg1.getText(), cpf1.getText(),
                                                mat1.getText(), (String) cur.getSelectedItem());

                                        DAO.adiciona_AlSI(al);

                                        int s = JOptionPane.showConfirmDialog(this, "Deseja exibir a TELA PRINCIPAL?", "Tela Confirmação Tela Principal", JOptionPane.YES_NO_OPTION);
                                        if (s == JOptionPane.YES_OPTION) {

                                            new CadastrarSI().setVisible(false);
                                            dispose();
                                        } else {

                                            nome1.setText("");
                                            sexo1.setSelectedIndex(0);
                                            dia.setSelectedIndex(0);
                                            mes.setSelectedIndex(0);
                                            ano.setSelectedIndex(0);
                                            rg1.setText("");
                                            cpf1.setText("");
                                            mat1.setText("");

                                        }

                                    }
                                }
                         

    public void LimparActionPerformed(ActionEvent evt) {
        nome1.setText("");
        sexo1.setSelectedIndex(0);
        dia.setSelectedIndex(0);
        mes.setSelectedIndex(0);
        ano.setSelectedIndex(0);
        cur.setSelectedIndex(0);
        rg1.setText("");
        cpf1.setText("");
        mat1.setText("");

    }

    public void CancelarActionPerformed(ActionEvent evt) {
        dispose();
    }
}

    