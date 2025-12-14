package com.projeto.notafiscal.controller;

import com.projeto.notafiscal.model.Usuario;
import com.projeto.notafiscal.security.JwtUtil;
import com.projeto.notafiscal.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;
import java.util.Optional;

public class AuthController {

    private final UsuarioService usuarioService;

    public AuthController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Map<String, String> request){
        Usuario usuario = usuarioService.salvarUsuario(request.get("userName"), request.get(("password")));
        return ResponseEntity.ok(usuario);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> request){
        Optional<Usuario> usuario = usuarioService.buscarPorUserName(request.get("userName"));
        if(usuario.isPresent() && usuario.get().getPassword().equals((request.get("password")))){
            String token = JwtUtil.generateToken((usuario.get().getUserName()));
            return ResponseEntity.ok(Map.of("token", token));
        }
        return ResponseEntity.status(401).body("Credenciais Invalidas");
    }

}
