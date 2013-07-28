package br.unioeste.trymanualDB.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.unioeste.base.BankAccount;
import br.unioeste.base.Client;
import br.unioeste.trymanualDB.common.ResourceView;
import br.unioeste.trymanualDB.controller.UCMaintainBankAccountManager;
import br.unioeste.trymanualDB.controller.UCMaintainCustomerManager;

public class ExcluirContaView extends JPanel{

	private JLabel lblNomeCliente;
    private JTextField txtNomeCliente;
    private JButton btnExcluir;
    private JPanel pnpProcurar;
    
    private UCMaintainBankAccountManager manager = new UCMaintainBankAccountManager();
    
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
        btnExcluir.addActionListener(new ExcluirDadosConta());
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
        pnpProcurar.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK),"Excluir conta:"));
        pnpProcurar.setPreferredSize(new Dimension(getWidth() - 15, 100));
        pnpProcurar.setLayout(new FlowLayout());
    }
	
	private class ExcluirDadosConta implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			if(txtNomeCliente.getText().isEmpty()){
				
			}
			else{
				Client client = new Client();
				client.setName(txtNomeCliente.getText());
				BankAccount account = new BankAccount();
				
				
				try {
					UCMaintainCustomerManager customer = new UCMaintainCustomerManager();
					client = customer.findClientByName(client);
					
					account.setClient(client);
					account = manager.deleteAccount(account);
					
					if(account == null){
						JOptionPane.showMessageDialog(null,
								"Conta Excluida com sucesso",
								"Sucesso",
								JOptionPane.INFORMATION_MESSAGE);
					}
					else{
						JOptionPane.showMessageDialog(null,
								"Não foi possivel excluir a conta",
								"Erro",
								JOptionPane.ERROR_MESSAGE);
					}
					
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (InstantiationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IllegalAccessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		
	}
}
