package info.developia.prevengic.dao;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "REPORT_RESULTS")
@Builder
@Data
public class ReportResultDao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @EqualsAndHashCode.Exclude
    private Long id;

    @OneToOne
    private Compound compound;

    @OneToOne(cascade = CascadeType.ALL)
    private ExpositionResultDao shortExposition;

    @OneToOne(cascade = CascadeType.ALL)
    private ExpositionResultDao exposition;

    @ManyToOne
    private ReportDao report;

}
