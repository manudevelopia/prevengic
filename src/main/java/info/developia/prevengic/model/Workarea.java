package info.developia.prevengic.model;

import lombok.Data;

import java.util.Set;

@Data
public class Workarea {

    private String name;
    private Report report;
    private Set<Compound> compounds;

}
