package com.example.spring_security_demo.persistance.entity;

// defines the different levels of access to the system
// define los diferentes niveles de aceso al sistema
// this should mirror the query SELECT nombre_role FROM roles
// esto debe espejar the query  SELECT nombre_role FROM roles
public final class RoleName {
    // has all the access permissions
    // tiene todos los permisos de acceso
    public final static  String SYSTEM_ADMIN="SYSTEM_ADMIN";
    // has all the access permissions to the USERS api
    // tiene todos los permisos de acceso a la api USERS
    public final static  String USER_ADMIN="USER_ADMIN";
    // has all the access permissions to the BOOKS api
    // tiene todos los permisos de acceso a la api BOOKS
    // this could be any api , we use BOOK as an example
    // esto podria ser cualquier api, usamos BOOK como ejemplo
    public final static  String BOOK_ADMIN="BOOK_ADMIN";
    // has only reading permissions but to all apis
    // tiene solo derechos de lectura pero a todas las apis
    public final static  String AUDITHOR="AUDITHOR";
}
