package com.gilsontsc.agendaapi.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gilsontsc.agendaapi.model.entity.Contato;

public interface ContatoRepository extends JpaRepository<Contato, Integer>{

}