package br.com.trabalho.usuarios.configuration;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.trabalho.usuarios.model.Usuario;
import br.com.trabalho.usuarios.repository.UsuarioRepository;

@Configuration
public class UsuarioConfiguration {

    @Bean
    CommandLineRunner inserirUsuarios(UsuarioRepository usuarioRepository) {
        return args -> {
            if (usuarioRepository.count() == 0) {
                // Registros demonstrativos (CPFs ficticios, nao validos para uso real).
                usuarioRepository.saveAll(List.of(
                    new Usuario("Ana", "Souza", "00000000001"),
                    new Usuario("Bruno", "Lima", "00000000002"),
                    new Usuario("Carla", "Oliveira", "00000000003"),
                    new Usuario("Daniel", "Santos", "00000000004"),
                    new Usuario("Eduarda", "Costa", "00000000005")
                ));
            }
        };
    }
}
