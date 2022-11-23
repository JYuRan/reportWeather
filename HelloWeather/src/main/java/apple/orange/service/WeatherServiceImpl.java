package apple.orange.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import apple.orange.domain.WeatherRequestDTO;
import apple.orange.mapper.WeatherMapper;

@Service
public class WeatherServiceImpl implements WeatherService
{
    @Autowired
    private WeatherMapper weatherMapper;

    @Override
    public List<WeatherRequestDTO> getArea(Map<String, String> params)
    {
        return this.weatherMapper.selectArea(params);
    }
}
