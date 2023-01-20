package ro.jlg.AirplanesApi.application;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ro.jlg.AirplanesApi.Domain.Airplane;
import ro.jlg.AirplanesApi.Domain.AirplaneRepository;
import ro.jlg.AirplanesApi.application.dto.CreateAirplaneDTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AirplaneService {
private AirplaneRepository airplaneRepository;

public void create (final CreateAirplaneDTO dto  ){
final Airplane airplane = new Airplane(UUID.randomUUID().toString(),
        dto.getDeparture(),
        dto.getDestination(),
        LocalDateTime.parse(dto.getDepartureTime()),
        dto.getNumberOfSeats());
this.airplaneRepository.save(airplane);
}
public List<Airplane>getAll(){
    return this.airplaneRepository.getAll();

}
public void deleteAirplaneById(final String airplaneId){
    this.airplaneRepository.remove(airplaneId);
}


}
