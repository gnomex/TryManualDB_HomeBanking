package br.unioeste.trymanualDB.config;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.unioeste.base.BankAccount;
import br.unioeste.trymanualDB.controller.UCMaintainBankAccountManager;


public class ContaTableModel extends AbstractTableModel{

	private static final long serialVersionUID = 1L;
	private Object[] columns = {"Numero", "Agência", "Data Adesão", "Data Encerramento", "Saldo", "Tipo"};
	private List list;
	
	public ContaTableModel(){
		list = new ArrayList<BankAccount>();
	}
	
	public int getColumnCount() {
		return columns.length;
	}

	public int getRowCount() {
		return list.size();
	}

    public Object getValueAt(int rowIndex, int columnIndex) {
        BankAccount account = (BankAccount)list.get(rowIndex);
        switch(columnIndex){
        	case 0: return account.getAccountNumber();
        	case 1: return account.getBankBranch();
        	case 2: return account.getStartAccountDate();
        	case 3: return account.getClosingAccountDate();
        	case 4: return account.getSaldoCorrente();
        	case 5: return account.getTipo().getId();
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
    
    public BankAccount setAccount(BankAccount account){
    	UCMaintainBankAccountManager manager = new UCMaintainBankAccountManager();
    	
    	try {
    		account = manager.findAccount(account);
			
			if(account != null) {
				list.add(account);
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
    	
    	return account;
    }
}
