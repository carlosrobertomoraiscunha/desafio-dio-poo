package br.com.dio.desafio.dominio;

import java.time.LocalDate;
import java.util.Objects;

public class Mentoria {
    private String titulo;
    private String descricao;
    private LocalDate data;

    public Mentoria() {
    }

    public Mentoria(String titulo, String descricao, LocalDate data) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.data = data;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getData() {
        return this.data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Curso[")
                .append("titulo=").append(this.titulo).append(", ")
                .append("descricao=").append(this.descricao).append(", ")
                .append("data=").append(this.data).append("]");

        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Mentoria))
            return false;
        Mentoria mentoria = (Mentoria) obj;
        return Objects.equals(this.titulo, mentoria.titulo)
                && Objects.equals(this.descricao, mentoria.descricao)
                && this.data == mentoria.data;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.titulo, this.descricao, this.data);
    }
}