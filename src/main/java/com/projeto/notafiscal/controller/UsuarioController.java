package com.projeto.notafiscal.controller;

import com.projeto.notafiscal.exceptions.ResourceNotFoundException;
import com.projeto.notafiscal.model.Usuario;
import com.projeto.notafiscal.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {
    private final UsuarioService service;

    public UsuarioController(UsuarioService service){
        this.service = service;
    }

    @GetMapping
    public List<Usuario> listarUsuarios(){

        return service.listarUsuarios();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarUsuario(@PathVariable Long id){
            Usuario usuario = service.buscarPorId(id);
            return ResponseEntity.ok(usuario);
    }

    //@PostMapping
    //public Usuario criarUsuario(@RequestBody Usuario usuario){
       // return service.salvarUsuario(usuario);
   // }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable Long id){
        service.deletarUsuario(id);
        return ResponseEntity.noContent().build();
    }

}
