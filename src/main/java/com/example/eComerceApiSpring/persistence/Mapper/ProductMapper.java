package com.example.eComerceApiSpring.persistence.Mapper;

import com.example.eComerceApiSpring.domain.Product;
import com.example.eComerceApiSpring.persistence.entity.Producto;
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
            @Mapping(source = "codigoBarra", target = "codigoBarra"),
            @Mapping(source = "categoria",target = "categoria")
    })
    Product toProduct(Producto producto);
    List<Product> toProductos(List<Producto> products);

    @InheritInverseConfiguration
    Producto toProduct(Product product);

}
