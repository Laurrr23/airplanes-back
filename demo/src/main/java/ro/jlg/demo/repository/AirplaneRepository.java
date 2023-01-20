package ro.jlg.demo.repository;

import ro.jlg.demo.domain.Airplane;

import java.util.List;

public interface AirplaneRepository {

        void save(final Airplane airplane);
        List<Airplane> getAll();
        void deleteById(final String airplaneId);
        Airplane getById(final String airplaneId);

}
