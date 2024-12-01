package Tool;

import Negocio.NCita;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class TBCita {
    public void cargarCitas(javax.swing.JTable tbCita) {
    try {
        NCita negocioCita = new NCita();
        List<Object[]> citas = negocioCita.mostrarCitas();
        DefaultTableModel model = (DefaultTableModel) tbCita.getModel();
        
        model.setColumnIdentifiers(new String[]{"ID", "Paciente", "Médico", "Fecha/Hora", "Estado"});
        
        model.setRowCount(0); 
        for (Object[] cita : citas) {
            model.addRow(cita);
        }
    } catch (Exception e) {
        System.out.println("Error al cargar las citas: " + e.getMessage());
        e.printStackTrace(); 
    }
}
}