/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Datos.DPaciente;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author josue
 */
public class NPaciente {
         DPaciente dpaciente;

    public NPaciente() {
        dpaciente = new DPaciente();
    }
      public void NModificarPaciente(String idPaciente, String nombre, String apellido, String carnet) throws Exception {
        dpaciente.actualizarPaciente(idPaciente, nombre, apellido, carnet);
    }

    public void NInsertarPaciente(String nombre, String apellido, String carnet) throws Exception {
        dpaciente.setNombre(nombre);
        dpaciente.setApellido(apellido);
        dpaciente.setCarnet(carnet);
        dpaciente.insertarPaciente();
    }

    public List<Object[]> mostrarPacientes() throws Exception {
        ResultSet rs = dpaciente.obtenerPacientes();
        List<Object[]> pacientes = new ArrayList<>();

        while (rs.next()) {
            Object[] paciente = new Object[4];
            paciente[0] = rs.getInt("id");
            paciente[1] = rs.getString("nombre");
            paciente[2] = rs.getString("apellido");
            paciente[3] = rs.getString("carnet");
            pacientes.add(paciente);
        }

        return pacientes;
    }

    public void NEliminarPaciente(String idPaciente) throws Exception {
        dpaciente.eliminarPaciente(idPaciente);
    }
         
         
}
