package biblio_interface;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class CadLivro extends JPanel {
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Color UFT= new Color(9, 106, 97);
	Color UFT_clarinho=new Color(39,147,138);
	Font negrito= new Font("Arial",Font.ROMAN_BASELINE , 18);
	Font negri= new Font("Arial",Font.BOLD , 30);
	JFileChooser gerenciador= new JFileChooser();
    JLabel titulo= new JLabel("Titulo:");
    JLabel autor= new JLabel("Autor(es):");
    JLabel descricao= new JLabel("Descrição:");
    JLabel Ano= new JLabel("Ano de lançamento:");
    JLabel quantidade= new JLabel("Quantidade:");
    JLabel pesquisaImagem= new JLabel("adicione uma imagem:");
    JLabel tituloTela= new JLabel("Cadastro de Livros");
    JButton botaoPesquisa= new JButton("Pesquisar");
    JButton botaoSalvar= new JButton("Salvar");
    JButton botaoCancelar= new JButton("Cancelar");
    JLabel imagens= new JLabel("");
    ImageIcon imagem;
    Image aux;
    JTextArea areaDescricao= new JTextArea();
    JScrollPane  scroll= new JScrollPane(areaDescricao);
    JTextField fieldTitulo= new JTextField(70);
    JTextField fieldAutor= new JTextField(70);
    JTextField fieldAno= new JTextField(30);
    JTextField fieldQuant= new JTextField(20);
    JTextField fieldPesquisa= new JTextField(70);
    JPanel label;
  
    TelaPrincipal telaPricipal;
    
	 
   private Image image = new ImageIcon("src/imageIcons/bib.png").getImage();
   
    public CadLivro(TelaPrincipal telaprincipal) {
		// TODO Auto-generated constructor stub
    	 this.telaPricipal= telaprincipal;
    	 
    	 setLayout(null);
    	 this.setSize(1168, 768);
         this.setOpaque(false);
         setPreferredSize(new Dimension(getWidth(), getHeight()));
        
         posicionaNoPainel();
         adicionaAcao();
  
         
	}
    public void posicionaNoPainel() {
    	tituloTela.setBounds(400,10,400,70);
    	tituloTela.setFont(negrito);
    	tituloTela.setFont(negri);
    	this.add(tituloTela);
        titulo.setBounds(80,100,50,30);
        titulo.setFont(negrito);
        this.add(titulo);
        fieldTitulo.setBounds(160, 100, 400, 30);
        fieldTitulo.setFont(negrito);
        fieldTitulo.addKeyListener(new java.awt.event.KeyAdapter() {
			 public void keyTyped(java.awt.event.KeyEvent e) {
			                
			     if (fieldTitulo.getText().length() <= 100) {
			                      //deixe passar
			     } else {
			         e.setKeyChar((char) KeyEvent.VK_CLEAR);
			     }
			 }
			 
			 });
        this.add(fieldTitulo);
        autor.setBounds(80,165,80,30);
        autor.setFont(negrito);
        this.add(autor);
        fieldAutor.setBounds(160, 165, 400, 30);
        fieldAutor.setFont(negrito);
        fieldAutor.addKeyListener(new java.awt.event.KeyAdapter() {
			 public void keyTyped(java.awt.event.KeyEvent e) {
			                
			     if (fieldTitulo.getText().length() <= 100) {
			                      //deixe passar
			     } else {
			         e.setKeyChar((char) KeyEvent.VK_CLEAR);
			     }
			 }
			 
			 });
        this.add(fieldAutor);
        Ano.setBounds(80,230,170,30);
        Ano.setFont(negrito);
        this.add(Ano);
        fieldAno.setBounds(240, 230, 55, 30);
        fieldAno.setFont(negrito);
        fieldAno.addKeyListener(new KeyListener() {//limita o Jtextfild somente a numeros
            public void keyTyped(KeyEvent e) {
                if (!((e.getKeyChar() >= KeyEvent.VK_0 &&    e.getKeyChar() <= KeyEvent.VK_9) || 
                      (e.getKeyChar() == KeyEvent.VK_ENTER ))) {
                    e.consume();
                }
            }
            public void keyPressed(KeyEvent e) {
            }
            public void keyReleased(KeyEvent e) {
            }
        });
        fieldAno.addKeyListener(new java.awt.event.KeyAdapter() {
			 public void keyTyped(java.awt.event.KeyEvent e) {
			                
			     if (fieldAno.getText().length() <= 3) {
			                      //deixe passar
			     } else {
			         e.setKeyChar((char) KeyEvent.VK_CLEAR);
			     }
			 }
			 
			 });
        this.add(fieldAno);
        this.add(fieldAutor);
        quantidade.setBounds(305,230,150,30);
        quantidade.setFont(negrito);
        this.add(quantidade);
        fieldQuant.setBounds(415, 230, 55, 30);
        fieldQuant.setFont(negrito);
        fieldQuant.addKeyListener(new KeyListener() {//limita o Jtextfild somente a numeros
            public void keyTyped(KeyEvent e) {
                if (!((e.getKeyChar() >= KeyEvent.VK_0 &&    e.getKeyChar() <= KeyEvent.VK_9) || 
                      (e.getKeyChar() == KeyEvent.VK_ENTER ))) {
                    e.consume();
                }
            }
            public void keyPressed(KeyEvent e) {
            }
            public void keyReleased(KeyEvent e) {
            }
        });
        fieldQuant.addKeyListener(new java.awt.event.KeyAdapter() {
			 public void keyTyped(java.awt.event.KeyEvent e) {
			                
			     if (fieldQuant.getText().length() <= 1) {
			                      //deixe passar
			     } else {
			         e.setKeyChar((char) KeyEvent.VK_CLEAR);
			     }
			 }
			 
			 });
        this.add(fieldQuant);
        descricao.setBounds(80, 315, 85, 20);
        descricao.setFont(negrito);
        this.add(descricao);
        scroll.setBounds(165, 315, 430, 100);
        areaDescricao.setFont(negrito);
        areaDescricao.setLineWrap(true);//\n
        areaDescricao.setWrapStyleWord(true);// nao quebra a linha
        scroll.setPreferredSize(new Dimension(1, 1));
        areaDescricao.addKeyListener(new java.awt.event.KeyAdapter() {
			 public void keyTyped(java.awt.event.KeyEvent e) {
			                
			     if (areaDescricao.getText().length() <= 256) {
			                      //deixe passar
			    	 
			     } else {
			         e.setKeyChar((char) KeyEvent.VK_CLEAR);
			     }
			 }
			 
			 });
        this.add(scroll);
        pesquisaImagem.setBounds(80, 460, 200, 30);
        pesquisaImagem.setFont(negrito);
        this.add(pesquisaImagem);
        fieldPesquisa.setBounds(270,465,300,25);
        fieldPesquisa.setFont(negrito);
        fieldPesquisa.setEditable(false);
        this.add(fieldPesquisa);
        botaoPesquisa.setBounds(582,465,110,25);
        this.add(botaoPesquisa);
        imagens.setBounds(700, 100, 400,400);
        this.add(imagens);
        botaoSalvar.setBounds(810,600,100,25);
        this.add(botaoSalvar);
        botaoCancelar.setBounds(928,600,100,25);
        this.add(botaoCancelar);
    }
    public void adicionaAcao(){
    	
    	botaoPesquisa.setFocusPainted(true);
 	    botaoPesquisa.setContentAreaFilled(false);
 	    botaoPesquisa.setHorizontalTextPosition(SwingConstants.CENTER);
 	    botaoPesquisa.setBackground(UFT);
 	    botaoPesquisa.setForeground(Color.WHITE);
 	    botaoPesquisa.setFont(new Font("Arial", Font.ROMAN_BASELINE, 15));
 	    botaoPesquisa.setMargin(new Insets(0, 0, 0, 0));
 	    botaoPesquisa.setBorder(null);
 	    botaoPesquisa.setOpaque(true);
 	    botaoPesquisa.setBorderPainted(false);
 	    botaoPesquisa.addMouseListener(new MouseAdapter() {
 			
 			@Override
 			public void mouseExited(MouseEvent e) {
 				// TODO Auto-generated method stub
 				  botaoPesquisa.setBackground(UFT);
 				  botaoPesquisa.setForeground(Color.WHITE);
 				  botaoPesquisa.setFocusPainted(false);
 				  botaoPesquisa.setContentAreaFilled(true);
 				  botaoPesquisa.setOpaque(true);
 			}
 			
 			@Override
 			public void mouseEntered(MouseEvent e) {
 				// TODO Auto-generated method stub
 				  botaoPesquisa.setForeground(Color.BLACK);
 				  botaoPesquisa.setFocusPainted(false);
 				  botaoPesquisa.setContentAreaFilled(true);
 				  botaoPesquisa.setOpaque(true);
 				  botaoPesquisa.setBackground(UFT_clarinho);
 			}
 			@Override
 			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				gerenciador.showOpenDialog(null);
				Redimensionamostra();
				fieldPesquisa.setText(gerenciador.getSelectedFile().getName());
				
			}
 			
 		});
    	
 	    botaoSalvar.setFocusPainted(false);
	    botaoSalvar.setContentAreaFilled(true);
	    botaoSalvar.setHorizontalTextPosition(SwingConstants.CENTER);
	    botaoSalvar.setBackground(UFT);
	    botaoSalvar.setForeground(Color.WHITE);
	    botaoSalvar.setFont(new Font("Arial",  Font.ROMAN_BASELINE, 15));
	    botaoSalvar.setMargin(new Insets(0, 0, 0, 0));
	    botaoSalvar.setBorder(null);
	    botaoSalvar.setOpaque(true);
	    botaoSalvar.setBorderPainted(false);
	    botaoSalvar.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				  botaoSalvar.setBackground(UFT);
				  botaoSalvar.setForeground(Color.WHITE);
				  botaoSalvar.setFocusPainted(false);
				  botaoSalvar.setContentAreaFilled(true);
				  botaoSalvar.setOpaque(true);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				  botaoSalvar.setForeground(Color.BLACK);
				  
				  botaoSalvar.setFocusPainted(false);
				  botaoSalvar.setContentAreaFilled(true);
				  botaoSalvar.setOpaque(true);
				  botaoSalvar.setBackground(UFT_clarinho);
				 
			}
			@Override
        	public void mouseClicked(MouseEvent e) {
        		// TODO Auto-generated method stub
        		super.mouseClicked(e);
        	
					Salva();
					telaPricipal.primeiraTela.doClick();
					telaPricipal.principal.adicionaLivros(fieldTitulo.getText(), fieldAutor.getText(), areaDescricao.getText(), "imagens/"+gerenciador.getSelectedFile().getName(), Integer.parseInt(fieldAno.getText()), Integer.parseInt(fieldQuant.getText()));
					fieldTitulo.setText("");
					fieldAutor.setText("");
					areaDescricao.setText("");
					fieldPesquisa.setText("");
					fieldAno.setText("");
					fieldQuant.setText("");
					imagem= new ImageIcon ("");
			    	imagem.setImage(imagem.getImage().getScaledInstance(400, 400, 100));
			    	aux = imagem.getImage();
			        aux.flush();
			        imagem = null;
			        imagens.setIcon(new ImageIcon(aux));
					add(imagens);
					
					JOptionPane.showMessageDialog(null, "Livro cadastrado com sucesso!", "confirmação",1);
        	}
			
		});
        
	    botaoCancelar.setFocusPainted(false);
	    botaoCancelar.setContentAreaFilled(true);
	    botaoCancelar.setHorizontalTextPosition(SwingConstants.CENTER);
	    botaoCancelar.setBackground(UFT);
	    botaoCancelar.setForeground(Color.WHITE);
	    botaoCancelar.setFont(new Font("Arial",  Font.ROMAN_BASELINE, 15));
	    botaoCancelar.setMargin(new Insets(0, 0, 0, 0));
	    botaoCancelar.setBorder(null);
	    botaoCancelar.setOpaque(true);
	    botaoCancelar.setBorderPainted(false);
	    botaoCancelar.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				 botaoCancelar.setBackground(UFT);
				  botaoCancelar.setForeground(Color.WHITE);
				  botaoCancelar.setFocusPainted(false);
				  botaoCancelar.setContentAreaFilled(true);
				  botaoCancelar.setOpaque(true);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				  botaoCancelar.setForeground(Color.BLACK);
				  botaoCancelar.setFocusPainted(false);
				  botaoCancelar.setContentAreaFilled(true);
				  botaoCancelar.setOpaque(true);
				  botaoCancelar.setBackground(UFT_clarinho);
			}
			
			@Override
        	public void mouseClicked(MouseEvent e) {
        		// TODO Auto-generated method stub
        		super.mouseClicked(e);
        		telaPricipal.primeiraTela.doClick();
        		fieldTitulo.setText("");
				fieldAutor.setText("");
				areaDescricao.setText("");
				fieldPesquisa.setText("");
				fieldAno.setText("");
				fieldQuant.setText("");
				imagem= new ImageIcon ("");
		    	imagem.setImage(imagem.getImage().getScaledInstance(400, 400, 100));
		    	aux = imagem.getImage();
		        aux.flush();
		        imagem = null;
		        imagens.setIcon(new ImageIcon(aux));
				add(imagens);
        	}
		});
        
    }
    	
      
    
    public void Redimensionamostra() {
    	
    	imagem= new ImageIcon (gerenciador.getSelectedFile().getAbsolutePath());
    	imagem.setImage(imagem.getImage().getScaledInstance(400, 400, 100));
    	aux = imagem.getImage();
        aux.flush();
        imagem = null;
        imagens.setIcon(new ImageIcon(aux));
		this.add(imagens);
    }
    
   
	private void Salva()  {
	
		
		try {
			Files.copy(Paths.get(gerenciador.getSelectedFile().getAbsolutePath()), Paths.get("imagens/"+gerenciador.getSelectedFile().getName()));
		} catch (IOException e) {
			int i=1;
			String novonome="imagens/"+gerenciador.getSelectedFile().getName().replaceAll(".png", Integer.toString(i)).replaceAll(".png", Integer.toString(i)).replaceAll(".jpg", Integer.toString(i)).replaceAll(".jpeg", Integer.toString(i))+".jpg";
			while(true) {
			if(!(new File(novonome)).exists()){
				break;
			}
			i++;
			novonome="imagens/"+gerenciador.getSelectedFile().getName().replaceAll(".png", Integer.toString(i)).replaceAll(".jpg", Integer.toString(i)).replaceAll(".jpeg", Integer.toString(i))+".jpg";
			}
			try {
				Files.copy(Paths.get(gerenciador.getSelectedFile().getAbsolutePath()), Paths.get(novonome));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}	
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
    
