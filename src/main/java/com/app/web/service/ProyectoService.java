package com.app.web.service;

import com.app.web.entities.Proyecto;

import java.util.List;

public interface ProyectoService {
    // metodo para devolver todos los registros
    public List<Proyecto> buscarTodos();
    // metodo para buscar un registro por id
    public Proyecto buscarPorId(Long id);
    // metodo para registro
    public Proyecto guardar(Proyecto proyecto);
    // metodo para eliminar
    public Proyecto borrar(Long id);
}
