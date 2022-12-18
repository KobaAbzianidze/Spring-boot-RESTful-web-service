package com.example.springbootrestfulwebservice.repositories;

import com.example.springbootrestfulwebservice.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository<Item , Long> {

    Optional<Item> findBySerialNumber(String serialNumber);

    void deleteBySerialNumber(String serialNumber);
}
