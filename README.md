# HotelSpringBoot

## Configuración de la base de datos

La aplicación usa PostgreSQL. Configura la contraseña mediante la variable de entorno `DB_PASSWORD` antes de iniciar la aplicación; no guardes credenciales en `application.properties`.

En PowerShell:

```powershell
$env:DB_PASSWORD = "tu_contraseña"
.\mvnw.cmd spring-boot:run
```

## Pruebas

Ejecuta todas las pruebas con:

```powershell
.\mvnw.cmd test
```
