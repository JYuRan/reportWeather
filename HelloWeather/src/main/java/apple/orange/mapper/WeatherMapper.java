package apple.orange.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import apple.orange.domain.WeatherRequestDTO;

@Mapper
public interface WeatherMapper
{
    List<WeatherRequestDTO> selectArea(Map<String, String> params);
}