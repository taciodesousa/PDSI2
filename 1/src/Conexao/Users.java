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

        public void listarLogin(String nome, String senha, String curso) {
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

                   String cmd = "select * from  login where Curso='" + curso + "'and Login='" + nome + "' and Senha='"+senha+"'";
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
        }
        

        public void adiciona_AlSI(Alunos Alu){
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
            }

            connection.Desconecta();
        }
        
        public void Excluir_SI(String matricula) {

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
            }
            connection.Desconecta();

        }

        public void Alterar_SI(Alunos Al, String matricula) {

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
            }

            connection.Desconecta();
            

        }


    }
