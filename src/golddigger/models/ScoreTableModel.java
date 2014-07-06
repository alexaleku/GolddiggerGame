/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package golddigger.models;

import golddigger.score.impl.UserScore;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author alexkurocha
 */
public class ScoreTableModel extends AbstractTableModel {

    private final ArrayList<UserScore> list;

    public ArrayList<UserScore> getList() {
        return list;
    }

    public ScoreTableModel(ArrayList<UserScore> list) {
        this.list = list;
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    private DateFormat dataFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    public DateFormat getDataFormat() {
        return dataFormat;
    }

    public void setDataFormat(DateFormat dataFormat) {
        this.dataFormat = dataFormat;
    }

    @Override
    public String getColumnName(int columnIndex) {
        String columnName;
        switch (columnIndex) {
            case 0:
                columnName = "№";
                break;
            case 1:
                columnName = "Имя игрока";
                break;
            case 2:
                columnName = "Дата игры";
                break;
            case 3:
                columnName = "Кол-во очков";
                break;
            case 4:
                columnName = "Кол-во игр";
                break;
            default:
                throw new IndexOutOfBoundsException("Column index out of bounds: " + columnIndex);
        }
        return columnName;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        Class<?> clazz;
        switch (columnIndex) {
            case 0:
            case 3:
            case 4:
                clazz = Integer.class;
                break;
            case 1:
                clazz = String.class;
                break;
            case 2:
                clazz = Long.class;
                break;
            default:
                throw new IndexOutOfBoundsException("Column index out of bounds " + columnIndex);
        }
        return clazz;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object value = null;
        switch (columnIndex) {
            case 0:
                value = rowIndex + 1;
                break;
            case 1:
                value = list.get(rowIndex).getUserName();
                break;
            case 2:
                Date date = new Date(list.get(rowIndex).getPlayDate());
                value = dataFormat.format(date);
                break;
            case 3:
                value = list.get(rowIndex).getScore();
                break;
            case 4:
                value = list.get(rowIndex).getPlayCount();
                break;
            default:
                throw new IndexOutOfBoundsException("Column index out of bounds " + columnIndex);
        }
        return value;
    }

//    @Override
//    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void addTableModelListener(TableModelListener l) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void removeTableModelListener(TableModelListener l) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

}
