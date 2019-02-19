package biblio_interface;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class DevolverLivro extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Color UFT= new Color(9, 106, 97);
	Color UFT_clarinho=new Color(39,147,138);
	
	private JLabel cod;
	private JTextField tfCod;
	private JButton btDevolver;
	TelaPrincipal telaPrincipal;
	private Image image = new ImageIcon("src/imageIcons/bib.png").getImage();
	public DevolverLivro(TelaPrincipal telaPrincipal) {
		
		this.telaPrincipal= telaPrincipal;
		Componentes();
		setSize(1168, 768);
		setVisible(true);
		setOpaque(false);
		setPreferredSize(new Dimension(getWidth(), getHeight()));
		

	}
	
	public void Componentes() {
		JLabel titulo = new JLabel("Devolução de Livros");
		titulo.setFont(new Font("Arial", Font.BOLD, 30));
		
		cod = new JLabel("Código do Livro");
		cod.setFont(new Font("Arial", Font.ROMAN_BASELINE, 15));
		tfCod = new JTextField();
		
		btDevolver = new JButton("Devolver");
		
		setLayout(null);
		
		titulo.setBounds(430,90,300,40);
		cod.setBounds(520,290,150,25);
		tfCod.setBounds(470,320,200,30);
		tfCod.setFont(new Font("Arial", Font.ROMAN_BASELINE, 15));
		tfCod.addKeyListener(new java.awt.event.KeyAdapter() {
			 public void keyTyped(java.awt.event.KeyEvent e) {
			                
			     if (tfCod.getText().length() <= 9) {
			                      //deixe passar
			    	 
			     } else {
			         e.setKeyChar((char) KeyEvent.VK_CLEAR);
			     }
			 }
			 
			 });
		btDevolver.setBounds(510,380,120,25);
		
		add(titulo);
		add(cod);
		add(tfCod);
		add(btDevolver);
		
		btDevolver.setHorizontalTextPosition(SwingConstants.CENTER);
		btDevolver.setForeground(Color.WHITE);
		btDevolver.setBackground(UFT);
		btDevolver.setFont(new Font("Arial", Font.ROMAN_BASELINE, 15));
		btDevolver.setMargin(new Insets(0, 0, 0, 0));
		btDevolver.setBorder(null);
		btDevolver.setOpaque(true);
		btDevolver.setFocusPainted(false);
		btDevolver.setContentAreaFilled(true);
		btDevolver.setOpaque(true);
		btDevolver.setBorderPainted(false);
	     
		btDevolver.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				
				
				if(telaPrincipal.principal.listaLivro().get(tfCod.getText()).verifica()==false) {
					
					telaPrincipal.principal.devolveLivro(tfCod.getText());
					JOptionPane.showMessageDialog(null, "Livro Devolvido com Sucesso", "Devolução", JOptionPane.PLAIN_MESSAGE);
					tfCod.setText("");
					telaPrincipal.primeiraTela.doClick();
				}else {
					
					JOptionPane.showMessageDialog(null,"Livros não está da Lista de Livros Emprestados");
					
				}
				
			}
		});
	 
		btDevolver.addMouseListener(new MouseAdapter()  {
			
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				btDevolver.setForeground(Color.WHITE);
				btDevolver.setFocusPainted(false);
				btDevolver.setContentAreaFilled(false);
				btDevolver.setOpaque(true);
				btDevolver.setBackground(UFT);
			}

			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				btDevolver.setForeground(Color.BLACK);
				btDevolver.setFocusPainted(false);
				btDevolver.setContentAreaFilled(true);
				btDevolver.setOpaque(true);
				btDevolver.setBackground(UFT_clarinho);
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


