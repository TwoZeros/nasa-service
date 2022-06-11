package services.nasa.exception;

import java.io.IOException;

public class PictureNotFoundException extends IOException {

    public PictureNotFoundException(Throwable throwable) {
        super("Картинка не была найдена", throwable);
    }

    public PictureNotFoundException(String message) {
        super(message);
    }

    public PictureNotFoundException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
