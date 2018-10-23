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
}
