package ro.jlg.demo.interfaces;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.jlg.demo.domain.Passanger;
import ro.jlg.demo.dto.CreateAndUpdatePassangerDto;
import ro.jlg.demo.service.PassangerServices;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/passangers")
public class PassangerRestController {
    private PassangerServices services;
    @PostMapping
   public ResponseEntity<Void>create(final @RequestBody CreateAndUpdatePassangerDto dto) throws Exception {
       this.services.create(dto);
      return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Passanger>>readAll(){
        return ResponseEntity.ok(this.services.getAll());
    }

    @PatchMapping("/{passangerId}")

    public ResponseEntity<Void>update(final @PathVariable String passangerId,final @RequestBody CreateAndUpdatePassangerDto dto){
        this.services.update(passangerId,dto);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/{passangerId}")

    public ResponseEntity<Void> delete(final @PathVariable String passangerId){
        this.services.deleteById(passangerId);
        return ResponseEntity.ok().build();
    }
}
