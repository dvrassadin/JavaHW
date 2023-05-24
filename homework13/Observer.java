package homework13;

import java.util.HashSet;

/**
 * Интерфейс наблюдателя (соискателя, человек в поисках работы)
 */
public interface Observer {

    boolean receiveOffer(Vacancy vacancy);

    void addPositions(Position... positions);

    HashSet<Position> getPositions();

}
