package Negocio;

import Datos.DMedico;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class NMedico {
     DMedico dmedico;


    public NMedico() {
          dmedico = new DMedico();

    }
      public void NModificarDoctor(String idDoctor, String nom, String Apell, String direccion , String telefono ) throws Exception {
        dmedico.actualizarMedico(idDoctor, nom, Apell, direccion, telefono);
    }
 public void NInsertarMedico(String nom, String apellido, String  direccion , String telefono) throws Exception {
       dmedico.setNombre(nom);
       dmedico.setApellido(apellido);
       dmedico.setDireccion(direccion);
       dmedico.setTelefono(telefono);
       dmedico.insertarMedico();
    }
 
     public List<Object[]> mostrarMedico() throws Exception {
        ResultSet rs = dmedico.obtenerMedicos();
        List<Object[]> medicos = new ArrayList<>();

        while (rs.next()) {
            Object[] medico = new Object[5];
            medico[0] = rs.getInt("id");
            medico[1] = rs.getString("nombre");
            medico[2] = rs.getString("apellido");
            medico[3] = rs.getString("direccion");
            medico[4] = rs.getString("telefono");
            medicos.add(medico);
        }
    
    return medicos;
}
     public void NEliminarMedico(String idMedico) throws Exception {
        dmedico.eliminarMedico(idMedico);
    }

}
