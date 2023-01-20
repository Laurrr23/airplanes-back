package ro.jlg.demo.service;

import ro.jlg.demo.domain.Airplane;
import ro.jlg.demo.domain.Passanger;
import ro.jlg.demo.dto.CreateAndUpdatePassangerDto;
import ro.jlg.demo.repository.AirplaneRepository;
import ro.jlg.demo.repository.PassangerRepository;

import java.util.List;
import java.util.UUID;

public class PassangerServices {
    private AirplaneRepository airplaneRepository;

    private PassangerRepository repository;

    public void create(final CreateAndUpdatePassangerDto dto) throws Exception {
        final Airplane passangerInAriplane = this.airplaneRepository.getById(dto.getPlaneId());
        passangerInAriplane.reserveSeat();
       final Passanger passanger = new Passanger(UUID.randomUUID().toString(), dto.getEmail(), dto.getPlaneId() );
       this.repository.save(passanger);
       this.airplaneRepository.save(passangerInAriplane);
    }

    public List<Passanger> getAll(){
        return this.repository.getAll();
    }
    public void deleteById(final String passangerId){
        this.repository.deleteById(passangerId);
    }

    public void update(final String passangerId,final CreateAndUpdatePassangerDto dto){
        final Passanger passangerToUpdate = this.repository.getById(passangerId);
        passangerToUpdate.update(dto.getEmail(),dto.getPlaneId());
        this.repository.save(passangerToUpdate);

    }
}
