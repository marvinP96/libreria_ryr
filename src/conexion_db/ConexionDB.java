/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion_db;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

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
   
   public String procedureAggProd(String nombre,String fecha,Double precio,Integer existencia,Integer idProv,Integer idCat)
   {
       
       String resultado=null;
       try {            
           
            CallableStatement proc = conn.prepareCall("{CALL aggprodpro(?,?,?,?,?,?,?)}");
            proc.setString("NOMBRE_PROD",nombre );
            proc.setString("FECHA_INGRESO_PROD",fecha );
            proc.setDouble("PRECIO_PROD",precio );
            proc.setInt("EXISTENCIA_PROD",existencia );
            proc.setInt("ID_PROVEEDOR",idProv );
            proc.setInt("ID_CAT_PRODUCTO",idCat );
            proc.registerOutParameter("msj", java.sql.Types.VARCHAR);
            proc.executeQuery();            
            
            resultado = proc.getString("msj");
        } 
       catch (Exception e) {                  
            JOptionPane.showMessageDialog(null, e);
       }
       return resultado;
   }
   
   public String procedureAggProdaVenta(Integer idVenta,Integer idProd,Double PrecioU,Integer Cantidad)
   {
       
       String resultado=null;
       try {            
           
            CallableStatement proc = conn.prepareCall("{CALL Gventa(?,?,?,?,?)}");
            proc.setInt("ID_VENTA",idVenta );
            proc.setInt("ID_PRODUCTO",idProd );
            proc.setDouble("PRECIO_UNI_VENT",PrecioU );
            proc.setInt("CANTIDAD_VENTA",Cantidad );
            proc.registerOutParameter("msj", java.sql.Types.VARCHAR);
            proc.executeQuery();            
            
            resultado = proc.getString("msj");
        } 
       catch (Exception e) {                  
            JOptionPane.showMessageDialog(null, e);
       }
       return resultado;
   }
   
   
   
   public String[] procIniciarVenta(String fecha,Integer total,Integer id_empleado)
   {
       
       //String resultado=null;
       String[] retorno = new String[3];
       try {            
           
            CallableStatement proc = conn.prepareCall("{CALL iniciarVenta(?,?,?,?,?)}");
            proc.setString("FECHA_VENT",fecha );
            proc.setInt("TOTAL_VENT",total );
            proc.setInt("ID_EMPLEADO",id_empleado );
            proc.registerOutParameter("msj", java.sql.Types.VARCHAR);
            proc.registerOutParameter("ultimoIdV", java.sql.Types.VARCHAR);
            proc.executeQuery();            
            
            //resultado = proc.getString("msj");
            retorno[0]= proc.getString("msj");
            //En este caso retornamos el parametro 5 (ultimo id de venta)
            retorno[1]=proc.getString("ultimoIdV");
        } 
       catch (Exception e) {                  
            JOptionPane.showMessageDialog(null, e);
       }
       return retorno;
   }
   
   public ResultSet selectfact(String _idVenta){
       ResultSet rs=null;
       try{
           PreparedStatement sql=conn.prepareStatement("select dv.id_venta,pd.nombre_prod,dv.precio_uni_vent,dv.cantidad_venta from detalle_venta dv\n" +
                                                       "join producto pd on pd.id_producto=dv.id_producto\n" +
                                                       "join venta vt on vt.id_venta=dv.id_venta\n" +
                                                       "where vt.id_venta=?");
           sql.setString(1,_idVenta);
           rs=sql.executeQuery();
       }catch(Exception e){
           
       }
       return rs;
   }
   public ResultSet selectcliente(String _Nregistro){
       ResultSet rs=null;
       try{
           PreparedStatement sql1=conn.prepareStatement("select * from cliente where n_registro_clie=?");
           sql1.setString(1,_Nregistro);
           rs=sql1.executeQuery();
       }catch(Exception e){
           
       }
       return rs;
   }
   
   
   
   
   
   
   
   
   
   
   
   
   


}
