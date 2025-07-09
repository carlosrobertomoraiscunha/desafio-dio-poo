package br.com.dio.desafio.dominio;

import java.time.LocalDate;
import java.util.Objects;

public non-sealed class Mentoria extends Conteudo {
    private LocalDate data;

    @Override
    public double calcularXp() {
        return XP_PADRAO * 20d;
    }

    public LocalDate getData() {
        return this.data;
    }

    public void setData(final LocalDate data) {
        this.data = data;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (obj == null || this.getClass() != obj.getClass())
            return false;
        if (!super.equals(obj))
            return false;
        final Mentoria mentoria = (Mentoria) obj;
        return Objects.equals(this.data, mentoria.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), this.data);
    }

    @Override
    public String toString() {
        return "Mentoria [data=" + data + "] é filha de  " + super.toString();
    }
}