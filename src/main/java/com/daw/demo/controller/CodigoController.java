package com.daw.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Codigo")

public class CodigoController {

    private CodigoService codigoService;

    @GetMapping
    public ResponseEntity<List<Codigo>> getAllCodigos() {
        return ResponseEntity.ok(codigoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Codigo> getCodigoById(@PathVariable Integer id) {
        return codigoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Codigo> createCodigo(@RequestBody Codigo codigo) {
        return ResponseEntity.ok(codigoService.save(codigo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Codigo> updateCodigo(@PathVariable Integer id, @RequestBody Codigo codigo) {
        codigo.setIdCodigo(id);
        return ResponseEntity.ok(codigoService.save(codigo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCodigo(@PathVariable Integer id) {
        codigoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
