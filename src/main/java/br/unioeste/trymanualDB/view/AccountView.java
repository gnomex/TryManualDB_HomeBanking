package br.unioeste.trymanualDB.view;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AccountView extends JPanel{

	private JTextField txtIDcli;
	private JTextField txtAgencia;
	private JFormattedTextField txtDataAdesao;
	private JFormattedTextField txtDataEncerramento;
	private JTextField txtValorCorrente;
	private JComboBox<String> listTipoConta;
	
	private JLabel lblIDcli;
	private JLabel lblAgencia;
	private JLabel lblDataAdesao;
	private JLabel lblDataEncerramento;
	private JLabel lblValorCorrent;
	private JLabel lblTipoConta;
	
	private JPanel pnpDados;
	private JPanel pnpAction;
	
	private JButton btnSalvar, btnCancelar;
	
	public AccountView(Dimension res){
		this.setSize(res);
	}
	
	
}
