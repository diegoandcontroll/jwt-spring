package br.com.diegoandcontroll.controllers;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

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

import br.com.diegoandcontroll.domain.Categories;
import br.com.diegoandcontroll.dtos.IRequesCategory;
import br.com.diegoandcontroll.services.CategoriesService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/categories")
@RequiredArgsConstructor
public class CategoriesController {
  private final CategoriesService categoriesService;
 
  @GetMapping()
  public ResponseEntity<Page<Categories>> findAllPaginable(Pageable pageable){
    return ResponseEntity.ok(categoriesService.findAll(pageable));
  }

  @GetMapping(path = "all")
  public ResponseEntity<List<IRequesCategory>> findAll(){
    List<Categories> list = categoriesService.findAllCategoriesNoPaginable();
    return ResponseEntity.ok(list.stream().map(cat -> new IRequesCategory(cat)).collect(Collectors.toList()));
  }

  @GetMapping("/{id}")
  public ResponseEntity<IRequesCategory> findOne(@PathVariable UUID id){
    return ResponseEntity.ok(categoriesService.findId(id)); 
  }

  @PostMapping
  public ResponseEntity<IRequesCategory> create(@RequestBody IRequesCategory category){
    IRequesCategory createCategoryRequest = categoriesService.create(category);
    return new ResponseEntity<IRequesCategory>(createCategoryRequest, HttpStatus.CREATED);
  }
  @PutMapping
  public ResponseEntity<IRequesCategory> update (@RequestBody IRequesCategory category){
    return new ResponseEntity<>(categoriesService.update(category), HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> remove(@PathVariable UUID id){
    categoriesService.remove(id);
    return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
  }
}
