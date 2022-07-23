package util;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Task;

public class TaskTableModel extends AbstractTableModel{
	
	String[] columns = {"Nome", "Descrição", "prazo", "Tarefa Concluida", "Editar", "Excluir"};
	List<Task> task = new ArrayList();

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}

}
