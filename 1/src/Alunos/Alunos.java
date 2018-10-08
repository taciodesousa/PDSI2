/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Alunos;

/**
 *
 * @author Tiago
 */
public class Alunos {
    
    private int Cod_Aluno;
    private String Nome;
    private String Sexo;
    private String DataNascimento;
    private String RG;
    private String CPF;
    private String MATRICULA;
    private String CURSO;
   
    public Alunos (){
    
    }
    public Alunos(String Nome, String Sexo, String DataNascimento, String RG, String CPF, String Matri, String curso) {
        this.Nome = Nome;
        this.Sexo = Sexo;
        this.DataNascimento = DataNascimento;
        this.RG = RG;
        this.CPF = CPF;
        this.MATRICULA= Matri;
        this.CURSO = curso;
    }
 

    public int getCod_Aluno() {
        return Cod_Aluno;
    }

    public void setCod_Aluno(int Cod_Alun) {
        this.Cod_Aluno = Cod_Alun;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String Sexo) {
        this.Sexo = Sexo;
    }

    public String getDataNascimento() {
        return DataNascimento;
    }

    public void setDataNascimento(String DataNascimento) {
        this.DataNascimento = DataNascimento;
    }


    public String getRG() {
        return RG;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getMatricula() {
        return MATRICULA;
    }

    public void setMatricula(String MAT) {
        this.MATRICULA = MAT;
    }    
    
    
    public String getCurso() {
        return CURSO;
    }

    public void setCurso(String cur) {
        this.CURSO = cur;
    }
   
}




