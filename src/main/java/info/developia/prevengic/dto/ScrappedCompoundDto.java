package info.developia.prevengic.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.util.Strings;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScrappedCompoundDto {

    public static final String REGEX_VLA_UNITS = "(mg/m3)|(ppm)|(---)";

    private String link;
    private String name;
    private String parent;
    private String ncas;
    private String nce;
    private String url;
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
            this.vlaEdPpm = parseVlaValues(vlas[0]);
            this.vlaEdMgm = parseVlaValues(vlas[1]);
            this.vlaEcPpm = parseVlaValues(vlas[2]);
            this.vlaEcMgm = parseVlaValues(vlas[3]);
        }
    }

    public void setParent(String parent) {
        this.parent = saneText(parent);
    }

    private String saneText(String text) {
        return text.replaceAll("[\\n\\t]", "").trim();
    }

    private Double parseVlaValues(String valueWithUnit) {
        String value = valueWithUnit.replaceAll(REGEX_VLA_UNITS, Strings.EMPTY).trim();

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
