package ro.jlg.demo.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ro.jlg.demo.domain.Airplane;
import ro.jlg.demo.dto.CreateAndUpdateAirplaneDto;
import ro.jlg.demo.repository.AirplaneRepository;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AirplaneServices {

    private AirplaneRepository airplaneRepository;


        public void save(final CreateAndUpdateAirplaneDto dto){
            Airplane airplane = new Airplane(UUID.randomUUID().toString()
                    , dto.getDeparture()
                    , dto.getDestination()
                    , dto.getNoOfSeats());
            this.airplaneRepository.save(airplane);
        }

        public List<Airplane> getAll(){
            return this.airplaneRepository.getAll();
        }

        public void update (final String airplaneId,final CreateAndUpdateAirplaneDto dto){
            Airplane airplaneToUpdate = this.airplaneRepository.getById(airplaneId);
            airplaneToUpdate.update(dto.getDeparture(),dto.getDestination(),dto.getNoOfSeats());
        }

        public void deleteById(final String airplaneId){
            this.airplaneRepository.deleteById(airplaneId);
        }



}
