package com.xavierdias.clickhouse.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Usuario{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long idusuario;
    
    @NotNull
    private String nome;
    
    @NotNull
    private String email;
    
    @NotNull
    private String telefone;
    
    @NotNull
    @Size(min = 8, message = "Senha deve ter no mínimo 8 caracteres")
    private String senha;


    public Usuario(){
        super();
    }


    public long getIdusuario() {
        return idusuario;
    }
    public void setIdusuario(long idusuario) {
        this.idusuario = idusuario;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString(){
        return String.format("Usuário [id = %s, nome = %s, email = %s, telefone = %s, senha = %s]", idusuario, nome, email, telefone, senha);
    }
}


