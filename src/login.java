import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Objects;

public class login extends JFrame{
    private JButton verificarButton;
    private JTextField valHost;
    private JTextField valPass;
    private JPanel panel1;

    public Connection conexion;

    public Connection conectar(){
        String url = "jdbc:mysql://localhost:3306/conexion_java";
        String hostname = "root";
        String password = "123456";
        conexion = null;
        try{
            conexion = DriverManager.getConnection(url, hostname, password);
            JOptionPane.showMessageDialog(null, "Conexion exitosa con la base de datos");
        } catch (Exception error){
            JOptionPane.showMessageDialog(null, "No se pudo establecer conexion con la base de datos");
        }
        return conexion;
    }

    public boolean validarConexion(){
        String url = "jdbc:mysql://localhost:3306/conexion_java";
        String hostname = valHost.getText();
        String password = valPass.getText();
        Connection conn = null;
        try{
            conn = DriverManager.getConnection(url, hostname, password);
            JOptionPane.showMessageDialog(null, "Conexion exitosa con la base de datos");
            return true;
        } catch (Exception error){
            JOptionPane.showMessageDialog(null, "No se pudo establecer conexion con la base de datos");
            return false;
        }
    }
    public login() {
        super("Login");
        setContentPane(panel1);
        verificarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(validarConexion()){
                    insetar ingresar = new insetar();
                    ingresar.iniciar();
                }else{
                    JOptionPane.showMessageDialog(null, "Datos erroneos");
                    valHost.setText("");
                    valPass.setText("");
                }
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
