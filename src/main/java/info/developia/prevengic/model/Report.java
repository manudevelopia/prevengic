package info.developia.prevengic.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Report {

    private List<CompoundReportResult> compoundReportResults;

    private Set<WarningAdvice> warningAdvices;
    private Set<Note> notes;

    public Set<WarningAdvice> getWarningAdvices(){
        return compoundReportResults.stream()
                .map(CompoundReportResult::getWarningAdvices)
                .flatMap(Collection::stream)
                .collect(Collectors.toSet());
    }

    public Set<Note> getNotes(){
        return compoundReportResults.stream()
                .map(CompoundReportResult::getNotes)
                .flatMap(Collection::stream)
                .collect(Collectors.toSet());
    }

}
