package br.com.dio.desafio.dominio;

import java.util.Objects;

public class Curso {
    private String titulo;
    private String descricao;
    private int cargaHoraria;

    public Curso() {
    }

    public Curso(String titulo, String descricao, int cargaHoraria) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.cargaHoraria = cargaHoraria;
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

    public int getCargaHoraria() {
        return this.cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Curso[")
                .append("titulo=").append(this.titulo).append(", ")
                .append("descricao=").append(this.descricao).append(", ")
                .append("cargaHoraria=").append(this.cargaHoraria).append("]");

        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Curso))
            return false;
        Curso curso = (Curso) obj;
        return Objects.equals(this.titulo, curso.titulo)
                && Objects.equals(this.descricao, curso.descricao)
                && this.cargaHoraria == curso.cargaHoraria;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.titulo, this.descricao, this.cargaHoraria);
    }
}