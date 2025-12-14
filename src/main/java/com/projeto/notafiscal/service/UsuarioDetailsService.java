package com.projeto.notafiscal.service;

import com.projeto.notafiscal.model.Usuario;
import com.projeto.notafiscal.repository.UsuarioRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioDetailsService implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioDetailsService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByUserName(username).
                orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado."));

        return User.builder()
                .username(usuario.getUserName())
                .password(usuario.getPassword())
                .roles("USER")
                .build();
    }
}
