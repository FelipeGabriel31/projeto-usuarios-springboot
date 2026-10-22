package br.com.trabalho.usuarios.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.trabalho.usuarios.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
