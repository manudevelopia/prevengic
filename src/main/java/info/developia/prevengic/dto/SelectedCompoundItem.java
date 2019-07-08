package info.developia.prevengic.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SelectedCompoundItem {

    private String name;

    private Double concentration;
    private Double exposition;

}