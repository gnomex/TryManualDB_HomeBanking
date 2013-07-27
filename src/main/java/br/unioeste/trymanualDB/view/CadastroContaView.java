package br.unioeste.trymanualDB.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.unioeste.base.TipoConta;
import br.unioeste.trymanualDB.common.ResourceView;
import br.unioeste.trymanualDB.controller.UCMaintainBankAccountManager;

public class CadastroContaView extends JPanel {

	private JTextField txtNumero;
	private JTextField txtAgencia;
	private JTextField txtDataAdesao;
	private JTextField txtDataEnce;
	private JTextField txtValor;
	private JComboBox<String> listTipoConta;
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
	
	private JButton btnSalvar, btnLimpar;
	
	private UCMaintainBankAccountManager account = new UCMaintainBankAccountManager();
	
	public CadastroContaView(Dimension d){
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
		listTipoConta = new JComboBox<String>();
		loadTypeClient();
		txtCliente = new JTextField(40);
	}
	
	private void loadTypeClient() {
    	List<String> list;
		try {
			list = account.getAllTypeAccounts();
			for(int i = 0; i < list.size(); i++){
	    		System.out.println(list.get(i));
	    		listTipoConta.insertItemAt(list.get(i), i);
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
	
	private void initLabels(){
		lblNumero = ResourceView.getLabel("Numero:", txtNumero);
		lblAgencia = ResourceView.getLabel("Agência:", txtAgencia);
		lblDataAdesao = ResourceView.getLabel("Data de adesão:", txtDataAdesao);
		lblDataEnce = ResourceView.getLabel("Data de encerramento:", txtDataEnce);
		lblValor = ResourceView.getLabel("Valor corrente:", txtValor);
		lblTipoConta = ResourceView.getLabel("Tipo de conta:", listTipoConta);
		lblCliente = ResourceView.getLabel("Cliente:", txtCliente);
	}
	
	private void initButtons(){
		btnSalvar = ResourceView.getButton("Salvar", KeyEvent.VK_S);
		btnLimpar = ResourceView.getButton("Limpar", KeyEvent.VK_L);
	}
	
	private void initPanels(){
		configDataPanel();
		configBtnPanel();
		
		add(pnpDados, BorderLayout.NORTH);
		add(pnpAction, BorderLayout.SOUTH);
		
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
		ResourceView.setComponentToPanel(pnpDados, listTipoConta);
		ResourceView.setComponentToPanel(pnpDados, lblCliente);
		ResourceView.setComponentToPanel(pnpDados, txtCliente);
		
		ResourceView.setComponentToPanel(pnpAction, btnSalvar);
		ResourceView.setComponentToPanel(pnpAction, btnLimpar);
	}
	
	private void configDataPanel(){
        pnpDados = new JPanel();
        pnpDados.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createBevelBorder(5), "Cadastro de conta:"));
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
