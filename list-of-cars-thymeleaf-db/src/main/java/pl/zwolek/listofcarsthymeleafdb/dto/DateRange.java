package pl.zwolek.listofcarsthymeleafdb.dto;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class DateRange {
    @NotNull
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date productionDateFrom;
    @NotNull
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date productionDateTo;

    public Date getProductionDateFrom() {
        return productionDateFrom;
    }

    public void setProductionDateFrom(Date productionDateFrom) {
        this.productionDateFrom = productionDateFrom;
    }

    public Date getProductionDateTo() {
        return productionDateTo;
    }

    public void setProductionDateTo(Date productionDateTo) {
        this.productionDateTo = productionDateTo;
    }
}
