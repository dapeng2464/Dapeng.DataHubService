package Dapeng.DataHubService.controllers;

import Dapeng.DataHubService.models.AddStockRecordRequest;
import Dapeng.DataHubService.models.StockInfoModel;
import Dapeng.DataHubService.models.StockInfoResponse;
import Dapeng.DataHubService.services.IDataHubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("datahub")
public class UploadController {
    @Autowired
    IDataHubService dataHubService;

    @GetMapping("stock")
    public ResponseEntity<StockInfoResponse> getStockInfo(@RequestParam String id){
        List<StockInfoModel> list = dataHubService.getStockInfo(id);
        return ResponseEntity.ok(new StockInfoResponse(list));
    }

    @PostMapping("/upload")
    public ResponseEntity uploadFile(@RequestParam("file") MultipartFile file) {
        try{
            int recordInserted = dataHubService.uploadJsonFile(file);
            return  ResponseEntity.status(HttpStatus.OK).body(String.format("Upload data successfully! Total records inserted: %d.", recordInserted));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(String.format("Could not upload the file: %s!", file.getOriginalFilename()));

        }

    }

    @PostMapping("/add")
    public ResponseEntity addRecord(@Valid @RequestBody AddStockRecordRequest request) {
        try{
            dataHubService.addRecord(request);
            return  ResponseEntity.status(HttpStatus.OK).body("Add record successfully!");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Could not add the record!");

        }

    }
}
