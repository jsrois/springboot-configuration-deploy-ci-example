# User management SpringBoot Backend example

Ejemplo de aplicación en SpringBoot.

| Método | Path | Descripción |
| ----   | ---- | ------- |
| GET | `/users` | Devuelve los usuarios que existen |

### Profiles y configuración del proyecto

El proyecto utiliza los siguientes perfiles de Spring: `local` y `prod`. [Más información...](https://www.baeldung.com/spring-profiles)

Para seleccionar el perfil por línea de comandos se puede hacer de cualquiera de los siguientes modos:


- Usando los argumentos de Gradle Wrapper

```bash
./gradlew bootRun --args='--spring.profiles.active=local'
./gradlew bootRun --args='--spring.profiles.active=prod'
```

- Usando una variable de entorno
```bash
spring_profiles_active=local ./gradlew bootRun 
spring_profiles_active=prod ./gradlew bootRun 
```

#### prod

- Base de datos Postgres

#### local

- Base de datos H2 (en memoria)
- Carga de datos de prueba usando la clase `DataLoader`