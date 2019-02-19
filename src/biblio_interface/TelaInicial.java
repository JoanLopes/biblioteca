package biblio_interface;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class TelaInicial extends JPanel {
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    Image image = new ImageIcon("src/imageIcons/bib.png").getImage();
    TelaPrincipal telaPrincipal;
   
     public TelaInicial(TelaPrincipal telaprincipal) {
		// TODO Auto-generated constructor stub
    	 this.telaPrincipal= telaprincipal;
    	 
    	 setLayout(null);
    	 this.setSize(1168, 768);
         this.setOpaque(false);
         setPreferredSize(new Dimension(getWidth(), getHeight()));
        
       
         
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
    

