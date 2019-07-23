package info.developia.prevengic.service;

import info.developia.prevengic.dao.CompoundDao;
import info.developia.prevengic.dao.ExpositionResultDao;
import info.developia.prevengic.dao.ReportDao;
import info.developia.prevengic.dao.ReportResultDao;
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
        List<ReportResultDao> results = processSelectedCompounds(selectedCompoundForm);

        ReportDao report = ReportDao.builder()
                .compoundReportResults(results)
                .build();

        reportRepository.save(report);

        return ReportMapper.MAPPER.entityToDomain(report);
    }

    private List<ReportResultDao> processSelectedCompounds(SelectedCompoundForm selectedCompoundForm) {
        return selectedCompoundForm.getCompounds().stream()
                .map(this::processCompound)
                .collect(Collectors.toList());
    }

    private ReportResultDao processCompound(SelectedCompoundItem item) {
        CompoundDao compound = compoundRepository.findByName(item.getName())
                .orElseThrow(CompoundDoesNotExistException::new);

        // TODO: replace hour values with constants
        ExpositionResultDao exposition = calculateExposition(compound, 8);
        ExpositionResultDao shortExposition = calculateExposition(compound, 1);

        return ReportResultDao.builder()
                .compound(compound)
                .exposition(exposition)
                .shortExposition(shortExposition)
                .build();
    }

    private ExpositionResultDao calculateExposition(CompoundDao compound, int hours) {
        return ExpositionResultDao.builder()
                // TODO: replace Math.random() with real calculations
                .ed(Math.random())
                .vlaEd(Math.random())
                .i(Math.random())
                .build();
    }

}
