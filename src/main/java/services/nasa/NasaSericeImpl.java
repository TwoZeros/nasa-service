package services.nasa;

import com.fasterxml.jackson.databind.ObjectMapper;
import services.nasa.dto.NasaPicture;
import services.nasa.exception.PictureNotFoundException;
import services.nasa.interfaces.NasaHttpClient;
import services.nasa.interfaces.NasaService;

import java.io.*;
import java.util.Date;

public class NasaSericeImpl implements NasaService {
    private NasaHttpClient nasaHttpClient;
    private ObjectMapper mapper = new ObjectMapper();
    private static final String PATH_SAVE = "Picture";

    public NasaSericeImpl() {
        nasaHttpClient = new NasaHttlpClientImpl();
    }

    @Override
    public NasaPicture getAstronomyPicture(Date date) throws PictureNotFoundException {
        try {
            return nasaHttpClient.getAstronomyPicture(date);
        } catch (IOException e) {
            throw new PictureNotFoundException(e.getCause());
        }

    }

    @Override
    public void saveToDiskNasaPicture(NasaPicture picture) throws PictureNotFoundException {
        if (pictureIsLoaded(picture))
            return;

        String fileName = PATH_SAVE + File.separator + getNameFilePicture(picture);

        try (InputStream inputStream = nasaHttpClient.downloadPicture(picture.getHdurl());
             FileOutputStream fos = new FileOutputStream(fileName);
             BufferedOutputStream bos = new BufferedOutputStream(fos)) {
            byte[] bytes = inputStream.readAllBytes();
            bos.write(bytes, 0, bytes.length);
        } catch (IOException e) {
            throw new PictureNotFoundException(e.getCause());
        }
    }

    public boolean pictureIsLoaded(NasaPicture picture) {
        String filename = getNameFilePicture(picture);
        File file = new File(PATH_SAVE + File.separator + filename);
        return file.exists();
    }

    @Override
    public String getNameFilePicture(NasaPicture picture) {
        String url = picture.getHdurl();
        return getNameFilePicture(url);
    }

    @Override
    public String getNameFilePicture(String url) {
        String[] arr = url.split("/");
        return arr[arr.length - 1];
    }
}
