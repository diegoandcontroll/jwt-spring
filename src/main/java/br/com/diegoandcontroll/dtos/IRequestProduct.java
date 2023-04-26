package br.com.diegoandcontroll.dtos;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import br.com.diegoandcontroll.domain.Categories;
import br.com.diegoandcontroll.domain.Products;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
public class IRequestProduct implements Serializable {
  private static final long serialVersionUID = 1L;

  private UUID id;

  private String name;

  private String description;

  private String image_url;

  private double price;

  private Instant date;

  private List<IRequesCategory> categories = new ArrayList<>();

  public IRequestProduct(UUID id, String name, String description, Double price, String imgUrl, Instant date) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.price = price;
    this.image_url = imgUrl;
    this.date = date;
  }

  public IRequestProduct(Products entity) {
    this.id = entity.getId();
    this.name = entity.getName();
    this.description = entity.getDescription();
    this.price = entity.getPrice();
    this.image_url = entity.getImage_url();
    this.date = entity.getDate();
  }

  public IRequestProduct(Products entity, Set<Categories> categories) {
    this(entity);
    categories.forEach(cat -> this.categories.add(new IRequesCategory(cat)));
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getImage_url() {
    return image_url;
  }

  public void setImage_url(String image_url) {
    this.image_url = image_url;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public Instant getDate() {
    return date;
  }

  public void setDate(Instant date) {
    this.date = date;
  }

  public List<IRequesCategory> getCategories() {
    return categories;
  }

  public void setCategories(List<IRequesCategory> categories) {
    this.categories = categories;
  }

}
