package com.projeto.notafiscal.service;

import com.projeto.notafiscal.exceptions.ResourceNotFoundException;
import com.projeto.notafiscal.model.Usuario;
import com.projeto.notafiscal.repository.UsuarioRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository repository)
    {
        this.repository = repository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public List<Usuario> listarUsuarios(){
        return repository.findAll();
    }

    public Usuario buscarPorId(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário com Id" + id + "não foi encontrado."));
    }

    public void deletarUsuario(Long id){
        if(!repository.existsById(id)){
            throw new ResourceNotFoundException("Usuário com Id" + id + "não foi encontrado.");
        }
        repository.deleteById(id);
    }

    public Usuario salvarUsuario(String userName, String password){
        String senhaCriptografada = passwordEncoder.encode(password);
        Usuario usuario = new Usuario(userName, senhaCriptografada);
        return repository.save(usuario);
    }

    public Optional<Usuario> buscarPorUserName(String userName){
        return repository.findByUserName(userName);
    }
}
