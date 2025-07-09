package br.com.dio.desafio.dominio;

import java.util.Objects;

public non-sealed class Curso extends Conteudo {
    private int cargaHoraria;

    @Override
    public double calcularXp() {
        return XP_PADRAO * cargaHoraria;
    }

    public int getCargaHoraria() {
        return this.cargaHoraria;
    }

    public void setCargaHoraria(final int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (obj == null || this.getClass() != obj.getClass())
            return false;
        if (!super.equals(obj))
            return false;
        final Curso curso = (Curso) obj;
        return this.cargaHoraria == curso.cargaHoraria;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), this.cargaHoraria);
    }

    @Override
    public String toString() {
        return "Curso [cargaHoraria=" + cargaHoraria + "] é filho de " + super.toString();
    }
}