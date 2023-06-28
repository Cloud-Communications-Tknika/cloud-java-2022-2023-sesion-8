# Practica Cloud Java 2022-2023

Aitor Iturrioz & Pablo Rubio

Este repositorio es el código inicial del ejercicio principal del Curso Cloud de Tknika.


---

Crea un fichero .yaml con el cual, cada vez que se crea un tag en el repositorio se despliegue el docker compose del proyecto en el servidor.

Nota:

En la línea [3,4] del docker-compose, se encuentra el siguiente código.

```
  app:
    image: <TU-IMAGEN>
```

recuerda modificar `<TU-IMAGEN>`

En la línea [22,28] de cdDockerHub.yaml se encuentra:

```
      - name: Build and push
        id: docker_build
        uses: docker/build-push-action@v2
        with:
          context: .
          push: true
          tags: ${{secrets.DOCKERHUB_USERNAME}}/<NOMBRE_DEL_PROYECTO>:${{ env.RELEASE_VERSION }}
```

Recuerda modificar el nombre del proyecto.

Tabien deberás modificar el evento disparador de este:

```
on:
  push:
    branches:
      - "nothing"

```
