package com.daw.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public class UsuarioRepository {


    @Repository
    public interface usuarioRepository<Usuario> extends JpaRepository<Usuario, Integer> {

        List<Usuario> findByRolIdRol(int idRol);
        // Consulta por email
        <usurious> Optional<usurious> findByEmail(String email);

        // Consulta por rol
        List<Usuario> findByRol_IdRol(Integer idRol);

        // Consulta por tipo de cliente
        List<Usuario> findByTipoCliente(String tipoCliente);

    /*
    // Consulta combinada
    @Query("SELECT u FROM Usuario u WHERE u.nombre LIKE %:nombre% AND u.rol.idRol = :idRol")
    List<Usuario> buscarPorNombreYRol(String nombre, Integer idRol);

    // Consulta para autenticación
    @Query("SELECT u FROM usuario u WHERE u.email = :email AND u.contrasenia = :contrasenia")
    Optional<Usuario> autenticarUsuario(String email, String contrasenia);

    */
    }
}
