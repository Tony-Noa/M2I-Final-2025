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
 
2. **Utilisation des services liés à la base de données via des requêtes HTTP**
Pour le moment il n'a pas été possible de lier directement le back (Java) avec le front (Angular). Mais il est possible d'utiliser des requêtes http  (sur postman par exemple) pour gérer la base de données et ses différentes tables principales (UserAccount, Tourney, Matches & Game Category).

On a besoin d'un utilisateur (UserAccount) et d'une Game Category pour créer un tournoi, et on a besoin d'un tournoi pour créer un match.

Les exemples suivants sont utilisés depuis le port 8090 défini dans l'application.properties du projet java back.

On montrera l'exemple du "get by id", "get all" et "delete" de UserAccount, mais ca marchera de façon similaire avec les 3 autres classes (GameCategory, Tourney, Match), juste que le delete chez UserAccount est /private/ plutot que /public/ juste pour tester.
En public il y a pas besoin de mettre les tokens.

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
      } # il semble pas possible de mettre quelqu'un en role admin

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


   ## Récupération de tout les utilisateurs
   GET http://localhost:8090/useraccount/public/all

   ## Récupération de l'utilisateur id2 (= testB)
   GET http://localhost:8090/useraccount/public/2

   ## Mise à jour de l'utilisateur id2
   PUT http://localhost:8090/useraccount/public/2
   Content-Type: application/json

      {
        "username": "testBnew",
        "email": "testb@hotmail.com",
        "password": "ptestB",
        "role": 0,
        "pp": "pictureb.jpg"
      }

   ## Suppression utilisateur id4
   # On crée d'abord un login puisque cette méthode est en private (peu importe, pour le moment n'importe quel utilisateur enregistré peut supprimer un autre utilisateur, on implémentera plus tard la capacité à l'admin du site à supprimer n'importe quel utilisateur et un utilisateur de se supprimer lui même).

   POST http://localhost:8090/auth/public/login
   Content-Type: application/json
   {
    "email": "testc@hotmail.com",
    "password": "ptestC"
   }

      # On reçoit un token en résultat
   -> {
    "id": 3,
    "token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZXN0Q0Bob3RtYWlsLmNvbSIsInJvbGUiOiJST0xFX1VTRVIiLCJpYXQiOjE3NTYzODk5MzQsImV4cCI6MTc4NzkyNTkzNH0.FF-D-t_p-OG27eG5m3Jmz6iMmJ-frAg-uS6HqZWHwuyo32eVNpU7js2_KHKQr8W_9mEvMfHvorknlNN8UJd2IA"
      }


   Authorization -> Auth Type = Bearer Token -> Token : eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZXN0Q0Bob3RtYWlsLmNvbSIsInJvbGUiOiJST0xFX1VTRVIiLCJpYXQiOjE3NTYzODk5MzQsImV4cCI6MTc4NzkyNTkzNH0.FF-D-t_p-OG27eG5m3Jmz6iMmJ-frAg-uS6HqZWHwuyo32eVNpU7js2_KHKQr8W_9mEvMfHvorknlNN8UJd2IA
   
   DELETE http://localhost:8090/useraccount/private/4

      # Ainsi, l'utilisateur d'ID4 est supprimé


   ### Catégorie

   ## Création d'une catégorie
   POST http://localhost:8090/gamecategory/public
   Content-Type: application/json
   {
	"name": "Super Smash Bros Ultimate",
    "icon": "iconssbu.jpg",
    "logo": "logossbu.jpg"
   }

   POST http://localhost:8090/gamecategory/public
   Content-Type: application/json
   {
	"name": "Street Fighter 5",
    "icon": "iconsf5.jpg",
    "logo": "logosf5.jpg"
   }

   ## Modification d'une catégorie
   PUT http://localhost:8090/gamecategory/public/2
   Content-Type: application/json
   {
	 "name": "Street Fighter 6",
    "icon": "iconsf6.jpg",
    "logo": "logosf6.jpg"
   }

   ### Tournois

   ## Création de tournoi 
   POST http://localhost:8090/tourney/public
   Content-Type: application/json
   {
	 "name": "September Smash Bonanza",
    "format": "SINGLE_ELIMINATION",
    "creationDate": "01-09-2025",
    "startDate": "07-09-2025",
    "signStartDate": "02-09-2025",
    "signEndDate": "06-09-2025",
    "gameCategoryId": 1,
    "founderId": 3
   }
      # ici c'est l'utilisateur id3 qui a crée le tournoi, en utilisant la catégorie id3 (Super Smash Bros Ultimate)

   ## Mis à jour du tournoi
   PUT http://localhost:8090/tourney/public/1
   Content-Type: application/json
   {
    "name": "September Smash Bonanza REVAMPED",
    "format": "SINGLE_ELIMINATION",
    "creationDate": "01-09-2025",
    "startDate": "07-09-2025",
    "signStartDate": "02-09-2025",
    "signEndDate": "05-09-2025",
    "gameCategoryId": 1,
    "founderId": 3
   }
      # Ici on a changé que le nom et le sign end date. Ce qui sera modifié sont juste les dates (sauf creation), le nom et le format. Mais à cause de la nature du TourneyReceiveDto, il faut quand même mettre la creation date, le founder id et le game category id.

   ## Participation à un tournoi (la méthode est juste pour tester, normalement ca devrait se faire depuis le front)

   PUT http://localhost:8090/useraccount/public/1/1
      # Ici le premier "1" représente l'id du joueur et le 2eme représente l'id du tournoi.

   PUT http://localhost:8090/useraccount/public/2/1
      # Le "2" représente l'id du joueur et le "1" représente l'id du tournoi

      # Ainsi, l'utilisateur 1 et 2 seront dans la liste des joueurs du tournoi 1, et vice-versa



   ### Match

   ## Création d'un match
   POST http://localhost:8090/match/public
   Content-Type: application/json
   {
	 "p1Id": 1,
    "p2Id": 2,
    "position": "1-1",
    "tourneyId": 1
   }


   ## Mis à jour d'un match
   PUT http://localhost:8090/match/public/1
   Content-Type: application/json

   {
        "p1Id": 1,
        "p2Id": 2,
        "resultP1": 3,
        "resultP2": 2,
        "position": "1-1",
        "tourneyId": 1
   }
   # Ici, le joueur id1 a gagné 3 match à 2 sur le joueur id2 
```



### PROBLEMES A REGLER


- Faire le gestionnaire de bracket plutot dans le back
- Diagramme UML : faire un diagramme de classe et un diagramme de BDD (ce que j'ai fait actuellement mixe les deux et c'est pas ouf)
- Back : Quand le response JSON sur postman renvoie un probleme car on a mal mis un truc, on a un "401 unauthorized" alors que c'est censé nous envoyer un autre type d'erreur. Ca nous fait une erreur d'authentification alors que y'a pas d'authentification censé être lié à ça.
- Faire la connection entre le front et le back