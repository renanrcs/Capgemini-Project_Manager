package util;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Task;

public class TaskTableModel extends AbstractTableModel{
	
	String[] columns = {"Nome", "Descri��o", "prazo", "Tarefa Concluida", "Editar", "Excluir"};
	List<Task> tasks = new ArrayList();

	@Override
	public int getRowCount() {
		return tasks.size();
	}

	@Override
	public int getColumnCount() {
		return columns.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {

		switch (columnIndex) {
		case 0: 
			return tasks.get(rowIndex).getName();
		case 1: 
			return tasks.get(rowIndex).getDescription();
		case 2: 
			return tasks.get(rowIndex).getDeadline();
		case 3: 
			return tasks.get(rowIndex).isCompleted();
		case 4: 
			return "";
		case 5: 
			return "";
		default:
			throw new IllegalArgumentException("Unexpected value: " + columnIndex);
		}
	}

}
