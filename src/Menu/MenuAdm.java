/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import Venta.nuevaVenta;
import facturacion.frmFacturacion;
import facturacion.frmMostrarFac;
import ingreso_datos.Agregar_categoria;
import ingreso_datos.Agregar_empleados;
import ingreso_datos.Agregar_proveedor;
import ingreso_datos.Datos_cliente;
import ingreso_datos.Ingresar_productos;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComponent;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicMenuBarUI;
import login.Login;
import net.sf.jasperreports.web.actions.AbstractAction;
import net.sf.jasperreports.web.actions.ActionException;
import reporte.reporte_fecha;

/**
 *
 * @author migue
 */
public class MenuAdm extends javax.swing.JFrame {

    /**
     * Creates new form MenuAdm
     */
    public MenuAdm() {
        initComponents();
        menuBarAdmin.setUI ( new BasicMenuBarUI (){
                public void paint ( Graphics g, JComponent c ){
                   g.setColor (Color.decode("#0099cc"));
                   g.fillRect ( 0, 0, c.getWidth (), c.getHeight () );
                }
                 } );
        
        this.setLocationRelativeTo(null);
       
        
    }
    
    
   
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        menuBarAdmin = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jmiCrearVenta = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jmiGenerarFactura = new javax.swing.JMenuItem();
        jmiListarFacturas = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jmiRegistrarProd = new javax.swing.JMenuItem();
        jmiRegistrarCat = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jmiRegistrarEmp = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jmiRegistrarProv = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jmiRegistrarCli = new javax.swing.JMenuItem();
        jMenu8 = new javax.swing.JMenu();
        jmiGenerarRep = new javax.swing.JMenuItem();
        mnCerrarSesion = new javax.swing.JMenu();
        jmiCerrarSesion = new javax.swing.JMenuItem();
        opcSalir = new javax.swing.JMenu();
        jmiSalir = new javax.swing.JMenuItem();

        jMenuItem2.setText("jMenuItem2");

        jMenuItem3.setText("jMenuItem3");

        jMenuItem6.setText("jMenuItem6");

        jMenuItem7.setText("jMenuItem7");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Menu/fondo1C.jpg"))); // NOI18N

        menuBarAdmin.setBackground(new java.awt.Color(255, 153, 0));

        jMenu1.setBackground(new java.awt.Color(153, 153, 255));
        jMenu1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMenu1.setForeground(new java.awt.Color(255, 255, 255));
        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Menu/shopping-bag.png"))); // NOI18N
        jMenu1.setText("Venta");
        jMenu1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        jmiCrearVenta.setText("Crear Venta");
        jmiCrearVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiCrearVentaActionPerformed(evt);
            }
        });
        jMenu1.add(jmiCrearVenta);

        menuBarAdmin.add(jMenu1);

        jMenu2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMenu2.setForeground(new java.awt.Color(255, 255, 255));
        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Menu/file-text.png"))); // NOI18N
        jMenu2.setText("Facturación");
        jMenu2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jMenu2.setMargin(new java.awt.Insets(75, 75, 75, 75));

        jmiGenerarFactura.setText("Generar Factura");
        jmiGenerarFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiGenerarFacturaActionPerformed(evt);
            }
        });
        jMenu2.add(jmiGenerarFactura);

        jmiListarFacturas.setText("Listar Facturas");
        jmiListarFacturas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiListarFacturasActionPerformed(evt);
            }
        });
        jMenu2.add(jmiListarFacturas);

        menuBarAdmin.add(jMenu2);

        jMenu3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMenu3.setForeground(new java.awt.Color(255, 255, 255));
        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Menu/shopping-cart.png"))); // NOI18N
        jMenu3.setText("Productos");
        jMenu3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        jmiRegistrarProd.setText("Registrar Producto");
        jmiRegistrarProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiRegistrarProdActionPerformed(evt);
            }
        });
        jMenu3.add(jmiRegistrarProd);

        jmiRegistrarCat.setText("Registrar Categoría");
        jmiRegistrarCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiRegistrarCatActionPerformed(evt);
            }
        });
        jMenu3.add(jmiRegistrarCat);

        menuBarAdmin.add(jMenu3);

        jMenu4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMenu4.setForeground(new java.awt.Color(255, 255, 255));
        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Menu/user-circle.png"))); // NOI18N
        jMenu4.setText("Empleado");
        jMenu4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        jmiRegistrarEmp.setText("Registrar Empleado");
        jmiRegistrarEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiRegistrarEmpActionPerformed(evt);
            }
        });
        jMenu4.add(jmiRegistrarEmp);

        menuBarAdmin.add(jMenu4);

        jMenu6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMenu6.setForeground(new java.awt.Color(255, 255, 255));
        jMenu6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Menu/truck.png"))); // NOI18N
        jMenu6.setText("Proveedor");
        jMenu6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        jmiRegistrarProv.setText("Registrar Proveedor");
        jmiRegistrarProv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiRegistrarProvActionPerformed(evt);
            }
        });
        jMenu6.add(jmiRegistrarProv);

        menuBarAdmin.add(jMenu6);

        jMenu5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMenu5.setForeground(new java.awt.Color(255, 255, 255));
        jMenu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Menu/user-circle-o.png"))); // NOI18N
        jMenu5.setText("Cliente");
        jMenu5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        jmiRegistrarCli.setText("Registrar Cliente");
        jmiRegistrarCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiRegistrarCliActionPerformed(evt);
            }
        });
        jMenu5.add(jmiRegistrarCli);

        menuBarAdmin.add(jMenu5);

        jMenu8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMenu8.setForeground(new java.awt.Color(255, 255, 255));
        jMenu8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Menu/folder.png"))); // NOI18N
        jMenu8.setText("Reporte");
        jMenu8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        jmiGenerarRep.setText("Generar Reporte");
        jmiGenerarRep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiGenerarRepActionPerformed(evt);
            }
        });
        jMenu8.add(jmiGenerarRep);

        menuBarAdmin.add(jMenu8);

        mnCerrarSesion.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        mnCerrarSesion.setForeground(new java.awt.Color(255, 255, 255));
        mnCerrarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Menu/sign-out.png"))); // NOI18N
        mnCerrarSesion.setText("Cerrar Sesión");
        mnCerrarSesion.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        jmiCerrarSesion.setText("Cerrar Sesión");
        jmiCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiCerrarSesionActionPerformed(evt);
            }
        });
        mnCerrarSesion.add(jmiCerrarSesion);

        menuBarAdmin.add(mnCerrarSesion);

        opcSalir.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        opcSalir.setForeground(new java.awt.Color(255, 255, 255));
        opcSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Menu/window-close.png"))); // NOI18N
        opcSalir.setText("Salir");
        opcSalir.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        jmiSalir.setText("Salir");
        jmiSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiSalirActionPerformed(evt);
            }
        });
        opcSalir.add(jmiSalir);

        menuBarAdmin.add(opcSalir);

        setJMenuBar(menuBarAdmin);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmiCrearVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiCrearVentaActionPerformed
        // TODO add your handling code here:
        nuevaVenta frm = new nuevaVenta();
        frm.setVisible(true);
        
    }//GEN-LAST:event_jmiCrearVentaActionPerformed

    private void jmiSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiSalirActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jmiSalirActionPerformed

    private void jmiCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiCerrarSesionActionPerformed
        // TODO add your handling code here:
        this.dispose();
        Login frm = new Login();
        frm.setVisible(true);
        
        
    }//GEN-LAST:event_jmiCerrarSesionActionPerformed

    private void jmiGenerarFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiGenerarFacturaActionPerformed
        // TODO add your handling code here:
        frmFacturacion frm = new  frmFacturacion();
        frm.setVisible(true);
    }//GEN-LAST:event_jmiGenerarFacturaActionPerformed

    private void jmiListarFacturasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiListarFacturasActionPerformed
        // TODO add your handling code here:
        frmMostrarFac frm = new  frmMostrarFac();
        frm.setVisible(true);
    }//GEN-LAST:event_jmiListarFacturasActionPerformed

    private void jmiRegistrarProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiRegistrarProdActionPerformed
        // TODO add your handling code here:
        Ingresar_productos frm = new  Ingresar_productos();
        frm.setVisible(true);
    }//GEN-LAST:event_jmiRegistrarProdActionPerformed

    private void jmiRegistrarCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiRegistrarCatActionPerformed
        // TODO add your handling code here:
        Agregar_categoria frm = new  Agregar_categoria();
        frm.setVisible(true);
    }//GEN-LAST:event_jmiRegistrarCatActionPerformed

    private void jmiRegistrarEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiRegistrarEmpActionPerformed
        // TODO add your handling code here:
        Agregar_empleados frm = new  Agregar_empleados();
        frm.setVisible(true);
    }//GEN-LAST:event_jmiRegistrarEmpActionPerformed

    private void jmiRegistrarProvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiRegistrarProvActionPerformed
        // TODO add your handling code here:
        Agregar_proveedor frm = new  Agregar_proveedor();
        frm.setVisible(true);
    }//GEN-LAST:event_jmiRegistrarProvActionPerformed

    private void jmiRegistrarCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiRegistrarCliActionPerformed
        // TODO add your handling code here:
        Datos_cliente frm = new  Datos_cliente();
        frm.setVisible(true);
    }//GEN-LAST:event_jmiRegistrarCliActionPerformed

    private void jmiGenerarRepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiGenerarRepActionPerformed
        // TODO add your handling code here:
        reporte_fecha frm = new  reporte_fecha();
        frm.setVisible(true);
    }//GEN-LAST:event_jmiGenerarRepActionPerformed

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
            java.util.logging.Logger.getLogger(MenuAdm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuAdm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuAdm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuAdm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuAdm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jmiCerrarSesion;
    private javax.swing.JMenuItem jmiCrearVenta;
    private javax.swing.JMenuItem jmiGenerarFactura;
    private javax.swing.JMenuItem jmiGenerarRep;
    private javax.swing.JMenuItem jmiListarFacturas;
    private javax.swing.JMenuItem jmiRegistrarCat;
    private javax.swing.JMenuItem jmiRegistrarCli;
    private javax.swing.JMenuItem jmiRegistrarEmp;
    private javax.swing.JMenuItem jmiRegistrarProd;
    private javax.swing.JMenuItem jmiRegistrarProv;
    private javax.swing.JMenuItem jmiSalir;
    private javax.swing.JMenuBar menuBarAdmin;
    private javax.swing.JMenu mnCerrarSesion;
    private javax.swing.JMenu opcSalir;
    // End of variables declaration//GEN-END:variables
}
