package services.nasa.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class NasaPicture {
    private String copyright;
    private String date;
    private String explanation;
    private String hdurl;
    private String title;
    private String media_type;
    private String url;
    private String service_version;

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
