/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion_db;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Miguel Benavides
 */
public class ConexionDB {
 private String login = "RYR";
  private String password = "1234";
  private String url = "jdbc:oracle:thin:@localhost:1521:XE";
  private Connection conn = null;
//___________________________________________________________________________________ Soy una barra separadora ??
  //Constructor de la clase que se conecta a la base de datos una vez que se crea la instancia
  public ConexionDB(){
      try{         
         Class.forName("oracle.jdbc.driver.OracleDriver");         
         conn = DriverManager.getConnection(url,login,password);         
      }catch(SQLException e){
         System.out.println(e);
      }catch(ClassNotFoundException e){
         System.out.println(e);
      }
    }
  
  
   public String procedureVenta(String fecha,Integer total,Integer id_empleado)
   {
       
       String resultado=null;
       try {            
           
            CallableStatement proc = conn.prepareCall("{CALL ventapro(?,?,?,?)}");
            proc.setString("FECHA_VENT",fecha );
            proc.setInt("TOTAL_VENT",total );
            proc.setInt("ID_EMPLEADO",id_empleado );
            proc.registerOutParameter("msj", java.sql.Types.VARCHAR);
            proc.executeQuery();            
            
            resultado = proc.getString("msj");
        } 
       catch (Exception e) {                  
            JOptionPane.showMessageDialog(null, e);
       }
       return resultado;
   }

}
