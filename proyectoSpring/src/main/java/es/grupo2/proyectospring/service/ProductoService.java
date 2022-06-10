package es.grupo2.proyectospring.service;


import es.grupo2.proyectospring.dto.ProductoDTO;
import es.grupo2.proyectospring.entity.Producto;
import es.grupo2.proyectospring.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductoService {
    private ProductoRepository productoRepository;

    @Autowired
    public void setUsuarioRepository(ProductoRepository productoRepository){
        this.productoRepository = productoRepository;
    }

    protected List<ProductoDTO> convertirAListaDTO (List<Producto> lista){
        if (lista != null) {
            List<ProductoDTO> listaDTO = new ArrayList<ProductoDTO>();
            for (Producto pr:lista) {
                listaDTO.add(pr.toDTO());
            }
            return listaDTO;
        } else {
            return null;
        }
    }

    public List<ProductoDTO> listarProductos (String filtroNombre) {
        List<Producto> lista;

        if ((filtroNombre != null && filtroNombre.length()>0 )) {
            lista = this.productoRepository.findByTitulo(filtroNombre);
        } else {  // Quiero mostrar todos
            lista = this.productoRepository.findAll();
        }
        return this.convertirAListaDTO(lista);
    }

    public List<ProductoDTO> listarProductos () {
        return this.listarProductos(null);
    }

    public void borrarProducto (Integer id) {
        Producto pr = this.productoRepository.findById(id).orElse(null);
        this.productoRepository.delete(pr);
    }

    public ProductoDTO buscarProducto (Integer id) {
        Producto pr = this.productoRepository.findById(id).orElse(null);
        if (pr != null) {
            return pr.toDTO();
        } else {
            return null;
        }
    }

    public void guardarProducto(ProductoDTO dto){
        Producto us;
        us = new Producto();
        //TODO
    }
}
