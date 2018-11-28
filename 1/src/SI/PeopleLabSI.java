/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SI;

/**
 *
 * @author Tiago
 */
public class PeopleLabSI {
    
    
    private String Matricula;
    private String Equipamento;
    private String Entrada;
    private String Saida;
    
    public PeopleLabSI(){
    
    }
    
    public PeopleLabSI(String Matricula, String Equipamento, String Entrada, String Saida){
       
       this.Matricula= Matricula ;
       this.Equipamento = Equipamento;
       this.Entrada= Entrada;
       this.Saida = Saida;
         
    
    }

    
    public String getMatricula() {
        return Matricula;
    }

    public void setMatricula(String Matricula) {
        this.Matricula = Matricula;
    }


    public String getEquipamento() {
        return Equipamento;
    }

    public void setEquipamento(String equipamento) {
        this.Equipamento = equipamento;
    }

    public String getEntrada() {
        return Entrada;
    }

    public void setEntrada(String Entrada) {
        this.Entrada = Entrada;
    }

    public String getSaida() {
        return Saida;
    }

    public void setSaida(String Saida) {
        this.Saida = Saida;
    }

}