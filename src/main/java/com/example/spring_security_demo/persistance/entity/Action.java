package com.example.spring_security_demo.persistance.entity;
/*
* Defines the types of actions that can be taken from a module
* Define los tipos de acciones que pueden tomarse desde un modulo
* */
public enum Action {
    // query data
    // requerir datos
    READ,
    // insert data
    // insertar datos
    WRITE,
    // modiffy data
    // modificar datos
    OVERWRITE,
    // delete data
    // borrar datos
    DELETE,
    // no action, just to catch errors
    // ninguna acción sólo para capturar errores
    NONE
}
