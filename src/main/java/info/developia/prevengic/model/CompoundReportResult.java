package info.developia.prevengic.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompoundReportResult {

    private String name;

    private ExpositionResult shortExposition;
    private ExpositionResult exposition;

    private List<String> fh;
    private List<String> notes;

}
