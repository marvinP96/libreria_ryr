/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Venta;

/**
 *
 * @author migue
 */
public class DetalleVenta {
    private int idVenta;
    private int idProducto;
    private String nombreProducto;
    private double precioUVenta;
    private int cantidadVenta;

    public DetalleVenta(int idVenta, int idProducto, String nombreProducto, double precioUVenta, int cantidadVenta) {
        this.idVenta = idVenta;
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.precioUVenta = precioUVenta;
        this.cantidadVenta = cantidadVenta;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public double getPrecioUVenta() {
        return precioUVenta;
    }

    public int getCantidadVenta() {
        return cantidadVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public void setPrecioUVenta(double precioUVenta) {
        this.precioUVenta = precioUVenta;
    }

    public void setCantidadVenta(int cantidadVenta) {
        this.cantidadVenta = cantidadVenta;
    }
    
    
}
