package dev.gabrafo.EsportsAI.error.address;

public class PostalCodeNotFoundException extends RuntimeException {
    public PostalCodeNotFoundException(String message) {
        super(message);
    }
}