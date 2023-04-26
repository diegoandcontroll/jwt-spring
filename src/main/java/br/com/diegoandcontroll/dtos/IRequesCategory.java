package br.com.diegoandcontroll.dtos;

import java.io.Serializable;
import java.util.UUID;

import br.com.diegoandcontroll.domain.Categories;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IRequesCategory implements  Serializable{
  private static final long serialVersionUID = 1L;
  private UUID id;
  private String name;

  public IRequesCategory(Categories c){
    this.id = c.getId();
    this.name = c.getName();
  }
  
}
