package biblioteca;

import java.util.ArrayList;
import java.util.Map;
import javax.swing.table.AbstractTableModel;

public class ModeloTabelaUsuario extends AbstractTableModel {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Usuario> usuario;

    public ModeloTabelaUsuario(Map<String, Usuario> usuario) {
        this.usuario = new ArrayList<>(usuario.values());
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public int getRowCount() {
        return usuario.size();
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 1:
                return "NOME";
            case 2:
                return "MATRICULA";
            case 3:
                return "CPF";
            case 0:
                return "CODIGO";
        }
        return null;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Usuario registro = usuario.get(rowIndex);
        switch (columnIndex) {
            case 1:
                return registro.getNome();
            case 2:
                return registro.getMatricula();
            case 3:
                return registro.getCpf();
            case 0:
                return registro.getOcupacao();
            default:
                return null;
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    public Usuario getLivro(int i) {
        return usuario.get(i);
    }
    
    public void setHash(Map<String, Usuario> usuario) {
        this.usuario = new ArrayList<>(usuario.values());
    }
}
