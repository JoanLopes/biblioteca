package biblioteca;


public class Livro {
	private int ano;
	private String titulo,descricao,caminhoImagem;
	private String autor,codigo;
	private Usuario usuario = null;
	
	public Livro(String titulo, String autor,String descricao,String caminhoImagem,int ano,String codigo) {
		this.setTitulo(titulo);
		this.setAutor(autor);
		this.setDescricao(descricao);
        this.setAno(ano);
        this.setCodigo(codigo);
        this.caminhoImagem= caminhoImagem;
        
        System.out.println("livro 1");
	}
	
   public int retorna() {
	   return 1;
   }

	
	public String getUsuario() {
		if(verifica()==true) {
			return "livro disponivel";
		}
		return usuario.getNome();
		
	}
	
	public boolean verifica() {
		
		if(usuario==null) {
			return true;
		}
		return false;
	}

	public boolean anexaLivro(Usuario usuario) {
		if(this.usuario == null) {
			this.usuario = usuario;
			return true;
		}
		return false;
	}
	
	public void desanexaLivro() {
		this.usuario = null;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}



	public String getTitulo() {
		return titulo;
	}



	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}



	public String getAutor() {
		return autor;
	}



	public void setAutor(String autor) {
		this.autor = autor;
	}



	public String getCaminhoImagem() {
		return caminhoImagem;
	}



	public void setCaminhoImagem(String caminhoImagem) {
		this.caminhoImagem = caminhoImagem;
	}



	public String getCodigo() {
		return codigo;
	}



	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
}
