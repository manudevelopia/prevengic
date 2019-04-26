package info.developia.prevengic.controller

import info.developia.prevengic.dto.SelectedCompoundForm
import info.developia.prevengic.dto.SelectedCompoundItem
import info.developia.prevengic.model.Report
import info.developia.prevengic.service.ReportService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import spock.lang.Specification

class ReportControllerTest extends Specification {

    def reportService
    def reportController
    def compoundReportForm
    def report

    def setup() {
        reportService = Mock(ReportService)
        reportController = new ReportController(reportService)
        report = new Report()

        compoundReportForm = new SelectedCompoundForm(compounds: [
                new SelectedCompoundItem(name: "Test Compound 1", concentration: 1D, exposition: 2D),
                new SelectedCompoundItem(name: "Test Compound 2", concentration: 2D, exposition: 3D),
                new SelectedCompoundItem(name: "Test Compound 3", concentration: 3D, exposition: 4D),
                new SelectedCompoundItem(name: "Test Compound 4", concentration: 4D, exposition: 5D)
        ])
    }

    def "test get all Reports controller"() {
        given:
        reportService.findAll() >> [report]

        when:
        ResponseEntity<List<Report>> result = reportController.getAll()

        then:
        result.getStatusCode() == HttpStatus.OK
        result.getBody() != null
    }

    def "test create a Report"() {
        given:
        reportService.create(_ as SelectedCompoundForm) >> report

        when:
        ResponseEntity result = reportController.create(compoundReportForm)

        then:
        result.getStatusCode() == HttpStatus.OK
        result.getBody() != null
    }

}