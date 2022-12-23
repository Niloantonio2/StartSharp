#language: es
#Author: Nilo Chaverra

  Característica: inicio de sesion start sharp
    Descricion: El usuario puede ingresar a la pagina web con sus credenciales

    Esquema del escenario: <Escenario>
      Dado que el usuario se encuentra en la pagina web
      Cuando ingresa sus credenciales
      | strUsuario   | strClave    |
      | <strUsuario> | <strClave>  |
      Entonces podra visualizar su Dashboard

    Ejemplos:
     | Escenario     | strUsuario | strClave  |
     | Login failed  | adm1n      | seren1ty  |
     | Login exitoso | admin      | serenity  |
