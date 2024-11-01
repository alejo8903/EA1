/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iud.ea1.util;

import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author alejo
 */
public class ModelarTabla {

    private DefaultTableModel model;
    private TableRowSorter<DefaultTableModel> sorter;

    /**
     * Constructor de la clase
     *
     * @param table
     */
    public ModelarTabla(JTable table) {
        this.model = (DefaultTableModel) table.getModel();
        table.setModel(model);
        table.setAutoCreateRowSorter(true);
        sorter = new TableRowSorter<>(model);
        table.setRowSorter(sorter);
    }

    public void filter(String filtro, Integer column) {
        if (column != null) {
            try {
                sorter.setRowFilter(RowFilter.regexFilter(filtro, column));

            } catch (Exception e) {

            }
        }else{
            sorter.setRowFilter(RowFilter.regexFilter(filtro));
        }

    }

    public DefaultTableModel getModel() {
        return this.model;
    }
}
