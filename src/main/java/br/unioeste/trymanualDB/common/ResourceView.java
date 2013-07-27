package br.unioeste.trymanualDB.common;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ResourceView {

	public static JLabel getLabel(String label,Component txt){
        JLabel t = new JLabel(label);
        t.setLabelFor(txt);
        t.setHorizontalAlignment(JLabel.RIGHT);
        return t;
    }
	
	public static JButton getButton(String label,int key){
        JButton t = new JButton(label);
        t.setMnemonic(key);
        return t;
    }
    
    public static void setComponentToPanel(JPanel p,Component cp){
    	p.add(cp);
    }
    
    public static void addComponent(JFrame frame,String layoutPos,Component board){
        frame.add(board, layoutPos);
        frame.invalidate(); //remove layout atual com os componentes
        frame.validate(); //repõe layout com os componentes e os novos componentes
    }
    
    public static void removeComponent(JFrame frame,Component board){
        frame.remove(board);       
        frame.repaint();
    }
    
}
