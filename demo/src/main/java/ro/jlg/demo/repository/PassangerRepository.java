package ro.jlg.demo.repository;

import ro.jlg.demo.domain.Airplane;
import ro.jlg.demo.domain.Passanger;

import java.util.List;

public interface PassangerRepository {

    void save(final Passanger passanger);
    List<Passanger>getAll();
    void deleteById(final String passangerId);
    Passanger getById(final String passangerId);
}
