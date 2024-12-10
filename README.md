# Salutation App

Cette application est une API Spring Boot simple qui expose un point d'accès `/salutation` renvoyant une réponse `"Bonjour Master DevOps II"`. Elle utilise également Spring Boot Actuator pour le monitoring et est configurée pour s'exécuter sur le port `8888`.

---

## Prérequis

Avant de commencer, assurez-vous d'avoir installé les outils suivants sur votre machine :

1. **Java JDK 17 ou supérieur**  
   Vérifiez l'installation avec :  
   ```bash
   java -version
   ```
2. **Maven** (optionnel si vous utilisez Gradle, mais le projet ici utilise Maven)  
   Vérifiez l'installation avec :  
   ```bash
   mvn -v
   ```
3. **Un IDE ou éditeur de code** (par exemple : IntelliJ IDEA, VS Code, Eclipse).
4. **Postman ou cURL** pour tester l'API.

---

## Installation et Configuration

### 1. Cloner le projet

Clonez ce dépôt sur votre machine locale :

```bash
git clone <URL_DU_DEPOT>
cd salutation-app
```

### 2. Configurer le port

Le fichier `application.properties`, situé dans le dossier `src/main/resources`, contient les configurations de l'application. Assurez-vous qu'il ressemble à ceci :

```properties
server.port=8888
management.endpoints.web.exposure.include=*
```

- **`server.port=8888`** : Définit le port de l'application à `8888`.
- **`management.endpoints.web.exposure.include=*`** : Expose tous les points de monitoring d'Actuator.

---

## Structure du Projet

Voici la structure du projet :

```plaintext
salutation-app/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/salutationapp/
│   │   │       ├── SalutationAppApplication.java
│   │   │       └── SalutationController.java
│   │   └── resources/
│   │       ├── application.properties
├── pom.xml
```

---

## Développement

### 1. Classe Principale : `SalutationAppApplication.java`

Cette classe initialise l'application Spring Boot :

```java
package com.example.salutationapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SalutationAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(SalutationAppApplication.class, args);
    }
}
```

---

### 2. Contrôleur REST : `SalutationController.java`

Le contrôleur expose l'API `/salutation` :

```java
package com.example.salutationapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/salutation")
public class SalutationController {

    @GetMapping
    public String saluer() {
        return "Bonjour Master DevOps II";
    }
}
```

---

## Exécution de l'Application

### 1. Avec Maven

Dans le répertoire racine du projet, exécutez :

```bash
./mvnw spring-boot:run
```

### 2. Avec un IDE

Lancez la méthode `main` dans la classe `SalutationAppApplication` via votre IDE.

---

## Test de l'API

1. **Tester le point d'accès `/salutation`**  
   Ouvrez un navigateur, Postman, ou utilisez `cURL` :

   ```bash
   curl http://localhost:8888/salutation
   ```

   Vous obtiendrez la réponse :  
   ```plaintext
   Bonjour Master DevOps II
   ```

2. **Tester les points Actuator**  
   - Santé de l'application :  
     ```bash
     curl http://localhost:8888/actuator/health
     ```
   - Métriques :  
     ```bash
     curl http://localhost:8888/actuator/metrics
     ```

---

## Fonctionnalités

- **Point d'accès `/salutation`** : Retourne une salutation en français.
- **Monitoring avec Spring Boot Actuator** :
  - Santé : `/actuator/health`
  - Métriques : `/actuator/metrics`
  - Autres endpoints configurés automatiquement.

---

## Personnalisation

Vous pouvez personnaliser les réponses ou ajouter d'autres endpoints en modifiant le fichier `SalutationController.java`.

---

## Ressources Utiles

- [Documentation Spring Boot](https://spring.io/projects/spring-boot)
- [Spring Boot Actuator](https://docs.spring.io/spring-boot/docs/current/reference/html/actuator.html)
- [Spring Initializr](https://start.spring.io/)

---

## Auteur

**AMIDI Manar**
