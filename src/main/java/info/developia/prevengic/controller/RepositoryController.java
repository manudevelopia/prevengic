package info.developia.prevengic.controller;

import info.developia.prevengic.dao.Report;
import info.developia.prevengic.service.ReportService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/reports")
public class RepositoryController {

    private final ReportService reportService;

    public RepositoryController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping("/all")
    ResponseEntity<List<Report>> getAll() {
        List<Report> reports = reportService.findAll();

        return ResponseEntity.ok(reports);
    }

}
