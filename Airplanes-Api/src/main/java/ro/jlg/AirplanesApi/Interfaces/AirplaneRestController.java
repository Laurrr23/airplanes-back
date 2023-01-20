package ro.jlg.AirplanesApi.Interfaces;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.jlg.AirplanesApi.Domain.Airplane;
import ro.jlg.AirplanesApi.application.AirplaneService;
import ro.jlg.AirplanesApi.application.dto.CreateAirplaneDTO;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/airplane")
public class AirplaneRestController {
    private AirplaneService airplaneService;


    @PostMapping

        public ResponseEntity<Void> create (final @RequestBody CreateAirplaneDTO dto){
                this.airplaneService.create(dto);
                return ResponseEntity.ok().build();
        }
        @GetMapping
      public ResponseEntity<List<Airplane>>readAll(){
        return ResponseEntity.ok(this.airplaneService.getAll());
        }
        @DeleteMapping("/{airplaneId}")
    public ResponseEntity<Void>delete(final @PathVariable String airplaneId){
            this.airplaneService.deleteAirplaneById(airplaneId);
            return ResponseEntity.ok().build();
        }

}
