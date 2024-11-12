# Employee Management RESTFUL API

## Description
This project is a RESTful API for managing employee data. It provides endpoints for employee registration, authentication, profile management, and more. The API is built using Java and follows best practices for security and performance.

## Features
- **employee Registration**: Create a new employee account.
- **Profile Management**: View and update employee profile information.
- **employee Deletion**: Remove a employee account.

## Technologies Used
- **Java**: The primary programming language.
- **Spring Boot**: Framework for building the REST API.
- **h2database**: Database for storing employee data.

-  **Refer to pom.xml for more details.**

## Installation
1. Clone the repository:
    ```bash
    git clone git@github.com:lekond77/api-rest-java.git

2. Deploy the api:
    ```bash
    java -jar target/api-0.0.1-SNAPSHOT.jar

## API Endpoints

- POST http://localhost:8090/employee: Create a new employee.
- GET http://localhost:8090/employee/{id}: Get employee details by ID.
- PUT http://localhost:8090/employee/{id}: Update employee details by ID.
- DELETE http://localhost:8090/employee/{id}: Delete a employee by ID.

## Contributing
Contributions are welcome! Please fork the repository and create a pull request with your changes.



# API RESTFUL de Gestion des Employés

## Description
Ce projet est une API RESTful pour la gestion des données des employés. Il fournit des points de terminaison pour l'enregistrement des employés, l'authentification, la gestion des profils, et plus encore. L'API est construite en utilisant Java et suit les meilleures pratiques en matière de sécurité et de performance.

## Fonctionnalités
- **Enregistrement des Employés** : Créer un nouveau compte employé.
- **Gestion des Profils** : Voir et mettre à jour les informations du profil des employés.
- **Suppression des Employés** : Supprimer un compte employé.

## Technologies Utilisées
- **Java** : Le langage de programmation principal.
- **Spring Boot** : Framework pour construire l'API REST.
- **H2 Database** : Base de données pour stocker les données des employés.

- **Référez-vous au fichier `pom.xml` pour plus de détails.**

## Installation
1. Cloner le dépôt :
   ```bash
   git clone git@github.com:lekond77/api-rest-java.git

2. Déployer l'api :
   ```bash
  java -jar target/api-0.0.1-SNAPSHOT.jar