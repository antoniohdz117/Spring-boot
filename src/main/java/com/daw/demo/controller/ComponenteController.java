package com.daw.demo.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/componente")
public class ComponenteController {
    private final ComponenteService componenteService;

    public ComponenteController(ComponenteService componenteService) {
        this.componenteService = componenteService;
    }

    @GetMapping
    public List<Componente> getAllComponentes() {
        return componenteService.findAll();
    }

    @GetMapping("/{id}")
    public Componente getComponenteById(@PathVariable int id) {
        return componenteService.findById(id);
    }

    @GetMapping("/by-categoria/{idCategoria}")
    public List<Componente> getComponentesByCategoria(@PathVariable int idCategoria) {
        return componenteService.findByCategoria(idCategoria);
    }

    @PostMapping
    public Componente createComponente(@RequestBody Componente componente) {
        return componenteService.save(componente);
    }

    @PutMapping("/{id}")
    public Componente updateComponente(@PathVariable int id, @RequestBody Componente componente) {
        componente.setIdComponente(id);
        return componenteService.save(componente);
    }

    @DeleteMapping("/{id}")
    public void deleteComponente(@PathVariable int id) {
        componenteService.deleteById(id);
    }
}
