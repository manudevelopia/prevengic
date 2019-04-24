package info.developia.prevengic.controller

import info.developia.prevengic.dao.Report
import info.developia.prevengic.dto.SelectedCompoundForm
import info.developia.prevengic.dto.SelectedCompoundItem
import info.developia.prevengic.service.ReportService
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import spock.lang.Specification

import static org.mockito.ArgumentMatchers.any
import static org.mockito.Mockito.when

class ReportControllerTest extends Specification {

    @Mock
    ReportService reportService

    @InjectMocks
    ReportController reportController

    SelectedCompoundForm compoundReportForm

    def setup() {
        MockitoAnnotations.initMocks(this)

        compoundReportForm = new SelectedCompoundForm(compounds: [
                new SelectedCompoundItem(name: "Test Compound 1", concentration: 1D, exposition: 2D),
                new SelectedCompoundItem(name: "Test Compound 2", concentration: 2D, exposition: 3D),
                new SelectedCompoundItem(name: "Test Compound 3", concentration: 3D, exposition: 4D),
                new SelectedCompoundItem(name: "Test Compound 4", concentration: 4D, exposition: 5D)
        ])
    }

    def "test get All"() {
        given:
        when(reportService.findAll()).thenReturn([new Report()])

        when:
        ResponseEntity<List<Report>> result = reportController.getAll()

        then:
        result.getStatusCode() == HttpStatus.OK
        result.getBody() != null
    }

    def "test create"() {
        given:
        when(reportService.create(any() as SelectedCompoundForm)).thenReturn(new Report())

        when:
        ResponseEntity result = reportController.create(compoundReportForm)

        then:
        result.getStatusCode() == HttpStatus.OK
        result.getBody() != null
    }

}