package info.developia.prevengic.model;

import lombok.Data;

import java.util.Set;

@Data
public class Report {

    private String name;
    private Set<Workarea> workareas;
    private User user;
}
