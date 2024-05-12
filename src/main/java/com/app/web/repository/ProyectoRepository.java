package com.app.web.repository;

import com.app.web.entities.Proyecto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProyectoRepository extends CrudRepository<Proyecto, Long> {
}
