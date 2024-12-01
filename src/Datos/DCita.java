package Datos;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DCita {
    private DConexion conn;
    private int id_Number;
    private String fecha_hora_DateTime;
    private String estado;
    private int id_paciente_int;
    private int id_medico_int;

    public DCita() {
        conn = new DConexion();
    }

    public void setIdNumber(int id_Number) {
        this.id_Number = id_Number;
    }

    public void setFechaHoraDateTime(String fecha_hora_DateTime) {
        this.fecha_hora_DateTime = fecha_hora_DateTime;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setIdPacienteInt(int id_paciente_int) {
        this.id_paciente_int = id_paciente_int;
    }

    public void setIdMedicoInt(int id_medico_int) {
        this.id_medico_int = id_medico_int;
    }

    public void insertarCita() throws Exception {
        String sql = "INSERT INTO citas (id, fecha_hora, estado, id_paciente, id_medico) VALUES ('" + this.id_Number + "', '" + this.fecha_hora_DateTime + "', '" + this.estado + "', '" + this.id_paciente_int + "', '" + this.id_medico_int + "')";
        conn.insertDate(sql);
    }

    public void actualizarCita(int id_Number, String fecha_hora_DateTime, String estado, int id_paciente_int, int id_medico_int) throws Exception {
        String sql = "UPDATE citas SET fecha_hora_DateTime = '" + fecha_hora_DateTime + "', estado = '" + estado + "', id_paciente_int = '" + id_paciente_int + "', id_medico_int = '" + id_medico_int + "' WHERE id_Number = " + id_Number;
        conn.updateDate(sql);
    }

    public void eliminarCita(String id_Number) throws Exception {
        String sql = "DELETE FROM citas WHERE id = " + id_Number;
        conn.deleteDate(sql);
    }

    public ResultSet obtenerCitas() throws Exception {
        String sql = "SELECT * FROM citas";
        return conn.showDate(sql);
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

public ResultSet obtenerCitaPorId(String id) throws Exception {
    String sql = "SELECT * FROM citas WHERE id = '" + id + "'";
    return conn.showDate(sql);
}
public void editarCargo(String id, String value) throws Exception {
    String sql = "UPDATE citas SET estado = '" + value + "' WHERE id = " + id;
    conn.updateDate(sql);
}

}