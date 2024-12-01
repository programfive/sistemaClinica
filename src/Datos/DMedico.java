package Datos;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DMedico {
    private DConexion conn;
    String id;
    String nombre;
    String apellido;
    String direccion;
    String telefono;
    public DMedico() {
        conn = new DConexion();
    }



    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void insertarMedico() throws Exception {

            String sql = "INSERT INTO medico (nombre, apellido, direccion, telefono) VALUES ('" + this.nombre + "', '" +this.apellido + "', '" +this.direccion + "', '" +this.telefono + "')";
            conn.insertDate(sql);
         
    }

    public void actualizarMedico(String id, String nombre, String apellido, String direccion, String telefono) throws Exception {
 
            String sql = "UPDATE medico SET nombre = '" + nombre + "', apellido = '" + apellido + "', direccion = '" + direccion + "', telefono = '" + telefono + "' WHERE id = " + id;
            System.out.println(sql);
            conn.updateDate(sql);
        
    }

    public void eliminarMedico(String id) throws Exception {

            String sql = "DELETE FROM medico WHERE id = " + id;
            conn.deleteDate(sql);
    
    }

    public ResultSet obtenerMedicos() throws Exception {
        String sql = "SELECT * FROM medico";
        return conn.showDate(sql);
    }

public ResultSet obtenerMedicoPorId(String id) throws Exception {
    String sql = "SELECT * FROM medico WHERE id = '" + id + "'";
    return conn.showDate(sql);
}
}