package com.daw.demo.service;

@Service
@Transactional
public class ComputadoraxComponenteService {

    private final ComputadoraXComponenteRepository computadoraXComponenteRepository;
    private final ComputadoraRepository computadoraRepository;
    private final ComponenteRepository componenteRepository;

    public ComputadoraXComponenteService(ComputadoraXComponenteRepository computadoraXComponenteRepository,
                                         ComputadoraRepository computadoraRepository,
                                         ComponenteRepository componenteRepository) {
        this.computadoraXComponenteRepository = computadoraXComponenteRepository;
        this.computadoraRepository = computadoraRepository;
        this.componenteRepository = componenteRepository;
    }

    public List<ComputadoraXComponente> findByComputadora(Integer idComputadora) {
        return computadoraXComponenteRepository.findByIdComputadora(idComputadora);
    }

    public List<ComputadoraXComponente> findByComponente(Integer idComponente) {
        return computadoraXComponenteRepository.findByIdComponente(idComponente);
    }

    public ComputadoraXComponente save(ComputadoraXComponente relation) {
        // Validar que existan las referencias
        if (!computadoraRepository.existsById(relation.getIdComputadora())) {
            throw new IllegalArgumentException("Computadora no existe");
        }
        if (!componenteRepository.existsById(relation.getIdComponente())) {
            throw new IllegalArgumentException("Componente no existe");
        }
        return computadoraXComponenteRepository.save(relation);
    }

    public void delete(Integer idComputadora, Integer idComponente) {
        computadoraXComponenteRepository.deleteByIdComputadoraAndIdComponente(idComputadora, idComponente);
    }
}
