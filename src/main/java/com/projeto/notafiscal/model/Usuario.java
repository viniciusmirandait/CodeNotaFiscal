package com.projeto.notafiscal.model;

import jakarta.persistence.*;

@Entity
@Table (name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, columnDefinition = "varchar(255) default 'TEMPORARY_VALUE'")
    private String userName;
    @Column(nullable = false, columnDefinition = "varchar(255) default 'TEMPORARY_VALUE'")
    private String password;

    public Usuario() {
        
    }

    public Usuario(String userName, String password){
        this.userName = userName;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
