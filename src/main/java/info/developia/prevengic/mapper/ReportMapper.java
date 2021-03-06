package info.developia.prevengic.mapper;

import info.developia.prevengic.dao.ReportDao;
import info.developia.prevengic.dao.ReportResultDao;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ReportMapper {

    ReportMapper MAPPER = Mappers.getMapper(ReportMapper.class);

    info.developia.prevengic.model.Report entityToDomain(ReportDao entity);

    List<info.developia.prevengic.model.Report> entityToDomain(List<ReportDao> entity);

    @Mapping(source = "compound.name", target = "name")
    @Mapping(source = "compound.chemicalProfile.warningAdvices", target = "warningAdvices")
    @Mapping(source = "compound.chemicalProfile.notes", target = "notes")
    info.developia.prevengic.model.CompoundReportResult entityToDomain(ReportResultDao entity);

}
