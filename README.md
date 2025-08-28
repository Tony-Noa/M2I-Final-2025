# M2I-Final-2025

**Dernier projet M2i – Développeur Full-Stack Java 2025**  
Avec Salim et Tony Noa

---

##  Table des matières

- [À propos / Description](#à-propos-description)  
- [Captures d’écran / Aperçu](#captures-décran-aperçu)  
- [Fonctionnalités principales](#fonctionnalités-principales)  
- [Technologies utilisées](#technologies-utilisées)  
- [Architecture & Design](#architecture-design)  
- [Endpoints API](#endpoints-api)  
- [Installation & Lancement](#installation-lançement)  
- [Contributeurs](#contributeurs)  
- [Licence](#licence)

---

##  À propos / Description

Ce projet est le dernier travail du parcours **M2i Développeur Full-Stack Java (2025)**, créé par **Tony Noa** avec **Salim**. Il s'agit d'une application web complète (backend Java + frontend moderne) pour [décrire brièvement la fonction principale, ex. gestion de tâches, carnet d’adresse, etc.].

---

##  Captures d’écran / Aperçu

Voici un aperçu visuel de l'application :  

![Page d'accueil de l'application](https://via.placeholder.com/600x300?text=Page+d%27accueil)  
![Formulaire de création](https://via.placeholder.com/600x300?text=Formulaire+de+création)

*(Remplacez les URLs par de vraies captures hébergées ou sur le dépôt.)*

---

##  Fonctionnalités principales

- Authentification des utilisateurs (login / inscription)
- CRUD sur les entités principales (ex. tâches, utilisateurs, produits…)
- Interface responsive (mobile et desktop)
- Validation côté client et serveur
- Gestion des erreurs et retours clairs à l’utilisateur

---

##  Technologies utilisées

| Partie        | Technologies / Frameworks                |
|---------------|------------------------------------------|
| Backend       | Java, Spring Boot, JPA/Hibernate         |
| Frontend      | TypeScript, React (ou Angular/Vue), CSS |
| Base de données | MySQL ou PostgreSQL (à renseigner)     |
| Tests         | JUnit, Mockito (backend), Jest (frontend)|
| CI / Déploiement | GitHub Actions, Docker (optionnel)    |

---

##  Architecture & Design

- Utilisation de **principes RESTful** pour l'API
- Séparation claire entre la **couche service** et la **couche contrôleur**
- Modèle **MVC côté front** (ex. composants React, services, stores)
- Base de données relationnelle avec **entités bien modélisées**
- (Optionnel) Diagrammes UML ou schéma de base de données en annexes (ex. `.drawio`)

---

## Diagramme UML

Voici une représentation visuelle de l'architecture (structure, entités, relations) du projet :

![Diagramme UML](STN2025UML_final1.drawio.png)

---

##  Endpoints API

| Méthode | Endpoint                   | Description                          |
|:-------:|----------------------------|--------------------------------------|
| `POST`  | `/api/auth/register`       | Inscription d’un nouvel utilisateur  |
| `POST`  | `/api/auth/login`          | Connexion (authentification)         |
| `GET`   | `/api/items`               | Récupérer la liste des éléments      |
| `GET`   | `/api/items/{id}`          | Récupérer un élément par son ID      |
| `POST`  | `/api/items`               | Créer un nouvel élément              |
| `PUT`   | `/api/items/{id}`          | Mettre à jour un élément existant    |
| `DELETE`| `/api/items/{id}`          | Supprimer un élément                  |

*(Adapté selon votre domaine métier : items, tasks, users, etc.)*

---

##  Installation & Lancement

1. **Cloner le dépôt**  
   ```bash
   git clone https://github.com/Tony-Noa/M2I-Final-2025.git
   cd M2I-Final-2025
 
2. **Utilisation des services liés à la base de données**
Pour le moment il n'a pas été possible de lier directement le back (Java) avec le front (Angular). Mais il est possible d'utiliser des requêtes http  (sur postman par exemple) pour gérer la base de données et ses différentes tables principales (UserAccount, Tourney, Matches & Game Category).

On a besoin d'un utilisateur (UserAccount) et d'une Game Category pour créer un tournoi, et on a besoin d'un tournoi pour créer un match.

Les exemples suivants sont utilisés depuis le port 8090 défini dans l'application.properties du projet java back.
```http
   ### Utilisateurs

   ## Création d'utilisateurs
   POST http//localhost:8090/auth/public/register
   Content-Type: application/json
      {
        "username": "testA",
        "email": "testa@hotmail.com",
        "password": "ptesta",
        "role":1
      }

   POST http//localhost:8090/auth/public/register
   Content-Type: application/json

      {
        "username": "testB",
        "email": "testB@hotmail.com",
        "password": "ptestB",
        "role":0
      }

   POST http//localhost:8090/auth/public/register 
   Content-Type: application/json
      {
        "username": "testC",
        "email": "testC@hotmail.com",
        "password": "ptestC",
        "role":0
      }
   
   POST http//localhost:8090/auth/public/register 
   Content-Type: application/json
      {
        "username": "testD",
        "email": "testd@hotmail.com",
        "password": "ptestd",
        "role":0
      }

   


   ## Récupération et gestion d'utilisateurs

   # Récupération de tout les utilisateurs
   GET http://localhost:8090/useraccount/public/all

   # Récupération de l'utilisateur id2 (= testB)
   GET http://localhost:8090/useraccount/public/2

   # Mise à jour de l'utilisateur id2
   PUT http://localhost:8090/useraccount/public/2
   Content-Type: application/json

      {
        "username": "testBnew",
        "email": "testb@hotmail.com",
        "password": "ptestB",
        "role": 0,
        "pp": "pictureb.jpg"
      }

   # Suppression utilisateur id4 : on crée d'abord un login puisque cette méthode est en private (peu importe, pour le moment n'importe quel utilisateur enregistré peut supprimer un autre utilisateur, on implémentera plus tard la capacité à l'admin du site à supprimer n'importe quel utilisateur et un utilisateur de se supprimer lui même).

   POST http://localhost:8090/auth/public/login
   Content-Type: application/json
   {
    "email": "testa@hotmail.com",
    "password": "ptesta"
   }

   On reçoit un token en résultat



   ### Tournois
   Authorization -> Auth Type = Bearer Token -> Token : [token]
   DELETE http://localhost:8090/useraccount/private/4



```
