package info.developia.prevengic.service;

import info.developia.prevengic.dao.Report;
import info.developia.prevengic.repository.ReportRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportServiceImpl implements ReportService{

    public final ReportRepository reportRepository;

    public ReportServiceImpl(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    @Override
    public List<Report> findAll() {
        return reportRepository.findAll();
    }

}
