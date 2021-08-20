package com.acme.demoapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.acme.demoapi.model.Producto;

@RestController
@RequestMapping(value="api/productos", produces ="applications/json")
public class ProductoController {
    private Map<String, Producto> productos;

    public ProductoController(){
        productos = new HashMap<String,Producto>();
      Producto p = new Producto();
      p.setCategoria("Fideos");
      p.setName("Lavagi");
      p.setPrecio("8.00");
    
      String id = UUID.randomUUID().toString();
      p.setId(id);
      productos.put(id, p);
    }

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Producto>> all() {
        return new ResponseEntity<Map<String, Producto>>(
            productos, HttpStatus.OK);
    }

    @PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity add(@RequestBody Producto p) {
        productos.put(p.getId(),p);
        return new ResponseEntity(
         HttpStatus.CREATED);
    }

}
