package com.daw.demo.service;

@Service
@Transactional
public class FormaPagoService {
    private final FormaPagoRepository formaPagoRepository;

    public FormaPagoService(FormaPagoRepository formaPagoRepository) {
        this.formaPagoRepository = formaPagoRepository;
    }

    public List<FormaPago> findAll() {
        return formaPagoRepository.findAll();
    }

    public Optional<FormaPago> findById(Integer id) {
        return formaPagoRepository.findById(id);
    }

    public FormaPago save(FormaPago formaPago) {
        // Validar datos de tarjeta
        if (formaPago.getTipoPago().equalsIgnoreCase("tarjeta") &&
                formaPago.getNumero().toString().length() != 16) {
            throw new IllegalArgumentException("Número de tarjeta inválido");
        }
        return formaPagoRepository.save(formaPago);
    }

    public void deleteById(Integer id) {
        formaPagoRepository.deleteById(id);
    }



}
