package info.developia.prevengic.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Compound {

    private String code;
    private String name;
    private ChemicalProfile chemicalProfile;
}
