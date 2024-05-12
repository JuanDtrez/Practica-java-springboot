package com.app.web.controller;

import com.app.web.entities.Alumno;
import com.app.web.repository.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ApiController {

    @Autowired
    private AlumnoRepository alumRepository;

    @GetMapping({"/",""})
    public String home(Model modelo) {
        List<Alumno> alumnos = alumRepository.findAll();
        modelo.addAttribute("alumnos", alumnos);
        return "index";
    }

    @GetMapping("/nuevo")
    public String formularioAlumno(Model modelo) {
        modelo.addAttribute("alumno", new Alumno());
        return "nuevo";
    }

    @PostMapping("/nuevo")
    public String guardarAlumno(@Validated Alumno alumno, BindingResult bindingResult, RedirectAttributes redirect,  Model modelo) {
        if(bindingResult.hasErrors()) {
            modelo.addAttribute("alumno", alumno);
            return "nuevo";
        }
        alumRepository.save(alumno);
        redirect.addFlashAttribute("msgSuccess","El alumno ha sido agregado con exito");
        return "redirect:/";
    }

    @GetMapping("/{id}/editar")
    public String formularioEditarAlumno(@PathVariable Integer id, Model modelo) {
        Alumno alumno = alumRepository.getReferenceById(id);
        modelo.addAttribute("alumno", alumno);
        return "nuevo";
    }

    @PostMapping("/{id}/editar")
    public String actualizarAlumno(@PathVariable Integer id, @Validated Alumno alumno, BindingResult bindingResult, RedirectAttributes redirect,  Model modelo) {
        Alumno alumnoDB = alumRepository.getReferenceById(id);
        
        if(bindingResult.hasErrors()) {
            modelo.addAttribute("alumno", alumno);
            return "nuevo";
        }

        alumnoDB.setNombre(alumno.getNombre());
        alumnoDB.setApellido(alumno.getApellido());
        alumnoDB.setEmail(alumno.getEmail());
        alumnoDB.setDni(alumno.getDni());
        alumnoDB.setTelefono(alumno.getTelefono());
        alumnoDB.setCreatedAt(alumno.getCreatedAt());

        alumRepository.save(alumnoDB);
        redirect.addFlashAttribute("msgSuccess","El alumno ha sido actualizado con exito");
        return "redirect:/";
    }

    @PostMapping("/{id}/eliminar")
    public String eliminarAlumno(@PathVariable Integer id, RedirectAttributes redirect) {
        alumRepository.deleteById(id);
        redirect.addFlashAttribute("msgSuccess", "El alumno ha sido eliminado con éxito");
        return "redirect:/";
    }
}
