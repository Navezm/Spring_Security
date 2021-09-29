package com.example.springsecurity.services.groupe;

import com.example.springsecurity.entities.Groupe;

import java.util.List;

public interface GroupeService {
    List<Groupe> findAll();

    Groupe findById(Long id);
}
