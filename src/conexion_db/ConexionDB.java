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
  
  
    public String procedureFactura(Integer idCliente,String fecha,Integer idVenta,Integer TipoFact,Integer NumFact,Integer EstadoFact)
   {
       
       String resultado=null;
       try {            
           
            CallableStatement proc = conn.prepareCall("{CALL GFactura(?,?,?,?,?,?,?)}");
            proc.setInt("ID_CLIENTE", idCliente);
            proc.setString("FECHA_FACT",fecha );
            proc.setInt("ID_VENTA",idVenta );
            proc.setInt("TIPO_FACT", TipoFact);
            proc.setInt("NUMERO_FACT",NumFact );
            proc.setInt("ESTADO_FACT", EstadoFact);
            proc.registerOutParameter("msj", java.sql.Types.VARCHAR);
            proc.executeQuery();            
            
            resultado = proc.getString("msj");
            JOptionPane.showMessageDialog(null, resultado);
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
     //Modifique esto 7/11/2018
   public String procedureAggProdaVenta(Integer idVenta,Integer idProd,Double PrecioU,Integer Cantidad,double total, double subtotal, double iva)
   {
       
       String resultado=null;
       try {            
           
            CallableStatement proc = conn.prepareCall("{CALL Gventa(?,?,?,?,?,?,?,?)}");
            proc.setInt("ID_VENTA",idVenta );
            proc.setInt("ID_PRODUCTO",idProd );
            proc.setDouble("PRECIO_UNI_VENT",PrecioU );
            proc.setInt("CANTIDAD_VENTA",Cantidad );
            proc.setDouble("TOTAL_VENT",total);
            proc.setDouble("SUB_TOTAL",subtotal);
            proc.setDouble("IVA_VENT",iva);
            proc.registerOutParameter("msj", java.sql.Types.VARCHAR);
            proc.executeQuery();            
            
            resultado = proc.getString("msj");
        } 
       catch (Exception e) {                  
            JOptionPane.showMessageDialog(null, e);
       }
       return resultado;
   }
   
   
   //Modifique esto 7/11/2018
   public String[] procIniciarVenta(String fecha,double total,Integer id_empleado,double subtotal, double iva)
   {
       
       //String resultado=null;
       String[] retorno = new String[3];
       try {            
           
            CallableStatement proc = conn.prepareCall("{CALL iniciarVenta(?,?,?,?,?,?,?)}");
            proc.setString("FECHA_VENT",fecha );
            proc.setDouble("TOTAL_VENT",total );
            proc.setInt("ID_EMPLEADO",id_empleado );
            proc.setDouble("SUB_TOTAL",subtotal );
            proc.setDouble("IVA_VENT",iva);
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
   
   public ResultSet selectventafact(String _idVenta){
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
    public ResultSet selectallcliente(){
       ResultSet rs=null;
       try{
           PreparedStatement sql1=conn.prepareStatement("select * from cliente");
           //sql1.setString(1,_Nregistro);
           rs=sql1.executeQuery();
       }catch(Exception e){
           
       }
       return rs;
   }
     public ResultSet selectVenta(String _idVent){
       ResultSet rs1=null;
       try{
           PreparedStatement sql1=conn.prepareStatement("SELECT TOTAL_VENT,IVA_VENT,SUB_TOTAL FROM VENTA WHERE ID_VENTA=?");
           sql1.setString(1,_idVent);
           rs1=sql1.executeQuery();
       }catch(Exception e){
           
       }
       return rs1;
   }
    public ResultSet selectFactFiscal(){
       ResultSet rs=null;
       try{
           PreparedStatement sql1=conn.prepareStatement("select id_factura,nombre_clie,APELLIDO_CLIE,fecha_fact,id_venta,"+
                                                        "tipo_fact,numero_fact,estado_fact from factura fc\n" +
                                                        "join CLIENTE ct on ct.ID_CLIENTE=fc.ID_CLIENTE\n");
           //sql1.setString(1,_Nregistro);
           rs=sql1.executeQuery();
       }catch(Exception e){
           
       }
       return rs;
   }
    public ResultSet selectTipoFact(String _TipoFact){
       ResultSet rs=null;
       try{
           PreparedStatement sql1=conn.prepareStatement("select id_factura,nombre_clie,APELLIDO_CLIE,fecha_fact,id_venta,"+
                                                        "tipo_fact,numero_fact,estado_fact from factura fc\n" +
                                                        "join CLIENTE ct on ct.ID_CLIENTE=fc.ID_CLIENTE\n"+
                                                         "where estado_fact=?");
           sql1.setString(1,_TipoFact);
           rs=sql1.executeQuery();
       }catch(Exception e){
           
       }
       return rs;
   }
     public ResultSet selectFactFiscal1(String nFact){
       ResultSet rs=null;
       try{
           PreparedStatement sql1=conn.prepareStatement("select id_factura,nombre_clie,APELLIDO_CLIE,fecha_fact,id_venta,"+
                                                        "tipo_fact,numero_fact,estado_fact from factura fc\n" +
                                                        "join CLIENTE ct on ct.ID_CLIENTE=fc.ID_CLIENTE\n" +
                                                        "where estado_fact=1 and numero_fact=?");
           sql1.setString(1,nFact);
           rs=sql1.executeQuery();
       }catch(Exception e){
           
       }
       return rs;
   }
   public void UpdateEstadoFact(String _idfact){
       ResultSet rs=null;
       try{
           PreparedStatement sql1=conn.prepareStatement("update factura set estado_fact=0 where id_factura=?");
           sql1.setString(1,_idfact);
           sql1.executeUpdate();
           JOptionPane.showMessageDialog(null, "Factura Actualizada");
       }catch(Exception e){
           
       }
       
   }
   public void UpdateCat(String _idCat,String _nomcat){
       ResultSet rs=null;
       try{
           PreparedStatement sql1=conn.prepareStatement("update cat_producto set nombre_cat_prod=? where id_cat_producto=?");
           sql1.setString(1,_nomcat);
           sql1.setString(2,_idCat);
           sql1.executeUpdate();
           JOptionPane.showMessageDialog(null, "Categoria Actualizada");
       }catch(Exception e){
           
       }
       
   }
   public ResultSet selectAllCat(){
       ResultSet rs=null;
       try{
           PreparedStatement sql1=conn.prepareStatement("select * from cat_producto");
           //sql1.setString(1,_Nregistro);
           rs=sql1.executeQuery();
       }catch(Exception e){
           
       }
       return rs;
   }
   public void UpdateEmp(String _idEmp,String _nomEmp,String _apeEmp,String _dirEmp,String _telEmp){
       ResultSet rs=null;
       try{
           PreparedStatement sql1=conn.prepareStatement("update empleado set nombre_emp=?, apellido_emp=?, direccion_emp=?,"
                                                        + "telefono_emp=? where id_empleado=?");
           sql1.setString(1,_nomEmp);
           sql1.setString(2,_apeEmp);
           sql1.setString(3,_dirEmp);
           sql1.setString(4,_telEmp);
           sql1.setString(5,_idEmp);
           sql1.executeUpdate();
           JOptionPane.showMessageDialog(null, "Empleado Actualizado");
       }catch(Exception e){
           
       }
       
   }
    public ResultSet selectAllEmp(){
       ResultSet rs=null;
       try{
           PreparedStatement sql1=conn.prepareStatement("select * from empleado");
           //sql1.setString(1,_Nregistro);
           rs=sql1.executeQuery();
       }catch(Exception e){
           
       }
       return rs;
   }
    public void UpdateProv(String _idProv,String _nomProv,String _dirProv,String _telProv){
       ResultSet rs=null;
       try{
           PreparedStatement sql1=conn.prepareStatement("update proveedor set nombre_prov=?, direccion_prov=?,"
                                                        + "telefono_prov=? where id_proveedor=?");
           sql1.setString(1,_nomProv);
           sql1.setString(2,_dirProv);
           sql1.setString(3,_telProv);
           sql1.setString(4,_idProv);
           sql1.executeUpdate();
           JOptionPane.showMessageDialog(null, "Proveedor Actualizado");
       }catch(Exception e){
           
       }
       
   }
    public ResultSet selectAllProv(){
       ResultSet rs=null;
       try{
           PreparedStatement sql1=conn.prepareStatement("select * from proveedor");
           //sql1.setString(1,_Nregistro);
           rs=sql1.executeQuery();
       }catch(Exception e){
           
       }
       return rs;
   }
    public void UpdateClie(String _idClie,String _nomClie,String _apeClie,String _dirClie,
                            String _nitClie,String _telClie,String _munClie,String _depClie,String _nrClie){
       ResultSet rs=null;
       try{
           PreparedStatement sql1=conn.prepareStatement("update cliente set nombre_clie=?,apellido_clie=?,direccion_clie=?,"
                                                        + "nit_clie=?,telefono_clie=?,municipio_clie=?,departamento_clie=?,"
                                                        + "n_registro_clie=? where id_cliente=?");
           sql1.setString(1,_nomClie);
           sql1.setString(2,_apeClie);
           sql1.setString(3,_dirClie);
           sql1.setString(4,_nitClie);
           sql1.setString(5,_telClie);
           sql1.setString(6,_munClie);
           sql1.setString(7,_depClie);
           sql1.setString(8,_nrClie);
           sql1.setString(9,_idClie);
           sql1.executeUpdate();
           JOptionPane.showMessageDialog(null, "Cliente Actualizado");
       }catch(Exception e){
           
       }
       
   }
    
   public ResultSet selectAllProd(){
       ResultSet rs=null;
       try{
           PreparedStatement sql1=conn.prepareStatement("select ID_PRODUCTO,NOMBRE_PROD,FECHA_INGRESO_PROD,PRECIO_PROD,"
                                                        +"EXISTENCIA_PROD,NOMBRE_PROV,NOMBRE_CAT_PROD from PRODUCTO PD\n" 
                                                        +"JOIN CAT_PRODUCTO PR ON PR.ID_CAT_PRODUCTO=PD.ID_CAT_PRODUCTO\n" 
                                                        +"JOIN PROVEEDOR PV ON PV.ID_PROVEEDOR=PD.ID_PROVEEDOR");
           //sql1.setString(1,_Nregistro);
           rs=sql1.executeQuery();
       }catch(Exception e){
           
       }
       return rs;
   }
   
    
   
   
   
   
   
   
   
   
   
   
   
   


}
