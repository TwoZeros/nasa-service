package services.nasa.interfaces;

import services.nasa.dto.NasaPicture;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

public interface NasaHttpClient {
    NasaPicture getAstronomyPicture(Date date) throws IOException;
    InputStream downloadPicture(String url) throws IOException;
}
