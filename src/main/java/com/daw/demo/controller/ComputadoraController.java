package com.daw.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Ccomputadora")
public class ComputadoraController {
    @Autowired
    private ComputadoraService computadoraService;

    @GetMapping
    public ResponseEntity<List<Computadora>> getAllComputadoras() {
        return ResponseEntity.ok(computadoraService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Computadora> getComputadoraById(@PathVariable Integer id) {
        return computadoraService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Computadora> createComputadora(@RequestBody Computadora computadora) {
        return ResponseEntity.ok(computadoraService.save(computadora));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Computadora> updateComputadora(@PathVariable Integer id, @RequestBody Computadora computadora) {
        computadora.setIdComputadora(id);
        return ResponseEntity.ok(computadoraService.save(computadora));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComputadora(@PathVariable Integer id) {
        computadoraService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
