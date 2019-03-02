package br.com.home.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
public class Tarefa implements Serializable, Comparable<Tarefa> {
    @Id
    @GeneratedValue
    private int id;

    @NotNull(message = "{tarefa.descricao.vazia}")
    @Size(min = 5, message = "{tarefa.descricao.pequena}")
    private String descricao;

    private boolean finalizado;

    @Temporal(TemporalType.TIMESTAMP)
    private Date datafinalizacao;

    public Tarefa() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isFinalizado() {
        return finalizado;
    }

    public void setFinalizado(boolean finalizado) {
        this.finalizado = finalizado;
    }

    public Date getDatafinalizacao() {
        return datafinalizacao;
    }

    public void setDatafinalizacao(Date datafinalizacao) {
        this.datafinalizacao = datafinalizacao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tarefa tarefa = (Tarefa) o;
        return id == tarefa.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public int compareTo(Tarefa o) {
        if (this.getId() < o.getId()) {
            return -1;
        }
        if (this.getId() > o.getId()) {
            return 1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("Tarefa [id=")
                .append(this.id)
                .append(", descricao=")
                .append(this.descricao)
                .append(", finalizado=")
                .append(this.finalizado)
                .append(", dataFinalizacao=")
                .append(this.datafinalizacao)
                .append("]")
                .toString();
    }
}
