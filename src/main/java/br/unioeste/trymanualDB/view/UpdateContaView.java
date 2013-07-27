package br.unioeste.trymanualDB.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.sql.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import br.unioeste.base.BankAccount;
import br.unioeste.trymanualDB.common.ResourceView;

public class UpdateContaView extends JPanel{

	private JTextField txtNumero;
	private JTextField txtAgencia;
	private JTextField txtDataAdesao;
	private JTextField txtDataEnce;
	private JTextField txtValor;
	private JTextField txtTipoConta;
	private JTextField txtCliente;
	
	private JLabel lblNumero;
	private JLabel lblAgencia;
	private JLabel lblDataAdesao;
	private JLabel lblDataEnce;
	private JLabel lblValor;
	private JLabel lblTipoConta;
	private JLabel lblCliente;
	
	private JPanel pnpDados;
	private JPanel pnpAction;
	private JPanel pnpProcurar;
	
	private JLabel lblNomeCliente;
    private JTextField txtNomeCliente;
    
	private JButton btnSalvar, btnLimpar, btnProcurar;

	private BankAccount oldAccount, newAccount;
	
	public UpdateContaView(Dimension d){
		this.setSize(d);
		initTextFields();
		initLabels();
		initButtons();
		initPanels();
	}
	
	private void initTextFields(){
		txtNumero = new JTextField(20);
		txtAgencia = new JTextField(40);
		txtDataAdesao = new JTextField(20);
		txtDataEnce = new JTextField(20);
		txtValor = new JTextField(20);
		txtTipoConta = new JTextField(20);
		txtCliente = new JTextField(40);
		txtNomeCliente = new JTextField(30);
	}
	
	private void initLabels(){
		lblNumero = ResourceView.getLabel("Numero:", txtNumero);
		lblAgencia = ResourceView.getLabel("Agência:", txtAgencia);
		lblDataAdesao = ResourceView.getLabel("Data de adesão:", txtDataAdesao);
		lblDataEnce = ResourceView.getLabel("Data de encerramento:", txtDataEnce);
		lblValor = ResourceView.getLabel("Valor corrente:", txtValor);
		lblTipoConta = ResourceView.getLabel("Tipo de conta:", txtTipoConta);
		lblCliente = ResourceView.getLabel("Cliente:", txtCliente);
		lblNomeCliente = ResourceView.getLabel("Nome do Cliente:", txtNomeCliente);
	}
	
	private void initButtons(){
        btnSalvar = ResourceView.getButton("Salvar", KeyEvent.VK_S);
        
        btnLimpar = ResourceView.getButton("Limpar", KeyEvent.VK_L);
        
        btnProcurar = ResourceView.getButton("Pesquisar", KeyEvent.VK_P);
        
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
		
		ResourceView.setComponentToPanel(pnpDados, lblNumero);
		ResourceView.setComponentToPanel(pnpDados, txtNumero);
		ResourceView.setComponentToPanel(pnpDados, lblAgencia);
		ResourceView.setComponentToPanel(pnpDados, txtAgencia);
		ResourceView.setComponentToPanel(pnpDados, lblDataAdesao);
		ResourceView.setComponentToPanel(pnpDados, txtDataAdesao);
		ResourceView.setComponentToPanel(pnpDados, lblDataEnce);
		ResourceView.setComponentToPanel(pnpDados, txtDataEnce);
		ResourceView.setComponentToPanel(pnpDados, lblValor);
		ResourceView.setComponentToPanel(pnpDados, txtValor);
		ResourceView.setComponentToPanel(pnpDados, lblTipoConta);
		ResourceView.setComponentToPanel(pnpDados, txtTipoConta);
		ResourceView.setComponentToPanel(pnpDados, lblCliente);
		ResourceView.setComponentToPanel(pnpDados, txtCliente);
		
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
    	txtNumero.setText("");
    	txtAgencia.setText("");
    	txtDataAdesao.setText("");
    	txtDataEnce.setText("");
    	txtValor.setText("");
    	txtTipoConta.setText("");
    	txtCliente.setText("");
    }
    
    private void setDataToFields(BankAccount account){
    	txtNumero.setText(String.valueOf(account.getAccountNumber()));
    	txtAgencia.setText(account.getBankBranch());
    	txtDataAdesao.setText(account.getStartAccountDate().toString());
    	txtDataEnce.setText(account.getClosingAccountDate().toString());
    	txtValor.setText(account.getSaldoCorrente().toString());
    	txtTipoConta.setText(String.valueOf(account.getTipo().getId()));
    	txtCliente.setText(account.getClient().getName());
    }
    
    private void getDataOfFields(){
    	newAccount.setAccountNumber(Integer.parseInt(txtNumero.getText()));
    	newAccount.setBankBranch(txtAgencia.getText());
    	newAccount.setStartAccountDate(Date.valueOf(txtDataAdesao.getText()));
    	newAccount.setClosingAccountDate(Date.valueOf(txtDataEnce.getText()));
    	newAccount.setSaldoCorrente(Float.parseFloat(txtValor.getText()));
    }
}
