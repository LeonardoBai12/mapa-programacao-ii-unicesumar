package br.unicesumar.aula.controle;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import br.unicesumar.aula.exceptions.DadoConsultadoException;
import br.unicesumar.aula.modelo.Projeto;

public class ProjetoImpl implements ProjetoDAO {
    // Collection que irá armazenar todos os projetos
    private static Set<Projeto> projetos = new HashSet<>();

    @Override
    public void adicionar(Projeto projeto) throws DadoConsultadoException {
        for (Projeto p : projetos) {
            if (p.getNome().equalsIgnoreCase(projeto.getNome())){
                throw new DadoConsultadoException("Já existe um projeto com o nome: " + projeto.getNome());
            }
        }
        projetos.add(projeto);
    }

    @Override
    public List<Projeto> listar() {
        List<Projeto> projetos = new ArrayList<Projeto>();
        projetos.addAll(ProjetoImpl.projetos);
        return projetos;
    }

    @Override
    public Projeto consultarPorNome(String nome) throws DadoConsultadoException {
        for (Projeto projeto : projetos) {
            if (projeto.getNome().equalsIgnoreCase(nome)) {
                return projeto;
            }
        }
        throw new DadoConsultadoException("Não foi possível encontrar um projeto com o nome: " + nome);
    }

    @Override
    public Projeto alterar(String nome, Projeto projetoNovo) throws DadoConsultadoException {
        Projeto projetoEncontrado = consultarPorNome(nome);
        projetoEncontrado.setNecessidades(projetoNovo.getNecessidades());
        projetoEncontrado.setObjetivo(projetoNovo.getObjetivo());
        projetoEncontrado.setDataInicio(projetoNovo.getDataInicio());
        projetoEncontrado.setDataInicio(projetoNovo.getDataInicio());
        projetoEncontrado.setDataFinal(projetoNovo.getDataFinal());
        projetoEncontrado.setDataFinal(projetoNovo.getDataFinal());
        projetoEncontrado.setStatus(projetoNovo.getStatus());
        return projetoEncontrado;
    }

    @Override
    public void excluir(Projeto projeto) throws DadoConsultadoException, UnsupportedOperationException {
        if (projetos.contains(projeto)){
            projetos.remove(projeto);
            return;
        }
        throw new DadoConsultadoException("Não foi encontrado o projeto para exclusão");
    }

    @Override
    public void excluir(String nome) throws DadoConsultadoException, UnsupportedOperationException {
        Projeto projetoEncontrado = consultarPorNome(nome);

        if (projetos.contains(projetoEncontrado)) {
            projetos.remove(projetoEncontrado);
            return;
        }
        throw new DadoConsultadoException("Não foi encontrado o projeto para exclusão");
    }
}