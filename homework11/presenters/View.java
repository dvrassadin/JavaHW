package homework11.presenters;

import homework11.models.Table;
import java.util.Collection;

public interface View {

    /**
     * Отобразить список всех столиков
     * 
     * @param tables список столиков
     */
    void showTables(Collection<Table> tables);

    void showReservationStatus(int reservationNo);

    /**
     * Установить нового наблюдателя
     * 
     * @param observer наблюдатель (презентер)
     */
    void setObserver(ViewObserver observer);

    /**
     * Отмена бронирования.
     * 
     * @param oldReservation номер бронирования для отмены
     */
    void removeReservation(int oldReservation);

    void showRemovalResult(boolean result);

    /**
     * Отображает список всех бронирований.
     * 
     * @param tables список столиков
     */
    void showAllReservations(Collection<Table> tables);

}
