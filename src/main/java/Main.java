import services.nasa.NasaSericeImpl;
import services.nasa.dto.NasaPicture;
import services.nasa.exception.PictureNotFoundException;
import services.nasa.interfaces.NasaService;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Main {
    private static NasaService nasaService = new NasaSericeImpl();

    public static void main(String[] args) {
        try {
            Calendar calendar = new GregorianCalendar(2022, Calendar.JUNE, 14);
            Date date = calendar.getTime();
            NasaPicture picture = nasaService.getAstronomyPicture(date);
            nasaService.saveToDiskNasaPicture(picture);
            System.out.println("Картинка сохранена " + nasaService.getNameFilePicture(picture));
        } catch (PictureNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }
}
