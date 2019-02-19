
package biblioteca;


public class Bibliotecaria extends Usuario {
	
	Biblioteca biblioteca= new Biblioteca();
	


    public Bibliotecaria(String nome) {
       
    	super(nome);
    }
    
    public void adicionaLivros(String titulo, String autor,String descricao,String caminhoImagem,int ano,int quant) {

				biblioteca.addLivro(titulo, autor, descricao, caminhoImagem, ano, quant);
			
		} 	
    	
    
    public void adicionarUsuario(String nome, String cpf, String dataNasc, String ocupação, String matricula,String caminhoImagem) {
    	
    	Usuario usuario= new Usuario(nome,cpf,dataNasc,ocupação,matricula,caminhoImagem);
    	
       biblioteca.resgistraUsuario(matricula, usuario);
    }
    
    public void emprestarLivro(Usuario usuario, String codigoLivro) {

        biblioteca.catalogo.get(codigoLivro).anexaLivro(usuario);
    }
    
    public void devolverLivro(String codigoLivro) {
       
        biblioteca.catalogo.get(codigoLivro).desanexaLivro();
    	
    }
 
    
   
    
}