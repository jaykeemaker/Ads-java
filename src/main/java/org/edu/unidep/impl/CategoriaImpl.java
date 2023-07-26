package org.edu.unidep.impl;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.edu.unidep.model.Categoria;
import org.edu.unidep.repository.CategoriaRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class CategoriaImpl implements PanacheRepository<Categoria>,
        CategoriaRepository {
    @Override
    public List<Categoria> listarCategorias() {
        return listAll();
    }

    @Override
    public Categoria listarCategoriaPeloCodigo(Long id) {

        String jpql = """
                    SELECT c FROM Categoria c WHERE c.id = :codigo
                """;

        return getEntityManager()
                .createQuery(jpql, Categoria.class)
                .setParameter("codigo", id)
                .getResultStream()
                .findAny()
                .orElseThrow();
    }

    @Transactional
    @Override
    public void salvar(Categoria categoria) {
        persist(categoria);
    }

}
