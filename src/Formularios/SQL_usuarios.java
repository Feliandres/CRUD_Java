package Formularios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SQL_usuarios extends Conexion{
    public boolean registrar(Usuarios usr) {

        PreparedStatement pst = null;
        Connection con = getConexion();

        String sql = "insert into usuarios (nom_usuario,apel_usuario,mail_usuario,cell_usuario,password_usuario,confirm_password_usuario)values (?,?,?,?,?,?)";

        try {
            pst = con.prepareStatement(sql);
            pst.setString(1,usr.getNombre());
            pst.setString(2,usr.getApellido());
            pst.setString(3,usr.getEmail());
            pst.setString(4,usr.getCelular());
            pst.setString(5,usr.getPassword());
            pst.setString(6,usr.getConfirm_password());
            pst.execute();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(SQL_usuarios.class.getName()).log(Level.SEVERE,null,ex);
            return false;
        }
    }

    public int existenciaUsuario(String email) {

        PreparedStatement pst = null;
        ResultSet rs = null;
        Connection con = getConexion();

        String sql = "SELECT count(mail_usuario) FROM usuarios WHERE mail_usuario = ?";

        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, email);
            rs = pst.executeQuery();

            if (rs.next()){
                return rs.getInt(1);
            }
            return 1;

        } catch (SQLException ex) {
            Logger.getLogger(SQL_usuarios.class.getName()).log(Level.SEVERE,null,ex);
            return 1;
        }
    }

    public boolean esEmail(String email) {
        // Patron para validar el email
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher mather = pattern.matcher(email);
        return mather.find();
    }

    public boolean iniciarSesion(Usuarios usr) {

        PreparedStatement pst = null;
        ResultSet rs = null;
        Connection con = getConexion();

        String sql = "SELECT nom_usuario,apel_usuario,mail_usuario, password_usuario FROM usuarios WHERE mail_usuario = ?";

        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, usr.getEmail());
            rs = pst.executeQuery();

            if (rs.next()){
                if(usr.getPassword().equals(rs.getString(4))){

                    /*usr.setNombre(rs.getString(1));
                    usr.setApellido(rs.getString(2));*/
                    return true;

                } else {
                    return false;
                }
            }
            return false;

        } catch (SQLException ex) {
            Logger.getLogger(SQL_usuarios.class.getName()).log(Level.SEVERE,null,ex);
            return false;
        }
    }

}
