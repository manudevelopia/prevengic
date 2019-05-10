package info.developia.prevengic.service;

import info.developia.prevengic.model.Compound;

import java.util.List;

public interface CompoundService {

    List<Compound> findAll();

    List<Compound> findBy(String nce, String cas, String name);

}
