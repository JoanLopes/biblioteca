
package biblioteca;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;




public class Biblioteca{
	 int num;
	 String cod= "Livro";
	 ArrayList<String> codLivro = new ArrayList<>();
	 Map<String,Livro> catalogo= new HashMap<>();
	 Map<String,Usuario> listaUsuarios= new HashMap<>();
	 
	 ModeloTabela tabela;

      public Biblioteca(){
      
         }
   
       public void  addLivro(String titulo, String autor,String descricao,String caminhoImagem,int ano,int quant) {
    	   num=codLivro.size();
    	   
    	   for(int i=0;i<quant;i++) {
    	   num++;
    	   String cod= "Livro";
    	   cod+= String.valueOf(num);
    	   codLivro.add(cod);
    	   Livro novoLivro= new Livro(titulo, autor, descricao, caminhoImagem, ano, cod);
    	   catalogo.put(cod, novoLivro);
    	  
    	  
    	   System.out.println(cod);
    	   }
    	   
       }
       public void resgistraUsuario(String codigoUsuario,Usuario usuario) {
    	   
    	   listaUsuarios.put(codigoUsuario, usuario);
       
       }
      
       public void exibeLivrosDisponiveis() {
    	   
    	  for(Map.Entry<String,Livro> exibir:  catalogo.entrySet()) {
    		  
    		  if(exibir.getValue().verifica()==true) {
    			  System.out.println("codUnico: "+exibir.getKey()+" Titulo: "+exibir.getValue().getTitulo()+" Autor: "+exibir.getValue().getAutor());
    		  }
       }
       }
       
       public  Map<String,Livro> exibeLivrosIndisponiveis() {
    	   
    	   Map<String,Livro> LivrosEmprestados= new HashMap<>();
    	   
    	   for(Map.Entry<String,Livro> exibir:  catalogo.entrySet()) {
     		  
     		  if(exibir.getValue().verifica()==false) {
     			  
     			  System.out.println(exibir.getValue());
     			  LivrosEmprestados.put(exibir.getKey(),exibir.getValue());
     			 
     		  }
        }
    	   return LivrosEmprestados;
        }   
     
    }