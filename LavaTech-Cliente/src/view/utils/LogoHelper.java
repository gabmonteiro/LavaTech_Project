package view.utils;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class LogoHelper {
    
    /**
     * Cria um JLabel com a logo LavaTech redimensionada
     * @param width largura desejada
     * @param height altura desejada
     * @return JLabel com a logo ou null se não conseguir carregar
     */
    public static JLabel createLogoLabel(int width, int height) {
        try {
            java.net.URL logoUrl = LogoHelper.class.getResource("/view/imagens/logo_lavatech.png");
            if (logoUrl != null) {
                ImageIcon logoIcon = new ImageIcon(logoUrl);
                java.awt.Image img = logoIcon.getImage().getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
                JLabel logoLabel = new JLabel(new ImageIcon(img));
                return logoLabel;
            }
        } catch (Exception e) {
            System.err.println("Erro ao carregar logo: " + e.getMessage());
        }
        return null;
    }
}

