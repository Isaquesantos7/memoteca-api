package com.example.memoteca.repositories;

import com.example.memoteca.models.Memoteca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemotecaRepository extends JpaRepository<Memoteca, Integer> {
}
