package br.com.diegoandcontroll.dtos;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IRequestUpdateCategory {
  private UUID id;

  private String name;
}
