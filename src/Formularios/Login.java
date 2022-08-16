package Formularios;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame{
    private JPanel Main_Login;
    private JButton inicia_sesionBTN;
    private JLabel Login_PNG;
    private JLabel Email_PNG;
    private JLabel Password_PNG;
    private JButton registrarseBTN;
    private JPasswordField passwordTF;
    private JLabel passwordTxt;
    private JLabel emailTxt;
    private JTextField email_TF;
    private JPanel Titulo_Panel;
    private JLabel UsuarioTxt;
    private JLabel accesoTxt;
    private JPanel Logo_Panel;
    private JPanel Subtitulo_Panel;
    private JPanel Registrarse_Panel;
    private JPanel iniciar_sesion_Panel;
    private JPanel Campos_Panel;
    private JButton salirButton;


    public Login () {
        setContentPane(Main_Login);
        setTitle("Login");
        setSize(460,560);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null); // centrar la pantalla

        // FUNCION BOTON REGISTRARSE
        registrarseBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login.this.setVisible(false);
                Register register = new Register();
                register.setVisible(true);
            }

        // FUNCION BOTON INICIAR SESION
        });

        // FUNCION BOTON INICIAR SESION
        inicia_sesionBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SQL_usuarios sqlUsuarios = new SQL_usuarios();
                Usuarios usuarios = new Usuarios();

                String password = passwordTF.getText();

                if(!email_TF.getText().equals("") && !password.equals("")) {
                    usuarios.setEmail(email_TF.getText());
                    usuarios.setPassword(password);

                    if (sqlUsuarios.iniciarSesion(usuarios)){

                        JOptionPane.showMessageDialog(null,"Inicio de Sesion Correctamente","Login Exitoso",JOptionPane.PLAIN_MESSAGE, icono("/images/exitoso.png",64,64));
                        Login.this.setVisible(false);
                        Crud_Productos crud_productos = new Crud_Productos();
                        crud_productos.setVisible(true);




                    } else {
                        JOptionPane.showMessageDialog(null,"Datos Incorrectos","Email o Contraseña incorrectos",JOptionPane.PLAIN_MESSAGE, icono("/images/error.png",64,64));
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Debe ingresar sus datos","Completar los campos",JOptionPane.PLAIN_MESSAGE, icono("/images/error.png",64,64));
                }

            }
        });

        // FUNCION BOTON SALIR
        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login.this.dispose();
                Login.this.setVisible(false);
                Login.this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            }
        });
    }

    // CAMBIAR ICONO DE JOPTIONPANE
    public Icon icono (String path, int widht, int height) {

        Icon img = new ImageIcon(new ImageIcon(getClass().getResource(path)).getImage().getScaledInstance(widht,height, Image.SCALE_SMOOTH));
        return img;
    }

    // MAIN
    public static void main(String[] args) {
        Login login = new Login();
    }

}