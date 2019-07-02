package info.developia.prevengic.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.util.Strings;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompoundForm {

    public static final String REGEX_VLA_UNITS = "(mg/m3)|(ppm)|(---)";

    private String link;
    private String name;
    private String[] vlas;
    private Double vlaEdPpm;
    private Double vlaEdMgm;
    private Double vlaEcPpm;
    private Double vlaEcMgm;

    private List<Advise> notes;
    private List<Advise> warns;

    public void setVlas(String[] vlas) {
        this.vlas = vlas;

        if (vlas.length == 4) {
            this.vlaEdPpm = parse(vlas[0]);
            this.vlaEdMgm = parse(vlas[1]);
            this.vlaEcPpm = parse(vlas[2]);
            this.vlaEcMgm = parse(vlas[3]);
        }
    }

    private Double parse(String value) {
        value = value.replaceAll(REGEX_VLA_UNITS, Strings.EMPTY).trim();

        try {
            return Double.parseDouble(value);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Advise {
        private String code;
        private String title;
    }

}
