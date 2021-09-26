package br.unicesumar.aula.modelo;

import java.io.Serializable;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_projeto")
public class Projeto implements Serializable {

    private Integer id;
    private String nome;
    private String objetivo;
    private String necessidades;
    private LocalDate dataInicio;
    private LocalDate dataFinal;
    private String status;

    private final DateTimeFormatter FORMATO_DATA = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_projeto")
    public Integer getId() {
        return id;
    }

    @Column(name = "tx_nome")
    public String getNome() {
        return nome;
    }

    @Column(name = "tx_objetivo")
    public String getObjetivo() {
        return objetivo;
    }

    @Column(name = "tx_necessidades")
    public String getNecessidades() {
        return necessidades;
    }

    @Column(name = "dt_inicio")
    public LocalDate getDataInicio() {
        return dataInicio;
    }

    @Column(name = "dt_final")
    public LocalDate getDataFinal() {
        return dataFinal;
    }

    @Column(name = "tx_status")
    public String getStatus() {
        return status;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public void setNecessidades(String necessidades) {
        this.necessidades = necessidades;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public void setDataInicio(String dataInicio) throws ParseException {
        this.dataInicio = LocalDate.parse(dataInicio, FORMATO_DATA);
    }

    public void setDataFinal(LocalDate dataFinal) {
        this.dataFinal = dataFinal;
    }

    public void setDataFinal(String dataFinal) {
        this.dataFinal = LocalDate.parse(dataFinal, FORMATO_DATA);
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Projeto projeto = (Projeto) o;
        return Objects.equals(nome, projeto.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }

    public Projeto copia() {
        Projeto projeto = new Projeto();
        projeto.setNome(this.nome);
        projeto.setObjetivo(this.objetivo);
        projeto.setNecessidades(this.necessidades);
        projeto.setDataInicio(this.dataInicio);
        projeto.setDataFinal(this.dataFinal);
        projeto.setStatus(this.status);
        return projeto;
    }

    public void substituir(Projeto projetoNovo) {
        this.setObjetivo(projetoNovo.getObjetivo());
        this.setNome(projetoNovo.getNome());
        this.setNecessidades(projetoNovo.getNecessidades());
        this.setNecessidades(projetoNovo.getNecessidades());
        this.setDataInicio(projetoNovo.getDataInicio());
        this.setDataFinal(projetoNovo.getDataFinal());
        this.setStatus(projetoNovo.getStatus());
    }

    @Override
    public String toString() {
        return "\nProjeto: \n" + "Nome: " + nome + "\n" + "Objetivo: " + objetivo + "\n" + "Necessidades: "
                + necessidades + "\n" + "Data Início: " + dataInicio.format(FORMATO_DATA) + "\n" + "Data Final: "
                + dataFinal.format(FORMATO_DATA) + "\n" + "Status: " + status + "\n";
    }
}