package apple.orange.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@Table(name = "wrather")
public class WeatherRequestDTO {
	// 행정구역코드
	private String totalCityName;

	// 시도
	private String doName;

	// 시군구
	private String cityName;

	// 읍면동
	private String cityAreaId;

	// 발표 일자
	private String kmaTci;

	// 발표 시각
	private String TCI_GRADE;

}