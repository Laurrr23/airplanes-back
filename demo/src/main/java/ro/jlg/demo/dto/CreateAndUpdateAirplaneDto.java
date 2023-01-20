package ro.jlg.demo.dto;

import lombok.Getter;

@Getter
public class CreateAndUpdateAirplaneDto {

    private String departure;
    private String destination;
    private int noOfSeats;
}
