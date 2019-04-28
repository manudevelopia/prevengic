package info.developia.prevengic.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompoundReportResult {

    private String name;

    private ExpositionResult shortExposition;
    private ExpositionResult exposition;

    private Set<WarningAdvice> warningAdvices;
    private Set<Note> notes;

}
