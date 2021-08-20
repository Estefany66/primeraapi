package com.acme.demoapi.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Producto {

private String id;
private String name;
private String categoria;
private String precio;

}


