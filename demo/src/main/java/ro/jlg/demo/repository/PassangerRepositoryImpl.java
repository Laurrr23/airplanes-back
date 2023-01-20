package ro.jlg.demo.repository;

import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import ro.jlg.demo.domain.Passanger;

import java.util.List;
@Repository
@AllArgsConstructor
public class PassangerRepositoryImpl implements PassangerRepository{
    private MongoTemplate mongoTemplate;
    @Override
    public void save(final Passanger passanger) {

        this.mongoTemplate.save(passanger);
    }

    @Override
    public List<Passanger> getAll() {
        return this.mongoTemplate.findAll(Passanger.class);
    }

    @Override
    public void deleteById(final String passangerId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(passangerId));
        this.mongoTemplate.remove(query,Passanger.class);

    }

    @Override
    public Passanger getById(final String passangerId) {
        return this.mongoTemplate.findById(passangerId,Passanger.class);
    }
}
