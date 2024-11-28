package Datos;

import java.sql.ResultSet;

public class DLogin {
    private String nombre = "";
    private String contraseña = "";
    private final DConexion conn;

    public DLogin(DConexion conn) {
        this.conn = conn;
    }

    public boolean verificarUsuario(String usuario, String password) {
        try {
            String sql = "SELECT * FROM usuario WHERE nombre = '" + usuario + "' AND contraceña = '" + password + "'";
             ResultSet rs = conn.showDate(sql);
             boolean usuarioEncontrado = rs.next();
        
            if (rs != null) {
                rs.close();
            }

            return usuarioEncontrado;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}