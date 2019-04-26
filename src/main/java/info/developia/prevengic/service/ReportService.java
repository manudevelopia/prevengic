package info.developia.prevengic.service;

import info.developia.prevengic.dto.SelectedCompoundForm;
import info.developia.prevengic.model.Report;

import java.util.List;

public interface ReportService {

    List<Report> findAll();

    Report create(SelectedCompoundForm selectedCompoundForm);

}
