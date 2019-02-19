package biblioteca;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

import br.com.conexaoBD.Conexao;

public class Principal{
	
	private transient String nomeBib="biblioteca UFT";

	Map<String,Bibliotecaria> admBiblioteca= new HashMap<>();
	
	
	public Principal() {
		
		Bibliotecaria admBib= new Bibliotecaria("biblioteca UFT");
		//admBiblioteca.put(nomeBib,admBib);
		Conexao conexao = new Conexao();
		conexao.getConnection();
		JOptionPane.showInputDialog("Boulos");
		
	}
	
    public void adicionaLivros(String titulo, String autor,String descricao,String caminhoImagem,int ano,int quant) {
    	
    
    	
    	this.admBiblioteca.get(nomeBib).adicionaLivros(titulo, autor, descricao, caminhoImagem, ano, quant);
    	this.admBiblioteca.get(nomeBib).biblioteca.exibeLivrosDisponiveis();
    	System.out.println(descricao+caminhoImagem+quant);
    	
    }
    
    public void adicionarUsuario(String nome, String cpf, String dataNasc, String ocupacao, String matricula,String caminhoImagem) {
    	
    
    	this.admBiblioteca.get(nomeBib).adicionarUsuario(nome, cpf, dataNasc, ocupacao, matricula,caminhoImagem);
    	
    }
    
    public Map<String, Livro>  listaLivro(){
    	
    	return  this.admBiblioteca.get(nomeBib).biblioteca.catalogo;
    	
    }
    
    public Map<String, Usuario>  listaUsuaro(){
    	
    	return  this.admBiblioteca.get(nomeBib).biblioteca.listaUsuarios;
    	
    }
    
    public void emprestaLivro(Usuario usuario,String codigoLivro) {
    	
    	this.admBiblioteca.get(nomeBib).emprestarLivro(usuario, codigoLivro);
    }
    
    public void devolveLivro(String codigoLivro) {
    	
    	this.admBiblioteca.get(nomeBib).devolverLivro(codigoLivro);
    }
   
    public Map<String, Livro>  listaLivrosEmprestados(){
    	
    	return  this.admBiblioteca.get(nomeBib).biblioteca.exibeLivrosIndisponiveis();
    	
    }
    
    
  
}
		 



	
