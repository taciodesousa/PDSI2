
package Conexao;

/**
 *
 * @author Tiago
 */

public class Login {
    
    private int Cod_Login;
    private String Login;
    private String Senha;
    private String Curso;
    
    public Login(){
         
    }

    public Login(int Cod_Login, String Login, String Senha,String Curso) {
        this.Cod_Login = Cod_Login;
        this.Login = Login;
        this.Senha = Senha;
        this.Curso = Curso;
    }

    public int getCod_Login() {
        return Cod_Login;
    }

    public void setCod_Login(int Cod_Login) {
        this.Cod_Login = Cod_Login;
    }

    public String getLogin() {
        return Login;
    }

    public void setLogin(String Login) {
        this.Login = Login;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String Senha) {
        this.Senha = Senha;
    }
     public String getCurso() {
        return Curso;
    }

    public void setCurso(String Curso) {
        this.Curso = Curso;
    }
    
    
}


