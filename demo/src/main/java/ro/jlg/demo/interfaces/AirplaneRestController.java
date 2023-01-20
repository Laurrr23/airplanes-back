package ro.jlg.demo.interfaces;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.jlg.demo.domain.Airplane;
import ro.jlg.demo.dto.CreateAndUpdateAirplaneDto;
import ro.jlg.demo.service.AirplaneServices;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/airplanes")
public class AirplaneRestController {
    private AirplaneServices services;
    @PutMapping
    public ResponseEntity<Void> create(final @RequestBody CreateAndUpdateAirplaneDto dto) {
        this.services.save(dto);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Airplane>> getAll() {
        return ResponseEntity.ok(this.services.getAll());
    }

    @PatchMapping("/{airplaneId}")
    public ResponseEntity<Void> edit(final @PathVariable String airplaneId, final @RequestBody CreateAndUpdateAirplaneDto dto) {
        this.services.update(airplaneId, dto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{airplaneId}")
    public ResponseEntity<Void>delete(final @PathVariable String airplaneId){
        this.services.deleteById(airplaneId);
        return ResponseEntity.ok().build();
    }
}
