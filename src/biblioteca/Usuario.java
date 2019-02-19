package biblioteca;


import java.util.ArrayList;

public class Usuario {
	protected String nome,cpf,dataNasc,ocupacao,matricula,caminhoImagem;
	protected int cont = 0;
	ArrayList<Livro> listaLivro = new ArrayList<Livro>();
	
	
	
	public Usuario(String nome, String cpf, String dataNasc, String ocupacao, String matricula,String caminhoImagem) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.dataNasc = dataNasc;
		this.ocupacao = ocupacao;
		this.matricula = matricula;
		this.caminhoImagem=caminhoImagem;
		
		System.out.println("1 usuario");
	
	}
	public int quantLivros() {
		return listaLivro.size();
	}
	public String getCaminhoImagem() {
		return caminhoImagem;
	}
	public void setCaminhoImagem(String caminhoImagem) {
		this.caminhoImagem = caminhoImagem;
	}
	public Usuario(String nome) {
		
		this.nome=nome;
	}

	
	
	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getCpf() {
		return cpf;
	}



	public void setCpf(String cpf) {
		this.cpf = cpf;
	}



	public String getDataNasc() {
		return dataNasc;
	}



	public void setDataNasc(String dataNasc) {
		this.dataNasc = dataNasc;
	}



	public String getOcupacao() {
		return ocupacao;
	}



	public void setAcupação(String ocupacao) {
		this.ocupacao = ocupacao;
	}



	public String getMatricula() {
		return matricula;
	}



	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}



	public void anexaLista(Livro livro, Usuario usuario) {
		if(livro.anexaLivro(usuario) == true) {
			
			if(cont < 3) {
				livro.anexaLivro(usuario);
				listaLivro.add(livro);
				cont++;
			}
		}
	}
	
	public void desanexaLista(Livro livro) {
		for(int i = 0; i < listaLivro.size(); i++) {
			if(listaLivro.get(i).equals(livro)) {
				listaLivro.remove(i);
				livro.desanexaLivro();
			}
		}
	}
}
