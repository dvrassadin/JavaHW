package homework11.presenters;

import homework11.models.Table;

import java.util.Collection;
import java.util.Date;

public class BookingPresenter implements ViewObserver {

    private final Model model;
    private final View view;
    private Collection<Table> tables;

    public BookingPresenter(Model model, View view) {
        this.model = model;
        this.view = view;
        this.view.setObserver(this);
    }

    /**
     * Загрузить список всех столиков
     */
    public void loadTables() {
        if (tables == null) {
            tables = model.loadTables();
        }
    }

    /**
     * Отобразить список столиков
     */
    public void updateView() {
        view.showTables(tables);
    }

    public void updateReservationsView() {
        this.view.showAllReservations(tables);
    }

    /**
     * Отобразить результат бронирования столика
     * 
     * @param reservationNo номер брони
     */
    private void updateReservationStatusView(int reservationNo) {
        view.showReservationStatus(reservationNo);
    }

    /**
     * Получили уведомление о попытке бронирования столика
     * 
     * @param orderDate дата бронирования
     * @param tableNo   номер столика
     * @param name      имя клиента
     */
    @Override
    public void onReservationTable(Date orderDate, int tableNo, String name) {
        int reservationNo = model.reservationTable(orderDate, tableNo, name);
        updateReservationStatusView(reservationNo);
    }

    @Override
    public void onChangeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name) {
        int newReservationNo = this.model.changeReservationTable(oldReservation, reservationDate, tableNo, name);
        updateReservationStatusView(newReservationNo);
    }

    @Override
    public void onRemoveReservation(int oldReservation) {
        this.view.showRemovalResult(this.model.removeReservation(oldReservation));
    }
}
