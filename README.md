# API de Usuarios - Documentación

Esta es una API de usuarios desarrollada en Spring Boot Java que permite realizar operaciones básicas relacionadas con usuarios. La API incluye la creación de usuarios con información como nombre de usuario, contraseña, nombre, apellido, dirección, teléfono y correo electrónico. Además, proporciona autenticación de usuario y recuperación de usuarios por su ID.

## Endpoints

La API consta de los siguientes endpoints:

### Crear Usuario

- **URL**: `/api/user/register`
- **Método HTTP**: `POST`
- **Descripción**: Crea un nuevo usuario con la información proporcionada.
- **Cuerpo de la Solicitud (JSON)**:
  ```json
  {
      "username": "nombredeusuario",
      "password": "contrasenia",
      "firstname": "Nombre",
      "lastname": "Apellido",
      "address": "Dirección",
      "phone": "Teléfono",
      "email": "correo@ejemplo.com"
  }

### Autentica el usuario

- **URL**: `/api/user/auth`
- **Método HTTP**: `POST`
- **Descripción**: Autentica el usuario por su username y password.
- **Cuerpo de la Solicitud (JSON)**:
  ```json
  {
      "username": "nombredeusuario",
      "password": "contrasenia"
  }

### Obtener usuario por ID

- **URL**: `/api/user/auth/{id}`
- **Método HTTP**: `GET`
- **Descripción**: Obtener información del usuario por ID.

