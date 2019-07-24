package info.developia.prevengic.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CompoundDto {

    private String nce;
    private String ncas;
    private String name;
    private String url;

}
