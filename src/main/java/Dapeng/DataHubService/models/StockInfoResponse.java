package Dapeng.DataHubService.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class StockInfoResponse{
    private List<StockInfoModel> list;
}
