package br.unioeste.trymanualDB.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
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

public class UpdateClienteView extends JPanel{

	private JTextField txtNome;
	private JTextField txtSobrenome;
	private JTextField txtCpf;
	private JTextField txtRg;
	private JTextField txtCnpj;
	private JTextField txtEmail;
	private JTextField txtDataNascimento;
	private JTextField txtUsername;
	private JPasswordField txtUserpassword;
	private JTextField txtTipoCliente;
	
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
	private JPanel pnpProcurar;
	
	private JLabel lblNomeCliente;
    private JTextField txtNomeCliente;
    
	private JButton btnSalvar, btnLimpar, btnProcurar;
	private Client oldCliente, newCliente;
	
	private UCMaintainCustomerManager customer = new UCMaintainCustomerManager();
	
	public UpdateClienteView(Dimension res){
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
		txtTipoCliente = new JTextField(20);
		txtNomeCliente = new JTextField(30);
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
		lblTipoCliente = ResourceView.getLabel("Tipo de cliente:", txtTipoCliente);
		lblNomeCliente = ResourceView.getLabel("Nome do Cliente:", txtNomeCliente);
	}
	
	private void initButtons(){
        btnSalvar = ResourceView.getButton("Salvar", KeyEvent.VK_S);
        btnSalvar.addActionListener(new SalvarDadosCliente());
        btnLimpar = ResourceView.getButton("Limpar", KeyEvent.VK_L);
        btnLimpar.addActionListener(new LimparCampos());
        btnProcurar = ResourceView.getButton("Pesquisar", KeyEvent.VK_P);
        btnProcurar.addActionListener(new ConsultaDadosCliente() );
    }
    
	private void initPanels(){
		configFindPanel();
		configDataPanel();
		configBtnPanel();
		
		add(pnpProcurar, BorderLayout.NORTH);
		add(pnpDados, BorderLayout.CENTER);
		add(pnpAction, BorderLayout.SOUTH);
		
		ResourceView.setComponentToPanel(pnpProcurar, lblNomeCliente);
		ResourceView.setComponentToPanel(pnpProcurar, txtNomeCliente);
		ResourceView.setComponentToPanel(pnpProcurar, btnProcurar);
		
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
		ResourceView.setComponentToPanel(pnpDados, txtTipoCliente);
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
    
    private void configFindPanel(){
        pnpProcurar = new JPanel();
        pnpProcurar.setBorder(BorderFactory.createBevelBorder(5));
        pnpProcurar.setPreferredSize(new Dimension(getWidth() - 5, 30));
        pnpProcurar.setLayout(new FlowLayout());
    }
    
    private void clearFields(){
    	txtNomeCliente.setText("");
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
    
    private void setDataToFields(Client cli){
    	txtNome.setText(cli.getName());
    	txtSobrenome.setText(cli.getLastName());
    	txtCpf.setText(cli.getCpf());
    	txtRg.setText(cli.getRg());
    	txtCnpj.setText(cli.getCNPJ());
    	txtEmail.setText(cli.getEmail());
    	txtDataNascimento.setText(cli.getBirthDate().toString());
    	txtUsername.setText(cli.getUserName());
    	txtUserpassword.setText(cli.getPwd());
    	
    	switch(cli.getTipo().getId()){
    		case 1: txtTipoCliente.setText("Especial"); break;
    		case 2: txtTipoCliente.setText("Pessoa Física"); break;
    		case 3: txtTipoCliente.setText("Pessoa Jurídica"); break;
    	}
    }
    
    private void getDataOfFields(){
    	newCliente = new Client();
    	newCliente.setName(txtNome.getText());
    	newCliente.setLastName(txtSobrenome.getText());
    	newCliente.setCpf(txtCpf.getText());
    	newCliente.setRg(txtRg.getText());
    	newCliente.setCNPJ(txtCnpj.getText());
    	newCliente.setEmail(txtEmail.getText());
    	newCliente.setBirthDate(Date.valueOf(txtDataNascimento.getText()));
    	newCliente.setUserName(txtUsername.getText());
    	newCliente.setPwd(txtUserpassword.getText());
    	newCliente.setTipo(oldCliente.getTipo());
    }
    
    private class ConsultaDadosCliente implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			if(txtNomeCliente.getText().isEmpty()){
				JOptionPane.showMessageDialog(null,
						"Digite o nome do cliente!",
						"",
						JOptionPane.INFORMATION_MESSAGE);
			}
			else{
				oldCliente = new Client();
				oldCliente.setName(txtNomeCliente.getText());
				
				try {
					oldCliente = customer.findClientByName(oldCliente);
					setDataToFields(oldCliente);
					
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
    
	private class SalvarDadosCliente implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			getDataOfFields();
			
			try {
				customer.updateClient("Nome", newCliente.getName(), oldCliente.getName());
				customer.updateClient("Sobrenome", newCliente.getLastName(), oldCliente.getLastName());
				customer.updateClient("CPF", newCliente.getCpf(), oldCliente.getCpf());
				customer.updateClient("RG", newCliente.getRg(), oldCliente.getRg());
				customer.updateClient("CNPJ", newCliente.getCNPJ(), oldCliente.getCNPJ());
				customer.updateClient("Email", newCliente.getEmail(), oldCliente.getEmail());
				//customer.updateClient("DataNascimento", newCliente.getBirthDate(), oldCliente.getBirthDate());
				customer.updateClient("UserName", newCliente.getUserName(), oldCliente.getUserName());
				customer.updateClient("Userpasswd", newCliente.getPwd(), oldCliente.getPwd());
				
				clearFields();
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
    
    private class LimparCampos implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			clearFields();
		}
    	
    }
}
