package dev.gabrafo.EsportsAI.error.general;

public class UnavailableClientException extends RuntimeException {
    public UnavailableClientException(String message) {
        super(message);
    }
}
