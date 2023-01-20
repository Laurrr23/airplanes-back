package ro.jlg.AirplanesApi.Domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
@Getter
@AllArgsConstructor
@Document
public class Airplane {
        @Id
        private String Id;
        private String departure;
        private String destination;
        private LocalDateTime departureTime;
        private int numberOfSeats;
}
