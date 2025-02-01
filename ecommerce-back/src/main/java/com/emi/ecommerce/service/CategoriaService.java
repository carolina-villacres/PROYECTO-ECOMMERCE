package com.emi.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emi.ecommerce.model.Categoria;
import com.emi.ecommerce.repository.CategoriaRepository;

@Service
public class CategoriaService {

  @Autowired
  private CategoriaRepository categoriaRepository;

  public Categoria readCategoria(String categoriaNombre) {
    return categoriaRepository.findByCategoriaNombre(categoriaNombre);
  }

  public Optional<Categoria> readCategoria(Integer categoriaID){
    return categoriaRepository.findById(categoriaID);
  }

  public void createCategoria(Categoria categoria) {
    categoriaRepository.save(categoria);
  }

  public List<Categoria> listCategorias() {
    return categoriaRepository.findAll();
  }

  public void updateCategory(Integer categoriaID, Categoria newCategoria) {
    Categoria categoria = categoriaRepository.findById(categoriaID).get();
    categoria.setcategoriaNombre(newCategoria.getCategoriaNombre());
    categoria.setDescripcion(newCategoria.getDescripcion());
    categoria.setImageUrl(newCategoria.getImageUrl());
    categoriaRepository.save(categoria);
  }
}