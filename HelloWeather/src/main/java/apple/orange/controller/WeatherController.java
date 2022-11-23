package apple.orange.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import apple.orange.domain.WeatherRequestDTO;
import apple.orange.service.WeatherServiceImpl;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/board")
@Slf4j
public class WeatherController {
    @Autowired
    private WeatherServiceImpl weatherService;

    @GetMapping(value = "/weather.do")
    public String openWeatherPage()
    {
    	log.info("/weather.do 요청중...");
        return "/weather/weather";
    }
    
    @PostMapping(value = "/weatherStep.do")
    @ResponseBody
    public List<WeatherRequestDTO> getAreaStep(@RequestParam Map<String, String> params)
    {
    	log.info(params.toString());
        return this.weatherService.getArea(params);
    }
}
