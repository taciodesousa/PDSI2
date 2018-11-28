/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SI;

import Conexao.Users;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Tiago
 */
public class GerarRelatorioSI {
    
    public GerarRelatorioSI(ArrayList p,String nome) throws DocumentException, IOException{
    
         Document document = new Document();
        
        ArrayList <PeopleLabSI> novo = new ArrayList<PeopleLabSI>();
        
        Users dao = new Users();
        novo = p;
        

        
        try {
            
            PdfWriter.getInstance(document, new FileOutputStream("C:\\Windows\\Temp\\RelatorioDiario.pdf"));
            document.open();
            document.setPageSize(PageSize.A4);
            
          
          
            Image cab = null;
            try {
                    cab = Image.getInstance("\\icones\\CabSI.png");
                cab.scaleToFit(500, 300);
                
            
            } catch (BadElementException ex) {
                Logger.getLogger(GerarRelatorioSI.class.getName()).log(Level.SEVERE, null, ex);
            }
            
                 
          
           String dados = "";
           
            for (PeopleLabSI novo1 : novo) {
                dados += "" + novo1.getMatricula() + "        "  +
                        "                " 
                        + novo1.getEquipamento() + "                  " + 
                        novo1.getEntrada() + "            "+novo1.getSaida()+"\n";
            }
      
           
            
             String Menu = "";
            
            Menu += "" + "  Matrícula" + "               " +
                        "                           " 
                        + "Equipamento" + "                   " + 
                        "Entrada" + "          "+"Saída";
       
            
            
            document.add(cab);
            
  
            document.add(new Paragraph("Relação dos alunos que frequentaram o laboratório."));
            document.add(new Paragraph(""+Menu));
            document.add(new Paragraph(""+dados));
            document.add(new Paragraph("\n\n\n\n                                   ______________________________________________\n                                                Monitor(a): "+nome));
            

            
        } catch (FileNotFoundException ex) {
            System.out.println("Erro aqui"+ex);
        }finally{
              document.close();
          
        }
        
    } 
    }


