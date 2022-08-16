package Formularios;

import javax.swing.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SQL_usuarios {

    PreparedStatement pst;
    ResultSet rs;
    Connection con;

    // FUNCION PARA REGISTRAR USUARIOS
    public boolean registrar(Usuarios usr) {

        pst = null;

        String sql = "insert into usuarios (nom_usuario,apel_usuario,mail_usuario,cell_usuario,password_usuario,confirm_password_usuario)values (?,?,?,?,?,?)";

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/crud_java?serverTimezone=UTC","root","");
            pst = con.prepareStatement(sql);
            pst.setString(1,usr.getNombre());
            pst.setString(2,usr.getApellido());
            pst.setString(3,usr.getEmail());
            pst.setString(4,usr.getCelular());
            pst.setString(5,usr.getPassword());
            pst.setString(6,usr.getConfirm_password());
            pst.execute();
            return true;

        } catch (Exception e) {
            Logger.getLogger(SQL_usuarios.class.getName()).log(Level.SEVERE,null,e);
            JOptionPane.showMessageDialog(null, "Error");
            return false;
        } finally {
            try {
                pst.close();
                rs.close();
                con.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error");
            }
        }
    }

    // FUNCION PARA VERIFICAR SI UN USUARIO EXISTE EN LA BASE DE DATOS
    public int existenciaUsuario(String email) {

        pst = null;
        rs = null;
        String sql = "SELECT count(mail_usuario) FROM usuarios WHERE mail_usuario = ?";

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/crud_java?serverTimezone=UTC","root","");
            pst = con.prepareStatement(sql);
            pst.setString(1, email);
            rs = pst.executeQuery();

            if (rs.next()){
                return rs.getInt(1);
            }
            return 1;

        } catch (Exception e) {
            Logger.getLogger(SQL_usuarios.class.getName()).log(Level.SEVERE,null,e);
            JOptionPane.showMessageDialog(null, "Error");
            return 1;
        } finally {
            try {
                pst.close();
                rs.close();
                con.close();
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null, "Error");
            }
        }
    }

    // FUNCION PARA COMPROBAR LA EL FORMATO DEL EMAIL
    public boolean esEmail(String email) {
        // Patron para validar el email
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher mather = pattern.matcher(email);
        return mather.find();
    }

    // FUNCION PARA QUE LOS USUARIOS PUEDAN LOGUEARSE
    public boolean iniciarSesion(Usuarios usr) {

        pst = null;
        rs = null;
        String sql = "SELECT nom_usuario,apel_usuario,mail_usuario, password_usuario FROM usuarios WHERE mail_usuario = ?";

        try {

            con = DriverManager.getConnection("jdbc:mysql://localhost/crud_java?serverTimezone=UTC","root","");
            pst = con.prepareStatement(sql);
            pst.setString(1, usr.getEmail());
            rs = pst.executeQuery();

            if (rs.next()){
                if(usr.getPassword().equals(rs.getString(4))){
                    return true;

                } else {
                    return false;
                }
            }
            return false;

        } catch (Exception e) {
            Logger.getLogger(SQL_usuarios.class.getName()).log(Level.SEVERE,null,e);
            JOptionPane.showMessageDialog(null, "Error");
            return false;
        } finally {
            try {
                pst.close();
                rs.close();
                con.close();
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null, "Error");
            }
        }
    }

}
