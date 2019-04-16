package info.developia.prevengic.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SelectedCompoundForm {

    private List<SelectedCompoundItem> compounds;

}
