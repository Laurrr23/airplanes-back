package ro.jlg.AirplanesApi.application.dto;

import lombok.Getter;


@Getter
public class CreateAirplaneDTO {
    private String departure;
    private String destination;
    private String departureTime;
    private int numberOfSeats;
}
