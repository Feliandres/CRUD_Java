package Formularios;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;

public class Crud_Productos extends JFrame {
    private JPanel Crud_Panel;
    private JTextField idTF;
    private JTextField nombreTF;
    private JTextField ciudadTF;
    private JTextField precioTF;
    private JTextField cantidadTF;
    private JTable productos_table;
    private JButton guardarBTN;
    private JButton modificatBTN;
    private JButton eliminarBTN;
    private JButton limpiarBTN;
    private JLabel tituloTxt;
    private JButton cerrar_sesionBTN;

    // NOMBRE DE LAS COLUMNAS DE LA TABLA
    String header[] = {"ID","Nombre","Ciudad","Precio","Cantidad"};

    // DECLARAR VARIABLES PARA CONEXION Y USO BASE DE DATOS
    PreparedStatement pst;
    ResultSet rs;
    Connection con;
    ResultSetMetaData rsmd;


    public Crud_Productos () {

        setContentPane(Crud_Panel);
        setTitle("Productos");
        setSize(800,500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null); // centrar la pantalla
        idTF.setEnabled(false);
        cargarTabla(); // carga el contenido de la tabla

        // FUNCION BOTON GUARDAR
        guardarBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Create();
            }
        });

        // FUNCION DE LA JTABLE
        productos_table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                interaccionTabla();
            }
        });

        // FUNCION BOTON MODIFICAR
        modificatBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Actualizar();
            }
        });

        // FUNCION BOTON ELIMINAR
        eliminarBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Eliminar();
            }
        });

        // FUNCION BOTON LIMPIAR
        limpiarBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Limpiar();
            }
        });

        // FUNCION BOTON SALIR
        cerrar_sesionBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Crud_Productos.this.setVisible(false);
                Login login = new Login();
                login.setVisible(true);
            }
        });
    }

    // FUNCION QUE CREA EL NOMBRE DE LAS COLUMNAS DE LA JTABLE
    private void createUIComponents () {
        // TODO: place custom component creation code here
        DefaultTableModel model = new DefaultTableModel(0,5);
        model.setColumnIdentifiers(header);
        productos_table = new JTable(model);

    }

    public void Create () {
        String nombre = nombreTF.getText();
        String ciudad = ciudadTF.getText();
        Double precio = Double.parseDouble(precioTF.getText());
        Integer cantidad = Integer.parseInt(cantidadTF.getText());

        try {

            con = DriverManager.getConnection("jdbc:mysql://localhost/mitienda?serverTimezone=UTC","root","");
            pst = con.prepareStatement("INSERT INTO productos (pnombre,pciudad,pprecio,pcantidad) VALUES (?,?,?,?)");

            pst.setString(1,nombre);
            pst.setString(2,ciudad);
            pst.setDouble(3,precio);
            pst.setInt(4,cantidad);
            pst.executeUpdate();

            JOptionPane.showMessageDialog(null,"Producto Guardado","Producto Guardado",JOptionPane.PLAIN_MESSAGE, icono("/images/exitoso.png",64,64));
            Limpiar();
            cargarTabla();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.toString());
            JOptionPane.showMessageDialog(null, "Error al guardar producto","Error Producto",JOptionPane.PLAIN_MESSAGE, icono("/images/error.png",64,64));
            Limpiar();
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

    public void Limpiar() {
        idTF.setText("");
        nombreTF.setText("");
        ciudadTF.setText("");
        precioTF.setText("");
        cantidadTF.setText("");
    }

    public void cargarTabla(){

        DefaultTableModel model = (DefaultTableModel) productos_table.getModel(); // casteo
        model.setRowCount(0); // limpiar tabla

        int columnas;

        int[] anchos = {10,100,50,20,20};
        for (int i=0;i<productos_table.getColumnCount();i++){
            productos_table.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]); // asignar el ancho
        }

        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost/mitienda?serverTimezone=UTC","root","");
            pst = con.prepareStatement("SELECT * from productos");

            rs = pst.executeQuery();
            rsmd = rs.getMetaData();
            columnas = rsmd.getColumnCount();

            while(rs.next()){
                Object[] fila = new Object[columnas];

                for (int indice=0; indice<columnas; indice++) {
                    fila[indice] = rs.getObject(indice + 1);
                }
                model.addRow(fila);
            }

        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
            JOptionPane.showMessageDialog(null,"Error al cargar tabla","Error Tabla",JOptionPane.PLAIN_MESSAGE, icono("/images/error.png",64,64));
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

    public void interaccionTabla() {
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost/mitienda?serverTimezone=UTC","root","");

            int fila = productos_table.getSelectedRow();
            int id = Integer.parseInt(productos_table.getValueAt(fila,0).toString());

            pst = con.prepareStatement("SELECT * from productos where pid = ?");
            pst.setInt(1,id);
            rs = pst.executeQuery();

            while (rs.next()){
                idTF.setText(String.valueOf(id));
                nombreTF.setText(rs.getString("pnombre"));
                ciudadTF.setText(rs.getString("pciudad"));
                precioTF.setText(rs.getString("pprecio"));
                cantidadTF.setText(rs.getString("pcantidad"));
            }


        }catch (Exception e){
            JOptionPane.showMessageDialog(null,e.toString());
            JOptionPane.showMessageDialog(null,"Error seleccion de la tabla","Error de seleccion",JOptionPane.PLAIN_MESSAGE, icono("/images/error.png",64,64));

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

    public void Actualizar() {

        int id = Integer.parseInt(idTF.getText());
        String nombre = nombreTF.getText();
        String ciudad = ciudadTF.getText();
        Double precio = Double.parseDouble(precioTF.getText());
        Integer cantidad = Integer.parseInt(cantidadTF.getText());

        try {

            con = DriverManager.getConnection("jdbc:mysql://localhost/mitienda?serverTimezone=UTC","root","");
            pst = con.prepareStatement("UPDATE productos SET pnombre = ?, pciudad = ?, pprecio = ?, pcantidad = ? where pid = ?");

            pst.setString(1,nombre);
            pst.setString(2,ciudad);
            pst.setDouble(3,precio);
            pst.setInt(4,cantidad);
            pst.setInt(5,id);
            pst.executeUpdate();

            JOptionPane.showMessageDialog(null,"Producto Modificado","Producto Modificado",JOptionPane.PLAIN_MESSAGE, icono("/images/exitoso.png",64,64));
            Limpiar();
            cargarTabla();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.toString());
            JOptionPane.showMessageDialog(null,"Error al actualizar producto","Error de Actualizacion",JOptionPane.PLAIN_MESSAGE, icono("/images/error.png",64,64));
            Limpiar();
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

    public void Eliminar () {

        int id = Integer.parseInt(idTF.getText());

        try {

            con = DriverManager.getConnection("jdbc:mysql://localhost/mitienda?serverTimezone=UTC","root","");
            pst= con.prepareStatement("DELETE FROM productos where pid =? ");

            pst.setInt(1,id);
            pst.executeUpdate();

            JOptionPane.showMessageDialog(null,"Producto Eliminado","Producto Eliminado",JOptionPane.PLAIN_MESSAGE, icono("/images/exitoso.png",64,64));
            Limpiar();
            cargarTabla();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.toString());
            JOptionPane.showMessageDialog(null,"Error al eliminar producto","Error al eliminar",JOptionPane.PLAIN_MESSAGE, icono("/images/error.png",64,64));
            Limpiar();
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

    // CAMBIAR ICONO DE JOPTIONPANE
    public Icon icono (String path, int widht, int height) {

        Icon img = new ImageIcon(new ImageIcon(getClass().getResource(path)).getImage().getScaledInstance(widht,height, Image.SCALE_SMOOTH));
        return img;
    }

    // MAIN
    public static void main(String[] args) {
        //Crud_Productos crud_productos = new Crud_Productos();

    }

}
