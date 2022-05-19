package me.dio.academia.digital.controller;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AlunoUpdateForm;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaForm;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaUpdateForm;
import me.dio.academia.digital.service.impl.AvaliacaoFisicaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoFisicaController {

    @Autowired
    private AvaliacaoFisicaServiceImpl service;

    @PostMapping
    public AvaliacaoFisica create(@Valid @RequestBody AvaliacaoFisicaForm form) {
        return  service.create(form);
    }

    @GetMapping(path = {"/{id}"})
    public AvaliacaoFisica getAvaliacaoFisica(@PathVariable Long id) {
        return service.get(id);
    }

    @GetMapping
    public List<AvaliacaoFisica> getAll() {
        return service.getAll();
    }

    @PutMapping(path = {"/{id}"})
    public AvaliacaoFisica Update(@PathVariable Long id, @Valid @RequestBody AvaliacaoFisicaUpdateForm form) {
        return service.update(id, form);
    }

    @DeleteMapping(path = {"/{id}"})
    public void Delete(@PathVariable Long id) {
        service.delete(id);
    }
}
