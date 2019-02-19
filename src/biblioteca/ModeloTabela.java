package biblioteca;

import java.util.ArrayList;
import java.util.Map;
import javax.swing.table.AbstractTableModel;

public class ModeloTabela extends AbstractTableModel {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Livro> livros;

    public ModeloTabela(Map<String, Livro> livros) {
        this.livros = new ArrayList<>(livros.values());
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public int getRowCount() {
        return livros.size();
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 1:
                return "TITULO";
            case 2:
                return "AUTOR";
            case 3:
                return "ANO";
            case 0:
                return "CODIGO";
        }
        return null;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Livro registro = livros.get(rowIndex);
        switch (columnIndex) {
            case 1:
                return registro.getTitulo();
            case 2:
                return registro.getAutor();
            case 3:
                return registro.getAno();
            case 0:
                return registro.getCodigo();
            default:
                return null;
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    public Livro getLivro(int i) {
        return livros.get(i);
    }
    
    public void setHash(Map<String, Livro> livros) {
        this.livros = new ArrayList<>(livros.values());
    }
}
