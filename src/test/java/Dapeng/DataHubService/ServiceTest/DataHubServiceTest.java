package Dapeng.DataHubService.ServiceTest;

import Dapeng.DataHubService.repositories.DataHubRepository;
import Dapeng.DataHubService.services.IDataHubService;
import Dapeng.DataHubService.utils.CustomException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DataHubServiceTest {
    @MockBean
    DataHubRepository dataHubRepository;
    @Autowired
    IDataHubService dataHubService;

    @Test
    public void shouldReturnCountOfRecordWhenUploadSuccess(){
        String text ="quarter,stock,date,open,high,low,close,volume,percent_change_price,percent_change_volume_over_last_wk,previous_weeks_volume,next_weeks_open,next_weeks_close,percent_change_next_weeks_price,days_to_next_dividend,percent_return_next_dividend\n" +
                "1,AA,1/7/2011,$15.82,$16.72,$15.78,$16.42,239655616,3.79267,,,$16.71,$15.97,-4.42849,26,0.182704\n" +
                "1,AA,1/14/2011,$16.71,$16.71,$15.64,$15.97,242963398,-4.42849,1.380223028,239655616,$16.19,$15.79,-2.47066,19,0.187852\n" +
                "1,AA,1/21/2011,$16.19,$16.38,$15.60,$15.79,138428495,-2.47066,-43.02495926,242963398,$15.87,$16.13,1.63831,12,0.189994\n" +
                "1,AA,1/28/2011,$15.87,$16.63,$15.82,$16.13,151379173,1.63831,9.355500109,138428495,$16.18,$17.14,5.93325,5,0.185989";
        int expected = 4;
        MockMultipartFile file = new MockMultipartFile("file","test.txt", "text/plain", text.getBytes());

        try {
            int actual = dataHubService.uploadJsonFile(file);
            assertThat(actual).isEqualTo(expected);
        } catch (CustomException e) {
            assertThat(true).isFalse();
        }

    }
}
