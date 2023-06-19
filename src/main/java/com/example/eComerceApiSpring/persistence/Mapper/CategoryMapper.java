package com.example.eComerceApiSpring.persistence.Mapper;

import com.example.eComerceApiSpring.domain.Category;
import com.example.eComerceApiSpring.persistence.entity.Categoria;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    @Mappings({
            @Mapping(source = "idCategoria", target = "categoryIdCompra"),
            @Mapping(source = "descripcion", target = "descripcion"),
            @Mapping(source = "estado", target = "estado")
    })
    Category toCategory(Categoria categoria);

    @InheritInverseConfiguration
    @Mapping(target = "productos", ignore = true)
    Categoria toCategoria(Category category);
}
