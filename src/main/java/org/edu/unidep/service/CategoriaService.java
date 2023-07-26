package org.edu.unidep.service;

import org.edu.unidep.model.Categoria;
import org.edu.unidep.repository.CategoriaRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

@ApplicationScoped
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    @Inject
    public CategoriaService(
            CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    /*
    * Categoria categoria
    *   Codigo    Nome
    *     1       Entrada Autorizada
    */
6
    @Transactional
    public Categoria atualizar(Long id, Categoria categoria) {
        Categoria categoriaEncontrada =
                categoriaRepository
                        .listarCategoriaPeloCodigo(id);

        /*
         * Categoria categoriaEncontrada
         *   Codigo    Nome
         *     1       Entrada
         */
        categoriaEncontrada.setNome(categoria.getNome());
        // "Entrada".setNome("Entrada Autorizada");

        return categoriaEncontrada;
    }

}
