package com.example.springsecurity.services.groupe;

import com.example.springsecurity.entities.Groupe;
import com.example.springsecurity.repositories.GroupeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupeServiceImpl implements GroupeService {
    private final GroupeRepository repository;

    @Autowired
    public GroupeServiceImpl(GroupeRepository groupeRepository){
        this.repository = groupeRepository;
    }

    @Override
    public List<Groupe> findAll() {
        return this.repository.findAll();
    }

    @Override
    public Groupe findById(Long id) {
        if (this.repository.findById(id).isPresent()) return this.repository.findById(id).get();
        else return null;
    }
}
