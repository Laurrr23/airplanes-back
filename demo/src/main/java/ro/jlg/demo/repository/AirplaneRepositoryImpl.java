package ro.jlg.demo.repository;

import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import ro.jlg.demo.domain.Airplane;

import java.util.List;
@Repository
@AllArgsConstructor
public class AirplaneRepositoryImpl implements AirplaneRepository{
    private MongoTemplate mongoTemplate;
    @Override
    public void save(final Airplane airplane) {
        this.mongoTemplate.save(airplane);

    }

    @Override
    public List<Airplane> getAll() {
        return this.mongoTemplate.findAll(Airplane.class);
    }

    @Override
    public void deleteById(final String airplaneId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(airplaneId));
        this.mongoTemplate.remove(query,Airplane.class);

    }

    @Override
    public Airplane getById(final String airplaneId) {
        return this.mongoTemplate.findById(airplaneId,Airplane.class);
    }
}
