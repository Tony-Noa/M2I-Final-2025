package org.example.tournament.exception;

public class TokenNotFoundException extends RuntimeException {
} // Permettrait de faire la difference entre un NotFoundException classique et un NotFoundException dans le cas d'un
 // manque de token pour faire les requêtes "private"... comme sur le UserAccountController -> Delete. Mais la réimplémentation
 // n'est pas encore maitrisée.
