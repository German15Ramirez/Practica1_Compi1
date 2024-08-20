package source.frontend.PanelReporte;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class OcurrenciaOperadoresMatematicos extends javax.swing.JPanel {

    private List<List<Object>> operadorData;
    private DefaultTableModel model;
    private TableRowSorter<DefaultTableModel> sorter;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;

    public OcurrenciaOperadoresMatematicos() {
        initComponents();
        model = (DefaultTableModel) jTable1.getModel();
        sorter = new TableRowSorter<>(model);
        jTable1.setRowSorter(sorter);
    }

    private void initComponents() {
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        // Configuración del JTable y su modelo
        jTable1.setModel(new DefaultTableModel(
                new Object [][] {},
                new String [] {"Operador", "Cantidad"}
        ) {
            boolean[] canEdit = new boolean [] {
                    false, false
            };

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        // Configuración del layout del JPanel
        setLayout(new BorderLayout());
        add(jScrollPane1, BorderLayout.CENTER);
    }

    public void actualizarTabla(List<List<Object>> operadorList) {
        model.setRowCount(0); // Borra todas las filas existentes en la tabla
        for (List<Object> fila : operadorList) {
            model.addRow(fila.toArray()); // Agrega los nuevos datos a la tabla
        }
        operadorData = operadorList;
        sorter.setModel(model); // Actualiza el sorter con el nuevo modelo
    }

    private void filtrarTablaPorOperador(String operador) {
        if (operador.isEmpty()) {
            sorter.setRowFilter(null);
        } else {
            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + operador, 0));
        }
    }

    private void mostrarContenidoOriginal() {
        sorter.setRowFilter(null); // Muestra todos los datos
    }
}