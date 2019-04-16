package info.developia.prevengic.service;

import info.developia.prevengic.dao.Report;
import info.developia.prevengic.dto.SelectedCompoundForm;
import info.developia.prevengic.dto.SelectedCompoundItem;
import info.developia.prevengic.model.Compound;
import info.developia.prevengic.model.CompoundReportResult;
import info.developia.prevengic.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReportServiceImpl implements ReportService {

    private final ReportRepository reportRepository;

    private final CompoundService compoundService;

    @Autowired
    public ReportServiceImpl(ReportRepository reportRepository, CompoundService compoundService) {
        this.reportRepository = reportRepository;
        this.compoundService = compoundService;
    }

    @Override
    public List<Report> findAll() {
        return reportRepository.findAll();
    }

    @Override
    public Report create(SelectedCompoundForm selectedCompoundForm) {
        Report report = new Report();

        // TODO: add compounds results to entity
        List<CompoundReportResult> result = processSelectedCompounds(selectedCompoundForm);

        return reportRepository.save(report);
    }

    private List<CompoundReportResult> processSelectedCompounds(SelectedCompoundForm selectedCompoundForm) {
        return selectedCompoundForm.getCompounds().stream()
                .map(this::processCompound)
                .collect(Collectors.toList());
    }

    private CompoundReportResult processCompound(SelectedCompoundItem selectedCompoundItem) {
        Compound compound = compoundService.findById(selectedCompoundItem.getId());

        // TODO: calculate with compound with compound exposure and concentration

        return CompoundReportResult.builder()
                .build();
    }

}
