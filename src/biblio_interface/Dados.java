package biblio_interface;

import biblioteca.Livro;
import biblioteca.Usuario;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JDialog;


public class Dados extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public Dados(Usuario usuario) {
		JLabel imagens = new JLabel("");
		String name = usuario.getNome();
		String Cp = usuario.getCpf();
		String mat = usuario.getMatricula();
		String nasc =usuario.getDataNasc();
		String ocupa= usuario.getOcupacao();
		
		this.setBounds(400, 200, 550, 350);
		
		setVisible(true);
		setLayout(null);
		
		JLabel label = new JLabel("Dados do Usuario");
		label.setFont(new Font("Arial", Font.CENTER_BASELINE, 30));
		label.setBounds(150, 5, 300, 37);
		this.add(label);
		
		JLabel labelNome = new JLabel();
		labelNome.setBounds(20, 50, 178, 26);
		labelNome.setText("Nome: "+name);
		this.add(labelNome);
		
		JLabel labelCpf = new JLabel();
		labelCpf.setBounds(20, 90, 149, 20);
		labelCpf.setText("CPF: "+ Cp);
		this.add(labelCpf);
		
		JLabel labelMatricula = new JLabel();
		labelMatricula.setBounds(20, 130, 178, 20);
		labelMatricula.setText("Matricula: "+mat);
		this.add(labelMatricula);
		
		JLabel labelOcupacao = new JLabel("Data de Nascimento: ");
		labelOcupacao.setBounds(20, 210, 196, 26);
		labelOcupacao.setText("Ocupação: "+ocupa);
		this.add(labelOcupacao);
		
		JLabel labelNascimento = new JLabel("Data de Nascimento: ");
		labelNascimento.setBounds(20, 170, 196, 26);
		labelNascimento.setText("Data de Nascimento: "+nasc);
		this.add(labelNascimento);
		
		ImageIcon imagem= new ImageIcon (usuario.getCaminhoImagem());
    	imagem.setImage(imagem.getImage().getScaledInstance(200, 200, 100));
		imagens.setIcon(imagem);
		imagens.setBounds(290, 45, 200, 200);
		this.add(imagens);
		
		
	}
	
	public Dados(Livro livro) {
		JLabel imagens = new JLabel("");
		String titulo = livro.getTitulo();
		String autor = livro.getAutor();
		String cod = livro.getCodigo();
		String usuario =livro.getUsuario();
		
		this.setBounds(400, 200, 550, 350);
		
		setVisible(true);
		setLayout(null);
		
		JLabel label = new JLabel("Dados do Livro");
		label.setFont(new Font("Arial", Font.CENTER_BASELINE, 30));
		label.setBounds(150, 5, 300, 37);
		this.add(label);
		
		JLabel labelNome = new JLabel();
		labelNome.setBounds(20, 50, 178, 26);
		labelNome.setText("Titulo: "+titulo);
		this.add(labelNome);
		
		JLabel labelCpf = new JLabel();
		labelCpf.setBounds(20, 90, 149, 20);
		labelCpf.setText("Autor: "+ autor);
		this.add(labelCpf);
		
		JLabel labelMatricula = new JLabel();
		labelMatricula.setBounds(20, 130, 178, 20);
		labelMatricula.setText("Codigo do livro: "+cod);
		this.add(labelMatricula);
		
		JLabel labelNascimento = new JLabel("Data de Nascimento: ");
		labelNascimento.setBounds(20, 170, 196, 26);
		labelNascimento.setText("Usuario: "+usuario);
		this.add(labelNascimento);
		
		
		ImageIcon imagem= new ImageIcon (livro.getCaminhoImagem());
    	imagem.setImage(imagem.getImage().getScaledInstance(200, 200, 100));
		imagens.setIcon(imagem);
		imagens.setBounds(290, 45, 200, 200);
		this.add(imagens);
		
		
	}
}
