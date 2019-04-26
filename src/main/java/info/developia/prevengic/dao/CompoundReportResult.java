package info.developia.prevengic.dao;

import lombok.Builder;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "REPORTS")
@Builder
@Data
public class CompoundReportResult {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    private Compound compound;

    @OneToOne(cascade = CascadeType.ALL)
    private ExpositionResult shortExposition;

    @OneToOne(cascade = CascadeType.ALL)
    private ExpositionResult exposition;

    @ManyToOne
    private Report report;

}
