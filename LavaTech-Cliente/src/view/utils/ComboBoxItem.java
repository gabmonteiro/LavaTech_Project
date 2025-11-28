package view.utils;

/**
 * Classe genérica para itens de ComboBox
 */
public class ComboBoxItem {
    private int key;
    private String value;
    
    public ComboBoxItem(int key, String value) {
        this.key = key;
        this.value = value;
    }
    
    @Override
    public String toString() {
        return value;
    }
    
    public int getKey() {
        return key;
    }
    
    public String getValue() {
        return value;
    }
    
    public static int getSelectedKey(javax.swing.JComboBox combo) {
        Object obj = combo.getSelectedItem();
        if (obj == null || !(obj instanceof ComboBoxItem)) {
            return -1;
        }
        return ((ComboBoxItem) obj).getKey();
    }
}

