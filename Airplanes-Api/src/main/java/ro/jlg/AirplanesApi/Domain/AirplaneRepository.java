package ro.jlg.AirplanesApi.Domain;

import java.util.List;

public interface AirplaneRepository {
void save(final Airplane airplane);
void remove (final String airplaneId);

List<Airplane>getAll();
Airplane getById(final String airplaneId);

}
