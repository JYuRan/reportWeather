package apple.orange.service;

import java.util.List;
import java.util.Map;

import apple.orange.domain.WeatherRequestDTO;

public interface WeatherService {
	List<WeatherRequestDTO> getArea(Map<String, String> params);
}
