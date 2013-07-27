package br.unioeste.trymanualDB.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.unioeste.base.Client;
import br.unioeste.trymanualDB.common.ResourceView;
import br.unioeste.trymanualDB.controller.UCMaintainCustomerManager;


public class ExcluirClienteView extends JPanel{

	private static final long serialVersionUID = 1L;
	private JLabel lblNomeCliente;
    private JTextField txtNomeCliente;
    private JButton btnExcluir;
    private JPanel pnpProcurar;
    
    private UCMaintainCustomerManager customer = new UCMaintainCustomerManager();
    
    public ExcluirClienteView(Dimension d){
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
        btnExcluir.addActionListener(new ExcluirDadosCliente() );
        
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
    
    
    private class ExcluirDadosCliente implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			if(txtNomeCliente.getText().isEmpty()){
				JOptionPane.showMessageDialog(null, "Digite o nome!", "", JOptionPane.INFORMATION_MESSAGE);
			}
			else{
				Client client = new Client();
				client.setName(txtNomeCliente.getText());
				
				try {
					client = customer.deleteClient(client);
					
					if(client == null){
						JOptionPane.showMessageDialog(null, 
								"Cliente excluido com sucesso!", 
								"Sucesso",
								JOptionPane.INFORMATION_MESSAGE);
					}
					else{
						JOptionPane.showMessageDialog(null, 
								"Não foi possivel excluir o cliente!", 
								"Erro",
								JOptionPane.ERROR_MESSAGE);
					}
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
    	
    }
}
