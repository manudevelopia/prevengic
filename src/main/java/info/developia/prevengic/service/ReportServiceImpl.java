package info.developia.prevengic.service;

import info.developia.prevengic.dao.Compound;
import info.developia.prevengic.dao.CompoundReportResult;
import info.developia.prevengic.dao.ExpositionResult;
import info.developia.prevengic.dao.ReportDao;
import info.developia.prevengic.dto.SelectedCompoundForm;
import info.developia.prevengic.dto.SelectedCompoundItem;
import info.developia.prevengic.exception.CompoundDoesNotExistException;
import info.developia.prevengic.mapper.ReportMapper;
import info.developia.prevengic.repository.CompoundRepository;
import info.developia.prevengic.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReportServiceImpl implements ReportService {

    private final ReportRepository reportRepository;

    private final CompoundRepository compoundRepository;

    @Autowired
    public ReportServiceImpl(ReportRepository reportRepository, CompoundRepository compoundRepository) {
        this.reportRepository = reportRepository;
        this.compoundRepository = compoundRepository;
    }

    @Override
    public List<info.developia.prevengic.model.Report> findAll() {
        return reportRepository.findAll().stream()
                .map(ReportMapper.MAPPER::entityToDomain)
                .collect(Collectors.toList());
    }

    @Override
    public info.developia.prevengic.model.Report create(SelectedCompoundForm selectedCompoundForm) {
        List<CompoundReportResult> result = processSelectedCompounds(selectedCompoundForm);

        ReportDao report = ReportDao.builder()
                .compoundReportResults(result)
                .build();

        reportRepository.save(report);

        return ReportMapper.MAPPER.entityToDomain(report);
    }

    private List<CompoundReportResult> processSelectedCompounds(SelectedCompoundForm selectedCompoundForm) {
        return selectedCompoundForm.getCompounds().stream()
                .map(this::processCompound)
                .collect(Collectors.toList());
    }

    private CompoundReportResult processCompound(SelectedCompoundItem item) {
        Compound compound = compoundRepository.findByName(item.getName())
                .orElseThrow(CompoundDoesNotExistException::new);

        // TODO: replace hour values with constants
        ExpositionResult exposition = calculateExposition(compound, 8);
        ExpositionResult shortExposition = calculateExposition(compound, 1);

        return CompoundReportResult.builder()
                .compound(compound)
                .exposition(exposition)
                .shortExposition(shortExposition)
                .build();
    }

    private ExpositionResult calculateExposition(Compound compound, int hours) {
        return ExpositionResult.builder()
                // TODO: replace Math.random() with real calculations
                .ed(Math.random())
                .vlaEd(Math.random())
                .i(Math.random())
                .build();
    }

}
