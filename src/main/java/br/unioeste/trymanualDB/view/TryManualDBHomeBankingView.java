package br.unioeste.trymanualDB.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class TryManualDBHomeBankingView extends JFrame{

	private static final long serialVersionUID = 1L;
	private CadastroClienteView customerCad;
	private ConsultaClienteView customerCon;
	private UpdateClienteView customerUp;
	
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
		
		//customer = new CadastroClienteView(this.getSize());
		//customerCon = new ConsultaClienteView(this.getSize());
		customerUp = new UpdateClienteView(this.getSize());
		
		getContentPane().add(customerUp, BorderLayout.CENTER);
	}
	
	private void initMenu(){
		menuBar = new JMenuBar();
		
		menuCliente = new JMenu("Cliente");
		menuCliente.setMnemonic(KeyEvent.VK_C);
		menuBar.add(menuCliente);
		
		cliCad = new JMenuItem("Cadastrar cliente");
		menuCliente.add(cliCad);
		
		cliCon = new JMenuItem("Consultar cliente");
		menuCliente.add(cliCon);
		
		cliUp = new JMenuItem("Atualizar dados...");
		menuCliente.add(cliUp);
		
		cliDel = new JMenuItem("Excluir um cliente");
		menuCliente.add(cliDel);
		
		menuCliente.addSeparator();
		sair = new JMenuItem("Sair");
		sair.setAccelerator(KeyStroke.getKeyStroke("control X"));
		menuCliente.add(sair);
		
		menuConta = new JMenu("Conta");
		menuConta.setMnemonic(KeyEvent.VK_O);
		menuBar.add(menuConta);
		
		ctClicad = new JMenuItem("Cadastrar conta de cliente");
		menuConta.add(ctClicad);
		
		ctClicon = new JMenuItem("Consultar conta de cliente");
		menuConta.add(ctClicon);
		
		ctCliup = new JMenuItem("Atualizar conta de cliente");
		menuConta.add(ctCliup);
		
		ctCliDel = new JMenuItem("Excluir conta de cliente");
		menuConta.add(ctCliDel);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TryManualDBHomeBankingView();
	}

}
