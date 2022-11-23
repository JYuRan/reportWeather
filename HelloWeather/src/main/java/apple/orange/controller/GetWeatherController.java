package apple.orange.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

@RestController
@RequestMapping("/weather")

public class GetWeatherController {
	
    GetWeatherController(){

    }
    @GetMapping("/getWeather")
    public String weather() throws IOException {
        String apiUrl = "http://apis.data.go.kr/1360000/TourStnInfoService/getCityTourClmIdx";

        String serviceKey = "VzLx16bEJbtZqnX2mz8R2EnEhhmymczgmq90LrKvGvWD0x%2Bd1ywdk%2B2XmChB%2BOagswKBdPyq7DFEzhFMw2tw%2Fg%3D%3D";
        String pageNo = "1";	//페이지 번호
        String numOfRows = "10";	//한 페이지 결과 수
        String dataType = "JSON";	//데이터 타입
        String currentDate = "20221121";	//조회하고싶은 날짜
        String day = "6";	//조회하고 싶은 날짜의 시간 날짜
        String cityAreaId = "2632000000";	//관광 코스ID


        StringBuilder urlBuilder = new StringBuilder(apiUrl);
        urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "="+serviceKey);
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode(pageNo, "UTF-8"));
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode(numOfRows, "UTF-8"));
        urlBuilder.append("&" + URLEncoder.encode("dataType","UTF-8") + "=" + URLEncoder.encode(dataType, "UTF-8"));
        urlBuilder.append("&" + URLEncoder.encode("currentDate","UTF-8") + "=" + URLEncoder.encode(currentDate, "UTF-8"));
        urlBuilder.append("&" + URLEncoder.encode("day","UTF-8") + "=" + URLEncoder.encode(day, "UTF-8"));
        urlBuilder.append("&" + URLEncoder.encode("cityAreaId","UTF-8") + "=" + URLEncoder.encode(cityAreaId, "UTF-8"));

        /*
         * GET방식으로 전송해서 파라미터 받아오기
         */
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        String result= sb.toString();
        System.out.println(result);

    return result;
    }
}