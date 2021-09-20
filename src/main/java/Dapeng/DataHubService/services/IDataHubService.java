package Dapeng.DataHubService.services;

import Dapeng.DataHubService.models.AddStockRecordRequest;
import Dapeng.DataHubService.models.StockInfoModel;
import Dapeng.DataHubService.models.StockInfoResponse;
import Dapeng.DataHubService.utils.CustomException;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IDataHubService {
    List<StockInfoModel> getStockInfo(String stock);
    int uploadJsonFile(MultipartFile file) throws CustomException;
    void addRecord(AddStockRecordRequest request);
}
