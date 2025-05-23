package com.daw.demo.service;

@Service

public class ComputadoraService
{
    Private final ComputadoraRepository computadoraRepository;
    private final CodigoRepository codigoRepository;
    private final FormaPagoRepository formaPagoRepository;

    public ComputadoraService(ComputadoraRepository computadoraRepository,
                              CodigoRepository codigoRepository,
                              FormaPagoRepository formaPagoRepository) {
        this.computadoraRepository = computadoraRepository;
        this.codigoRepository = codigoRepository;
        this.formaPagoRepository = formaPagoRepository;
    }

    public List<Computadora> findAll() {
        return computadoraRepository.findAll();
    }

    public Optional<Computadora> findById(Integer id) {
        return computadoraRepository.findById(id);
    }

    public Computadora save(Computadora computadora) {
        // Validar que existan las referencias
        if (!codigoRepository.existsById(computadora.getCodigo().getIdCodigo())) {
            throw new IllegalArgumentException("Código postal no existe");
        }
        if (!formaPagoRepository.existsById(computadora.getFormaPago().getIdFormaPago())) {
            throw new IllegalArgumentException("Forma de pago no existe");
        }
        return computadoraRepository.save(computadora);
    }

    public void deleteById(Integer id) {
        computadoraRepository.deleteById(id);
    }
}
