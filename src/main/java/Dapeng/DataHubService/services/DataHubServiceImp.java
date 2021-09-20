package Dapeng.DataHubService.services;

import Dapeng.DataHubService.entities.DowJonesEntity;
import Dapeng.DataHubService.models.AddStockRecordRequest;
import Dapeng.DataHubService.models.StockInfoModel;
import Dapeng.DataHubService.repositories.DataHubRepository;
import Dapeng.DataHubService.utils.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class DataHubServiceImp implements IDataHubService{
    @Autowired
    DataHubRepository dataHubRepository;


    @Override
    public List<StockInfoModel> getStockInfo(String stock) {

        List<DowJonesEntity> entities = dataHubRepository.findByStock(stock);
        List<StockInfoModel> list = new ArrayList<>();
        for(DowJonesEntity entity : entities){
            list.add(new StockInfoModel(entity));
        }
        return list;
    }

    @Override
    public int uploadJsonFile(MultipartFile multipartFile) throws CustomException {
        int recordInserted = 0;
        try {
            InputStream inputStream = multipartFile.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line = reader.readLine();
            while (reader.ready()) {
                line = reader.readLine().replace("$","");
                String lineArray[] = line.split(",");
                try{
                    if(lineArray.length == 16){
                        // data format correct, convert it to an entity and save to db
                        DowJonesEntity entity = new DowJonesEntity(
                                Integer.parseInt(lineArray[0]),
                                lineArray[1],
                                new SimpleDateFormat("dd/mm/yyyy").parse(lineArray[2]),
                                toBigDecimal(lineArray[3]),
                                toBigDecimal(lineArray[4]),
                                toBigDecimal(lineArray[5]),
                                toBigDecimal(lineArray[6]),
                                toBigDecimal(lineArray[7]),
                                toBigDecimal(lineArray[8]),
                                toBigDecimal(lineArray[9]),
                                toBigDecimal(lineArray[10]),
                                toBigDecimal(lineArray[11]),
                                toBigDecimal(lineArray[12]),
                                toBigDecimal(lineArray[13]),
                                Integer.parseInt(lineArray[14]),
                                toBigDecimal(lineArray[15])
                        );
                        dataHubRepository.save(entity);
                        recordInserted ++;
                    }else{
                    // Todo: data format error, save current record to a log file
                    }
                }catch ( ParseException pe) {
                    System.out.println(pe.getMessage());
                    // Todo: data format error, save current record to a log file
                }catch (Exception ex){
                    System.out.println(ex.getMessage());
                    // Todo: data format error, save current record to a log file
                }
            }


        } catch (IOException e) {
            throw new CustomException("Load data file failed");
        }
        return recordInserted;
    }

    @Override
    public void addRecord(AddStockRecordRequest request) {
        DowJonesEntity entity = new DowJonesEntity(
                request.getQuarter(),
                request.getStock(),
                request.getDate(),
                request.getOpen(),
                request.getHigh(),
                request.getLow(),
                request.getClose(),
                request.getVolume(),
                request.getPercent_change_price(),
                request.getPercent_change_volume_over_last_week(),
                request.getPrevious_weeks_volume(),
                request.getNext_weeks_open(),
                request.getNext_weeks_close(),
                request.getPercent_change_next_weeks_price(),
                request.getDays_to_next_dividend(),
                request.getPercent_return_next_dividend()
        );
        dataHubRepository.save(entity);
    }


    private BigDecimal toBigDecimal(String str) throws ParseException {
        if(str == null || str.trim().equals(""))
            return null;//new BigDecimal(0);
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        //symbols.setGroupingSeparator(',');
        symbols.setDecimalSeparator('.');
        String pattern = "#0.0#";
        DecimalFormat decimalFormat = new DecimalFormat(pattern, symbols);
        decimalFormat.setParseBigDecimal(true);

        return (BigDecimal) decimalFormat.parse(str);
    }
}
