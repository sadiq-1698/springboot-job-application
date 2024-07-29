#### Build image using Docker
``./mvnw spring-boot:build-image "-Dspring-boot.build-image.imageName=<username>/jobappimage"``

#### Launch Docker Desktop on your local machine
``systemctl --user start docker-desktop``

#### Running the application on your local machine
``docker run -p 8080:8080 <username>/jobappimage``

#### Running the application on your local machine (detached mode)
``docker run -d -p 8080:8080 <username>/jobappimage``

#### Running the application on your local machine
``docker stop <container-id>``

