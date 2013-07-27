package br.unioeste.trymanualDB.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import br.unioeste.trymanualDB.common.ResourceView;

public class TryManualDBHomeBankingView extends JFrame{

	private static final long serialVersionUID = 1L;
	
	private CadastroClienteView customerCad;
	private ConsultaClienteView customerCon;
	private UpdateClienteView customerUp;
	private ExcluirClienteView customerDel;
	
	private CadastroContaView accountCad;
	private ConsultarContaView accountCon;
	private UpdateContaView accountUp;
	private ExcluirContaView accountDel;
	
	private JMenuBar menuBar;
	private JMenu menuCliente;
	private JMenu menuConta;
	private JMenuItem cliCad, cliCon, cliDel, cliUp;
	private JMenuItem ctClicad, ctClicon, ctCliDel, ctCliup;
	private JMenuItem sair;
	
	
	public TryManualDBHomeBankingView(){
		super("Try ManualDB HomeBanking");
		initGui();
		setVisible(true);
	}
	
	private void initGui(){
		
		setSize(new Dimension(600, 700));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		initMenu();
		
		setJMenuBar(menuBar);
		
	}
	
	private void initMenu(){
		menuBar = new JMenuBar();
		
		menuCliente = new JMenu("Cliente");
		menuCliente.setMnemonic(KeyEvent.VK_C);
		menuBar.add(menuCliente);
		
		cliCad = new JMenuItem("Cadastrar cliente");
		cliCad.addActionListener(new CadastrarClienteMenuItem());
		menuCliente.add(cliCad);
		
		cliCon = new JMenuItem("Consultar cliente");
		cliCon.addActionListener(new ConsultarClienteMenuItem());
		menuCliente.add(cliCon);
		
		cliUp = new JMenuItem("Atualizar dados...");
		cliUp.addActionListener(new UpdateClienteMenuItem());
		menuCliente.add(cliUp);
		
		cliDel = new JMenuItem("Excluir um cliente");
		cliDel.addActionListener(new DelCustomerMenuItem());
		menuCliente.add(cliDel);
		
		menuCliente.addSeparator();
		sair = new JMenuItem("Sair");
		sair.setAccelerator(KeyStroke.getKeyStroke("control X"));
		sair.addActionListener(new Exit());
		menuCliente.add(sair);
		
		menuConta = new JMenu("Conta");
		menuConta.setMnemonic(KeyEvent.VK_O);
		menuBar.add(menuConta);
		
		ctClicad = new JMenuItem("Cadastrar conta de cliente");
		ctClicad.addActionListener(new CadastrarContaMenuItem());
		menuConta.add(ctClicad);
		
		ctClicon = new JMenuItem("Consultar conta de cliente");
		ctClicon.addActionListener(new ConsultarContaMenuItem());
		menuConta.add(ctClicon);
		
		ctCliup = new JMenuItem("Atualizar conta de cliente");
		ctCliup.addActionListener(new AtualizarContaMenuItem());
		menuConta.add(ctCliup);
		
		ctCliDel = new JMenuItem("Excluir conta de cliente");
		ctCliDel.addActionListener(new ExcluirContaMenuItem());
		menuConta.add(ctCliDel);
	}
	
	private void disablePanels(){
		if(customerCad != null){
			ResourceView.removeComponent(this, customerCad);
			customerCad = null;
		}
		
		if(customerCon != null){
			ResourceView.removeComponent(this, customerCon);
			customerCon = null;
		}
		
		if(customerUp != null){
			ResourceView.removeComponent(this, customerUp);
			customerUp = null;
		}
		
		if(customerDel != null){
			ResourceView.removeComponent(this, customerDel);
			customerDel = null;
		}
		
		if(accountCad != null){
			ResourceView.removeComponent(this, accountCad);
			accountCad = null;
		}
		
		if(accountCon != null){
			ResourceView.removeComponent(this, accountCon);
			accountCon = null;
		}
		
		if(accountUp != null){
			ResourceView.removeComponent(this, accountUp);
			accountUp = null;
		}
		
		if(accountDel != null){
			ResourceView.removeComponent(this, accountDel);
			accountDel = null;
		}
	}
	
	private void enableRegistryCustomer(){
		customerCad = new CadastroClienteView(this.getSize());
		ResourceView.addComponent(this, BorderLayout.CENTER, customerCad);
	}
	
	private class CadastrarClienteMenuItem implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			disablePanels();
			enableRegistryCustomer();
		}
		
	}
	
	private void enableFindCustomer(){
		customerCon = new ConsultaClienteView(this.getSize());
		ResourceView.addComponent(this, BorderLayout.CENTER, customerCon);
	}
	
	private class ConsultarClienteMenuItem implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			disablePanels();
			enableFindCustomer();
		}
		
	}
	
	private void enableUpdateCustomer(){
		customerUp = new UpdateClienteView(this.getSize());
		ResourceView.addComponent(this, BorderLayout.CENTER, customerUp);
	}
	
	private class UpdateClienteMenuItem  implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			disablePanels();
			enableUpdateCustomer();
		}
		
	}
	
	private void enableDelCustomer(){
		customerDel = new ExcluirClienteView(this.getSize());
		ResourceView.addComponent(this, BorderLayout.CENTER, customerDel);
	}
	
	private class DelCustomerMenuItem implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			disablePanels();
			enableDelCustomer();
		}
		
	}
	
	private void enableInsertAccount(){
		accountCad = new CadastroContaView(this.getSize());
		ResourceView.addComponent(this, BorderLayout.CENTER, accountCad);
	}
	
	private class CadastrarContaMenuItem implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			disablePanels();
			enableInsertAccount();
		}
		
	}
	
	private void enableFindAccount(){
		accountCon = new ConsultarContaView(this.getSize());
		ResourceView.addComponent(this, BorderLayout.CENTER, accountCon);
	}
	
	private class ConsultarContaMenuItem implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			disablePanels();
			enableFindAccount();
		}
		
	}
	
	private void enableUpdateAccount(){
		accountUp = new UpdateContaView(this.getSize());
		ResourceView.addComponent(this, BorderLayout.CENTER, accountUp);
	}
	
	private class AtualizarContaMenuItem implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			disablePanels();
			enableUpdateAccount();
		}
		
	}
	
	private void enableDelAccount(){
		accountDel = new ExcluirContaView(this.getSize());
		ResourceView.addComponent(this, BorderLayout.CENTER, accountDel);
	}
	
	private class ExcluirContaMenuItem implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			disablePanels();
			enableDelAccount();
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TryManualDBHomeBankingView();
	}

	private class Exit implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
		
	}
}
