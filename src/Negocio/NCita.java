package Negocio;

import Datos.DCita;
import Datos.DConexion;
import Datos.DMedico;
import Datos.DPaciente;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class NCita {
    private DCita dcita;
    private DConexion conexion;

    public NCita() {
        dcita = new DCita();
         this.conexion = new DConexion();
    }

    public void NInsertarCita(int id_Number, String fecha_hora_DateTime, String estado, int id_paciente_int, int id_medico_int) throws Exception {
        dcita.setIdNumber(id_Number);
        dcita.setFechaHoraDateTime(fecha_hora_DateTime);
        dcita.setEstado(estado);
        dcita.setIdPacienteInt(id_paciente_int);
        dcita.setIdMedicoInt(id_medico_int);
        dcita.insertarCita();
    }

    public void NActualizarCita(int id_Number, String fecha_hora_DateTime, String estado, int id_paciente_int, int id_medico_int) throws Exception {
        dcita.actualizarCita(id_Number, fecha_hora_DateTime, estado, id_paciente_int, id_medico_int);
    }

    public void NEliminarCita(String id) throws Exception {
        dcita.eliminarCita(id);
    }

public List<Object[]> mostrarCitas() throws Exception {
    ResultSet rs = dcita.obtenerCitas();
    List<Object[]> citas = new ArrayList<>();
    while (rs.next()) {
        Object[] cita = new Object[5];
        cita[0] = rs.getInt("id");
        
        String idPaciente = String.valueOf(rs.getInt("id_paciente"));
        String idMedico = String.valueOf(rs.getInt("id_medico"));
      
        String nombrePaciente = obtenerNombrePaciente(idPaciente);
        String nombreMedico = obtenerNombreMedico(idMedico);
        
        cita[1] = nombrePaciente;  
        cita[2] = nombreMedico;   
        cita[3] = rs.getString("fecha_hora");
        cita[4] = rs.getString("estado");
        
        citas.add(cita);
    }
    return citas;
}
    
    private String obtenerNombrePaciente(String idPaciente) throws Exception {
        DPaciente dpaciente = new DPaciente();
    ResultSet rs = dpaciente.obtenerPacientePorId(idPaciente);
    if (rs.next()) {
        return rs.getString("nombre") + " " + rs.getString("apellido");
    }
    return "Paciente Desconocido";
}

private String obtenerNombreMedico(String idMedico) throws Exception {
    DMedico dmedico = new DMedico();
    ResultSet rs = dmedico.obtenerMedicoPorId(idMedico);
    if (rs.next()) {
        return rs.getString("nombre") + " " + rs.getString("apellido");
    }
    return "Médico Desconocido";
}
public void NEditarCargo(String id, String value) throws Exception {
    dcita.editarCargo(id, value);
}
}