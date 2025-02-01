package com.emi.ecommerce.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "categorias")
public class Categoria {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "categoria_nombre")
  private @NotBlank String categoriaNombre;

  private @NotBlank String descripcion;

  private @NotBlank String imageUrl;

  public Categoria(){

  }

  public Categoria(@NotBlank String categoriaNombre, @NotBlank String descripcion) {
    this.categoriaNombre = categoriaNombre;
    this.descripcion = descripcion;
  }

  public Categoria(@NotBlank String categoriaNombre, @NotBlank String descripcion,@NotBlank String imageUrl) {
    this.categoriaNombre = categoriaNombre;
    this.descripcion = descripcion;
    this.imageUrl = imageUrl;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getCategoriaNombre() {
    return categoriaNombre;
  }

  public void setcategoriaNombre(String categoriaNombre) {
    this.categoriaNombre = categoriaNombre;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  @Override
  public String toString() {
    return "Category{" +
        "id=" + id +
        ", categoryName='" + categoriaNombre + '\'' +
        ", description='" + descripcion + '\'' +
        ", imageUrl='" + imageUrl + '\'' +
        '}';
  }
}