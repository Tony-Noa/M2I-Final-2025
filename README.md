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
 
