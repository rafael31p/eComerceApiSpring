package com.example.eComerceApiSpring.persistence;

import com.example.eComerceApiSpring.domain.Purchase;
import com.example.eComerceApiSpring.domain.repository.PurchaseRepository;
import com.example.eComerceApiSpring.persistence.Mapper.PurchaseMapper;
import com.example.eComerceApiSpring.persistence.crud.CompraCrudRepository;
import com.example.eComerceApiSpring.persistence.entity.Compra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
@Repository
public class CompraRepository implements PurchaseRepository {
    @Autowired
    private CompraCrudRepository compraCrudRepository;
    @Autowired
    private PurchaseMapper purchaseMapper;

    @Override
    public List<Purchase> getAll() {
        return purchaseMapper.toPurchases((List<Compra>) compraCrudRepository.findAll());
    }

    @Override
    public Optional<List<Purchase>> getByClient(String clienId) {
        return compraCrudRepository.findByIdCliente(clienId).map(compras ->
                purchaseMapper.toPurchases(compras));
    }

    @Override
    public Purchase save(Purchase purchase) {
        Compra compra = purchaseMapper.toCompra(purchase);
        compra.setFecha(LocalDateTime.now());
        compra.getCompraProductos().forEach(compraProducto -> compraProducto.setCompras(compra));
        return purchaseMapper.toPurchase(compraCrudRepository.save(compra));
    }
}
