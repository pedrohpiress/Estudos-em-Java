package com.example.controller;

import com.example.model.Pedido;
import com.example.service.PedidoService;
import com.example.service.PedidoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping("/alfa")
    public ResponseEntity<PedidoDTO> criarPedidoAlfa(@RequestBody @Validated Pedido pedido){
        return ResponseEntity.status(HttpStatus.CREATED).body(pedidoService.criarPedidoAlfa(pedido));
    }

    @PostMapping("/beta")
    public ResponseEntity<PedidoDTO> criarPedidoBeta(@RequestBody @Validated Pedido pedido){
        return ResponseEntity.status(HttpStatus.CREATED).body(pedidoService.criarPedidoBeta(pedido));
    }

    @GetMapping
    public ResponseEntity<List<Pedido>> listarPedidos(){
        return ResponseEntity.status(HttpStatus.FOUND).body(pedidoService.listar());
    }
}
