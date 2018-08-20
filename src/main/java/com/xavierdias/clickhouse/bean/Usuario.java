package com.xavierdias.clickhouse.bean;

public class Usuario{
    private Long idusuario;
    private String nome;
    private String email;
    private String telefone;
    private String senha;


    public Usuario(){
        super();
    }


    public Long getIdusuario() {
        return idusuario;
    }
    public void setIdusuario(Long idusuario) {
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



