package services.nasa;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import services.nasa.dto.NasaPicture;
import services.nasa.interfaces.NasaHttpClient;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NasaHttlpClientImpl implements NasaHttpClient {

    private static final String API_KEY = "cOOVRrGjZdOrnw5XVEKhQDlPaRFTDhFwezslQoKq";
    private static final String URI = "https://api.nasa.gov/";
    private final static ObjectMapper mapper = new ObjectMapper();
    private final CloseableHttpClient httpClient;
    private final SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");

    public NasaHttlpClientImpl() {
        httpClient = HttpClientBuilder.create()
                .setDefaultRequestConfig(RequestConfig.custom()
                        .setConnectTimeout(5000)    // максимальное время ожидание подключения к серверу
                        .setSocketTimeout(30000)    // максимальное время ожидания получения данных
                        .setRedirectsEnabled(false) // возможность следовать редиректу в ответе
                        .build())
                .build();
    }

    @Override
    public NasaPicture getAstronomyPicture(Date date) throws IOException {
        String strDate = formater.format(date);
        HttpGet request = new HttpGet(String.format("%s%s?api_key=%s&date=%s", URI, "planetary/apod", API_KEY, strDate));
        CloseableHttpResponse response = httpClient.execute(request);
        return mapper.readValue(response.getEntity().getContent(), NasaPicture.class);
    }

    @Override
    public InputStream downloadPicture(String url) throws IOException {
        HttpGet request = new HttpGet(url);
        CloseableHttpResponse response = httpClient.execute(request);
        return response.getEntity().getContent();
    }
}
