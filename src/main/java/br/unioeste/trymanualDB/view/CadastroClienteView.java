package br.unioeste.trymanualDB.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.Date;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import br.unioeste.base.Client;
import br.unioeste.base.TipoCliente;
import br.unioeste.trymanualDB.common.ResourceView;
import br.unioeste.trymanualDB.controller.UCMaintainCustomerManager;

public class CadastroClienteView extends JPanel{

	private JTextField txtNome;
	private JTextField txtSobrenome;
	private JTextField txtCpf;
	private JTextField txtRg;
	private JTextField txtCnpj;
	private JTextField txtEmail;
	private JTextField txtDataNascimento;
	private JTextField txtUsername;
	private JPasswordField txtUserpassword;
	private JComboBox<String> listTipoCliente;
	
	private JLabel lblNome;
	private JLabel lblSobrenome;
	private JLabel lblCpf;
	private JLabel lblRg;
	private JLabel lblCnpj;
	private JLabel lblEmail;
	private JLabel lblDataNascimento;
	private JLabel lblUsername;
	private JLabel lblUserpwd;
	private JLabel lblTipoCliente;
	
	private JPanel pnpDados;
	private JPanel pnpAction;
	
	private JButton btnSalvar, btnLimpar;
	
	private UCMaintainCustomerManager customer = new UCMaintainCustomerManager();
	
	public CadastroClienteView(Dimension res){
		this.setSize(res);
		initTextFields();
		initLabels();
		initButtons();
		initPanels();
	}
	
	private void initTextFields(){
		txtNome = new JTextField(40);
		txtSobrenome = new JTextField(40);
		txtCpf = new JTextField(15);
		txtRg = new JTextField(12);
		txtEmail = new JTextField(40);
		txtCnpj = new JTextField(20);
		txtUsername = new JTextField(20);
		txtUserpassword = new JPasswordField(20);
		txtDataNascimento = new JTextField(10);
		listTipoCliente = new JComboBox<String>();
		loadTypeClient();
	}
	
	private void initLabels(){
		lblNome = ResourceView.getLabel("Nome:", txtNome);
		lblSobrenome = ResourceView.getLabel("Sobrenome:", txtSobrenome);
		lblRg = ResourceView.getLabel("RG:", txtRg);
		lblCpf = ResourceView.getLabel("CPF:", txtCpf);
		lblCnpj = ResourceView.getLabel("CNPJ:", txtCnpj);
		lblDataNascimento = ResourceView.getLabel("Data de nascimento:", txtDataNascimento);
		lblEmail = ResourceView.getLabel("E-mail:", txtEmail);
		lblUsername = ResourceView.getLabel("Login:", txtUsername);
		lblUserpwd = ResourceView.getLabel("Senha:", txtUserpassword);
		lblTipoCliente = ResourceView.getLabel("Tipo de cliente:", listTipoCliente);
	}
	
	private void initButtons(){
        btnSalvar = ResourceView.getButton("Salvar", KeyEvent.VK_S);
        btnSalvar.addActionListener( new SalvarDadosCliente() );
        btnLimpar = ResourceView.getButton("Limpar", KeyEvent.VK_L);
        btnLimpar.addActionListener(new LimparCampos());
        
    }
    
	private void initPanels(){
		configDataPanel();
		configBtnPanel();
		
		add(pnpDados, BorderLayout.NORTH);
		add(pnpAction, BorderLayout.SOUTH);
		
		ResourceView.setComponentToPanel(pnpDados, lblNome);
		ResourceView.setComponentToPanel(pnpDados, txtNome);
		ResourceView.setComponentToPanel(pnpDados, lblSobrenome);
		ResourceView.setComponentToPanel(pnpDados, txtSobrenome);
		ResourceView.setComponentToPanel(pnpDados, lblCpf);
		ResourceView.setComponentToPanel(pnpDados, txtCpf);
		ResourceView.setComponentToPanel(pnpDados, lblRg);
		ResourceView.setComponentToPanel(pnpDados, txtRg);
		ResourceView.setComponentToPanel(pnpDados, lblCnpj);
		ResourceView.setComponentToPanel(pnpDados, txtCnpj);
		ResourceView.setComponentToPanel(pnpDados, lblEmail);
		ResourceView.setComponentToPanel(pnpDados, txtEmail);
		ResourceView.setComponentToPanel(pnpDados, lblDataNascimento);
		ResourceView.setComponentToPanel(pnpDados, txtDataNascimento);
		ResourceView.setComponentToPanel(pnpDados, lblTipoCliente);
		ResourceView.setComponentToPanel(pnpDados, listTipoCliente);
		ResourceView.setComponentToPanel(pnpDados, lblUsername);
		ResourceView.setComponentToPanel(pnpDados, txtUsername);
		ResourceView.setComponentToPanel(pnpDados, lblUserpwd);
		ResourceView.setComponentToPanel(pnpDados, txtUserpassword);
		
		ResourceView.setComponentToPanel(pnpAction, btnSalvar);
		ResourceView.setComponentToPanel(pnpAction, btnLimpar);
		
	}
	
	private void configDataPanel(){
        pnpDados = new JPanel();
        pnpDados.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createBevelBorder(5), "Cadastro de cliente:"));
        pnpDados.setPreferredSize(new Dimension(getWidth() - 150, getHeight() - 500));
        pnpDados.setLayout(new GridLayout(10, 10));
    }
    
    private void configBtnPanel(){
        pnpAction = new JPanel();
        pnpAction.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        pnpAction.setPreferredSize(new Dimension(getWidth() - 150, 50));
        pnpAction.setLayout(new GridLayout(1, 2));
    }
    
    private void loadTypeClient() {
    	List<String> list;
		try {
			list = customer.getAllTypeClients();
			for(int i = 0; i < list.size(); i++){
	    		System.out.println(list.get(i));
	    		listTipoCliente.insertItemAt(list.get(i), i);
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
    
    private void clearFields(){
    	txtNome.setText("");
    	txtSobrenome.setText("");
    	txtCpf.setText("");
    	txtCnpj.setText("");
    	txtRg.setText("");
    	txtEmail.setText("");
    	txtDataNascimento.setText("");
    	txtUsername.setText("");
    	txtUserpassword.setText("");
    }
    
    private class SalvarDadosCliente implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			if(txtNome.getText().isEmpty()){
				JOptionPane.showMessageDialog(null, 
						"Digite o Nome do cliente!", 
						"", 
						JOptionPane.INFORMATION_MESSAGE);
			}
			else if(txtSobrenome.getText().isEmpty()){
				JOptionPane.showMessageDialog(null, 
						"Digite o sobrenome!", 
						"", 
						JOptionPane.INFORMATION_MESSAGE);
			}
			else if(txtCpf.getText().isEmpty()){
				JOptionPane.showMessageDialog(null, 
						"Digite o CPF!", 
						"", 
						JOptionPane.INFORMATION_MESSAGE);
			}
			else if(txtRg.getText().isEmpty()){
				JOptionPane.showMessageDialog(null, 
						"Digite o RG!", 
						"", 
						JOptionPane.INFORMATION_MESSAGE);
			}
			else if(txtEmail.getText().isEmpty()){
				JOptionPane.showMessageDialog(null, 
						"Digite o E-mail!", 
						"", 
						JOptionPane.INFORMATION_MESSAGE);
			}
			else if(txtDataNascimento.getText().isEmpty()){
				JOptionPane.showMessageDialog(null, 
						"Digite a data de nascimento!", 
						"", 
						JOptionPane.INFORMATION_MESSAGE);
			}
			else if(txtUsername.getText().isEmpty()){
				JOptionPane.showMessageDialog(null, 
						"Digite o login", 
						"", 
						JOptionPane.INFORMATION_MESSAGE);
			}
			else if(txtUserpassword.getText().isEmpty()){
				JOptionPane.showMessageDialog(null, 
						"Digite a senha!", 
						"", 
						JOptionPane.INFORMATION_MESSAGE);
			}
			else{
				Client client = new Client();
				TipoCliente tipo = new TipoCliente();
				tipo.setId(listTipoCliente.getSelectedIndex() + 1);
				client.setTipo(tipo);
				client.setName(txtNome.getText());
				client.setLastName(txtSobrenome.getText());
				client.setCpf(txtCpf.getText());
				client.setCNPJ(txtCnpj.getText());
				client.setRg(txtRg.getText());
				client.setEmail(txtEmail.getText());
				client.setBirthDate(Date.valueOf(txtDataNascimento.getText()));
				client.setUserName(txtUsername.getText());
				client.setPwd(txtUserpassword.getText());
				
				try {
					client = customer.insertClient(client);
					
					if(client == null){
						JOptionPane.showMessageDialog(null, 
								"Não foi possivel cadastrar o cliente!", 
								"ERRO",
								JOptionPane.ERROR_MESSAGE);
					}
					else{
						clearFields();
						JOptionPane.showMessageDialog(null,
								"Cliente inserido com sucesso!",
								"Sucesso",
								JOptionPane.INFORMATION_MESSAGE);
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
    
    private class LimparCampos implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			clearFields();
		}
    	
    }
}
