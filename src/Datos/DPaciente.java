package Datos;

import java.sql.ResultSet;

/**
 *
 * @author josue
 */
public class DPaciente {
    private DConexion conn;
    String id;
    String nombre;
    String apellido;
    String carnet;

    public DPaciente() {
        conn = new DConexion();
    }

    // Setters
    public void setConn(DConexion conn) {
        this.conn = conn;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    // Métodos CRUD
    public void insertarPaciente() throws Exception {
        String sql = "INSERT INTO paciente (nombre, apellido, carnet) VALUES ('" + 
                     this.nombre + "', '" + this.apellido + "', '" + this.carnet + "')";
        conn.insertDate(sql);
    }

    public void actualizarPaciente(String id, String nombre, String apellido, String carnet) throws Exception {
        String sql = "UPDATE paciente SET nombre = '" + nombre + 
                     "', apellido = '" + apellido + 
                     "', carnet = '" + carnet + 
                     "' WHERE id = '" + id + "'";
        conn.updateDate(sql);
    }

    public void eliminarPaciente(String id) throws Exception {
        String sql = "DELETE FROM paciente WHERE id = '" + id + "'";
        conn.deleteDate(sql);
    }

    public ResultSet obtenerPacientes() throws Exception {
        String sql = "SELECT * FROM paciente";
        return conn.showDate(sql);
    }
}
