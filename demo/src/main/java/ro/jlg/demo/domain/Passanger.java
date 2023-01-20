package ro.jlg.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@Document
@Getter
public class Passanger {
    @Id
    private String id;
    private String email;
    private String planeId;

    public void update(final String email,final String planeId){
        this.email = email;
        this.planeId = planeId;
    }
}
