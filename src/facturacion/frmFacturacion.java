/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facturacion;

import conexion_db.ConexionDB;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Miguel Benavides
 */
public class frmFacturacion extends javax.swing.JFrame {

    /**
     * Creates new form frmFacturacion
     */
    public static int IdCliente=0;
    public static String NombreClie="";
    public static String ApellidoClie="";
    public static String DireecionClie="";
    public static String NitClie="";
    public static String TelefonoClie="";
    public static String MuniClie="";
    public static String DepaClie="";
    public static String NumRegisClie="";
    
    public frmFacturacion() {
        initComponents();
        this.setLocationRelativeTo(null);
        Calendar fecha=new GregorianCalendar();
        fecha2.setCalendar(fecha);
        cargarclientes();
        
    }
    public void cargarclientes(){
        
        ConexionDB cn=new ConexionDB();
        ResultSet rs=cn.selectallcliente();
        DefaultTableModel model1=new DefaultTableModel();
         this.jTable2.setModel(model1);
        model1.setColumnIdentifiers(new Object[]{"ID CLIENTE","NOMBRE","APELLIDO",
                "DIRECCION","NIT","TELEFONO","MUNICIPIO","DEPARTAMENTO","N° REGISTRO"});

        try{
            while(rs.next()){
                model1.addRow(new Object[]{rs.getInt("ID_CLIENTE"),rs.getString("NOMBRE_CLIE"),
                    rs.getString("APELLIDO_CLIE"),rs.getString("DIRECCION_CLIE"),rs.getString("NIT_CLIE"),
                    rs.getString("TELEFONO_CLIE"),rs.getString("MUNICIPIO_CLIE"),
                    rs.getString("DEPARTAMENTO_CLIE"),rs.getString("N_REGISTRO_CLIE")});
        }
        }catch(Exception e){
            JOptionPane.showMessageDialog(rootPane,"No se encuentran datos");
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

        jDialog1 = new javax.swing.JDialog();
        jLabel3 = new javax.swing.JLabel();
        txtNregistro = new javax.swing.JTextField();
        btnBClie = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        btnSelec = new javax.swing.JButton();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnBuscarVen = new javax.swing.JButton();
        txtIdVenta = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        txtNomClie = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtApellidoClie = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtDirecClie = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtNitClie = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtDepClie = new javax.swing.JTextField();
        txtMunClie = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtNClie = new javax.swing.JTextField();
        btnCli = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtTelClie = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        fecha2 = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtNumFact = new javax.swing.JTextField();
        rbnTicket = new javax.swing.JRadioButton();
        rbnCreditoF = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();

        jDialog1.setMinimumSize(new java.awt.Dimension(807, 360));

        jLabel3.setText("N° REGISTRO");

        btnBClie.setText("BUSCAR");
        btnBClie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBClieActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(jTable2);

        btnSelec.setText("SELECCIONAR");
        btnSelec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelecActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialog1Layout.createSequentialGroup()
                .addContainerGap(653, Short.MAX_VALUE)
                .addComponent(btnSelec)
                .addGap(51, 51, 51))
            .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jDialog1Layout.createSequentialGroup()
                    .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jDialog1Layout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtNregistro, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnBClie))
                        .addGroup(jDialog1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 787, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(btnSelec)
                .addContainerGap(314, Short.MAX_VALUE))
            .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jDialog1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnBClie)
                        .addComponent(txtNregistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3))
                    .addGap(18, 18, 18)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(13, Short.MAX_VALUE)))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTable1.setEnabled(false);
        jScrollPane1.setViewportView(jTable1);

        btnBuscarVen.setText("BUSCAR");
        btnBuscarVen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarVenActionPerformed(evt);
            }
        });

        jLabel1.setText("N° Venta:");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Datos Generales"));
        jPanel1.setToolTipText("");

        txtNomClie.setEnabled(false);

        jLabel2.setText("Cliente:");

        txtApellidoClie.setEnabled(false);

        jLabel4.setText("Direccion:");

        txtDirecClie.setEnabled(false);

        jLabel5.setText("NIT:");

        txtNitClie.setEnabled(false);

        jLabel6.setText("Departamento:");

        txtDepClie.setEnabled(false);

        txtMunClie.setEnabled(false);

        jLabel7.setText("Municipio:");

        jLabel8.setText("N° Registro:");

        txtNClie.setEnabled(false);

        btnCli.setText("Buscar");
        btnCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCliActionPerformed(evt);
            }
        });

        jLabel9.setText("Tel:");

        txtTelClie.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(14, 14, 14)
                        .addComponent(txtNomClie, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtApellidoClie, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCli)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNClie))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDepClie))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDirecClie, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(10, 10, 10)
                                .addComponent(txtTelClie)
                                .addContainerGap())
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtMunClie))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtNitClie, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 10, Short.MAX_VALUE))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNomClie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtApellidoClie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(btnCli))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDirecClie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtNitClie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDepClie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtMunClie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNClie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8)
                        .addComponent(txtTelClie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 53, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Datos Factura"));

        fecha2.setDateFormatString("yyyy-MM-dd");
        fecha2.setEnabled(false);
        fecha2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fecha2KeyPressed(evt);
            }
        });

        jLabel10.setText("Fecha:");

        jLabel11.setText("Tipo Factura:");

        jLabel12.setText("Numero Factura:");

        buttonGroup1.add(rbnTicket);
        rbnTicket.setText("Ticket");
        rbnTicket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbnTicketActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbnCreditoF);
        rbnCreditoF.setText("Credito Fiscal");
        rbnCreditoF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbnCreditoFActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel10))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(rbnCreditoF)
                                .addGap(18, 18, 18)
                                .addComponent(rbnTicket))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(fecha2, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNumFact, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(fecha2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(rbnCreditoF)
                    .addComponent(rbnTicket))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtNumFact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton1.setText("Generar Factura");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(54, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIdVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscarVen)
                        .addGap(477, 477, 477))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(28, 28, 28)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(11, 11, 11))
                            .addComponent(jScrollPane1)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txtIdVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnBuscarVen))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        jPanel1.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarVenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarVenActionPerformed
        // TODO add your handling code here:
        String idventa=this.txtIdVenta.getText().toString();
        ConexionDB cn=new ConexionDB();
        ResultSet rs=cn.selectventafact(idventa);
        DefaultTableModel model=new DefaultTableModel();
        this.jTable1.setModel(model);
        model.setColumnIdentifiers(new Object[]{"ID_VENTA","NOM_PROD","PRECIO_UNI","CANTIDAD"});
        try{
            while(rs.next()){
                model.addRow(new Object[]{rs.getInt("id_venta"),rs.getString("nombre_prod"),rs.getDouble("precio_uni_vent"),rs.getInt("cantidad_venta")});
            }
        }catch(Exception e){
            
        }
    }//GEN-LAST:event_btnBuscarVenActionPerformed

    private void btnBClieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBClieActionPerformed
        // TODO add your handling code here:
        String nregistro=this.txtNregistro.getText().toString();
        ConexionDB cn=new ConexionDB();
        ResultSet rs=cn.selectcliente(nregistro);
        DefaultTableModel model1=new DefaultTableModel();
         this.jTable2.setModel(model1);
        model1.setColumnIdentifiers(new Object[]{"ID CLIENTE","NOMBRE","APELLIDO",
                "DIRECCION","NIT","TELEFONO","MUNICIPIO","DEPARTAMENTO","N° REGISTRO"});

        try{
            while(rs.next()){
                model1.addRow(new Object[]{rs.getInt("ID_CLIENTE"),rs.getString("NOMBRE_CLIE"),
                    rs.getString("APELLIDO_CLIE"),rs.getString("DIRECCION_CLIE"),rs.getString("NIT_CLIE"),
                    rs.getString("TELEFONO_CLIE"),rs.getString("MUNICIPIO_CLIE"),
                    rs.getString("DEPARTAMENTO_CLIE"),rs.getString("N_REGISTRO_CLIE")});
        }
        }catch(Exception e){
            JOptionPane.showMessageDialog(rootPane,"No se encuentran datos");
        }
    }//GEN-LAST:event_btnBClieActionPerformed

    private void btnCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCliActionPerformed
        // TODO add your handling code here:
        this.jDialog1.setVisible(true);
    }//GEN-LAST:event_btnCliActionPerformed

    private void btnSelecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecActionPerformed
        // TODO add your handling code here:
        int filaseleccionada =  this.jTable2.getSelectedRow();
        this.IdCliente=Integer.parseInt(this.jTable2.getValueAt(filaseleccionada, 0).toString());
        NombreClie=this.jTable2.getValueAt(filaseleccionada, 1).toString();
        this.ApellidoClie=this.jTable2.getValueAt(filaseleccionada, 2).toString();
        this.DireecionClie=this.jTable2.getValueAt(filaseleccionada, 3).toString();
        this.NitClie=this.jTable2.getValueAt(filaseleccionada, 4).toString();
        this.TelefonoClie=this.jTable2.getValueAt(filaseleccionada, 5).toString();
        this.MuniClie=this.jTable2.getValueAt(filaseleccionada, 6).toString();
        this.DepaClie=this.jTable2.getValueAt(filaseleccionada, 7).toString();
        this.NumRegisClie=this.jTable2.getValueAt(filaseleccionada, 8).toString();
        JOptionPane.showMessageDialog(null,"Cliente Seleccionado");
        
        this.txtNomClie.setText(NombreClie.toString());
        this.txtApellidoClie.setText(ApellidoClie.toString());
        this.txtDirecClie.setText(DireecionClie);
        this.txtNitClie.setText(NitClie);
        this.txtTelClie.setText(TelefonoClie);
        this.txtMunClie.setText(MuniClie);
        this.txtDepClie.setText(DepaClie);
        this.txtNClie.setText(NumRegisClie);
    }//GEN-LAST:event_btnSelecActionPerformed

    private void fecha2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fecha2KeyPressed

    }//GEN-LAST:event_fecha2KeyPressed

    private void rbnCreditoFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbnCreditoFActionPerformed
        // TODO add your handling code here:
        if(this.rbnCreditoF.isSelected()){
           this.btnCli.setEnabled(true);
        }
    }//GEN-LAST:event_rbnCreditoFActionPerformed

    private void rbnTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbnTicketActionPerformed
        // TODO add your handling code here:
         if(this.rbnTicket.isSelected()){
           this.btnCli.setEnabled(false);
        }
    }//GEN-LAST:event_rbnTicketActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if(this.rbnCreditoF.isSelected()){
           
            ConexionDB fac=new ConexionDB();
            String dia=Integer.toString(fecha2.getCalendar().get(Calendar.DAY_OF_MONTH+1));
        String mes= Integer.toString(fecha2.getCalendar().get(Calendar.MONTH));
        String year= Integer.toString(fecha2.getCalendar().get(Calendar.YEAR));
        String fechaA=(dia+"-"+mes+"-"+year);
        String date=fechaA;
            fac.procedureFactura(this.IdCliente,date,Integer.parseInt(this.txtIdVenta.getText()),
                1,Integer.parseInt(this.txtNumFact.getText()),1);
        this.txtNomClie.setText("");
        this.txtApellidoClie.setText("");
        this.txtDirecClie.setText("");
        this.txtNitClie.setText("");
        this.txtTelClie.setText("");
        this.txtMunClie.setText("");
        this.txtDepClie.setText("");
        this.txtNClie.setText("");
        this.txtNumFact.setText("");
        this.txtIdVenta.setText("");
            
        }else if(this.rbnTicket.isSelected()){
        
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(frmFacturacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmFacturacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmFacturacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmFacturacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmFacturacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBClie;
    private javax.swing.JButton btnBuscarVen;
    private javax.swing.JButton btnCli;
    private javax.swing.JButton btnSelec;
    private javax.swing.ButtonGroup buttonGroup1;
    public static com.toedter.calendar.JDateChooser fecha2;
    private javax.swing.JButton jButton1;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JRadioButton rbnCreditoF;
    private javax.swing.JRadioButton rbnTicket;
    private javax.swing.JTextField txtApellidoClie;
    private javax.swing.JTextField txtDepClie;
    private javax.swing.JTextField txtDirecClie;
    private javax.swing.JTextField txtIdVenta;
    private javax.swing.JTextField txtMunClie;
    private javax.swing.JTextField txtNClie;
    private javax.swing.JTextField txtNitClie;
    private javax.swing.JTextField txtNomClie;
    private javax.swing.JTextField txtNregistro;
    private javax.swing.JTextField txtNumFact;
    private javax.swing.JTextField txtTelClie;
    // End of variables declaration//GEN-END:variables
}
