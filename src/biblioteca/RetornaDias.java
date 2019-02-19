package biblioteca;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RetornaDias {
	private Date data;

	public static long controleDeDias(Date emprestimo, Date devolucao) {
        return(devolucao.getTime() - emprestimo.getTime() + 3600000L) / 86400000L;
    }
    
    public String dataEmprestimo() {
    	data = new Date();
	    SimpleDateFormat formata = new SimpleDateFormat("dd/MM/yyyy");
        String Data = formata.format(data);
        return Data;
    }
    
    public String dataDevolucao() {
    	data = new Date();
	    SimpleDateFormat formata = new SimpleDateFormat("dd/MM/yyyy");
        String Data = formata.format(data);
        return Data;
    }
}
