package view.utils;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * Classe utilitária para estilização consistente do sistema
 */
public class UIStyle {
    
    // Cores do sistema
    public static final Color PRIMARY_COLOR = new Color(41, 128, 185);      // Azul moderno
    public static final Color PRIMARY_DARK = new Color(31, 97, 141);        // Azul escuro
    public static final Color PRIMARY_LIGHT = new Color(52, 152, 219);      // Azul claro
    public static final Color SUCCESS_COLOR = new Color(39, 174, 96);       // Verde
    public static final Color DANGER_COLOR = new Color(231, 76, 60);        // Vermelho
    public static final Color WARNING_COLOR = new Color(241, 196, 15);      // Amarelo
    public static final Color BACKGROUND_COLOR = new Color(245, 246, 250);  // Cinza claro
    public static final Color CARD_COLOR = Color.WHITE;                     // Branco
    public static final Color TEXT_PRIMARY = new Color(44, 62, 80);         // Cinza escuro
    public static final Color TEXT_SECONDARY = new Color(127, 140, 141);    // Cinza médio
    public static final Color BORDER_COLOR = new Color(189, 195, 199);      // Cinza claro
    
    // Fontes
    public static final Font FONT_TITLE = new Font("Segoe UI", Font.BOLD, 24);
    public static final Font FONT_SUBTITLE = new Font("Segoe UI", Font.BOLD, 18);
    public static final Font FONT_LABEL = new Font("Segoe UI", Font.PLAIN, 14);
    public static final Font FONT_BUTTON = new Font("Segoe UI", Font.BOLD, 14);
    public static final Font FONT_INPUT = new Font("Segoe UI", Font.PLAIN, 14);
    
    /**
     * Estiliza um botão primário
     */
    public static void stylePrimaryButton(JButton button) {
        button.setBackground(PRIMARY_COLOR);
        button.setForeground(Color.WHITE);
        button.setFont(FONT_BUTTON);
        button.setBorder(new EmptyBorder(12, 24, 12, 24));
        button.setFocusPainted(false);
        button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        button.setOpaque(true);
        button.setBorderPainted(false);
        
        // Efeito hover
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(PRIMARY_DARK);
            }
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(PRIMARY_COLOR);
            }
        });
    }
    
    /**
     * Estiliza um botão secundário
     */
    public static void styleSecondaryButton(JButton button) {
        button.setBackground(CARD_COLOR);
        button.setForeground(TEXT_PRIMARY);
        button.setFont(FONT_BUTTON);
        button.setBorder(new javax.swing.border.CompoundBorder(
            new LineBorder(BORDER_COLOR, 1, true),
            new EmptyBorder(12, 24, 12, 24)
        ));
        button.setFocusPainted(false);
        button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        button.setOpaque(true);
        button.setBorderPainted(true);
        
        // Efeito hover
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(BACKGROUND_COLOR);
            }
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(CARD_COLOR);
            }
        });
    }
    
    /**
     * Estiliza um botão de perigo (excluir)
     */
    public static void styleDangerButton(JButton button) {
        button.setBackground(DANGER_COLOR);
        button.setForeground(Color.WHITE);
        button.setFont(FONT_BUTTON);
        button.setBorder(new EmptyBorder(12, 24, 12, 24));
        button.setFocusPainted(false);
        button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        button.setOpaque(true);
        button.setBorderPainted(false);
        
        // Efeito hover
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(192, 57, 43));
            }
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(DANGER_COLOR);
            }
        });
    }
    
    /**
     * Estiliza um botão de sucesso
     */
    public static void styleSuccessButton(JButton button) {
        button.setBackground(SUCCESS_COLOR);
        button.setForeground(Color.WHITE);
        button.setFont(FONT_BUTTON);
        button.setBorder(new EmptyBorder(12, 24, 12, 24));
        button.setFocusPainted(false);
        button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        button.setOpaque(true);
        button.setBorderPainted(false);
        
        // Efeito hover
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(33, 150, 83));
            }
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(SUCCESS_COLOR);
            }
        });
    }
    
    /**
     * Estiliza um label
     */
    public static void styleLabel(JLabel label) {
        label.setFont(FONT_LABEL);
        label.setForeground(TEXT_PRIMARY);
    }
    
    /**
     * Estiliza um campo de texto
     */
    public static void styleTextField(JTextField field) {
        field.setFont(FONT_INPUT);
        field.setBorder(new LineBorder(BORDER_COLOR, 1, true));
        field.setBackground(CARD_COLOR);
        field.setForeground(TEXT_PRIMARY);
        field.setBorder(new javax.swing.border.CompoundBorder(
            new LineBorder(BORDER_COLOR, 1, true),
            new EmptyBorder(8, 12, 8, 12)
        ));
    }
    
    /**
     * Estiliza um campo de senha
     */
    public static void stylePasswordField(JPasswordField field) {
        field.setFont(FONT_INPUT);
        field.setBorder(new LineBorder(BORDER_COLOR, 1, true));
        field.setBackground(CARD_COLOR);
        field.setForeground(TEXT_PRIMARY);
        field.setBorder(new javax.swing.border.CompoundBorder(
            new LineBorder(BORDER_COLOR, 1, true),
            new EmptyBorder(8, 12, 8, 12)
        ));
    }
    
    /**
     * Estiliza um ComboBox
     */
    public static void styleComboBox(JComboBox<?> combo) {
        combo.setFont(FONT_INPUT);
        combo.setBackground(CARD_COLOR);
        combo.setForeground(TEXT_PRIMARY);
        combo.setBorder(new LineBorder(BORDER_COLOR, 1, true));
    }
    
    /**
     * Estiliza uma tabela
     */
    public static void styleTable(JTable table) {
        table.setFont(FONT_INPUT);
        table.setRowHeight(35);
        table.setSelectionBackground(PRIMARY_LIGHT);
        table.setSelectionForeground(Color.WHITE);
        table.setGridColor(BORDER_COLOR);
        table.setShowGrid(true);
        table.setIntercellSpacing(new java.awt.Dimension(0, 0));
        
        // Estilizar cabeçalho
        table.getTableHeader().setFont(FONT_BUTTON);
        table.getTableHeader().setBackground(PRIMARY_COLOR);
        table.getTableHeader().setForeground(Color.WHITE);
        table.getTableHeader().setReorderingAllowed(false);
        ((DefaultTableCellRenderer) table.getTableHeader().getDefaultRenderer())
            .setHorizontalAlignment(JLabel.CENTER);
        
        // Centralizar células
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }
    
    /**
     * Define o background padrão do frame
     */
    public static void setFrameBackground(javax.swing.JFrame frame) {
        frame.getContentPane().setBackground(BACKGROUND_COLOR);
    }
    
    /**
     * Define o background padrão do painel
     */
    public static void setPanelBackground(javax.swing.JPanel panel) {
        panel.setBackground(BACKGROUND_COLOR);
    }
}

