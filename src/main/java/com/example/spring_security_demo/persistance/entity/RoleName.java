package com.example.spring_security_demo.persistance.entity;

// defines the different levels of access to the system
// define los diferentes niveles de aceso al sistema
// this should mirror the query SELECT nombre_role FROM roles, except for NONE that is error catching
// esto debe espejar the query  SELECT nombre_role FROM roles, excepto por NONE que es captura de errores
public enum RoleName {
    // has all the access permissions
    // tiene todos los permisos de acceso
    SYSTEM_ADMIN,
    // has all the access permissions to the USERS api
    // tiene todos los permisos de acceso a la api USERS
    USER_ADMIN,
    // has all the access permissions to the BOOKS api
    // tiene todos los permisos de acceso a la api BOOKS
    // this could be any api , we use BOOK as an example
    // esto podria ser cualquier api, usamos BOOK como ejemplo
    BOOK_ADMIN,
    // has only reading permissions but to all apis
    // tiene solo derechos de lectura pero a todas las apis
    AUDITHOR,
    // no permissions , exists to catch errors
    // ningun permiso, existe para capturar errores
    NONE
}
