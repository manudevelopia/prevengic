package info.developia.prevengic.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "REPORTS")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReportDao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @EqualsAndHashCode.Exclude
    private Long id;

    @OneToMany(mappedBy = "report")
    private Set<Workarea> workareas;

    @ManyToOne
    private UserDao user;

    @OneToMany(mappedBy = "report", cascade = CascadeType.ALL)
    private List<CompoundReportResult> compoundReportResults;

}
