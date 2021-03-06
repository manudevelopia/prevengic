package info.developia.prevengic.service;

import info.developia.prevengic.dao.ChemicalProfileDao;
import info.developia.prevengic.dao.CompoundDao;
import info.developia.prevengic.dao.NoteDao;
import info.developia.prevengic.dao.WarningAdviceDao;
import info.developia.prevengic.dto.ScrappedCompoundDto;
import info.developia.prevengic.exception.ScrapperException;
import info.developia.prevengic.mapper.CompoundMapper;
import info.developia.prevengic.model.ChemicalProfile;
import info.developia.prevengic.model.Compound;
import info.developia.prevengic.model.Note;
import info.developia.prevengic.model.WarningAdvice;
import info.developia.prevengic.repository.CompoundRepository;
import info.developia.prevengic.repository.NoteRepository;
import info.developia.prevengic.repository.WarningAdviceRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ScrapperServiceImpl implements ScrapperService {

    private final CompoundRepository compoundRepository;

    private final NoteRepository noteRepository;

    private final WarningAdviceRepository warningAdviceRepository;

    public ScrapperServiceImpl(CompoundRepository compoundRepository, NoteRepository noteRepository, WarningAdviceRepository warningAdviceRepository) {
        this.compoundRepository = compoundRepository;
        this.noteRepository = noteRepository;
        this.warningAdviceRepository = warningAdviceRepository;
    }

    @Override
    public Compound parse(ScrappedCompoundDto scrappedCompoundDto) {
        Set<Note> notes = Optional.ofNullable(scrappedCompoundDto.getNotes()).orElse(Collections.emptyList())
                .stream()
                .map(advise -> new Note(advise.getCode(), advise.getTitle()))
                .collect(Collectors.toSet());

        Set<WarningAdvice> warningAdvices = Optional.ofNullable(scrappedCompoundDto.getWarns()).orElse(Collections.emptyList())
                .stream()
                .map(advise -> new WarningAdvice(advise.getCode(), advise.getTitle()))
                .collect(Collectors.toSet());

        ChemicalProfile chemicalProfile = ChemicalProfile.builder()
                .notes(notes)
                .warningAdvices(warningAdvices)
                .vlaEdPpm(scrappedCompoundDto.getVlaEdPpm())
                .vlaEdMgm(scrappedCompoundDto.getVlaEdMgm())
                .vlaEcPpm(scrappedCompoundDto.getVlaEcPpm())
                .vlaEcMgm(scrappedCompoundDto.getVlaEcMgm())
                .build();

        Compound newCompound = Compound.builder()
                .name(scrappedCompoundDto.getName())
                .parent(scrappedCompoundDto.getParent())
                .nce(scrappedCompoundDto.getNce())
                .ncas(scrappedCompoundDto.getNcas())
                .url(scrappedCompoundDto.getUrl())
                .chemicalProfile(chemicalProfile)
                .build();

        return createCompound(newCompound);
    }

    private Compound createCompound(Compound newCompound) {
        ChemicalProfile chemicalProfile = newCompound.getChemicalProfile();
        CompoundDao compoundEntity = CompoundDao.builder()
                .name(newCompound.getName())
                .nce(newCompound.getNce())
                .ncas(newCompound.getNcas())
                .url(newCompound.getUrl())
                .chemicalProfile(ChemicalProfileDao.builder()
                        .notes(new HashSet<>())
                        .warningAdvices(new HashSet<>())
                        .build())
                .build();

        String compundParent = newCompound.getParent();

        if (compundParent != null && !compundParent.isEmpty()) {
            parseParent(newCompound, compoundEntity);
        } else {
            Set<NoteDao> notes = newCompound.getChemicalProfile().getNotes()
                    .stream().map(this::parseNotes).collect(Collectors.toSet());
            compoundEntity.getChemicalProfile().setNotes(notes);

            Set<WarningAdviceDao> warningAdvices = newCompound.getChemicalProfile().getWarningAdvices()
                    .stream().map(this::parseWarningAdvices).collect(Collectors.toSet());
            compoundEntity.getChemicalProfile().setWarningAdvices(warningAdvices);

            compoundEntity.getChemicalProfile().setVlaEcMgm(chemicalProfile.getVlaEcMgm());
            compoundEntity.getChemicalProfile().setVlaEcPpm(chemicalProfile.getVlaEcPpm());
            compoundEntity.getChemicalProfile().setVlaEdMgm(chemicalProfile.getVlaEdMgm());
            compoundEntity.getChemicalProfile().setVlaEdPpm(chemicalProfile.getVlaEdPpm());
        }

        CompoundDao result = compoundRepository.save(compoundEntity);

        return CompoundMapper.MAPPER.entityToDomain(result);
    }

    private NoteDao parseNotes(Note note) {
        return noteRepository.findByCode(note.getCode())
                .orElse(NoteDao.builder()
                        .code(note.getCode())
                        .description(note.getDescription())
                        .build());

    }

    private WarningAdviceDao parseWarningAdvices(WarningAdvice warningAdvices) {
        return warningAdviceRepository.findByCode(warningAdvices.getCode())
                .orElse(WarningAdviceDao.builder()
                        .code(warningAdvices.getCode())
                        .description(warningAdvices.getDescription())
                        .build());
    }

    private void parseParent(Compound newCompound, CompoundDao compoundEntity) {
        CompoundDao parentCompound = compoundRepository
                .findByName(newCompound.getParent())
                .orElseThrow(() -> new ScrapperException("No parent '" + newCompound.getParent() + "' could be found for '" + newCompound.getName() + "'"));

        Optional<Set<NoteDao>> parentNotes = Optional.ofNullable(parentCompound.getChemicalProfile().getNotes());
        Optional<Set<WarningAdviceDao>> parentWarningAdvices = Optional.ofNullable(parentCompound.getChemicalProfile().getWarningAdvices());

        parentNotes.ifPresent(notes -> notes.forEach(note -> compoundEntity.getChemicalProfile().addNote(note)));
        parentWarningAdvices.ifPresent(warningAdvices -> warningAdvices.forEach(warningAdvice -> compoundEntity.getChemicalProfile().addWarningAdvice(warningAdvice)));
    }

}
