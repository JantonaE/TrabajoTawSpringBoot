/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.grupo2.proyectospring.dto;


import es.grupo2.proyectospring.entity.Comprador;
import es.grupo2.proyectospring.entity.ListaVenta;

import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author Alfonso
 */
public class ProductoDTO implements Serializable {

    
    private Integer id;
    private String titulo;
    private String descripcion;
    private BigDecimal precioSalida;
    private String uRLfoto;
    private int categoriaProducto;
    private List<Comprador> compradorList;
    private List<Comprador> compradorList1;
    private List<ListaVenta> listaVentaList;

    public ProductoDTO() {
    }

    public ProductoDTO(Integer id) {
        this.id = id;
    }

    public ProductoDTO(Integer id, String titulo, String descripcion, BigDecimal precioSalida, String uRLfoto, int categoriaProducto) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.precioSalida = precioSalida;
        this.uRLfoto = uRLfoto;
        this.categoriaProducto = categoriaProducto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getPrecioSalida() {
        return precioSalida;
    }

    public void setPrecioSalida(BigDecimal precioSalida) {
        this.precioSalida = precioSalida;
    }

    public String getURLfoto() {
        return uRLfoto;
    }

    public void setURLfoto(String uRLfoto) {
        this.uRLfoto = uRLfoto;
    }

    public int getCategoriaProducto() {
        return categoriaProducto;
    }

    public void setCategoriaProducto(int categoriaProducto) {
        this.categoriaProducto = categoriaProducto;
    }

    @XmlTransient
    public List<Comprador> getCompradorList() {
        return compradorList;
    }

    public void setCompradorList(List<Comprador> compradorList) {
        this.compradorList = compradorList;
    }

    @XmlTransient
    public List<Comprador> getCompradorList1() {
        return compradorList1;
    }

    public void setCompradorList1(List<Comprador> compradorList1) {
        this.compradorList1 = compradorList1;
    }

    @XmlTransient
    public List<ListaVenta> getListaVentaList() {
        return listaVentaList;
    }

    public void setListaVentaList(List<ListaVenta> listaVentaList) {
        this.listaVentaList = listaVentaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }


    @Override
    public String toString() {
        return "tawebay.entity.Producto[ id=" + id + " ]";
    }
    
}
