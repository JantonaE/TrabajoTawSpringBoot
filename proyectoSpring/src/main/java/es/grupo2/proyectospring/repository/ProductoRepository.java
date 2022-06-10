package es.grupo2.proyectospring.repository;

import es.grupo2.proyectospring.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto,Integer> {
    public List<Producto> findByTitulo(String titulo);
}
