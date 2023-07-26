package org.edu.unidep.rest;

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.edu.unidep.model.Categoria;
import org.edu.unidep.repository.CategoriaRepository;
import org.edu.unidep.service.CategoriaService;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

// 192.168.8.70:8080/api/categoria

@Path("/categoria")
public class CategoriaREST {

    private final CategoriaRepository categoriaRepository;

    private final CategoriaService categoriaService;

    @Inject
    public CategoriaREST(
            CategoriaRepository categoriaRepository,
            CategoriaService categoriaService) {
        this.categoriaRepository = categoriaRepository;
        this.categoriaService = categoriaService;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarCategorias() {
        List<Categoria> categorias = categoriaRepository.listarCategorias();
        return Response.ok(categorias).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarCategoriaPeloCodigo(
            @PathParam("id") Long id) {
        Categoria categoriaEncontrada =
                categoriaRepository.listarCategoriaPeloCodigo(id);

        return Response.ok(categoriaEncontrada).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public void salvar(@RequestBody Categoria categoria) {
        categoriaRepository.salvar(categoria);
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response atualizar(
            @PathParam("id") Long id,
            @RequestBody Categoria categoria) {

        Categoria categoriaAtualizada =
                categoriaService.atualizar(id, categoria);

        return Response.ok(categoriaAtualizada).build();
    }
}
