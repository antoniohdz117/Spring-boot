package com.daw.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/computadoraxcomponente")
@RestController
public class ComputadoraxComponenteController
 {
  @Autowired
  private ComputadoraXComponenteService computadoraXComponenteService;

  @GetMapping("/by-computadora/{idComputadora}")
  public ResponseEntity<List<ComputadoraXComponente>> getByComputadora(@PathVariable Integer idComputadora) {
   return ResponseEntity.ok(computadoraXComponenteService.findByComputadora(idComputadora));
  }

  @GetMapping("/by-componente/{idComponente}")
  public ResponseEntity<List<ComputadoraXComponente>> getByComponente(@PathVariable Integer idComponente) {
   return ResponseEntity.ok(computadoraXComponenteService.findByComponente(idComponente));
  }

  @PostMapping
  public ResponseEntity<ComputadoraXComponente> createRelation(@RequestBody ComputadoraXComponente relation) {
   return ResponseEntity.ok(computadoraXComponenteService.save(relation));
  }

  @PutMapping
  public ResponseEntity<ComputadoraXComponente> updateRelation(@RequestBody ComputadoraXComponente relation) {
   return ResponseEntity.ok(computadoraXComponenteService.save(relation));
  }

  @DeleteMapping("/{idComputadora}/{idComponente}")
  public ResponseEntity<Void> deleteRelation(
          @PathVariable Integer idComputadora,
          @PathVariable Integer idComponente) {
   computadoraXComponenteService.delete(idComputadora, idComponente);
   return ResponseEntity.noContent().build();
  }

 }
