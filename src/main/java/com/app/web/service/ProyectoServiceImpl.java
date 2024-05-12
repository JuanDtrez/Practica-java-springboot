package com.app.web.service;

import com.app.web.entities.Proyecto;
import com.app.web.repository.ProyectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProyectoServiceImpl implements ProyectoService {

    @Autowired
    private ProyectoRepository proyectoRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Proyecto> buscarTodos() {
        return (List<Proyecto>) proyectoRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Proyecto buscarPorId(Long id) {
        return proyectoRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Proyecto guardar(Proyecto proyecto) {
        return proyectoRepository.save(proyecto);
    }

    @Override
    @Transactional
    public Proyecto borrar(Long id) {
        Proyecto proyectoBorrar = proyectoRepository.findById(id).orElse(null);
        proyectoRepository.deleteById(id);
        return proyectoBorrar;
    }
}
