package ro.jlg.AirplanesApi.Infrastructure;

import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import ro.jlg.AirplanesApi.Domain.Airplane;
import ro.jlg.AirplanesApi.Domain.AirplaneRepository;

import java.util.List;

@Repository
@AllArgsConstructor
public class AirplaneRepositoryImpl implements AirplaneRepository {
    private MongoTemplate mongoTemplate;

    @Override
    public void save(final Airplane airplane) {
        this.mongoTemplate.save(airplane);

    }

    @Override
    public void remove(final    String airplaneId) {
        final Query query = new Query();
            query.addCriteria(Criteria.where("_id").is(airplaneId));
        this.mongoTemplate.remove(query,Airplane.class);

    }

    @Override
    public List<Airplane> getAll() {

        return this.mongoTemplate.findAll(Airplane.class);
    }
    @Override
    public Airplane getById(final String airplaneId){
        return this.mongoTemplate.findById(airplaneId,Airplane.class);

    }
}
