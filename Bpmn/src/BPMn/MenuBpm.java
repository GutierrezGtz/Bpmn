package BPMn;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
 
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
 
public class MenuBpm {
    JLabel texto;
 
    public JMenuBar MenuBpm() {
    	
        JMenuBar barraMenu;
        JMenu menu;
        JMenu submenu;
        JMenuItem menuItem;
 
        
        barraMenu = new JMenuBar();// Cria barra do Menu
        menu = new JMenu("Eventos");// Cria menu
        barraMenu.add(menu);
 
        
        menuItem = new JMenuItem("Evento Inicio", KeyEvent.VK_I);// Cria item do menu
 
        menuItem.addActionListener(new ActionListener(){// Cria evento do item
 
            @Override
            public void actionPerformed(ActionEvent e){
                texto.setText("Você cliquou no Evento Inicio do menu 1");
 
            }
        });
 
        menu.add(menuItem);// Adiciona item ao Menu
        
 
        menuItem = new JMenuItem("Evento Fim", KeyEvent.VK_T);
        menuItem.addActionListener(new ActionListener(){
 
            @Override
            public void actionPerformed(ActionEvent e){
                texto.setText("Você cliquou no Evento Fim do menu 1");
 
            }
        });
 
        menu.add(menuItem);
 
        
        menuItem = new JMenuItem("Evento x", KeyEvent.VK_E);
        menuItem.addActionListener(new ActionListener(){
 
            @Override
            public void actionPerformed(ActionEvent e){
                texto.setText("Você cliquou no Evento x do menu 1");
 
            }
        });
        menu.add(menuItem);
 
        
        menu.addSeparator();// Adiciona um separador de menu
 
        
        
        menuItem = new JMenuItem("Evento y", KeyEvent.VK_M);
        menuItem.addActionListener(new ActionListener(){
 
            @Override
            public void actionPerformed(ActionEvent e){
                texto.setText("Você cliquou no Evento y do menu 1");
 
            }
        });
        menu.add(menuItem);
 
        
        
        // SubMenu
        // para criar um submenu cria-se um novo menu.
        // e adiciona um item 
        // Cria um submenu (novo menu)
        submenu = new JMenu("Evento z");
 
        // Cria um item e seu evento
        menuItem = new JMenuItem("Evento z 1", KeyEvent.VK_U);
        menuItem.addActionListener(new ActionListener()
        {
 
            @Override
            public void actionPerformed(ActionEvent e)
            {
                texto.setText("Você cliquou no Evento z 1 do sub menu");
 
            }
        });
 
        submenu.add(menuItem);
        menu.add(submenu); 
        
        menuItem = new JMenuItem("Evento z 2", KeyEvent.VK_U);
        menuItem.addActionListener(new ActionListener()
        {
 
            @Override
            public void actionPerformed(ActionEvent e)
            {
                texto.setText("Você cliquou no Evento z 2 do sub menu");
 
            }
        });
 
        submenu.add(menuItem);
        menu.add(submenu); 
        
 
       
        
       
        menu = new JMenu("Tarefas"); // Cria um segundo menu
 
        
        menuItem = new JMenuItem("Tarefa Humana", KeyEvent.VK_D);
        menuItem.addActionListener(new ActionListener()
        {
 
            @Override
            public void actionPerformed(ActionEvent e)
            {
                texto.setText("Você cliquou no Tarefa Humana do menu 2");
 
            }
        });
 
        menu.add(menuItem);
        barraMenu.add(menu);

       
        menuItem = new JMenuItem("Desvio Condicional Exclusivo", KeyEvent.VK_L);
        menuItem.addActionListener(new ActionListener(){
 
            @Override
            public void actionPerformed(ActionEvent e){
                texto.setText("Você cliquou no Desvio Condicional Exclusivo do menu 2");
 
            }
        });
        
        menu.add(menuItem);
        barraMenu.add(menu);
        
        
        return barraMenu;// retorna menu completo
 
    }
 
    
    public Container criaPainel() {// Cria um painel
        
        JPanel painel = new JPanel(new BorderLayout());// Cria painel e suas propriedades
        painel.setOpaque(true);
 
        texto = new JLabel("Você cliquou no item:");// Cria um componente de texto

        painel.add(texto, BorderLayout.PAGE_END);// Adiciona componente ao painel
 
        return painel;
    }
 
    
    public static void criaGUI() {
        
        JFrame formulario = new JFrame("Bpmn");// Cria formulario e suas propriedades
        formulario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        MenuBpm menu = new MenuBpm();// Cria Menu
        
        formulario.setJMenuBar(menu.MenuBpm()); // Adiciona barra de menus na GUI
        formulario.setContentPane(menu.criaPainel());// Adiciona painel na GUI
 
        // Adiciona propriedades ao formulario
        formulario.setSize(400, 300);
        formulario.setVisible(true);        
 
    }
 
    
 
}
