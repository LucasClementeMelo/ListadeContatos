package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Contato;

public interface ContatoRepository extends JpaRepository<Contato, Integer> {

}
