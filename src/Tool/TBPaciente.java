/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tool;

import Negocio.NPaciente;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author josue
 */
public class TBPaciente {


   public void cargarPacientes(javax.swing.JTable tbPaciente) {
        try {
            NPaciente negocioPaciente = new NPaciente();
            List<Object[]> medicos = negocioPaciente.mostrarPacientes();

            DefaultTableModel model = (DefaultTableModel) tbPaciente.getModel();
            model.setRowCount(0); 

            for (Object[] medico : medicos) {
                model.addRow(medico);
            }
        } catch (Exception e) {
            System.out.println("error en este codigo");
        }
    }

}
