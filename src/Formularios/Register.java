package Formularios;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Register extends JFrame {
    private JTextField reg_nombreTF;
    private JTextField reg_apellidoTF;
    private JTextField reg_mailTF;
    private JTextField reg_celularTF;
    private JButton volverBTN;
    private JButton guardarBTN;
    private JPanel Main_Register;
    private JPasswordField reg_passwordTF;
    private JPanel registro_Panel;
    private JLabel RegistroTxt;
    private JLabel nombreTxt;
    private JLabel apellidoTxt;
    private JLabel email_regTxt;
    private JLabel celularTxt;
    private JLabel password_regTxt;
    private JPanel Botones_Reg_Panel;
    private JPanel Titulo_Panel;
    private JPasswordField reg_confirm_passwordTF;

    public Register () {

        setContentPane(Main_Register);
        setTitle("Register");
        setSize(400,400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null); // centrar la pantalla

        // FUNCION BOTON VOLVER
        volverBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Register.this.setVisible(false);
                Login login = new Login();
                login.setVisible(true);
            }
        });

        // FUNCION BOTON GUARDDAR
        guardarBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarUsuario();
            }

        });

    }

    public void guardarUsuario () {
        SQL_usuarios sqlUsuarios = new SQL_usuarios();
        Usuarios usuarios = new Usuarios();
        String password1 = reg_passwordTF.getText(), password2 = reg_confirm_passwordTF.getText();

        if (reg_nombreTF.getText().equals("") || reg_apellidoTF.getText().equals("") || reg_mailTF.getText().equals("")
                || reg_celularTF.getText().equals("") || reg_passwordTF.getText().equals("")
                || reg_confirm_passwordTF.getText().equals("")) {
            JOptionPane.showMessageDialog(null,"Hay campos vacios. Debe llenar todos los campos","Campos en blanco",JOptionPane.PLAIN_MESSAGE, icono("/images/error.png",64,64));

        } else {

            if (password1.equals(password2)) {

                if (sqlUsuarios.existenciaUsuario(reg_mailTF.getText())== 0) {

                    if (sqlUsuarios.esEmail(reg_mailTF.getText())) {


                        usuarios.setNombre(reg_nombreTF.getText());
                        usuarios.setApellido(reg_apellidoTF.getText());
                        usuarios.setEmail(reg_mailTF.getText());
                        usuarios.setCelular(reg_celularTF.getText());
                        usuarios.setPassword(reg_passwordTF.getText());
                        usuarios.setConfirm_password(reg_confirm_passwordTF.getText());

                        if (sqlUsuarios.registrar(usuarios)) {
                            //confirm_registroTxt.setText("Guardado Existosamente");
                            JOptionPane.showMessageDialog(null,"Guardado Correctamente","Guardado Correctamente",JOptionPane.PLAIN_MESSAGE, icono("/images/disquete.png",64,64));
                            Limpiar();

                        } else {
                            //confirm_registroTxt.setText("Error al guardar");
                            JOptionPane.showMessageDialog(null, "Error al guardar","Error",JOptionPane.PLAIN_MESSAGE, icono("/images/error.png",64,64));
                            Limpiar();
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "El email no es valido","Error email",JOptionPane.PLAIN_MESSAGE, icono("/images/email_error.png",64,64));
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "El usuario ya existe","Error usuario",JOptionPane.PLAIN_MESSAGE, icono("/images/usuario_error.png",64,64));

                }
            } else {
                JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden, verifique de nuevo","Error contraseñas",JOptionPane.PLAIN_MESSAGE, icono("/images/password_error.png",64,64));
            }
        }

    }

    public void Limpiar () {
        reg_nombreTF.setText("");
        reg_apellidoTF.setText("");
        reg_mailTF.setText("");
        reg_celularTF.setText("");
        reg_passwordTF.setText("");
        reg_confirm_passwordTF.setText("");
    }

    // CAMBIAR ICONO DE JOPTIONPANE
    public Icon icono (String path, int widht, int height) {

        Icon img = new ImageIcon(new ImageIcon(getClass().getResource(path)).getImage().getScaledInstance(widht,height, Image.SCALE_SMOOTH));
        return img;
    }

    // MAIN
    public static void main(String[] args) {
        //Register register = new Register();
    }

}
