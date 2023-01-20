package ro.jlg.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@Document
@Getter
public class Airplane {
    @Id
    private String id;
    private String departure;
    private String destination;
    private int noOfSeats;

public void update (final String departure,final String destination,final int noOfSeats){
    this.departure = departure;
    this.destination = destination;
    this.noOfSeats = noOfSeats;
}

public void reserveSeat() throws Exception{
    if (this.noOfSeats < 0 ){
        throw new Exception("Airplane has no empty seats");
    }
    this.noOfSeats --;
}

}
