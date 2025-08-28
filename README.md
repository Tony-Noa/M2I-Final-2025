# M2I Final 2025 – Projet de Fin d'Études Full-Stack Java

> **Dernier projet M2i** réalisé dans le cadre de la formation **Développeur Full-Stack Java** en 2025, mené par **Tony Noa** et Salim.

---

##  Table des matières

- [À propos](#à-propos)  
- [Technologies et architecture](#technologies-et-architecture)  
- [Diagramme UML](#diagramme-uml)  
- [API Endpoints](#api-endpoints)  
- [Installation & utilisation](#installation---utilisation)  
- [Contributeurs](#contributeurs)  
- [Licences & crédits](#licences---crédits)

---

## À propos

Ce projet représente l’aboutissement de la formation de **Développeur Full-Stack Java** proposée par M2i. Il englobe :

- Conception et développement front-end (React) et back-end (Spring Boot – Java)  
- Une API REST complète avec CRUD, authentification, etc.  
- Un diagramme UML clair modélisant l'architecture du système (fichier `.drawio` inclus)

---

## Technologies et architecture

| Côté         | Technologies                                        |
|--------------|----------------------------------------------------|
| Front-end    | React, TypeScript, HTML5, CSS (ou SCSS), Axios     |
| Back-end     | Spring Boot (Java), Spring Security (authentification JWT) |
| Base de données | PostgreSQL / MySQL / H2 (selon le choix projet)   |
| Outils & DevOps | Maven / Gradle, Docker (Dockerfile / docker-compose), CI/CD (GitHub Actions) |

---

## Diagramme UML

Voici une représentation visuelle de l'architecture (structure, entités, relations) du projet :

![Diagramme UML](URL_DE_L_IMAGE_UML_DERIVED_VIA_IMAGE_QUERY)

*(Remplacez `URL_DE_L_IMAGE...` par l'image hébergée du fichier `.drawio` converti en PNG ou SVG.)*

---

## API Endpoints

| Méthode | URL                  | Description                                      |
|---------|----------------------|--------------------------------------------------|
| GET     | `/api/items`         | Récupère la liste de tous les items              |
| GET     | `/api/items/{id}`    | Récupère un item spécifique par son ID           |
| POST    | `/api/items`         | Crée un nouvel item                              |
| PUT     | `/api/items/{id}`    | Met à jour un item existant                      |
| DELETE  | `/api/items/{id}`    | Supprime un item                                 |
| POST    | `/api/auth/login`    | Authentifie un utilisateur, retourne un token JWT |
| POST    | `/api/auth/register` | Enregistre un nouvel utilisateur                 |

*(Adaptez et complétez en fonction des routes réelles de votre projet)*

---

## Installation & utilisation

1. Clonez le dépôt :
   ```bash
   git clone https://github.com/Tony-Noa/M2I-Final-2025.git
   cd M2I-Final-2025
