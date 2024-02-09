import javax.swing.*;
import java.sql.*;

public class mostrar extends JFrame{
    private JPanel panel1;
    private JTextArea datos;

    private JLabel Info;


    public void mostrarDatos(Connection conn){

        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("select * from calificaciones");
            int id;
            String nombre;
            int cedula;
            float calificacion;
            StringBuilder info_completa = new StringBuilder();
            while(rs.next()){
                id = rs.getInt("id");
                nombre = rs.getString("nombre");
                cedula = rs.getInt("cedula");
                calificacion = rs.getFloat("calificacion1");
                info_completa.append("id: ").append(id).append(" ");
                info_completa.append("name: ").append(nombre).append(" ");
                info_completa.append("cedula: ").append(cedula).append(" ");
                info_completa.append("calificacion: ").append(calificacion).append("\n");
            }
            String completo = String.valueOf(info_completa);
            datos.setText(completo);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar los datos");
        }

    }


    public mostrar(){
        super("Mostrar Datos");
        setContentPane(panel1);
        login conn = new login();
        Connection  conexion =  conn.conectar();
        mostrarDatos(conexion);
    }

    public void iniciar(){
        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
    }



}
