package biblio_interface;

import biblioteca.*;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class ListaUsuario extends JPanel implements ComponentListener {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Color UFT= new Color(9, 106, 97);
	Color UFT_clarinho=new Color(39,147,138);
	JTable tabela;
    private ModeloTabelaUsuario modelo;
    Map<String, Usuario> usuarios;
    private Image image = new ImageIcon("src/imageIcons/bib.png").getImage();

    public ListaUsuario(TelaPrincipal telaPrincipal) {

        this.addComponentListener(this);
        this.usuarios= telaPrincipal.principal.listaUsuaro();
        
       
        JButton informacoes = new JButton("Detalhes");
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        this.setOpaque(false);

	    this.setForeground(Color.WHITE);
	    this.setFont(new Font("Arial", Font.ROMAN_BASELINE , 15));

	    this.setBorder(null);

        JLabel cabecalho = new JLabel("Lista de Usuarios", JLabel.CENTER);
        cabecalho.setFont(new Font("Arial", Font.BOLD, 28));
        tabela = new JTable();
        modelo = new ModeloTabelaUsuario(usuarios);
        tabela.setModel(modelo);
        tabela.getColumnModel().getColumn(0).setResizable(false);
        tabela.getColumnModel().getColumn(1).setResizable(false);
        tabela.getColumnModel().getColumn(2).setResizable(false);
        tabela.getColumnModel().getColumn(3).setResizable(false);
        tabela.setDragEnabled(false);
        tabela.setRowHeight(40);
        
        tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane b = new JScrollPane(tabela);
        b.setOpaque(false);
        b.setPreferredSize(new Dimension(550, 350));

   
        
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addComponent(cabecalho)
                .addGroup(layout.createSequentialGroup()
                        .addGap(50)
                        .addComponent(b)
                        .addGap(50)
                )
                .addGroup(layout.createSequentialGroup()
                        .addGap(50)
                        .addComponent(informacoes)
                        .addGap(50)
               )
        );
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGap(50)
                .addComponent(cabecalho)
                .addGap(50)
                .addComponent(b)
                .addGap(50)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(informacoes)
                )
                .addGap(50)
        );
        informacoes.addActionListener((ActionEvent ae) -> {
            if (tabela.getSelectedRow() != -1) {
                @SuppressWarnings("unused")
				Usuario usuario= modelo.getLivro(tabela.getSelectedRow());
                
                 new Dados(usuario);
                
              
            }
        });
        informacoes.setFocusPainted(false);
        informacoes.setContentAreaFilled(true);
        informacoes.setHorizontalTextPosition(SwingConstants.CENTER);
        informacoes.setBackground(UFT);
	    informacoes.setForeground(Color.WHITE);
	    informacoes.setFont(new Font("Arial",  Font.ROMAN_BASELINE, 15));
	    informacoes.setMargin(new Insets(0, 0, 0, 0));
	    informacoes.setBorder(null);
	    informacoes.setOpaque(true);
	    informacoes.setBorderPainted(false);
	    informacoes.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				 informacoes.setBackground(UFT);
				  informacoes.setForeground(Color.WHITE);
				  informacoes.setFocusPainted(false);
				  informacoes.setContentAreaFilled(true);
				  informacoes.setOpaque(true);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				  informacoes.setForeground(Color.BLACK);
				  informacoes.setFocusPainted(false);
				  informacoes.setContentAreaFilled(true);
				  informacoes.setOpaque(true);
				  informacoes.setBackground(UFT_clarinho);
			}
			
			@Override
        	public void mouseClicked(MouseEvent e) {
        		// TODO Auto-generated method stub
        		super.mouseClicked(e);
        		
        	}
		});
    }

    @Override
    public void componentResized(ComponentEvent ce) {
    }

    @Override
    public void componentMoved(ComponentEvent ce) {
    }

    @Override
    public void componentShown(ComponentEvent ce) {
    	modelo.setHash(usuarios);
        modelo.fireTableDataChanged();
    }

    @Override
    public void componentHidden(ComponentEvent ce) {
    }
    
    @Override
    public void paintComponent(Graphics g) {
        /*
         * A imagem vai ser desenhada em x=0, y=0 e usando o tamanho real da imagem
         * é fundamental que seja chamado o método drawImage antes de se chamar o
         * método paintComponent da superclasse.
         */
        g.drawImage(image, 0, 0, this);
       
        
        /*
         * Ao desenharmos primeiro a imagem garantimos que qualquer componente
         * que seja adicionado ao painel fique por cima da imagem, criando assim
         * o efeito de imagem de background que pretendemos.
         *
         * Se trocarmos a ordem, os efeitos podem não ser os esperados já que a
         * imagem vai ser desenhada em cima dos componentes que estão neste JPanel.
         * Se não existirem componente então a ordem não é relevante.
         */
        super.paintComponent(g);
    }
    

}
