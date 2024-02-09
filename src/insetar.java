import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class insetar extends JFrame{
    private JButton insertarButton;
    private JTextField valUsuario;
    private JTextField valCodigo;
    private JTextField valCedula;
    private JPasswordField valPassword;
    private JComboBox rol;
    private JPanel panel1;

    public void insertarDatos(Connection conn,  String usuario, int codigo, int cedula, double password){
        String query = "Insert into calificaciones(id, nombre, cedula, calificacion1) values (?,?,?,?)";
        try {
            PreparedStatement statement =  conn.prepareStatement(query);
            statement.setInt(1,codigo);
            statement.setString(2,usuario);
            statement.setInt(3,cedula);
            statement.setDouble(4,password);
            int rowInserted = statement.executeUpdate();
            if (rowInserted > 0){
                JOptionPane.showMessageDialog(null,"Se inserto un nuevo registro");
            }
        }catch (SQLException error){
            JOptionPane.showMessageDialog(null, "Error al ingresar datos");
        }

    }

    public insetar() {
        super("Ingresar Datos");
        setContentPane(panel1);
        insertarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login log = new login();
                Connection conexion =  log.conectar();
                String user = valUsuario.getText();
                int cod = Integer.parseInt(valCodigo.getText());
                int cedula =  Integer.parseInt(valCedula.getText());
                double pass= Double.parseDouble(valPassword.getText());
                insertarDatos(conexion, user, cod, cedula, pass);
                mostrar datos = new mostrar();
                datos.iniciar();
            }
        });
    }

    public void iniciar(){
        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
    }
}
