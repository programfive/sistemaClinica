package Datos;
import java.sql.*;
public class DConexion
{
    static String bd="Clinica";
    static String usuario="root";
    static String clave="";
    static String url = "jdbc:mysql://localhost:3306/" + bd + "?serverTimezone=UTC";
    static String dirDriv="com.mysql.cj.jdbc.Driver";
    protected Connection conn;
    protected Statement stmt;
    
    public void conectar ()throws Exception
    {
        Class.forName(dirDriv);
        this.conn =DriverManager.getConnection(url,usuario,clave);
        this.stmt=conn.createStatement();
        System.out.println("Conecto con exito");
    }
    public void desconectar()throws Exception
    {
        if(stmt != null && conn!=null)
        {
            try
            {
                this.stmt.close();
                this.conn.close();
            }
            catch (SQLException e)
            {
                System.err.println(e);
            }
        }
    }
    public void insertDate(String sql) throws Exception
    {
        conectar();
        stmt.execute(sql);
        desconectar();
    }
    public void updateDate (String sql) throws Exception
    {
        conectar();
        stmt.executeUpdate(sql);
        desconectar();
    }
    public void deleteDate (String sql) throws Exception
    {
        conectar();
        stmt.executeUpdate(sql);
        desconectar();
    }
    public ResultSet showDate(String sql) throws Exception
    {
        conectar();
        ResultSet rs = stmt.executeQuery(sql);
        return rs;

    }
}