package com.example.api.controller;

import com.example.api.service.ProdutoService;
import io.micrometer.core.annotation.Timed;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

  private final ProdutoService produtoService;

  public ProdutoController(ProdutoService produtoService) {
    this.produtoService = produtoService;
  }

  @PostMapping
  @Timed(value = "latencia.produtos", histogram = true)
  public ResponseEntity<String> criarProdutoAleatorio() {
    String produto = produtoService.criarProdutoAleatorio();
    return ResponseEntity.status(201).body(produto);
  }
}
