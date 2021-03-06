package info.developia.prevengic.service

import info.developia.prevengic.dao.CompoundDao
import info.developia.prevengic.dao.ReportDao
import info.developia.prevengic.dto.SelectedCompoundForm
import info.developia.prevengic.dto.SelectedCompoundItem
import info.developia.prevengic.repository.CompoundRepository
import info.developia.prevengic.repository.ReportRepository
import spock.lang.Specification

class ReportServiceImplTest extends Specification {

    ReportRepository reportRepository

    CompoundRepository compoundRepository

    ReportServiceImpl reportService

    def setup() {
        compoundRepository = Stub()
        reportRepository = Stub()

        reportService = new ReportServiceImpl(reportRepository, compoundRepository)
    }

    def "test find All"() {
        given:
        def reportDao = new ReportDao(compoundReportResults: [])
        def reportDto = new info.developia.prevengic.model.Report( compoundReportResults: [])

        reportRepository.findAll() >> [reportDao]

        when:
        List<info.developia.prevengic.model.Report> result = reportService.findAll()

        then:
        result == [reportDto]
    }

    def "test create"() {
        given:
        def compound = new CompoundDao(name: "Test CompoundDao")
        compoundRepository.findByName(_) >> Optional.of(compound)

        when:
        info.developia.prevengic.model.Report result = reportService.create(new SelectedCompoundForm([new SelectedCompoundItem()]))

        then:
        result.compoundReportResults[0].name == "Test CompoundDao"
    }
}
