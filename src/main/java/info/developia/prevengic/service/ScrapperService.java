package info.developia.prevengic.service;

import info.developia.prevengic.dto.ScrappedCompoundDto;
import info.developia.prevengic.model.Compound;

public interface ScrapperService {

    Compound parse(ScrappedCompoundDto scrappedCompoundDto);

}
