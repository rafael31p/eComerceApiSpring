package com.example.EComerceRafaelSama.persistence.Mapper;

import com.example.EComerceRafaelSama.domain.Product;
import com.example.EComerceRafaelSama.persistence.entity.producto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface ProductMapper {
    @Mappings({
            @Mapping(source = "idProducto",target = "idProducto"),
            @Mapping(source = "nombre",target = "nombre"),
            @Mapping(source = "idCategoria",target = "idCategoria"),
            @Mapping(source = "precioVenta",target = "precioVenta"),
            @Mapping(source = "cantidad",target = "cantidad"),
            @Mapping(source = "estado",target = "estado"),
            @Mapping(source = "categoria",target = "categoria")
    })
    Product toProduct(producto producto);
    List<Product> toProductos(List<producto> products);

    @InheritInverseConfiguration
    @Mapping(target = "codigoBarras", ignore = true)
    producto toProduct(Product product);

}
