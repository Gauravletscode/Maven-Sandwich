package Repository;

import Models.Sandwich;

import java.util.List;

public interface SandwichRepository {
    List<Sandwich> findAllSandwiches ();

}
