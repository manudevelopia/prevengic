package info.developia.prevengic.service

import info.developia.prevengic.dao.ChemicalProfileDao
import info.developia.prevengic.dao.CompoundDao
import info.developia.prevengic.dao.NoteDao
import info.developia.prevengic.dao.WarningAdviceDao
import info.developia.prevengic.dto.ScrappedCompoundDto
import info.developia.prevengic.model.ChemicalProfile
import info.developia.prevengic.model.Compound
import info.developia.prevengic.model.Note
import info.developia.prevengic.model.WarningAdvice
import info.developia.prevengic.repository.CompoundRepository
import info.developia.prevengic.repository.NoteRepository
import info.developia.prevengic.repository.WarningAdviceRepository
import spock.lang.Specification

class ScrapperServiceImplTest extends Specification {

    CompoundRepository compoundRepository
    NoteRepository noteRepository
    WarningAdviceRepository warningAdviceRepository

    ScrappedCompoundDto scrappedCompoundDto
    CompoundDao compoundDao
    Compound compound

    ScrapperServiceImpl scrapperServiceImpl

    def setup() {
        compoundRepository = Mock()
        noteRepository = Mock()
        warningAdviceRepository = Mock()

        scrappedCompoundDto = new ScrappedCompoundDto(
                link: "link",
                name: "name",
                parent: "parent",
                ncas: "ncas",
                nce: "nce",
                url: "url",
                vlas: ["vlas"] as String[],
                notes: [new ScrappedCompoundDto.Advise("note code", "note title")],
                warns: [new ScrappedCompoundDto.Advise("warn code", "warn title")])

        compoundDao = new CompoundDao(id: 1L, nce: "nce", ncas: "ncas", name: "name", url: "url",
                chemicalProfile: new ChemicalProfileDao(id: 1L, vlaEcMgm: 0D, vlaEcPpm: 0D, vlaEdMgm: 0D, vlaEdPpm: 0D,
                        notes: [new NoteDao(1L, "note code", "note description")],
                        warningAdvices: [new WarningAdviceDao(1L, "warningAdvice code", "warningAdvice description")]))

        compound = new Compound("nce", "ncas", "name", "parent", "url",
                new ChemicalProfile(0D, 0D, 0D, 0D,
                        [new WarningAdvice("code", "description")] as Set<WarningAdvice>,
                        [new Note("code", "description")] as Set<Note>))


        scrapperServiceImpl = new ScrapperServiceImpl(compoundRepository, noteRepository, warningAdviceRepository)
    }

    def "test parse"() {
        given:
        compoundRepository.findByName(_ as String) >> Optional.of(compoundDao)
        compoundRepository.save(_ as CompoundDao) >> compoundDao

        when:
        Compound result = scrapperServiceImpl.parse(scrappedCompoundDto)

        then:
        with(result) {
            nce == "nce"
            ncas == "ncas"
            name == "name"
            url == "url"

            chemicalProfile.notes[0].code == "note code"
            chemicalProfile.notes[0].description == "note description"
            chemicalProfile.warningAdvices[0].code == "warningAdvice code"
            chemicalProfile.warningAdvices[0].description == "warningAdvice description"
        }
    }

}
