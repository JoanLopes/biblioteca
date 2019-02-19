package biblio_interface;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import com.google.gson.Gson;

import biblioteca.Principal;

public class TelaPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Principal principal= new Principal();
	Color UFT= new Color(9, 106, 97);
	Color UFT_clarinho=new Color(39,147,138);
	
	JPanel painel= new JPanel();
    JButton botaoCadastraLivros= new JButton("Cadastrar Livros");  
    JButton botaoCadastrarUsuarios= new JButton("Cadastrar Usuarios");
    JButton botaoListaLivros= new JButton("Lista Livros");
    JButton botaoListaUsuario= new JButton("Lista Usuarios");
    JButton botaoemprestaLivro= new JButton("Empresta Livros");
    JButton botaoDevolveLivros= new JButton("Devolver Livros");
    JButton botaoLivrosEmprestados= new JButton("Lista Livros Emprestados");
    JButton primeiraTela= new JButton("<- Inicio");

	
    ListaLivros listalivros;
    ListaUsuario listaUsuario;
	CadUsuario cadUsuario;
	CadLivro    cadLivro;
	TelaInicial telaInicial;
	EmprestaLivro emprestaLivro;
	DevolverLivro devolverLivro;
	ListaLivrosEmprestados listaLivrosEmprestados;
	
	
	
	JLabel Brasao = new JLabel(new ImageIcon("src/imageIcons/brasao.png"));
	
	public TelaPrincipal(){
		
		 try {
		       	 
             BufferedReader br = new BufferedReader(new FileReader("arquivo.json"));

            //Converte String JSON para objeto Java
             this.principal = (new Gson()).fromJson(br, Principal.class);
             


          } catch (IOException e1) {
            File novo= new File("arquivo.json");
            if(!novo.exists()) {
            	try {
					novo.createNewFile();
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					System.exit(1);
				}
            }
             }
		 
		listalivros= new ListaLivros(this);
		cadLivro=new CadLivro(this);
		telaInicial= new TelaInicial(this);
		listaUsuario= new ListaUsuario(this);
		cadUsuario= new CadUsuario(this);
		emprestaLivro= new EmprestaLivro(this);
		devolverLivro=new DevolverLivro(this);

    	listaLivrosEmprestados= new ListaLivrosEmprestados();
		
		setLayout(null);
		Container container = getContentPane();
		container.setLayout(null);
		JPanel painelPrincipal= new JPanel();
		CardLayout cardLayout= new CardLayout();
		painelPrincipal.setLayout(cardLayout);
		painelPrincipal.setBounds(201,0 ,1168, 768);
		painelPrincipal.add(telaInicial,"primeira tela");
		painelPrincipal.add(cadLivro,"cadastrar livro");
	    painelPrincipal.add(cadUsuario,"cadastrar usuario");
		painelPrincipal.add(listalivros,"lista livros");
        painelPrincipal.add(cadUsuario,"cadastrar usuario");
        painelPrincipal.add(listaUsuario,"lista usuario");
        painelPrincipal.add(emprestaLivro,"empresta livro");
        painelPrincipal.add(devolverLivro,"devolve livro");
        painelPrincipal.add(listaLivrosEmprestados,"livros emprestados");
        
		setVisible(true);
		setSize(1368, 768);
		setLocationRelativeTo(null);
		setExtendedState(MAXIMIZED_BOTH);
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(primeiraTela);
		primeiraTela.setBounds(0,0,60,15);
		this.add(botaoCadastraLivros);
		botaoCadastraLivros.setBounds(0, 200,200 , 50);
		this.add(botaoCadastrarUsuarios);
		botaoCadastrarUsuarios.setBounds(0, 250,200 , 50);
	    painel.setBounds(0, 0, 200, 768);
	    this.add(botaoListaLivros);
	    botaoListaLivros.setBounds(0,400,200,50);
	    this.add(botaoListaUsuario);
	    botaoListaUsuario.setBounds(0,450,200,50);
	    this.add(botaoemprestaLivro);
	    botaoemprestaLivro.setBounds(0,300,200,50);
	    this.add(botaoDevolveLivros);
	    botaoDevolveLivros.setBounds(0,350,200,50);
	    this.add(botaoLivrosEmprestados);
	    botaoLivrosEmprestados.setBounds(0,500,200,50);
	    
	    this.add(painel);
	 
	    painel.setBackground(UFT);   
	    painel.add(Brasao);
	    
	   
	    Brasao.setSize(200,200);
	    
	    primeiraTela.setFocusPainted(false);
	    primeiraTela.setContentAreaFilled(false);
	    primeiraTela.setHorizontalTextPosition(SwingConstants.CENTER);
	    primeiraTela.setForeground(Color.WHITE);
	    primeiraTela.setFont(new Font("Arial", NORMAL, 15));
	    primeiraTela.setMargin(new Insets(0, 0, 0, 0));
	    primeiraTela.setBorder(null);
	    primeiraTela.setOpaque(false);
	    primeiraTela.setBorderPainted(false);
	    
	 
	    botaoCadastraLivros.setFocusPainted(false);
	    botaoCadastraLivros.setContentAreaFilled(false);
	    botaoCadastraLivros.setHorizontalTextPosition(SwingConstants.CENTER);
	    botaoCadastraLivros.setForeground(Color.WHITE);
	    botaoCadastraLivros.setFont(new Font("Arial", NORMAL, 15));
	    botaoCadastraLivros.setMargin(new Insets(0, 0, 0, 0));
	    botaoCadastraLivros.setBorder(null);
	    botaoCadastraLivros.setOpaque(false);
	    botaoCadastraLivros.setBorderPainted(false);
	    
	 
	    botaoCadastraLivros.addMouseListener(new MouseAdapter()  {
			
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				botaoCadastraLivros.setForeground(Color.WHITE);
				botaoCadastraLivros.setFocusPainted(false);
				  botaoCadastraLivros.setContentAreaFilled(false);
				  botaoCadastraLivros.setOpaque(false);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				  botaoCadastraLivros.setForeground(Color.BLACK);
				  botaoCadastraLivros.setFocusPainted(false);
				  botaoCadastraLivros.setContentAreaFilled(true);
				  botaoCadastraLivros.setOpaque(true);
				  botaoCadastraLivros.setBackground(UFT_clarinho);
			}
			
		});
	    botaoCadastrarUsuarios.setFocusPainted(false);
	    botaoCadastrarUsuarios.setContentAreaFilled(false);
	    botaoCadastrarUsuarios.setHorizontalTextPosition(SwingConstants.CENTER);
	    botaoCadastrarUsuarios.setForeground(Color.WHITE);
	    botaoCadastrarUsuarios.setFont(new Font("Arial", NORMAL, 15));
	    botaoCadastrarUsuarios.setMargin(new Insets(0, 0, 0, 0));
	    botaoCadastrarUsuarios.setBorder(null);
	    botaoCadastrarUsuarios.setOpaque(false);
	    botaoCadastrarUsuarios.setBorderPainted(false);
	    botaoCadastrarUsuarios.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				  botaoCadastrarUsuarios.setForeground(Color.WHITE);
				  botaoCadastrarUsuarios.setFocusPainted(false);
				  botaoCadastrarUsuarios.setContentAreaFilled(false);
				  botaoCadastrarUsuarios.setOpaque(false);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				  botaoCadastrarUsuarios.setForeground(Color.BLACK);
				  botaoCadastrarUsuarios.setFocusPainted(false);
				  botaoCadastrarUsuarios.setContentAreaFilled(true);
				  botaoCadastrarUsuarios.setOpaque(true);
				  botaoCadastrarUsuarios.setBackground(UFT_clarinho);
			}
			
			
		});
	    botaoListaLivros.setFocusPainted(false);
	    botaoListaLivros.setContentAreaFilled(false);
	    botaoListaLivros.setHorizontalTextPosition(SwingConstants.CENTER);
	    botaoListaLivros.setForeground(Color.WHITE);
	    botaoListaLivros.setFont(new Font("Arial", NORMAL, 15));
	    botaoListaLivros.setMargin(new Insets(0, 0, 0, 0));
	    botaoListaLivros.setBorder(null);
	    botaoListaLivros.setOpaque(false);
	    botaoListaLivros.setBorderPainted(false);
	    botaoListaLivros.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				  botaoListaLivros.setForeground(Color.WHITE);
				  botaoListaLivros.setFocusPainted(false);
				  botaoListaLivros.setContentAreaFilled(false);
				  botaoListaLivros.setOpaque(false);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				  botaoListaLivros.setForeground(Color.BLACK);
				  botaoListaLivros.setFocusPainted(false);
				  botaoListaLivros.setContentAreaFilled(true);
				  botaoListaLivros.setOpaque(true);
				  botaoListaLivros.setBackground(UFT_clarinho);
			}
			
			
		});
	    
	    botaoListaUsuario.setFocusPainted(false);
	    botaoListaUsuario.setContentAreaFilled(false);
	    botaoListaUsuario.setHorizontalTextPosition(SwingConstants.CENTER);
	    botaoListaUsuario.setForeground(Color.WHITE);
	    botaoListaUsuario.setFont(new Font("Arial", NORMAL, 15));
	    botaoListaUsuario.setMargin(new Insets(0, 0, 0, 0));
	    botaoListaUsuario.setBorder(null);
	    botaoListaUsuario.setOpaque(false);
	    botaoListaUsuario.setBorderPainted(false);
	    botaoListaUsuario.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				  botaoListaUsuario.setForeground(Color.WHITE);
				  botaoListaUsuario.setFocusPainted(false);
				  botaoListaUsuario.setContentAreaFilled(false);
				  botaoListaUsuario.setOpaque(false);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				  botaoListaUsuario.setForeground(Color.BLACK);
				  botaoListaUsuario.setFocusPainted(false);
				  botaoListaUsuario.setContentAreaFilled(true);
				  botaoListaUsuario.setOpaque(true);
				  botaoListaUsuario.setBackground(UFT_clarinho);
			}
			
			
		});
	    
	    botaoemprestaLivro.setFocusPainted(false);
	    botaoemprestaLivro.setContentAreaFilled(false);
	    botaoemprestaLivro.setHorizontalTextPosition(SwingConstants.CENTER);
	    botaoemprestaLivro.setForeground(Color.WHITE);
	    botaoemprestaLivro.setFont(new Font("Arial", NORMAL, 15));
	    botaoemprestaLivro.setMargin(new Insets(0, 0, 0, 0));
	    botaoemprestaLivro.setBorder(null);
	    botaoemprestaLivro.setOpaque(false);
	    botaoemprestaLivro.setBorderPainted(false);
	    botaoemprestaLivro.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				botaoemprestaLivro.setForeground(Color.WHITE);
				botaoemprestaLivro.setFocusPainted(false);
				botaoemprestaLivro.setContentAreaFilled(false);
				botaoemprestaLivro.setOpaque(false);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				botaoemprestaLivro.setForeground(Color.BLACK);
				botaoemprestaLivro.setFocusPainted(false);
				botaoemprestaLivro.setContentAreaFilled(true);
				botaoemprestaLivro.setOpaque(true);
				botaoemprestaLivro.setBackground(UFT_clarinho);
			}
			
			
		});
	    
	    botaoDevolveLivros.setFocusPainted(false);
	    botaoDevolveLivros.setContentAreaFilled(false);
	    botaoDevolveLivros.setHorizontalTextPosition(SwingConstants.CENTER);
	    botaoDevolveLivros.setForeground(Color.WHITE);
	    botaoDevolveLivros.setFont(new Font("Arial", NORMAL, 15));
	    botaoDevolveLivros.setMargin(new Insets(0, 0, 0, 0));
	    botaoDevolveLivros.setBorder(null);
	    botaoDevolveLivros.setOpaque(false);
	    botaoDevolveLivros.setBorderPainted(false);
	    botaoDevolveLivros.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				botaoDevolveLivros.setForeground(Color.WHITE);
				botaoDevolveLivros.setFocusPainted(false);
				botaoDevolveLivros.setContentAreaFilled(false);
				botaoDevolveLivros.setOpaque(false);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				botaoDevolveLivros.setForeground(Color.BLACK);
				botaoDevolveLivros.setFocusPainted(false);
				botaoDevolveLivros.setContentAreaFilled(true);
				botaoDevolveLivros.setOpaque(true);
				botaoDevolveLivros.setBackground(UFT_clarinho);
			}
			
			
		});
	    
	    botaoLivrosEmprestados.setFocusPainted(false);
	    botaoLivrosEmprestados.setContentAreaFilled(false);
	    botaoLivrosEmprestados.setHorizontalTextPosition(SwingConstants.CENTER);
	    botaoLivrosEmprestados.setForeground(Color.WHITE);
	    botaoLivrosEmprestados.setFont(new Font("Arial", NORMAL, 15));
	    botaoLivrosEmprestados.setMargin(new Insets(0, 0, 0, 0));
	    botaoLivrosEmprestados.setBorder(null);
	    botaoLivrosEmprestados.setOpaque(false);
	    botaoLivrosEmprestados.setBorderPainted(false);
	    botaoLivrosEmprestados.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				botaoLivrosEmprestados.setForeground(Color.WHITE);
				botaoLivrosEmprestados.setFocusPainted(false);
				botaoLivrosEmprestados.setContentAreaFilled(false);
				botaoLivrosEmprestados.setOpaque(false);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				botaoLivrosEmprestados.setForeground(Color.BLACK);
				botaoLivrosEmprestados.setFocusPainted(false);
				botaoLivrosEmprestados.setContentAreaFilled(true);
				botaoLivrosEmprestados.setOpaque(true);
				botaoLivrosEmprestados.setBackground(UFT_clarinho);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseClicked(e);
				 iniciar();
			}
			
			
		});
	  
	    
	    primeiraTela.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {					
				cardLayout.show(painelPrincipal, "primeira tela");
				
				
			}
	    }
			);
	    botaoCadastraLivros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {					
				cardLayout.show(painelPrincipal, "cadastrar livro");
				
				
			}
	    }
			);
	    botaoCadastrarUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {					
				cardLayout.show(painelPrincipal, "cadastrar usuario");
				
			}
	    }
			);
	    botaoListaLivros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				cardLayout.show(painelPrincipal, "lista livros");
				
			}
	    }
			);
	    botaoListaUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				cardLayout.show(painelPrincipal, "lista usuario");
				
			}
	    }
			);
	    botaoemprestaLivro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				cardLayout.show(painelPrincipal, "empresta livro");
				
			}
	    }
			);
	    botaoDevolveLivros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				cardLayout.show(painelPrincipal, "devolve livro");
				
			}
	    }
			);
	    botaoLivrosEmprestados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				
				cardLayout.show(painelPrincipal, "livros emprestados");
				
			}
	    }
			);
	    
	    container.add(painelPrincipal);

	   
	    this.pack();
	}
	  
    public void iniciar(){
    	listaLivrosEmprestados.listaLivrosEmprestados(this);
    }
	public void click() {
		
		this.botaoCadastrarUsuarios.doClick();
	}
	
	public static void main(String[] args) {
   	 
	    Gson gson = new Gson();
	    TelaPrincipal telaPrincipal= new TelaPrincipal();
	    telaPrincipal.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub

	  		   
			}

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				String json = gson.toJson(telaPrincipal.principal);
				  System.out.println("aki");
				
				  
				 try {
				        //Escreve Json convertido em arquivo chamado "file.json"
				        FileWriter salvar = new FileWriter("arquivo.json");
				        salvar.write(json);
				        salvar.close();
				       
				  
				    } catch (IOException e2) {
				        e2.printStackTrace();
				    }
				
			}

			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				System.out.println("fechou");
				 
			}

			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
			

			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
		});	    


	    }

}

	
