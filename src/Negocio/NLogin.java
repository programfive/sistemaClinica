package Negocio;

import Datos.DConexion;
import Datos.DLogin;

public class NLogin {
    private DLogin dLogin;
    private DConexion conexion;

    public NLogin() {
        this.conexion = new DConexion();
        this.dLogin = new DLogin(conexion);
    }

    public boolean autenticarUsuario(String usuario, String password) {
        if (usuario == null || usuario.trim().isEmpty()) {
            return false;
        }
        
        if (password == null || password.trim().isEmpty()) {
            return false;
        }
         
        return dLogin.verificarUsuario(usuario, password);
    }
}