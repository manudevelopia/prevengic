package info.developia.prevengic.service;

import info.developia.prevengic.dto.CompoundForm;
import info.developia.prevengic.model.Compound;

public interface ScrapperService {

    Compound parse(CompoundForm compoundForm);

}
