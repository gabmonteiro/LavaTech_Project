/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.utils;

import java.util.ArrayList;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import modelDominio.Usuario;

/**
 *
 * @author aluno
 */
public class ComboBoxUsuario {
    private String value;
    private int key;
    
    public ComboBoxUsuario(int key, String value) {
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
    
    public static int getSelectedIndex(JComboBox combo) {
        Object obj = combo.getSelectedItem();
        if(obj == null) {
            return -1;
        } else {
            return ((ComboBoxUsuario) obj).getKey();
        }
    }
    
    public static void preencheComboBoxUsuario(int SelCOdigo, JComboBox combo, ArrayList<Usuario> lista, boolean addTodos) {
        Vector vlista = new Vector();
        int x = 0;
        int selecionarCodigo = -1;
        
        if(addTodos) {
            vlista.add(new ComboBoxUsuario(0, "Todas"));
        }
        
        for(Usuario c: lista) {
            ComboBoxUsuario cmb = new ComboBoxUsuario(c.getCodUsuario(),c.getNome());
            vlista.add(cmb);
            if(cmb.getKey() == SelCOdigo) {
                selecionarCodigo = x;
            }
            x++;
        }
        
        DefaultComboBoxModel modeloCliente = new DefaultComboBoxModel(vlista);
        combo.setModel(modeloCliente);
        if(selecionarCodigo >= 0) {
            combo.setSelectedIndex(selecionarCodigo);
        }
    }
}
