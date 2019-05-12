package info.developia.prevengic.controller;

import info.developia.prevengic.dto.SelectedCompoundForm;
import info.developia.prevengic.model.Report;
import info.developia.prevengic.service.ReportService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/reports")
public class ReportController {

    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Report>> getAll() {
        List<Report> reports = reportService.findAll();

        return ResponseEntity.ok(reports);
    }

    @PostMapping("/create")
    public ResponseEntity create(@RequestBody SelectedCompoundForm selectedCompoundForm) {
        Report report = reportService.create(selectedCompoundForm);

        return ResponseEntity.ok(report);
    }

}
