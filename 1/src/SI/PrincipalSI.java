
package SI;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;


public class PrincipalSI extends JFrame{
    
    ImageIcon imagem = new ImageIcon(getClass().getResource("/icones/logoSI.jpg")); 
    JLabel label = new JLabel(imagem);
    
    Font fonte = new Font("Courier New", Font.BOLD, 25); 
    
    JMenuBar barra = new JMenuBar(); 
    
    JMenu menua = new JMenu("Usuário");
    JMenu menub = new JMenu("Permissão"); 
    JMenu menuc = new JMenu("Relatórios"); 
    JMenu menud = new JMenu("Sair");  
    
    JMenuItem Cadastrar = new JMenuItem("Cadastrar Usuário"); 
    JMenuItem Buscar = new JMenuItem("Buscar Usuário"); 
    JMenuItem Listar = new JMenuItem("Listar Usuários"); 
    JMenuItem Remover = new JMenuItem("Remover Usuário"); 
    JMenuItem Alterar = new JMenuItem("Alterar Usuário"); 
    
    
    JMenuItem uso = new JMenuItem("Liberar Uso");
    JMenuItem desuso = new JMenuItem("Dar baixa"); 
    JMenuItem listar = new JMenuItem("Listar"); 

    JMenuItem relatorio = new JMenuItem("Relatório Diário");
    
    JMenuItem OK = new JMenuItem("OK");    

    
    public PrincipalSI(){
              
        setJMenuBar(barra); 
       
        barra.add(menua); 
        barra.add(menub); 
        barra.add(menuc); 
        barra.add(menud);       
     
        
        menua.add(Cadastrar); 
        menua.add(Buscar); 
        menua.add(Listar); 
        menua.add(Remover); 
        menua.add(Alterar);         
        
        menub.add(uso); 
        menub.add(desuso); 
        menub.add(listar);        
        
        menuc.add(relatorio);
  
        
        menud.add(OK); 
        
        menua.setIcon(new ImageIcon(getClass().getResource("/icones/cadasi.png"))); 
        Cadastrar.setIcon(new ImageIcon(getClass().getResource("/icones/add.png")));
        Buscar.setIcon(new ImageIcon(getClass().getResource("/icones/busca.png")));
        Alterar.setIcon(new ImageIcon(getClass().getResource("/icones/editar.png")));
        Remover.setIcon(new ImageIcon(getClass().getResource("/icones/remover.png")));
        Listar.setIcon(new ImageIcon(getClass().getResource("/icones/listar.png")));
        
        
       menub.setIcon(new ImageIcon(getClass().getResource("/icones/security.png")));
       desuso.setIcon(new ImageIcon(getClass().getResource("/icones/Liberar.png")));
       uso.setIcon(new ImageIcon(getClass().getResource("/icones/polic.png")));
       listar.setIcon(new ImageIcon(getClass().getResource("/icones/listse.png")));
       
       menuc.setIcon(new ImageIcon(getClass().getResource("/icones/Relatorio.png")));
       relatorio.setIcon(new ImageIcon(getClass().getResource("/icones/pdf.png")));
       menuc.add(relatorio);
       
       
       menud.setIcon(new ImageIcon(getClass().getResource("/icones/exit.png")));
       OK.setIcon(new ImageIcon(getClass().getResource("/icones/ok.png")));         
   
        
        label.setBounds(3, -20, 820, 400);
        add(label);
        
        
        OK.addActionListener(new ActionListener (){ // Adiciona um Evento ao Item OK do menu
            @Override
            public void actionPerformed(ActionEvent e) {
                OKActionPerformed(e);
            }
            
        });     
        
         Cadastrar.addActionListener(new ActionListener (){ // Adiciona um Evento ao Item RemoverCLI do menu
            @Override
            public void actionPerformed(ActionEvent e) {
               xCadastroActionPerformed(e);
            }
            
        });
         
         Buscar.addActionListener(new ActionListener (){ // Adiciona um Evento ao Item BuscarCLI do menu
            @Override
            public void actionPerformed(ActionEvent e) {
                BuscActionPerformed(e);
            }
            
        });
         Listar.addActionListener(new ActionListener (){ // Adiciona um Evento ao Item BuscarCLI do menu
            @Override
            public void actionPerformed(ActionEvent e) {
                ListActionPerformed(e);
            }
            
        });
         
        setLayout(null); 
        setTitle("Monitor Sistemas de Informação"); setSize(820, 435); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        setLocationRelativeTo(null); 
        setResizable(false); 
        setVisible(true); 
        
    }    
   
    public void OKActionPerformed(ActionEvent evt){
        JOptionPane.showMessageDialog(null,"Programa Encerrado !");
        System.exit(0);
             
    }  
           
      public void xCadastroActionPerformed(ActionEvent evt){ 
        new CadastrarSI();     
    }
   
      public void BuscActionPerformed(ActionEvent evt){
        new BuscarSI();
    }
      public void ListActionPerformed(ActionEvent evt){
        new ListarTodos();
    }   
       
}
