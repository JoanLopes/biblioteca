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
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;


public class CadUsuario extends JPanel {
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Color UFT= new Color(9, 106, 97);
	Color UFT_clarinho=new Color(39,147,138);
	Font negrito= new Font("Arial",Font.ROMAN_BASELINE , 18);
	Font negri= new Font("Arial",Font.BOLD , 30);
	JFileChooser gerenciador= new JFileChooser();
    JLabel nomeCompleto= new JLabel("Nome:");
    JLabel cpf= new JLabel("CPF:");
    JLabel dataNasc= new JLabel("Data de Nascimento:");
    JLabel ocupacao= new JLabel("Ocupação:");
    JLabel matricula= new JLabel("Nº da matricula:");
    JLabel pesquisaImagem= new JLabel("adicione uma imagem:");
    JLabel tituloTela= new JLabel("Cadastro de Usuario");
    JButton botaoPesquisa= new JButton("Pesquisar");
    JButton botaoSalvar= new JButton("Salvar");
    JButton botaoCancelar= new JButton("Cancelar");
    JLabel imagens= new JLabel("");
    ImageIcon imagem;
    Image aux;
    
    ButtonGroup grupoBotao= new ButtonGroup();
    JRadioButton aluno= new JRadioButton("aluno", true);
    JRadioButton professor=new JRadioButton("professor",false);
    JTextField fieldNome= new JTextField(70);
    JFormattedTextField fieldCPF= new JFormattedTextField(Mascara("###.###.###-##"));
    JFormattedTextField fieldNasc= new JFormattedTextField(Mascara("##/##/####"));
    JTextField fieldMatricula= new JTextField(20);
    JTextField fieldPesquisa= new JTextField(70);
    JPanel label;

    TelaPrincipal telaPricipal;
    
	 
   private Image image = new ImageIcon("src/imageIcons/bib.png").getImage();
   
     public CadUsuario(TelaPrincipal telaprincipal) {
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
        nomeCompleto.setBounds(80,100,80,30);
        nomeCompleto.setFont(negrito);
        this.add(nomeCompleto);
        fieldNome.setBounds(160, 100, 400, 30);
        fieldNome.setFont(negrito);
        fieldNome.addKeyListener(new java.awt.event.KeyAdapter() {
			 public void keyTyped(java.awt.event.KeyEvent e) {
			                
			     if (fieldNome.getText().length() <= 39) {
			                      //deixe passar
			     } else {
			         e.setKeyChar((char) KeyEvent.VK_CLEAR);
			     }
			 }
			 
			 });
        this.add(fieldNome);
        cpf.setBounds(80,165,80,30);
        cpf.setFont(negrito);
        this.add(cpf);
        fieldCPF.setBounds(160, 165, 400, 30);
        fieldCPF.setFont(negrito);
        this.add(fieldCPF);
        dataNasc.setBounds(80,230,170,30);
        dataNasc.setFont(negrito);
        this.add(dataNasc);
        fieldNasc.setBounds(250, 230, 130, 30);
        fieldNasc.setFont(negrito);
        this.add(fieldNasc);
        matricula.setBounds(80,290,150,30);
        matricula.setFont(negrito);
        this.add(matricula);
        fieldMatricula.setBounds(250, 290, 130, 30);
        fieldMatricula.setFont(negrito);
        fieldMatricula.addKeyListener(new java.awt.event.KeyAdapter() {
			 public void keyTyped(java.awt.event.KeyEvent e) {
			                
			     if (fieldMatricula.getText().length() <= 9) {
			                      //deixe passar
			     } else {
			         e.setKeyChar((char) KeyEvent.VK_CLEAR);
			     }
			 }
			 
			 });
        this.add(fieldMatricula);
        ocupacao.setBounds(80, 345, 100, 20);
        ocupacao.setFont(negrito);
        this.add(ocupacao);
        
        grupoBotao.add(aluno);
        grupoBotao.add(professor);
        aluno.setBounds(180, 350, 200, 30);
        aluno.setFont(new Font("Arial", Font.BOLD, 15));
        aluno.setFocusPainted(false);
        aluno.setContentAreaFilled(false);
        aluno.setMargin(new Insets(0, 0, 0, 0));
        aluno.setBorder(null);
        aluno.setOpaque(false);
        aluno.setBorderPainted(false);
        this.add(aluno);
        professor.setBounds(180, 370, 200, 30);
        professor.setFont(new Font("Arial", Font.BOLD, 15));
        professor.setFocusPainted(false);
        professor.setContentAreaFilled(false);
        professor.setMargin(new Insets(0, 0, 0, 0));
        professor.setBorder(null);
        professor.setOpaque(false);
        this.add(professor);
        
        pesquisaImagem.setBounds(80,460,180,30);
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
					Salva();
					if(aluno.isSelected()) {
						telaPricipal.principal.adicionarUsuario(fieldNome.getText(), fieldCPF.getText(), fieldNasc.getText(),"aluno" , fieldMatricula.getText(), "imagens/"+gerenciador.getSelectedFile().getName());
					}else {
						telaPricipal.principal.adicionarUsuario(fieldNome.getText(), fieldCPF.getText(), fieldNasc.getText(),"professor" , fieldMatricula.getText(), "imagens/"+gerenciador.getSelectedFile().getName());
						
					}
					fieldNome.setText("");
					fieldCPF.setText("");
					fieldNasc.setText("");
					fieldMatricula.setText("");
					fieldPesquisa.setText("");
					imagem= new ImageIcon ("");
			    	imagem.setImage(imagem.getImage().getScaledInstance(400, 400, 100));
			    	aux = imagem.getImage();
			        aux.flush();
			        imagem = null;
			        imagens.setIcon(new ImageIcon(aux));
					add(imagens);
					JOptionPane.showMessageDialog(null, "Usuario cadastrado com sucesso!", "confirmação",1);
		        	
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
        		fieldNome.setText("");
				fieldCPF.setText("");
				fieldPesquisa.setText("");
				fieldNasc.setText("");
				fieldMatricula.setText("");
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
    
    public MaskFormatter Mascara(String Mascara){
        MaskFormatter F_Mascara = new MaskFormatter();
        try{
            F_Mascara.setMask(Mascara); //Atribui a mascara
            F_Mascara.setPlaceholderCharacter(' '); //Caracter para preencimento 
        }
        catch (Exception excecao) {
        excecao.printStackTrace();
        } 
        return F_Mascara;
 }
  
    
    public void Redimensionamostra() {
    	
    	imagem= new ImageIcon (gerenciador.getSelectedFile().getAbsolutePath());
    	imagem.setImage(imagem.getImage().getScaledInstance(200,200, 100));
    	aux = imagem.getImage();
        aux.flush();
        imagem = null;
        imagens.setIcon(new ImageIcon(aux));
		this.add(imagens);
    }
    
   
	private void Salva() {
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
    

