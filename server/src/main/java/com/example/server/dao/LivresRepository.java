package com.example.server.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.server.entity.Livres;

public interface LivresRepository extends JpaRepository<Livres, Long> {
}

