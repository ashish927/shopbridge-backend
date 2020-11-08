package com.thinkbridge.shopbridge.repository;

import com.thinkbridge.shopbridge.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
}
