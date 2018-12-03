package com.xavierdias.clickhouse.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="usuario_anuncio")
public class UsuarioAnuncio {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long idusuarioanuncio;

    @ManyToOne
    @JoinColumn(name="fk_idanuncio", nullable=false)
    private Anuncio anuncio;

    @NotNull
    private long fk_idusuario;

    public UsuarioAnuncio(final long idusuarioanuncio, final Anuncio anuncio){
        this.idusuarioanuncio = idusuarioanuncio;
        this.anuncio = anuncio;
    }

    public long getIdusuarioanuncio() { return idusuarioanuncio; }

    public void setIdusuarioanuncio(long idusuarioanuncio) { this.idusuarioanuncio = idusuarioanuncio; }

    public Anuncio getAnuncio() { return anuncio; }

    public void setAnuncio(Anuncio anuncio) { this.anuncio = anuncio; }

    public long getFk_idusuario() { return fk_idusuario; }

    public void setFk_idusuario(long fk_idusuario) { this.fk_idusuario = fk_idusuario; }
}
