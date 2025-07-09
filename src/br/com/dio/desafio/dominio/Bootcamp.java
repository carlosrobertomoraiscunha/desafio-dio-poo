package br.com.dio.desafio.dominio;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class Bootcamp {
    private String nome;
    private String descricao;
    private final LocalDate dataInicial = LocalDate.now();
    private final LocalDate dataFinal = this.dataInicial.plusDays(45);
    private Set<Dev> devsInscritos = new HashSet<>();
    private Set<Conteudo> conteudos = new LinkedHashSet<>();

    public String getNome() {
        return nome;
    }

    public void setNome(final String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(final String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataInicial() {
        return dataInicial;
    }

    public LocalDate getDataFinal() {
        return dataFinal;
    }

    public Set<Dev> getDevsInscritos() {
        return devsInscritos;
    }

    public void setDevsInscritos(final Set<Dev> devsInscritos) {
        this.devsInscritos = devsInscritos;
    }

    public Set<Conteudo> getConteudos() {
        return conteudos;
    }

    public void setConteudos(final Set<Conteudo> conteudos) {
        this.conteudos = conteudos;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (obj == null || this.getClass() != obj.getClass())
            return false;
        final Bootcamp bootcamp = (Bootcamp) obj;
        return Objects.equals(this.nome, bootcamp.nome)
                && Objects.equals(this.descricao, bootcamp.descricao)
                && Objects.equals(this.dataInicial, bootcamp.dataInicial)
                && Objects.equals(this.dataFinal, bootcamp.dataFinal)
                && Objects.equals(this.devsInscritos, bootcamp.devsInscritos)
                && Objects.equals(this.conteudos, bootcamp.conteudos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.nome, this.descricao, this.dataInicial, this.dataFinal, this.devsInscritos,
                this.conteudos);
    }

    @Override
    public String toString() {
        return "Bootcamp [nome=" + nome + ", descricao=" + descricao + ", dataInicial=" + dataInicial + ", dataFinal="
                + dataFinal + ", devsInscritos=" + devsInscritos + ", conteudos=" + conteudos + "]";
    }
}