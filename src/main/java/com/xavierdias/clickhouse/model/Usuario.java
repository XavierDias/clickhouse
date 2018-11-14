package com.xavierdias.clickhouse.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="usuario")
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

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "usuario_anuncio",
        joinColumns = { @JoinColumn(name = "fk_idusuario") },
        inverseJoinColumns = { @JoinColumn(name = "fk_idanuncio") }
    )
    Set<Anuncio> anuncios = new HashSet<>();


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

    public String getUsername() {
        return email;
    }
    public void setUsername(String email) {
        this.email = email;
    }

    public String getPassword() {
        return senha;
    }
    public void setPassword(String senha) {
        this.senha = senha;
    }

    public Set<Anuncio> getAnuncios() { return anuncios; }
    public void setAnuncios(Set<Anuncio> anuncios) { this.anuncios = anuncios; }

    @Override
    public String toString(){
        return String.format("Usuário [id = %s, nome = %s, email = %s, telefone = %s, senha = %s]", idusuario, nome, email, telefone, senha);
    }
}



