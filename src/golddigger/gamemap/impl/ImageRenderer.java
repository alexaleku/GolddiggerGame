package golddigger.gamemap.impl;

import golddigger.gameobjects.abstracts.AbsGameObject;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;


public class ImageRenderer extends DefaultTableCellRenderer {

    private JLabel lbl = new JLabel();
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
            boolean hasFocus, int row, int column) {

        lbl.setText(null);
        lbl.setIcon(((AbsGameObject) value).getIcon());
        
        return lbl;
    }
}