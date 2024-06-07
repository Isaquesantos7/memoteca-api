package com.example.memoteca.models;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name="tb_pensamentos")
public class Memoteca implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String conteudo;
    private String autor;
    private String modelo;

    public Memoteca() {}

    public Memoteca(Integer id, String conteudo, String autor, String modelo) {
        this.id = id;
        this.conteudo = conteudo;
        this.autor = autor;
        this.modelo = modelo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Memoteca memoteca = (Memoteca) o;
        return Objects.equals(id, memoteca.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
