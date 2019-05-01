package info.developia.prevengic.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompoundReportResult {

    private String name;

    private ExpositionResult shortExposition;
    private ExpositionResult exposition;

    // TODO: maybe? refactor those collection to String type, to avoid data duplicity in payload
    private Set<WarningAdvice> warningAdvices;
    private Set<Note> notes;

}
