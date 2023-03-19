package com.apu.appointwell.classes.utils;

import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Container;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JFrame;

/**
 *
 * @author Alex
 */
public class SwingUtils {
    
    DialogsUI dialogsUI = new DialogsUI();
    
    public void panelChangeActionPerformed(java.awt.event.MouseEvent evt, JPanel parentPanel, JPanel targetPanel, String panel) {
        targetPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CardLayout card = (CardLayout)parentPanel.getLayout();
                card.show(parentPanel, panel);
            }
        });
    }
    
    public void setComboBoxDefaultValue(String NOT_SELECTABLE_OPTION, JComboBox comboBoxName) {
        
        comboBoxName.setModel(new DefaultComboBoxModel<String>() {
          private static final long serialVersionUID = 1L;
          boolean selectionAllowed = true;

          @Override
          public void setSelectedItem(Object anObject) {
            if (!NOT_SELECTABLE_OPTION.equals(anObject)) {
              super.setSelectedItem(anObject);
            } else if (selectionAllowed) {
              // Allow this just once
              selectionAllowed = false;
              super.setSelectedItem(anObject);
            }
          }
        });

        comboBoxName.addItem(NOT_SELECTABLE_OPTION);
    }
    
    public void clearFields(Container container) {
        
        for (Component component : container.getComponents()) {
            switch (component) {
                case JTextField textField -> textField.setText("");
                case JComboBox<?> comboBox -> comboBox.setSelectedIndex(-1);
                case Container subContainer -> clearFields(subContainer);
                default -> {
                    dialogsUI.showErrorDialog("Failed to clear one or more fields");
                }
            }
        }
    } 
    
    public void centerTableValues(JTable tableName) {
        
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        tableName.setDefaultRenderer(String.class, centerRenderer);
        tableName.setDefaultRenderer(Integer.class, centerRenderer);
    }
    
    public void updateTable(JTable tableName, JFrame frame, int[] columnIndices, Object[] newData) {
        
        DefaultTableModel model = (DefaultTableModel) tableName.getModel();
        
        int rowIndex = tableName.getSelectedRow();
        
        if (rowIndex == -1) {
            dialogsUI.showErrorDialog(tableName.getRowCount() == 0 ? "Table is Empty" : "You must select a record");
        } else {
            for (int i = 0; i < columnIndices.length; i++) {
                model.setValueAt(newData[i], rowIndex, columnIndices[i]);
            }
        }
    }
}
  