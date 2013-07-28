package br.unioeste.trymanualDB.view;

import java.awt.BorderLayout;
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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import br.unioeste.base.BankAccount;
import br.unioeste.base.Client;
import br.unioeste.trymanualDB.common.ResourceView;
import br.unioeste.trymanualDB.config.ContaTableModel;
import br.unioeste.trymanualDB.controller.UCMaintainBankAccountManager;
import br.unioeste.trymanualDB.controller.UCMaintainCustomerManager;

public class ConsultarContaView extends JPanel {

	private JLabel lblNomeCliente;
    private JTextField txtNomeCliente;
    private JButton btnProcurar;
    private JPanel findPanel, tablePanel;
    private JTable tabela;
    private JScrollPane scroll;
    private ContaTableModel model;
    
    public ConsultarContaView(Dimension d){
    	this.setSize(d);
    	initComponents();
    }
    
    private void initComponents(){
        initTextField();
        initLabel();
        initButton();
        initTable();
        initPanels();
    }
    
    private void initTextField(){
        txtNomeCliente = getTextField(30);
    }
    
    private JTextField getTextField(int size){
        return new JTextField(size);
    }
    
    private void initLabel(){
        lblNomeCliente = getLabel("Cliente:", txtNomeCliente);
    }
    
    private JLabel getLabel(String label,JTextField txt){
        JLabel t = new JLabel(label);
        t.setLabelFor(txt);
        t.setHorizontalAlignment(JLabel.RIGHT);
        return t;
    }
    
    private void initButton(){
        btnProcurar = ResourceView.getButton("Procurar", KeyEvent.VK_P);
        btnProcurar.addActionListener(new ConsultarDadosConta());
        
    }
    
    private void initTable(){
        model = new ContaTableModel();
        tabela = new JTable(model);
        tabela.setPreferredSize(new Dimension(getWidth() - 15, getHeight() - 500));
        scroll = new JScrollPane(tabela);
        scroll.setPreferredSize(new Dimension(getWidth() - 15, getHeight() - 500));
    }
    
    private void initPanels(){
        configTablePanel();
        configFindPanel();
        
        tablePanel.add(scroll);
        findPanel.add(lblNomeCliente);
        findPanel.add(txtNomeCliente);
        findPanel.add(btnProcurar);
        
        add(findPanel, BorderLayout.NORTH);
        add(tablePanel, BorderLayout.SOUTH);
    }
    
    private void configTablePanel(){
        tablePanel = new JPanel();
        tablePanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createBevelBorder(5), "Dados da conta:"));
        tablePanel.setPreferredSize(new Dimension(getWidth() - 5, getHeight() - 400));
        tablePanel.setLayout(new FlowLayout());
    }
    
    private void configFindPanel(){
        findPanel = new JPanel();
        findPanel.setBorder(BorderFactory.createBevelBorder(5));
        findPanel.setPreferredSize(new Dimension(getWidth() - 5, 30));
        findPanel.setLayout(new FlowLayout());
    }
    
    private class ConsultarDadosConta implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			if(txtNomeCliente.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, 
                        "Digite o nome do cliente", 
                        "", 
                        JOptionPane.INFORMATION_MESSAGE);
            }
            else{
            	Client client = new Client();
            	client.setName(txtNomeCliente.getText());
            	UCMaintainCustomerManager customer = new UCMaintainCustomerManager();
            	
            	try {
					client = customer.findClientByName(client);
					
					if(client != null){
						BankAccount account = new BankAccount();
						account.setClient(client);
						account = model.setAccount(account);
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
