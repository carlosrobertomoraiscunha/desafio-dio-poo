package br.com.dio.desafio.dominio;

import java.util.Objects;

public sealed abstract class Conteudo permits Curso, Mentoria {
    protected static final double XP_PADRAO = 10d;

    private String titulo;
    private String descricao;

    public abstract double calcularXp();

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(final String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(final String descricao) {
        this.descricao = descricao;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.titulo, this.descricao);
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (obj == null || this.getClass() != obj.getClass())
            return false;
        final Conteudo conteudo = (Conteudo) obj;
        return Objects.equals(this.titulo, conteudo.titulo)
                && Objects.equals(this.descricao, conteudo.descricao);
    }

    @Override
    public String toString() {
        return "Conteudo [titulo=" + titulo + ", descricao=" + descricao + "]";
    }
}
