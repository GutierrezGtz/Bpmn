import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Botao extends JFrame implements ActionListener{
	
	private JButton eventoInicio = new JButton(new ImageIcon("C:\\Users\\matheus.villegas\\Pictures\\aaa.png"));
	private JButton cancela = new JButton("Cancela");
	private JButton eventoFim = new JButton(new ImageIcon("eventoFim"));
	private JPanel panel1;
	private JPanel panel2;
	private JFrame jFrame;
	
	public Botao(){
//		super("Criando botões");
//		setLayout(new FlowLayout());
		
		eventoInicio.addActionListener(this);
		add(eventoInicio);
		
		cancela.addActionListener(this);
		add(cancela);
		
		eventoFim.addActionListener(this);
		add(eventoFim);
		
		iniciarComponentes();
		
	}
	
	private void iniciarComponentes() {
		
		jFrame = new JFrame("Meu Frame");
        jFrame.setLayout(new GridLayout(2,2));
        
        panel1 = new JPanel();
        panel1.setLayout(new GridLayout(5, 5));
        
        panel2 = new JPanel();
        panel2.setLayout(new GridLayout(5, 5));
        
        panel1.add(new JLabel(" teste1 "));
        panel2.add(new JLabel(" teste2 "));
        
        jFrame.add(panel1);
        jFrame.add(panel2);
        jFrame.add(eventoInicio);
        jFrame.add(cancela);
        jFrame.add(eventoFim);
        jFrame.add();
        
        jFrame.pack();

        jFrame.setLocationRelativeTo(null);

        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jFrame.setVisible(true);
        
	}

	public void actionPerformed(ActionEvent evento) {
		if(evento.getSource() == eventoInicio)
			JOptionPane.showMessageDialog(null, "O botão Evento Inicio foi clicado");
		
		if(evento.getSource() == cancela)
		JOptionPane.showMessageDialog(null, "O botão CANCELA foi clicado");
		
		if(evento.getSource() == eventoFim)
			JOptionPane.showMessageDialog(null, "O botão Evento Fim foi clicado");
		 
		panel1.setVisible(true);
		panel2.setVisible(true);
	}


}