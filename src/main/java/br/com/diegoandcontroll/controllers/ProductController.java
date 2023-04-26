package br.com.diegoandcontroll.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.diegoandcontroll.domain.Products;
import br.com.diegoandcontroll.dtos.IRequestProduct;
import br.com.diegoandcontroll.services.ProductsService;
import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
  
  private final ProductsService productsService;

  @GetMapping(path = "all")
  public ResponseEntity<List<IRequestProduct>> findAllNoPaginable(){
    List<IRequestProduct> listRequest = productsService.findAllNoPaginable();
    return ResponseEntity.ok(listRequest);
  } 

  @GetMapping
  public ResponseEntity<Page<Products>> findAll(Pageable pageable){
    return ResponseEntity.ok(productsService.findAllNoPaginable(pageable));
  }

  @GetMapping("/{id}")
  public ResponseEntity<IRequestProduct> findOne(@PathVariable UUID id){
    return ResponseEntity.ok(productsService.findOne(id));
  }

  @PostMapping
  public ResponseEntity<IRequestProduct> create(@RequestBody IRequestProduct data){

    return new ResponseEntity<IRequestProduct>(productsService.create(data), HttpStatus.CREATED);
  }

  @PutMapping
  public ResponseEntity<IRequestProduct> update(@RequestBody IRequestProduct data){
    return ResponseEntity.ok(productsService.update(data));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> remove(@PathVariable UUID id){
    productsService.delete(id);
    return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
  }
}
