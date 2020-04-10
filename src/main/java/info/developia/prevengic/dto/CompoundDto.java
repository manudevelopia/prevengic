package info.developia.prevengic.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CompoundDto {

    private String nce;
    private String ncas;
    private String name;
    private String url;

    private Double vlaEdPpm;
    private Double vlaEdMgm;
    private Double vlaEcPpm;
    private Double vlaEcMgm;
}
