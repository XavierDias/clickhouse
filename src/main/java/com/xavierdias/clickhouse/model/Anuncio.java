package com.xavierdias.clickhouse.model;

import com.xavierdias.clickhouse.report.ToMapInterface;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.*;

@Entity
@Table(name="anuncio")
public class Anuncio implements ToMapInterface {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long idanuncio;

    @NotNull
    private String tipoanuncio;

    @NotNull
    private String tipoimovel;

    @NotNull
    private String cidade;

    @NotNull
    private String estado;

    @NotNull
    private String rua;

    @NotNull
    private String bairro;

    @NotNull
    private double areatotal;

    @NotNull
    private double areaconstruida;

    @NotNull
    private String descricao;

    @NotNull
    private double valor;

    @NotNull
    private long fk_idusuario;

    @ManyToMany(mappedBy = "anuncios")
    private Set<Usuario> usuarios = new HashSet<>();


    public Anuncio(){
        super();
    }


    public long getIdanuncio() {
        return idanuncio;
    }
    public void setIdanuncio(long idanuncio) {
        this.idanuncio = idanuncio;
    }

    public String getTipoanuncio() {
        return tipoanuncio;
    }
    public void setTipoanuncio(String tipoanuncio) {
        this.tipoanuncio = tipoanuncio;
    }

    public String getTipoimovel() {
        return tipoimovel;
    }
    public void setTipoimovel(String tipoimovel) {
        this.tipoimovel = tipoimovel;
    }

    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getRua() {
        return rua;
    }
    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public double getAreatotal() {
        return areatotal;
    }
    public void setAreatotal(double areatotal) {
        this.areatotal = areatotal;
    }

    public double getAreaconstruida() {
        return areaconstruida;
    }
    public void setAreaconstruida(double areaconstruida) {
        this.areaconstruida = areaconstruida;
    }

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }

    public long getFk_idusuario() {
        return fk_idusuario;
    }
    public void setFk_idusuario(long fk_idusuario) {
        this.fk_idusuario = fk_idusuario;
    }

    public Set<Usuario> getUsuarios() { return usuarios; }
    public void setUsuarios(Set<Usuario> usuarios) { this.usuarios = usuarios; }

    @Override
    public String toString(){
        return String.format("Anuncio [id = %s, tipoanuncio = %s, tipoimovel = %s, cidade = %s, estado = %s, rua = %s, bairro = %s, areatotal = %s, areaconstruida = %s, descricao = %s, valor = %s, fk_id= %s]", idanuncio, tipoanuncio, tipoimovel, cidade, estado,
                rua, bairro, areatotal, areaconstruida, descricao, valor, fk_idusuario);
    }

    public Map<String, ?> toMap() {
        Map lista = new HashMap();

        lista.put("idanuncio", idanuncio);
        lista.put("tipoanuncio", tipoanuncio);
        lista.put("tipoimovel", tipoimovel);
        lista.put("cidade", cidade);
        lista.put("estado", estado);
        lista.put("bairro", bairro);
        lista.put("areatotal", areatotal);
        lista.put("areaconstruida", areaconstruida);
        lista.put("descricao", descricao);
        lista.put("valor", valor);

        return lista;
    }
}


