package com.company.market.persistence;

import com.company.market.persistence.crud.ProductoCrudRepositorio;
import com.company.market.persistence.entity.Producto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class ProductoRepository {
    private ProductoCrudRepositorio productoCrudRepositorio;

    public List<Producto> getAll(){
        return (List<Producto>) productoCrudRepositorio.findAll();
    }
    public List<Producto> getByCategoria(int idCategoria){
        return productoCrudRepositorio.findByIdCategoriaOrderByNombreAsc(idCategoria);
    }
    public Optional<List<Producto>> getEscasos(int cantidad){
        return productoCrudRepositorio.findByCantidadStockLessThanAndEstado(cantidad, true);
    }
    public Optional<Producto> getProduct(int idProducto){
        return productoCrudRepositorio.findById(idProducto);
    }
    public Producto save(Producto producto){
        return productoCrudRepositorio.save(producto);
    }
    public void delete(int idProducto){
        productoCrudRepositorio.deleteById(idProducto);
    }
}
