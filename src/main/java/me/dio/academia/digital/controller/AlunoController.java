package me.dio.academia.digital.controller;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AlunoForm;
import me.dio.academia.digital.entity.form.AlunoUpdateForm;
import me.dio.academia.digital.service.impl.AlunoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoServiceImpl service;

    @PostMapping
    public Aluno Create(@Valid @RequestBody AlunoForm form){
        return service.create(form);
    }

    @GetMapping(path = {"/{id}"})
    public Aluno getAluno(@PathVariable Long id) {
        return service.get(id);
    }

    @GetMapping
    public List<Aluno> getAll(@RequestParam(value = "dataDeNascimento", required = false)
                                          String dataDeNascimento) {
       return service.getAll(dataDeNascimento);
    }

    @PutMapping(path = {"/{id}"})
    public Aluno Update(@PathVariable Long id, @Valid @RequestBody AlunoUpdateForm form) {
        return service.update(id, form);
    }

    @DeleteMapping(path = {"/{id}"})
    public void Delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/avaliacoes/{id}")
    public List<AvaliacaoFisica> getAllAvaliacaoFisicaId(@PathVariable Long id) {
        return service.getAllAvaliacaoFisicaId(id);
    }
}
