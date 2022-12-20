package unit;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.example.sport.idongjak.domain.home.HomeBoard;
import org.example.sport.idongjak.integration.center.HolidayInformation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class HomeBoardTest {

    @Test
    void service(){
        HolidayInformation holidayInformation = null;
        HomeBoard homeBoard = new HomeBoard(holidayInformation);
    }

    // Mock 객체 생성
    @Test
    void service_mock(){
        // HolidayInformation holidayInformation = null;
        HolidayInformation holidayInformation = mock(HolidayInformation.class);
        HomeBoard homeBoard = new HomeBoard(holidayInformation);
    }

    // Mock Annotation을 사용하려면 Extention 필요
    @Mock
    HolidayInformation mock;

    @Test
    void service_mock2(){
        // HolidayInformation holidayInformation = null;
        // HolidayInformation holidayInformation = mock(HolidayInformation.class);
        HomeBoard homeBoard = new HomeBoard(mock);
    }

    // 변수에 사용
    @Test
    void service_mock3(@Mock HolidayInformation holidayInformation){
        // HolidayInformation holidayInformation = null;
        // HolidayInformation holidayInformation = mock(HolidayInformation.class);
        HomeBoard homeBoard = new HomeBoard(holidayInformation);
    }

    //-------------------------------------------
    // Mock 객체 실행은 하였지만 Null 출력
    @Test
    void service_stubbing(){
        HomeBoard homeBoard = new HomeBoard(mock);
        List<Map<String, Object>> holiday = homeBoard.getHoliday(1L);

        // 아무런 일도 일어나지않고 Null로 출력
        System.out.println(holiday);

    }

    // Argument 값에 맞는 상태가 되면 원하는 객체를 받을 수 있다.
    @Test
    void service_stubbing2(){
        HomeBoard homeBoard = new HomeBoard(mock);

        List<Map<String, Object>> data_array = new ArrayList<>();
        Map<String, Object> data = new HashMap<>();
        data.put("date","20230101");
        data.put("holiday_name","NEW YEARS DAY");
        data_array.add(data);

        // Parameter 가 있으면 Parameter Value도 맞춰줘야 한다.
        // Argument Matcher 를 보고 구현하면 된다.
        when(mock.execute(1L)).thenReturn(data_array);

        List<Map<String, Object>> holiday = homeBoard.getHoliday(1L);
        System.out.println(holiday);

    }

    @Test
    void service_stubbing3(){
        HomeBoard homeBoard = new HomeBoard(mock);

        // return 이 있는 method
        when(mock.execute(1L)).thenThrow(new RuntimeException("그냥오류"));
        assertThrows(RuntimeException.class, () -> {
            List<Map<String, Object>> holiday = homeBoard.getHoliday(1L);
            System.out.println(holiday);
        });

        // Argument Matcher 를 보고 구현하면 된다.
        doThrow(new RuntimeException("Void Method 그냥오류")).when(mock).voidMethod();
        assertThrows(RuntimeException.class, () -> {
            List<Map<String, Object>> holiday = homeBoard.getHoliday(2L);
            System.out.println(holiday);
        });



    }


}
