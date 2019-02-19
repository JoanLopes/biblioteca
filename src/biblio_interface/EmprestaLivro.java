package biblio_interface;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import biblioteca.Usuario;


public class EmprestaLivro extends JPanel {
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Color UFT= new Color(9, 106, 97);
	Color UFT_clarinho=new Color(39,147,138);
	
	Font negrito= new Font("Arial",Font.ROMAN_BASELINE , 15);
	JButton botaoemprestar= new JButton("Emprestar");
	JTextField fieldCodLivro= new JTextField();
	JTextField fieldCodUsuario=new JTextField();
	JLabel idUsuario= new JLabel("Codigo do Usuario");
	JLabel codLivro= new JLabel("Codigo do Livro");
	JLabel empLivro= new JLabel("Emprestar Livro");
	 
   private Image image = new ImageIcon("src/imageIcons/bib.png").getImage();
   TelaPrincipal telaPrincipal;
   
     public EmprestaLivro(TelaPrincipal telaprincipal) {
		// TODO Auto-generated constructor stub
    	 this.telaPrincipal= telaprincipal;
    	 
    	 setLayout(null);
    	 this.setSize(1168, 768);
         this.setOpaque(false);
         setPreferredSize(new Dimension(getWidth(), getHeight()));
        
         posicionaNoPainel();  
         
	}
     
     
    public void posicionaNoPainel() {
    	
    	empLivro.setFont(new Font("Arial", Font.BOLD, 30));
        empLivro.setBounds(450, 50, 250, 50);
        this.add(empLivro);
        codLivro.setBounds(350, 200, 150,40);
        codLivro.setFont(negrito);
        this.add(codLivro);
        fieldCodLivro.setBounds(350, 250, 150, 30);
        fieldCodLivro.setFont(negrito);
        fieldCodLivro.addKeyListener(new java.awt.event.KeyAdapter() {
			 public void keyTyped(java.awt.event.KeyEvent e) {
			                
			     if (fieldCodLivro.getText().length() <= 9) {
			                      //deixe passar
			     } else {
			         e.setKeyChar((char) KeyEvent.VK_CLEAR);
			     }
			 }
			 
			 });
        this.add(fieldCodLivro);
        idUsuario.setBounds(580, 200, 150, 40);
        idUsuario.setFont(negrito);
        this.add(idUsuario);
        fieldCodUsuario.setBounds(580, 250, 150, 30);
        fieldCodUsuario.setFont(negrito);
        fieldCodUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
			 public void keyTyped(java.awt.event.KeyEvent e) {
			                
			     if (fieldCodUsuario.getText().length() <= 9) {
			                      //deixe passar
			     } else {
			         e.setKeyChar((char) KeyEvent.VK_CLEAR);
			     }
			 }
			 
			 });
        this.add(fieldCodUsuario);
        
        
        botaoemprestar.setBounds(480, 330, 100, 25);
        this.add(botaoemprestar);
        
	    botaoemprestar.setHorizontalTextPosition(SwingConstants.CENTER);
	    botaoemprestar.setForeground(Color.WHITE);
	    botaoemprestar.setBackground(UFT);
	    botaoemprestar.setFont(new Font("Arial", Font.ROMAN_BASELINE, 15));
	    botaoemprestar.setMargin(new Insets(0, 0, 0, 0));
	    botaoemprestar.setBorder(null);
	    botaoemprestar.setOpaque(true);
	    botaoemprestar.setFocusPainted(false);
		botaoemprestar.setContentAreaFilled(true);
		botaoemprestar.setOpaque(true);
	    botaoemprestar.setBorderPainted(false);
	    
	    botaoemprestar.addMouseListener(new MouseAdapter()  {
			
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				  botaoemprestar.setForeground(Color.WHITE);
				  botaoemprestar.setFocusPainted(false);
				  botaoemprestar.setContentAreaFilled(false);
				  botaoemprestar.setOpaque(true);
				  botaoemprestar.setBackground(UFT);
			}

			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				botaoemprestar.setForeground(Color.BLACK);
				botaoemprestar.setFocusPainted(false);
				botaoemprestar.setContentAreaFilled(true);
				botaoemprestar.setOpaque(true);
				botaoemprestar.setBackground(UFT_clarinho);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseClicked(e);
				Usuario usuario=telaPrincipal.principal.listaUsuaro().get(fieldCodUsuario.getText());
				String codigoLivro= fieldCodLivro.getText();
				
				
					
				telaPrincipal.principal.emprestaLivro(usuario, codigoLivro);
				telaPrincipal.primeiraTela.doClick();
				fieldCodLivro.setText("");
				fieldCodUsuario.setText("");
				
		
			}
			
		});
    	
    }
    
    
    
   
    @Override
    public void paintComponent(Graphics g) {
        /*
         * A imagem vai ser desenhada em x=0, y=0 e usando o tamanho real da imagem
         * é fundamental que seja chamado o método drawImage antes de se chamar o
         * método paintComponent da superclasse.
         */
        g.drawImage(image, 0, 0, this);
        
        /*
         * Ao desenharmos primeiro a imagem garantimos que qualquer componente
         * que seja adicionado ao painel fique por cima da imagem, criando assim
         * o efeito de imagem de background que pretendemos.
         *
         * Se trocarmos a ordem, os efeitos podem não ser os esperados já que a
         * imagem vai ser desenhada em cima dos componentes que estão neste JPanel.
         * Se não existirem componente então a ordem não é relevante.
         */
        super.paintComponent(g);
    }
 
}
    

