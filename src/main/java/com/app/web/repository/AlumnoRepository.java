package com.app.web.repository;

import com.app.web.entities.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlumnoRepository  extends JpaRepository <Alumno, Integer> {
}
