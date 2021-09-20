package Dapeng.DataHubService.entities;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "DOW_JONES_INDEX")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DowJonesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Integer id;
    private Integer quarter;
    private String stock;
    private Date date;
    private BigDecimal open;
    private BigDecimal high;
    private BigDecimal low;
    private BigDecimal close;
    private BigDecimal volume;
    private BigDecimal percent_change_price;
    private BigDecimal percent_change_volume_over_last_week;
    private BigDecimal previous_weeks_volume;
    private BigDecimal next_weeks_open;
    private BigDecimal next_weeks_close;
    private BigDecimal percent_change_next_weeks_price;
    private Integer days_to_next_dividend;
    private BigDecimal percent_return_next_dividend;

    public DowJonesEntity(Integer quarter, String stock, Date date, BigDecimal open, BigDecimal high, BigDecimal low, BigDecimal close, BigDecimal volume, BigDecimal percent_change_price, BigDecimal percent_change_volume_over_last_week, BigDecimal previous_weeks_volume, BigDecimal next_weeks_open, BigDecimal next_weeks_close, BigDecimal percent_change_next_weeks_price, Integer days_to_next_dividend, BigDecimal percent_return_next_dividend) {
        this.quarter = quarter;
        this.stock = stock;
        this.date = date;
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
        this.volume = volume;
        this.percent_change_price = percent_change_price;
        this.percent_change_volume_over_last_week = percent_change_volume_over_last_week;
        this.previous_weeks_volume = previous_weeks_volume;
        this.next_weeks_open = next_weeks_open;
        this.next_weeks_close = next_weeks_close;
        this.percent_change_next_weeks_price = percent_change_next_weeks_price;
        this.days_to_next_dividend = days_to_next_dividend;
        this.percent_return_next_dividend = percent_return_next_dividend;
    }




}
