package com.example.memoteca.controllers;

import com.example.memoteca.DTOS.MemotecaDTO;
import com.example.memoteca.models.Memoteca;
import com.example.memoteca.repositories.MemotecaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
public class MemotecaController {

    private MemotecaRepository memotecaRepository;

    public MemotecaController(MemotecaRepository memotecaRepository) {
        this.memotecaRepository = memotecaRepository;
    }

    @GetMapping("/api/pensamentos")
    public ResponseEntity<List<Memoteca>> listaPensamento() {
        List<Memoteca> listaPensamentos = this.memotecaRepository.findAll();

        return ResponseEntity.status(HttpStatus.OK).body(listaPensamentos);
    }

    @GetMapping("/api/pensamentos/{id}")
    public ResponseEntity<Object> umPensamento(@PathVariable(value="id") Integer id) {
        Optional<Memoteca> memoteca = this.memotecaRepository.findById(id);

        if (memoteca.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"message\": \"Pensamento não encontrado!\"}");
        }

        return ResponseEntity.status(HttpStatus.OK).body(memoteca.get());
    }

    @PutMapping("/api/pensamentos/{id}")
    public ResponseEntity<Object> atualizarPensamento(@PathVariable(value="id") Integer id ,@RequestBody @Valid MemotecaDTO memotecaDTO) {
        Optional<Memoteca> memoteca = this.memotecaRepository.findById(id);

        if (memoteca.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"message\": \"Pensamento não encontrado!\"}");
        }

        Memoteca modeloMemoteca = memoteca.get();
        BeanUtils.copyProperties(memotecaDTO, modeloMemoteca);
        return ResponseEntity.status(HttpStatus.OK).body(this.memotecaRepository.save(modeloMemoteca));
    }

    @PostMapping("/api/pensamentos")
    public ResponseEntity<Memoteca> SalvaPensamento(@RequestBody @Valid MemotecaDTO memotecaDTO) {
        Memoteca memoteca = new Memoteca();

        BeanUtils.copyProperties(memotecaDTO, memoteca);
        return ResponseEntity.status(HttpStatus.CREATED).body(this.memotecaRepository.save(memoteca));
    }

    @DeleteMapping("/api/pensamentos/{id}")
    public ResponseEntity<Object> deletaPensamentos(@PathVariable(value="id") Integer id) {
        Optional<Memoteca> memoteca = this.memotecaRepository.findById(id);

        if (memoteca.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"message\": \"Pensamento não encontrado!\"}");
        }

        this.memotecaRepository.delete(memoteca.get());
        return ResponseEntity.status(HttpStatus.OK).body("{\"message\": \"Pensamento deletado com sucesso!\"}");
    }

}
