package org.example.sport.idongjak.domain.home;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.example.sport.idongjak.integration.center.HolidayInformation;

public class HomeBoard {

    private final HolidayInformation holidayInformation;


    List<Map<String, Object>> notice_array = null;

    public HomeBoard(HolidayInformation holidayInformation) {
        assert holidayInformation != null;
        this.holidayInformation = holidayInformation;
    }

    public void init(){
        notice_array = new ArrayList<>();
        Map<String, Object> notice = new HashMap<String, Object>();

        notice.put("id", "3");
        notice.put("title","인터넷/모바일 수강신청 안내.");
        notice.put("date", "2023-01-15");
        notice.put("priority",2);
        notice_array.add(notice);

        notice.put("id", "1");
        notice.put("title","2023년 1월 수강신청 안내.");
        notice.put("date", "2022-12-15");
        notice.put("priority",2);
        notice_array.add(notice);

        notice.put("id", "2");
        notice.put("title","2023년 2월 수강신청 안내.");
        notice.put("date", "2023-01-15");
        notice.put("priority",2);
        notice_array.add(notice);

    }

    public Map<String, Object> getImageList(){
        Map<String, Object> data = new HashMap<String, Object>();

        // 1. Image List
        // 2. Notice List
        Map<String, Object> notice = new HashMap<String, Object>();

        return data;
    }

    public List<Map<String, Object>> getNoticeList(){
        return notice_array;
    }

    public List<Map<String, Object>> getHoliday(long number){

        List<Map<String, Object>> list_data = holidayInformation.execute(number);

        holidayInformation.voidMethod();

        return list_data;
    }


}
