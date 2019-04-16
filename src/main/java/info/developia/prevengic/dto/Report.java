package info.developia.prevengic.dto;

import info.developia.prevengic.model.CompoundReportResult;
import lombok.Data;

import java.util.List;

@Data
public class Report {

    private List<CompoundReportResult> compoundReportResults;

}
