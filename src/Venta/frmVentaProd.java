/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Venta;

import entidades.Empleado;
import entidades.EmpleadoJpaController;
import entidades.Producto;
import entidades.ProductoJpaController;
import entidades.entityMain;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

import java.sql.*;
import java.util.ArrayList;
import javafx.scene.effect.Light.Point;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Santillano
 */
public class frmVentaProd extends javax.swing.JFrame {
    ProductoJpaController control_Producto = new ProductoJpaController(entityMain.getInstance());
    /**
     * Creates new form frmVentaProd
     * 
     */
     //Declaramos el modelo
    
    DefaultTableModel modeloProd;
    DefaultTableModel modeloDetalleV;
    List<Producto> ListaProducto;
    Boolean encontrado;
    ArrayList <DetalleVenta> listaDetalleV;
    int cont1;
    double total;
    int cuentaFilasSeleccionadasB;
    int cuentaFilasSeleccionadas;
    public frmVentaProd() {
        initComponents();
        modeloProd=(DefaultTableModel) this.tblProductos.getModel();
        txtIDVentaActual.setEditable(false); 
       //txtIDVentaActual.setEnabled(false);
        tblProductos.getTableHeader().setFont(new Font("Dubai", 1, 16)); 
       
       LlenarPrimTablaProd();
       encontrado=false;
       listaDetalleV= new ArrayList<>();
       ///Esto es para mientras
       txtIDVentaActual.setText("21");
       cont1=0;
       modeloDetalleV=(DefaultTableModel) this.tblDetalleVenta.getModel();
       total=0.0;
       cuentaFilasSeleccionadasB=0;
       cuentaFilasSeleccionadas=0;
       
       tblProductos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); 
       tblDetalleVenta.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); 
      PopUpTableProd();
      PopUpTableDet();
      seleccionarFilaTbls();
    }
    
    public void PopUpTableProd(){
        JPopupMenu popupMenu = new JPopupMenu();
        
        JMenuItem menuItem1= new JMenuItem("Seleccionar Producto", new ImageIcon(getClass().getResource("seleccionarA.png" )));
        //JMenuItem menuItem1= new JMenuItem("Mensaje De Exito");
         menuItem1.setFont(new Font("Dubai", Font.PLAIN, 15));
        menuItem1.addActionListener(new ActionListener(){        
            @Override
            public void actionPerformed(ActionEvent e) {
                //JOptionPane.showMessageDialog(null,"HOLA AMigos","Mensaje",JOptionPane.INFORMATION_MESSAGE);
                SeleccionarProd();
            }
        
        
        });
        
        popupMenu.add(menuItem1);
        tblProductos.setComponentPopupMenu(popupMenu);
        
    }
    public void PopUpTableDet(){
        JPopupMenu popupMenu = new JPopupMenu();
        
        JMenuItem menuItem1= new JMenuItem("Seleccionar Producto", new ImageIcon(getClass().getResource("quitarA.png" )));
       
        //JMenuItem menuItem1= new JMenuItem("Mensaje De Exito");
        menuItem1.addActionListener(new ActionListener(){        
            @Override
            public void actionPerformed(ActionEvent e) {
               eliminarProdSel();
            }
        
        
        });
        
        popupMenu.add(menuItem1);
        tblDetalleVenta.setComponentPopupMenu(popupMenu);
        
    }
    
    public void seleccionarFilaTbls(){
        tblProductos.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent e) {
                if (SwingUtilities.isRightMouseButton(e)) {
                        java.awt.Point p = e.getPoint();
                        int rowNumber = tblProductos.rowAtPoint(p);
                        tblProductos.getSelectionModel().setSelectionInterval(rowNumber, rowNumber);
                }
        }     
        
        });
        tblDetalleVenta.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent e) {
                if (SwingUtilities.isRightMouseButton(e)) {
                        java.awt.Point p = e.getPoint();
                        int rowNumber = tblDetalleVenta.rowAtPoint(p);
                        tblDetalleVenta.getSelectionModel().setSelectionInterval(rowNumber, rowNumber);
                }
        }     
        
        });
        
    }
    
    public void LlenarPrimTablaProd(){
            //Este metodo solo se llamara 1 vez al iniciar el aplicativo
            ListaProducto= control_Producto.findProductoEntities();            
            for(int i=0; i<ListaProducto.size(); i++){         
            
            //ListaProducto.get(i).getFechaIngresoProd().toString()
            String[] registroProd = { ListaProducto.get(i).getIdProducto().toString(), ListaProducto.get(i).getNombreProd(),String.valueOf(ListaProducto.get(i).getFechaIngresoProd()),
                                    String.valueOf(ListaProducto.get(i).getPrecioProd()) ,ListaProducto.get(i).getExistenciaProd().toString(),ListaProducto.get(i).getIdProveedor().getNombreProv().toString(),
                                    ListaProducto.get(i).getIdCatProducto().getNombreCatProd()};
            modeloProd.addRow(registroProd);
        }
    
    }
    public void LlenarTablaProd(){
            //Este metodo se llamara cada vez que queramos actualizar la tabla Prod (al momento que se agrega un prod
            //al detalle venta            
            //ListaProducto= control_Producto.findProductoEntities();
            modeloProd.getDataVector().clear();
            for(int i=0; i<ListaProducto.size(); i++){         
            
            //ListaProducto.get(i).getFechaIngresoProd().toString()
            String[] registroProd = { ListaProducto.get(i).getIdProducto().toString(), ListaProducto.get(i).getNombreProd(),String.valueOf(ListaProducto.get(i).getFechaIngresoProd()),
                                    String.valueOf(ListaProducto.get(i).getPrecioProd()) ,ListaProducto.get(i).getExistenciaProd().toString(),ListaProducto.get(i).getIdProveedor().getNombreProv().toString(),
                                    ListaProducto.get(i).getIdCatProducto().getNombreCatProd()};
            modeloProd.addRow(registroProd);
        }    
    }
    
    public void BuscarProd(int id){
            
        for(int i=0; i<ListaProducto.size(); i++){
            int a;
            a=Integer.parseInt(ListaProducto.get(i).getIdProducto().toString());
            
            if(a==id){                
                //ListaProducto.get(i).getFechaIngresoProd().toString()
                modeloProd.getDataVector().clear();
                
            String[] registroProd = { ListaProducto.get(i).getIdProducto().toString(), ListaProducto.get(i).getNombreProd(),String.valueOf(ListaProducto.get(i).getFechaIngresoProd()),
                                    String.valueOf(ListaProducto.get(i).getPrecioProd()) ,ListaProducto.get(i).getExistenciaProd().toString(),ListaProducto.get(i).getIdProveedor().getNombreProv().toString(),
                                    ListaProducto.get(i).getIdCatProducto().getNombreCatProd().toString()};
            modeloProd.addRow(registroProd);
            encontrado=true;
            break;
            }else{
             encontrado=false;            
            
            
            }           
        }
        
            if(encontrado==true){
                JOptionPane.showMessageDialog(null,"Producto encontrado");
            }else{
                  JOptionPane.showMessageDialog(null,"Producto no encontrado");
                  modeloProd.getDataVector().clear();
                  LlenarTablaProd();
            }
    }
    
    public void SeleccionarProd(){       
           
                //contProd=1;
                int filaseleccionada =  tblProductos.getSelectedRow();
                String idProd = (String) tblProductos.getValueAt(filaseleccionada, 0);      
                //JOptionPane.showMessageDialog(null,"Producto seleccionado: "+idProd);                
                
                //Agregar el producto  a la lista Detalle de Venta
                //DetalleVenta nmbProd= new DetalleVenta(1,21,"Lapiz",0.35,2);
                //this.listaDetalleV.add(nmbProd);                
                //Pasar de la lista Detalle de Venta a una tabla
                int idVentaAct;
                idVentaAct=Integer.parseInt(txtIDVentaActual.getText()) ;
                
                //Esta es la cantidad que se quiere solicitar de un producto
                
                
                if(txtCantidadProdReq.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null,"Debe ingresar la cantidad que desea descontar");
                }else{
                    int cantidadProdReq;
                    cantidadProdReq=Integer.parseInt(txtCantidadProdReq.getText());                    
                    
                    if(cantidadProdReq ==0){
                        JOptionPane.showMessageDialog(null,"Debe ingresar una cantidad distinta a 0 para descontar");
                    }else{
                        //Esta es la cantidad existente de un producto
                        int cantidadProdExis;
                        cantidadProdExis=Integer.parseInt(tblProductos.getValueAt(filaseleccionada, 4).toString()); 
                        if(cantidadProdExis==0){
                            JOptionPane.showMessageDialog(null,"La cantidad existente del producto seleccionado es 0");
                        }
                        else{
                            if(cantidadProdExis>1 && cantidadProdReq<=cantidadProdExis)
                            {
                                double PrecioUnitario;                
                                PrecioUnitario=Double.parseDouble(tblProductos.getValueAt(filaseleccionada, 3).toString());
                                String nombreProd = (String) tblProductos.getValueAt(filaseleccionada, 1); 
                                double precioXCant;
                                precioXCant=PrecioUnitario*cantidadProdReq;
                                AddProdDetalleV(Integer.parseInt(idProd),idVentaAct,PrecioUnitario,cantidadProdExis,cantidadProdReq,nombreProd,precioXCant);
                                
                                idProd="";
                                idVentaAct=0;
                                cantidadProdReq=0;
                                precioXCant=0.0;
                                cantidadProdExis=0;
                                nombreProd="";
                                PrecioUnitario=0.0;
                                
                            }
                            else
                            {
                                JOptionPane.showMessageDialog(null,"No hay suficiente cantidad de producto existente para descontar");
                            }   
                        }  
                    }                    
                }  
            
        
    }
    
    //Este metodo es para buscar en la lista detalle de venta un producto
    //Si existe se suma la cantidad que llevara y si no pues se agrega
    public void AddProdDetalleV(int idProd, int idVenta,double precioU, int cantProdExis,int cantProdReq, String nombreProd,double  precioXCant){
                 
                           for(int i=0; i<ListaProducto.size(); i++)
                           {
                                int myIdProd;
                                myIdProd=Integer.parseInt(ListaProducto.get(i).getIdProducto().toString());

                                if(myIdProd==idProd)
                                {     
                                    BigInteger cantProdRequerido = BigInteger.valueOf(cantProdReq);
                                    
                                    ListaProducto.get(i).setExistenciaProd(ListaProducto.get(i).getExistenciaProd().subtract(cantProdRequerido));
                                    LlenarTablaProd();
                                    DetalleVenta dVProd= new DetalleVenta(idVenta,idProd,nombreProd,precioU,cantProdReq,precioXCant);
                                    
                                    if(cont1==0){
                                        //Solo la primera vez que se agregue un producto al detalle
                                        this.listaDetalleV.add(dVProd);
                                        llenarTablaDetalleV();
                                        cont1++; 
                                    }else{
                                        //Se ejecutara esto cuando en la lista exista mas de un detalle(producto) agregado
                                        //para verificar si existe y asi se suma en detalle
                                        
                                        for(int j=0;j<listaDetalleV.size();j++){
                                           int  myIdProdDet;
                                           myIdProdDet=listaDetalleV.get(j).getIdProducto();
                                            
                                           if(myIdProdDet==idProd)
                                            {
                                               listaDetalleV.get(j).setCantidadVenta(listaDetalleV.get(j).getCantidadVenta()+cantProdReq);
                                               listaDetalleV.get(j).setPrecXcantidad(listaDetalleV.get(j).getPrecXcantidad()+precioXCant);
                                               llenarTablaDetalleV();
                                               cont1++;
                                               encontrado=true;
                                               break;
                                            }else
                                            {
                                                encontrado=false;
                                                
                                            }
                                        }
                                        if(encontrado==true){                                            
                                        }else{
                                             this.listaDetalleV.add(dVProd);
                                                llenarTablaDetalleV();
                                                cont1++;  
                                        }
                                    }
                                    
                                
                                break;
                                }else
                                {}           
                            }
    }
    
    public void llenarTablaDetalleV(){
        total=0.0;
        modeloDetalleV.getDataVector().clear();
        for(int i=0; i<listaDetalleV.size(); i++){            
            String[] registroDetalleV = {Integer.toString(listaDetalleV.get(i).getIdVenta()),Integer.toString(listaDetalleV.get(i).getIdProducto()),listaDetalleV.get(i).getNombreProducto(),
                                          "$"+Double.toString(listaDetalleV.get(i).getPrecioUVenta()),Integer.toString(listaDetalleV.get(i).getCantidadVenta()),"$"+Double.toString(listaDetalleV.get(i).getPrecXcantidad())};
           
            modeloDetalleV.addRow(registroDetalleV);
            total=total+listaDetalleV.get(i).getPrecXcantidad();
            txtTotal.setText("$"+total);
        }
    }
    
    public void eliminarProdSel(){
        //contProd=1;
                int filaseleccionada =  tblDetalleVenta.getSelectedRow();
                //Obetenemos el id del producto y cantidad que queremos quitar de nuestro detalle venta
                int idProd = Integer.parseInt(tblDetalleVenta.getValueAt(filaseleccionada, 1).toString());   
                int cantProdDet=Integer.parseInt(tblDetalleVenta.getValueAt(filaseleccionada, 4).toString());                  
                 for(int i=0; i< ListaProducto.size(); i++)
                 {
                     int myIdProd;
                     myIdProd=Integer.parseInt(ListaProducto.get(i).getIdProducto().toString());
                     
                     if(myIdProd==idProd)
                       {                         
                           //JOptionPane.showMessageDialog(null,"Producto seleccionado: "+idProd);
                           BigInteger cantProdDevuelta = BigInteger.valueOf(cantProdDet);                                    
                           ListaProducto.get(i).setExistenciaProd(ListaProducto.get(i).getExistenciaProd().add(cantProdDevuelta));
                           LlenarTablaProd();
                           cantProdDet=0;
                           
                           for(int j=0; j< listaDetalleV.size(); j++){
                               int myIdProdDet;
                               myIdProdDet=listaDetalleV.get(j).getIdProducto();
                               if(myIdProdDet==idProd){
                                   listaDetalleV.remove(j);
                                   JOptionPane.showMessageDialog(null,"Producto quitado exitosamente "+idProd);
                                   while (modeloDetalleV.getRowCount() > 0)
                                        {
                                        modeloDetalleV.removeRow(0);
                                        }
                                   total=0.0;
                                   txtTotal.setText("$"+total);
                                   llenarTablaDetalleV();
                                   break;
                               }
                           }
                           break;
                       }    
                 }              
                
    }
    
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtIDVentaActual = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblProductos = new javax.swing.JTable();
        txtBuscarProd = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnBuscarProd = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDetalleVenta = new javax.swing.JTable();
        txtCantidadProdReq = new javax.swing.JTextField();
        txtSubtotal = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel4.setFont(new java.awt.Font("Dubai", 1, 24)); // NOI18N
        jLabel4.setText("Detalle de Venta");

        jLabel1.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        jLabel1.setText("ID Venta Actual:");

        txtIDVentaActual.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        tblProductos.setFont(new java.awt.Font("Dubai", 0, 16)); // NOI18N
        tblProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID ", "Nombre", "Fecha de Ingreso", "Precio Unitario", "Existencias", "Proveedor", "Categoria"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblProductos);

        txtBuscarProd.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        jLabel2.setText("ID Producto:");

        jLabel3.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        jLabel3.setText("BUSCAR PRODUCTO");

        btnBuscarProd.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        btnBuscarProd.setText("Buscar");
        btnBuscarProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarProdActionPerformed(evt);
            }
        });

        tblDetalleVenta.setFont(new java.awt.Font("Dubai", 0, 16)); // NOI18N
        tblDetalleVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Venta", "ID Producto", "Producto", "Precio Unitario Venta", "Cantidad Venta", "Ventas Grabada"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblDetalleVenta);

        txtCantidadProdReq.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txtSubtotal.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        jLabel5.setText("Total:");

        jLabel6.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        jLabel6.setText("Subtotal:");

        txtTotal.setEditable(false);
        txtTotal.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        jLabel7.setText("Cantidad a vender:");

        jButton1.setText("jButton1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(512, 512, 512)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(txtCantidadProdReq, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 361, Short.MAX_VALUE)
                                .addComponent(jButton1)
                                .addGap(75, 75, 75))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(txtIDVentaActual, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(30, 30, 30)
                                .addComponent(txtBuscarProd, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(btnBuscarProd))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addComponent(jLabel3))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 906, Short.MAX_VALUE)
                            .addComponent(jScrollPane2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(txtSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtIDVentaActual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtBuscarProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarProd)
                    .addComponent(jLabel7)
                    .addComponent(txtCantidadProdReq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))))
                .addGap(69, 69, 69))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProdActionPerformed
        // TODO add your handling code here:
        int idProd;
        idProd= Integer.parseInt(txtBuscarProd.getText());
        BuscarProd(idProd);
        
    }//GEN-LAST:event_btnBuscarProdActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmVentaProd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmVentaProd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmVentaProd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmVentaProd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmVentaProd().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarProd;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tblDetalleVenta;
    private javax.swing.JTable tblProductos;
    private javax.swing.JTextField txtBuscarProd;
    private javax.swing.JTextField txtCantidadProdReq;
    public javax.swing.JTextField txtIDVentaActual;
    private javax.swing.JTextField txtSubtotal;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
