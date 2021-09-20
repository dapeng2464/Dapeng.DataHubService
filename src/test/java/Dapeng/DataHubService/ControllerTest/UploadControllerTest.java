package Dapeng.DataHubService.ControllerTest;

import Dapeng.DataHubService.entities.DowJonesEntity;
import Dapeng.DataHubService.models.StockInfoModel;
import Dapeng.DataHubService.services.DataHubServiceImp;
import Dapeng.DataHubService.services.IDataHubService;
import Dapeng.DataHubService.utils.CustomException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UploadControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IDataHubService dataHubService;

    @Test
    public void shouldReturnOKWhenUploadIsSuccess() throws Exception {
        String text ="Text to be uploaded.";
        MockMultipartFile file = new MockMultipartFile("file","test.txt", "text/plain", text.getBytes());

        when(dataHubService.uploadJsonFile(file)).thenReturn(1);
        mockMvc.perform(MockMvcRequestBuilders.multipart("/datahub/upload")
                        .file(file)
                        .characterEncoding("UTF-8"))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    public void shouldReturnErrorMessageWhenUploadFailed() throws Exception {
        String text ="Text to be uploaded.";
        MockMultipartFile file = new MockMultipartFile("file","test.txt", "text/plain", text.getBytes());

        when(dataHubService.uploadJsonFile(file)).thenThrow(new CustomException("Load data file failed"));
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.multipart("/datahub/upload")
                        .file(file)
                        .characterEncoding("UTF-8"))
                .andExpect(MockMvcResultMatchers.status().is5xxServerError())
                .andReturn();

    }

    @Test
    public void shouldReturnListByValidStockId() throws Exception {
        String stockId = "AA";
        StockInfoModel model =  new StockInfoModel();
        when(dataHubService.getStockInfo(stockId)).thenReturn(Arrays.asList(model));
        MvcResult result = mockMvc.perform(get("/datahub/stock?id=AA"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

    }
}
