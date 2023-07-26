package org.edu.unidep.repository;

import org.edu.unidep.model.Categoria;

import java.util.List;

public interface CategoriaRepository {

    public List<Categoria> listarCategorias();

    /*
    * Salvar uma determinada categoria;
    * Listar somente uma categoria pelo codigo;
    * Atualizar as informações de uma categoria;
    */

    Categoria listarCategoriaPeloCodigo(Long id);

    void salvar(Categoria categoria);

}
