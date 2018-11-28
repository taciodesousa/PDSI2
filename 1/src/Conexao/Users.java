package Conexao;

import Alunos.Alunos;
import SI.PrincipalSI;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;

public class Users {

    Alunos al = new Alunos();
    ArrayList<Alunos> Aluno = new ArrayList<>();
    ConexaoBD connection = new ConexaoBD();
    JProgressBar bar = new JProgressBar();

    public int listarLogin(String nome, String senha, String curso) {
        try {
            connection.Conexao();
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Conexão errada !");

        }

        Login obj = new Login();

        switch (curso) {
            case " ":
                JOptionPane.showMessageDialog(null, " Há campos não preenchidos !");
                new TeladeLogin();
                break;
            case "Sistemas de Informação": {
                try {
                    connection.Conexao();
                } catch (ClassNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, "Conexão errada !");
                }

                String cmd = "select * from  login where Curso='" + curso + "'and Login='" + nome + "' and Senha='" + senha + "'";
                Statement stmt;
                ResultSet dados = null;

                try {
                    stmt = connection.con.prepareStatement(cmd);

                    dados = stmt.executeQuery(cmd);

                    while (dados.next()) {
                        obj.setCod_Login(dados.getInt("Cod_Login"));
                        obj.setLogin(dados.getString("Login"));
                        obj.setSenha(dados.getString("Senha"));
                        obj.setCurso(dados.getString("Curso"));
                    }

                    if (nome.equals(obj.getLogin()) && senha.equals(obj.getSenha())) {
                        new PrincipalSI().setVisible(true);
                        return 0;

                    } else if (!nome.equals(obj.getLogin()) && !senha.equals(obj.getSenha())) {
                        JOptionPane.showMessageDialog(null, "Login/Senha/Curso Incorretos !");
                        new TeladeLogin().setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "Login/Senha/Curso Incorretos !");
                        new TeladeLogin().setVisible(true);
                    }

                } catch (SQLException ex) {
                    Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
                }
                connection.Desconecta();
                break;
            }
        }
        return 1;
    }

    public int LiberarSI(String matricula) {

        try {
            connection.Conexao();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
            return 1;
        }
        String sql = "delete from em_uso where nome_aluno='" + matricula + "'";

        //SALVANDO NA OUTRA TABELA RELATORIO
        String cmd = "select nome_aluno,  maquina, hora_entrada from em_uso where nome_aluno='" + matricula + "'";

        String nome = null, maquina = null, hora_entrada = null;
        double hora_saida = System.currentTimeMillis();
        Statement stmt1;
        ResultSet dadus = null;

        try {
            stmt1 = connection.con.prepareStatement(cmd);

            dadus = stmt1.executeQuery(cmd);

            while (dadus.next()) {

                nome = dadus.getString("nome_aluno");
                maquina = dadus.getString("maquina");
                hora_entrada = dadus.getString("hora_entrada");

            }

        } catch (SQLException ex) {
            System.out.println("Erro no Banco!");
            return 1;
        }

        //SALVANDO AS INFORMAÇÕES NA TABELA RELATÓRIOS
        String COMANDO = "insert into relatorio"
                + "(nome_aluno, maquina, horario_entrada, horario_saida)"
                + " values(?,?,?,?)";
        try {

            PreparedStatement stmt = connection.con.prepareStatement(COMANDO);

            stmt.setString(1, nome);
            stmt.setString(2, maquina);
            stmt.setString(3, hora_entrada);
            stmt.setString(4, Double.toString(hora_saida));

            stmt.execute();

            //JOptionPane.showMessageDialog(null, "Máquina Liberada!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return 1;
        }

        try {

            PreparedStatement stmt = connection.con.prepareStatement(sql);

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "LIBERADO COM SUCESSO !");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        connection.Desconecta();

        return 0;
    }

    public int adiciona_AlSI(Alunos Alu) {
        try {
            connection.Conexao();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
        }

        String sql = "insert into alunos"
                + "(Nome, Sexo, DataNascimento, RG, CPF, Matricula, Curso)"
                + " values(?,?,?,?,?,?,?)";
        try {

            PreparedStatement stmt = connection.con.prepareStatement(sql);

            stmt.setString(1, Alu.getNome());
            stmt.setString(2, Alu.getSexo());
            stmt.setString(3, Alu.getDataNascimento());
            stmt.setString(4, Alu.getRG());
            stmt.setString(5, Alu.getCPF());
            stmt.setString(6, Alu.getMatricula());
            stmt.setString(7, Alu.getCurso());

            stmt.execute();

            JOptionPane.showMessageDialog(null, "DADOS SALVOS COM SUCESSO !");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return 1;
        }

        connection.Desconecta();

        return 0;
    }

    public int Excluir_SI(String matricula) {

        try {
            connection.Conexao();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
        }
        String sql = "delete from alunos where Matricula='" + matricula + "'";

        try {

            PreparedStatement stmt = connection.con.prepareStatement(sql);

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "EXCLUÍDO COM SUCESSO !");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return 1;
        }
        connection.Desconecta();

        return 0;
    }

    public int Alterar_SI(Alunos Al, String matricula) {

        try {
            connection.Conexao();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
        }

        String sql = "update alunos set Nome = ?, Sexo = ?, DataNascimento = ?, RG = ?, CPF = ?, Matricula = ?, Curso = ?  where Matricula='" + matricula + "'";

        try {

            PreparedStatement stmt = connection.con.prepareStatement(sql);

            stmt.setString(1, Al.getNome());
            stmt.setString(2, Al.getSexo());
            stmt.setString(3, Al.getDataNascimento());
            stmt.setString(4, Al.getRG());
            stmt.setString(5, Al.getCPF());
            stmt.setString(6, Al.getMatricula());
            stmt.setString(7, Al.getCurso());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Dados alterados com Sucesso !!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return 1;
        }

        connection.Desconecta();

        return 0;
    }

}
