package com.daw.demo.service;

@Service
@Transactional
public class CodigoService {

    private final CodigoRepository codigoRepository;

    public CodigoService(CodigoRepository codigoRepository) {
        this.codigoRepository = codigoRepository;
    }

    public List<Codigo> findAll() {
        return codigoRepository.findAll();
    }

    public Optional<Codigo> findById(Integer id) {
        return codigoRepository.findById(id);
    }

    public Codigo save(Codigo codigo) {
        return codigoRepository.save(codigo);
    }

    public void deleteById(Integer id) {
        codigoRepository.deleteById(id);
    }
}
