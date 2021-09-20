package Dapeng.DataHubService.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import java.math.BigDecimal;
import java.util.Date;
@Getter
public class AddStockRecordRequest {
    @NotNull
    @JsonProperty("stock")
    private String stock;
    @JsonProperty("quarter")
    //@Pattern(regexp = "\\d+", message = "quarter is invalid")
    private Integer quarter;
    @JsonProperty("date")
    @JsonFormat(pattern = "dd/mm/yyyy")
    private Date date;
    @JsonProperty("open")
    //@Pattern(regexp = "^-?\\d+(\\.\\d+)?$", message = "open is invalid")
    private BigDecimal open;
    @JsonProperty("high")
    //@Pattern(regexp = "^-?\\d+(\\.\\d+)?$", message = "high is invalid")
    private BigDecimal high;
    @JsonProperty("low")
    //@Pattern(regexp = "^-?\\d+(\\.\\d+)?$", message = "low is invalid")
    private BigDecimal low;
    @JsonProperty("close")
    //@Pattern(regexp = "^-?\\d+(\\.\\d+)?$", message = "close is invalid")
    private BigDecimal close;
    @JsonProperty("volume")
    //@Pattern(regexp = "^-?\\d+(\\.\\d+)?$", message = "volume is invalid")
    private BigDecimal volume;
    @JsonProperty("percent_change_price")
    //@Pattern(regexp = "^-?\\d+(\\.\\d+)?$", message = "percent_change_price is invalid")
    private BigDecimal percent_change_price;
    //@Pattern(regexp = "^-?\\d+(\\.\\d+)?$", message = "percent_change_volume_over_last_week is invalid")
    @JsonProperty("percent_change_volume_over_last_week")
    private BigDecimal percent_change_volume_over_last_week;
    @JsonProperty("previous_weeks_volume")
    //@Pattern(regexp = "^-?\\d+(\\.\\d+)?$", message = "previous_weeks_volume is invalid")
    private BigDecimal previous_weeks_volume;
    @JsonProperty("next_weeks_open")
    //@Pattern(regexp = "^-?\\d+(\\.\\d+)?$", message = "next_weeks_open is invalid")
    private BigDecimal next_weeks_open;
    @JsonProperty("next_weeks_close")
    //@Pattern(regexp = "^-?\\d+(\\.\\d+)?$", message = "percent_change_next_weeks_price is invalid")
    private BigDecimal next_weeks_close;
    @JsonProperty("percent_change_next_weeks_price")
    //@Pattern(regexp = "^-?\\d+(\\.\\d+)?$", message = "percent_change_next_weeks_price is invalid")
    private BigDecimal percent_change_next_weeks_price;
    @JsonProperty("days_to_next_dividend")
    //@Pattern(regexp = "\\d+", message = "percent_return_next_dividend is invalid")
    private Integer days_to_next_dividend;
    @JsonProperty("percent_return_next_dividend")
    //@Pattern(regexp = "^-?\\d+(\\.\\d+)?$", message = "percent_return_next_dividend is invalid")
    private BigDecimal percent_return_next_dividend;

}
