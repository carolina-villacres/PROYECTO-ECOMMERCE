package com.emi.ecommerce.controllers;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.emi.ecommerce.common.ApiResponse;
import com.emi.ecommerce.model.Categoria;
import com.emi.ecommerce.service.CategoriaService;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

  @Autowired
  private CategoriaService categoriaService;

  @PostMapping("/create")
  public ResponseEntity<ApiResponse> createCategoria(@Valid @RequestBody Categoria categoria){
    if(Objects.nonNull(categoriaService.readCategoria(categoria.getCategoriaNombre()))){
      return new ResponseEntity<ApiResponse>(new ApiResponse(false, "La categoría ya existe!"),
          HttpStatus.CONFLICT);
    }
    categoriaService.createCategoria(categoria);
    return new ResponseEntity<>(new ApiResponse(true, "Categoría creada!"), HttpStatus.CREATED);
  }

  @GetMapping("/")
  public ResponseEntity<List<Categoria>> getCategorias(){
    List<Categoria> body = categoriaService.listCategorias();
    return new ResponseEntity<>(body, HttpStatus.OK);
  }

  @PostMapping("/update/{categoriaID}")
  public ResponseEntity<ApiResponse> updateCategory(@PathVariable("categoriaID") Integer categoriaID,
                                                    @Valid @RequestBody Categoria categoria){
    if(Objects.nonNull(categoriaService.readCategoria(categoriaID))){
      categoriaService.updateCategoria(categoriaID, categoria);
      return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Categoría actualizada!"), HttpStatus.OK);
    }

    return new ResponseEntity<>(new ApiResponse(false, "La categoría no existe!"), HttpStatus.NOT_FOUND);
  }
}
