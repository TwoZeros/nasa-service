package services.nasa.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class NasaPicture {
    private String copyright;
    private String date;
    private String explanation;
    private String hdurl;
    private String title;
    private String mediaType;
    private String url;
    private String serviceVersion;

    public NasaPicture(
            @JsonProperty("copyright") String copyright,
            @JsonProperty("date") String date,
            @JsonProperty("explanation") String explanation,
            @JsonProperty("hdurl") String hdUrl,
            @JsonProperty("title") String title,
            @JsonProperty("media_type") String mediaType,
            @JsonProperty("url") String url,
            @JsonProperty("service_version") String serviceVersion) {
        this.copyright = copyright;
        this.date = date;
        this.explanation = explanation;
        this.hdurl = hdUrl;
        this.title = title;
        this.mediaType = mediaType;
        this.url = url;
        this.serviceVersion = serviceVersion;
    }


    @Override
    public String toString() {
        return "NasaPicture{" +
                "title='" + title + '\'' +
                ", date='" + date + '\'' +
                ", explanation='" + explanation + '\'' +
                ", hdurl='" + hdurl + '\'' +
                ", copyright='" + copyright + '\'' +
                '}';
    }
}
