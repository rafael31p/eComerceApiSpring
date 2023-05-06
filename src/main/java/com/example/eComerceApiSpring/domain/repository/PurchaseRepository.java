package com.example.eComerceApiSpring.domain.repository;

import com.example.eComerceApiSpring.domain.Purchase;
import com.example.eComerceApiSpring.domain.PurchaseItem;

import java.util.List;
import java.util.Optional;

public interface PurchaseRepository {
    List<Purchase> getAll();
    Optional<List<Purchase>> getByClient(String clienId);
    Purchase save(Purchase purchase);
}
