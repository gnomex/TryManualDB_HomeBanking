package br.unioeste.trymanualDB.config;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.unioeste.base.Client;
import br.unioeste.trymanualDB.controller.UCMaintainCustomerManager;

public class ClienteTableModel extends AbstractTableModel{

	private static final long serialVersionUID = 1L;
	private Object[] columns = {"ID", "Nome", "Sobrenome", "CPF", "RG", "CNPJ", 
			"E-mail", "DataNasci", "Tipo"};
	private List list;
	
	public ClienteTableModel(){
		list = new ArrayList<Client>();
	}
	
	public int getColumnCount() {
		return columns.length;
	}

	public int getRowCount() {
		return list.size();
	}

    public Object getValueAt(int rowIndex, int columnIndex) {
        Client customer = (Client)list.get(rowIndex);
        switch(columnIndex){
        	case 0: return customer.getIdClient();
        	case 1: return customer.getName();
        	case 2: return customer.getLastName();
        	case 3: return customer.getCpf();
        	case 4: return customer.getRg();
        	case 5: return customer.getCNPJ();
        	case 6: return customer.getEmail();
        	case 7: return customer.getBirthDate();
        	case 8: return customer.getTipo().getId();
        }
        return null;
    }

    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }
    
    public String getColumnName(int column) {
        return columns[column].toString();
    }
    
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
    
    public Client setCliente(Client cliente){
    	UCMaintainCustomerManager manager = new UCMaintainCustomerManager();
    	
    	try {
			cliente = manager.findClientByName(cliente);
			
			if(cliente != null) {
				list.add(cliente);
				fireTableRowsInserted(list.size()-1, list.size()-1);
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
    	
    	return cliente;
    }
}
