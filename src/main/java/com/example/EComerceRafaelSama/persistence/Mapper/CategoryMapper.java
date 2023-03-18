package com.example.EComerceRafaelSama.persistence.Mapper;

import com.example.EComerceRafaelSama.domain.Category;
import com.example.EComerceRafaelSama.persistence.entity.categoria;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    @Mappings({
            @Mapping(source = "idCategoria", target = "categoryId"),
            @Mapping(source = "descripcion", target = "descripcion"),
            @Mapping(source = "estado", target = "estado")
    })
    Category toCategory(categoria categoria);

    @InheritInverseConfiguration
    @Mapping(target = "estado", ignore = true)
    categoria toCategoria(Category category);
}
