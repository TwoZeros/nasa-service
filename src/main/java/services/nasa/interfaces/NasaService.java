package services.nasa.interfaces;

import services.nasa.dto.NasaPicture;
import services.nasa.exception.PictureNotFoundException;

import java.util.Date;

/**
 * @author Pakhtusov Kirill
 */
public interface NasaService {
    /**
     * Возвращет ежедневное фото на определенную дату см https://apod.nasa.gov/apod/astropix.html
     */
    NasaPicture getAstronomyPicture(Date date) throws PictureNotFoundException;

    /**
     * Сохраняет изображеие на ПК
     * @param picture Объект изображение
     */
    void saveToDiskNasaPicture(NasaPicture picture) throws PictureNotFoundException;

    /**
     * Возвращает название картинки + расширение
     * @param picture
     * @return
     */
    String getNameFilePicture(NasaPicture  picture);

    String getNameFilePicture(String  url);

    /**
     * Проверка, что картинка c таким именем уже скачена
     * @param picture
     * @return
     */
    boolean pictureIsLoaded(NasaPicture picture);
}
