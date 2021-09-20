package Dapeng.DataHubService.models;

import Dapeng.DataHubService.entities.DowJonesEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
public class StockInfoModel{
    @JsonProperty("stock")
    private String stock;
    @JsonProperty("quarter")
    private Integer quarter;
    @JsonProperty("date")
    private Date date;
    @JsonProperty("open")
    private BigDecimal open;
    @JsonProperty("high")
    private BigDecimal high;
    @JsonProperty("low")
    private BigDecimal low;
    @JsonProperty("close")
    private BigDecimal close;
    @JsonProperty("volume")
    private BigDecimal volume;
    @JsonProperty("percent_change_price")
    private BigDecimal percent_change_price;
    @JsonProperty("percent_change_volume_over_last_week")
    private BigDecimal percent_change_volume_over_last_week;
    @JsonProperty("previous_weeks_volume")
    private BigDecimal previous_weeks_volume;
    @JsonProperty("next_weeks_open")
    private BigDecimal next_weeks_open;
    @JsonProperty("next_weeks_close")
    private BigDecimal next_weeks_close;
    @JsonProperty("percent_change_next_weeks_price")
    private BigDecimal percent_change_next_weeks_price;
    @JsonProperty("days_to_next_dividend")
    private Integer days_to_next_dividend;
    @JsonProperty("percent_return_next_dividend")
    private BigDecimal percent_return_next_dividend;

    public StockInfoModel(DowJonesEntity entity) {
        stock = entity.getStock().trim();
        quarter = entity.getQuarter();
        date = entity.getDate();
        open = entity.getOpen();
        high = entity.getHigh();
        low = entity.getLow();
        close = entity.getClose();
        volume = entity.getVolume();
        percent_change_price = entity.getPercent_change_price();
        percent_change_volume_over_last_week = entity.getPercent_change_volume_over_last_week();
        previous_weeks_volume = entity.getPrevious_weeks_volume();
        next_weeks_open = entity.getNext_weeks_open();
        next_weeks_close = entity.getNext_weeks_close();
        percent_change_next_weeks_price = entity.getPercent_change_next_weeks_price();
        days_to_next_dividend = entity.getDays_to_next_dividend();
        percent_return_next_dividend =entity.getPercent_return_next_dividend();
    }
}
