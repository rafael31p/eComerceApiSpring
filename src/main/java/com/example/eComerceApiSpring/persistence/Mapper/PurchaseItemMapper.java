package com.example.eComerceApiSpring.persistence.Mapper;

import com.example.eComerceApiSpring.domain.PurchaseItem;
import com.example.eComerceApiSpring.persistence.entity.CompraProducto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface PurchaseItemMapper {
    @Mappings({
            @Mapping(source = "id.idProducto", target = "productId"),
            @Mapping(source = "cantidad", target = "quantity"),
            @Mapping(source = "estado", target = "active")
    })
    PurchaseItem toPurchaseItem(CompraProducto compraProducto);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "compras", expression = "java(null)"),
            @Mapping(target = "id.idCompra", ignore = true),
            @Mapping(target = "producto", expression = "java(null)")
    })
    CompraProducto toCompraProducto(PurchaseItem purchaseItem);
}
