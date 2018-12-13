package info.developia.prevengic.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Compound {

    private String nce;
    private String cas;
    private String name;

    private ChemicalProfile chemicalProfile;

}
