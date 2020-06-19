/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author coliv
 */
@Entity
@Table(name = "turma_tb")
public class Turma implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "turma_id")
    private Long id;
    
    @Column(name = "nome_turma")
    private String nome;
    
    @Enumerated(EnumType.STRING)
    private TipoTurma tipo;
    
    private int ano;
    
    @Column(name = "total_alunos")
    private int totalAlunos;
    
    @OneToMany(mappedBy = "turma", cascade=CascadeType.ALL)
    private List<Aluno> alunos;

    public Turma() {
        alunos = new ArrayList<>();
    }

    public Turma(Long id, String nome, TipoTurma tipo, int ano, int totalAlunos) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.ano = ano;
        this.totalAlunos = totalAlunos;
        alunos = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoTurma getTipo() {
        return tipo;
    }

    public void setTipo(TipoTurma tipo) {
        this.tipo = tipo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getTotalAlunos() {
        return totalAlunos;
    }

    public void setTotalAlunos(int totalAlunos) {
        this.totalAlunos = totalAlunos;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(ArrayList<Aluno> alunos) {
        this.alunos = alunos;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.id);
        hash = 17 * hash + Objects.hashCode(this.nome);
        hash = 17 * hash + Objects.hashCode(this.tipo);
        hash = 17 * hash + this.ano;
        hash = 17 * hash + this.totalAlunos;
        hash = 17 * hash + Objects.hashCode(this.alunos);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Turma other = (Turma) obj;
        if (this.ano != other.ano) {
            return false;
        }
        if (this.totalAlunos != other.totalAlunos) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (this.tipo != other.tipo) {
            return false;
        }
        if (!Objects.equals(this.alunos, other.alunos)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Turma{" + "id=" + id + ", nome=" + nome + ", tipo=" + tipo + ", ano=" + ano + ", totalAlunos=" + totalAlunos + '}';
    }
    
    
    
    
    
}
