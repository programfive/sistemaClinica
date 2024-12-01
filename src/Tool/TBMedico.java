/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tool;

import Negocio.NMedico;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author josue
 */
public class TBMedico {

    public TBMedico() {
    }

        public void cargarMedicos(javax.swing.JTable tbMedico) {
        try {
            NMedico negocioMedico = new NMedico();
            List<Object[]> medicos = negocioMedico.mostrarMedico();

            DefaultTableModel model = (DefaultTableModel) tbMedico.getModel();
            model.setRowCount(0); 

            for (Object[] medico : medicos) {
                model.addRow(medico);
            }
        } catch (Exception e) {
            System.out.println("error en este codigo");
        }
    }


}
