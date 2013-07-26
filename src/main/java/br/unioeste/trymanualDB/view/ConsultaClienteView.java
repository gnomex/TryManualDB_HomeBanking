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

import br.unioeste.base.Client;
import br.unioeste.trymanualDB.config.ClienteTableModel;

public class ConsultaClienteView extends JPanel{

	private JLabel lblNomeCliente;
    private JTextField txtNomeCliente;
    private JButton btnProcurar;
    private JPanel findPanel, tablePanel;
    private JTable tabela;
    private JScrollPane scroll;
    private ClienteTableModel model;
    
    
    public ConsultaClienteView(Dimension dimension){
        setSize(dimension);
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
        btnProcurar = getButton("Procurar", KeyEvent.VK_P);
        btnProcurar.addActionListener(new ConsultarDadosCliente() );
    }
    
    private JButton getButton(String label,int key){
        JButton t = new JButton(label);
        t.setMnemonic(key);
        return t;
    }
    
    private void initTable(){
        model = new ClienteTableModel();
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
                BorderFactory.createBevelBorder(5), "Dados do cliente:"));
        tablePanel.setPreferredSize(new Dimension(getWidth() - 5, getHeight() - 400));
        tablePanel.setLayout(new FlowLayout());
    }
    
    private void configFindPanel(){
        findPanel = new JPanel();
        findPanel.setBorder(BorderFactory.createBevelBorder(5));
        findPanel.setPreferredSize(new Dimension(getWidth() - 5, 30));
        findPanel.setLayout(new FlowLayout());
    }
    
    private class ConsultarDadosCliente implements ActionListener{

        public void actionPerformed(ActionEvent e) {
            if(txtNomeCliente.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, 
                        "Digite o nome do cliente", 
                        "", 
                        JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                Client customer = new Client();
                customer.setName(txtNomeCliente.getText());
            	customer = model.setCliente(customer);
            }
        }
        
    }
	
	
}
