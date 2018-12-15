package info.developia.prevengic.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Compound {

    private String nce;
    private String cas;
    private String name;

    private ChemicalProfile chemicalProfile;

}
