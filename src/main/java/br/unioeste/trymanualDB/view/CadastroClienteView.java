package br.unioeste.trymanualDB.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import br.unioeste.trymanualDB.common.ResourceView;

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
	
	private JButton btnSalvar, btnCancelar;
	
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
        btnSalvar = getButton("Salvar", KeyEvent.VK_S);
        
        btnCancelar = getButton("Cancelar", KeyEvent.VK_C);
        
    }
    
    private JButton getButton(String label,int key){
        JButton t = new JButton(label);
        t.setMnemonic(key);
        return t;
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
		ResourceView.setComponentToPanel(pnpAction, btnCancelar);
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
}
