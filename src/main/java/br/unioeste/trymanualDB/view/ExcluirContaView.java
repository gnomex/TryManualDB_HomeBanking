package br.unioeste.trymanualDB.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.unioeste.trymanualDB.common.ResourceView;

public class ExcluirContaView extends JPanel{

	private JLabel lblNomeCliente;
    private JTextField txtNomeCliente;
    private JButton btnExcluir;
    private JPanel pnpProcurar;
    
    public ExcluirContaView(Dimension d){
    	this.setSize(d);
    	initTextFields();
    	initLabels();
    	initButtons();
    	initPanels();
    }
    
    private void initTextFields(){
		txtNomeCliente = new JTextField(30);
	}
	
	private void initLabels(){
		lblNomeCliente = ResourceView.getLabel("Nome do Cliente:", txtNomeCliente);
	}
	
	private void initButtons(){
        btnExcluir = ResourceView.getButton("Excluir", KeyEvent.VK_E);
    }
    
	private void initPanels(){
		configFindPanel();
		
		add(pnpProcurar, BorderLayout.NORTH);
		
		ResourceView.setComponentToPanel(pnpProcurar, lblNomeCliente);
		ResourceView.setComponentToPanel(pnpProcurar, txtNomeCliente);
		ResourceView.setComponentToPanel(pnpProcurar, btnExcluir);
	}
    
	private void configFindPanel(){
        pnpProcurar = new JPanel();
        pnpProcurar.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK),"Excluir cliente:"));
        pnpProcurar.setPreferredSize(new Dimension(getWidth() - 15, 100));
        pnpProcurar.setLayout(new FlowLayout());
    }
}
