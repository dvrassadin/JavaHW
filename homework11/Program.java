package homework11;

import homework11.models.TableModel;
import homework11.presenters.BookingPresenter;
import homework11.views.BookingView;

import java.util.Date;

public class Program {

    /**
     * TODO: ДОМАШНЯЯ РАБОТА
     * Метод changeReservationTable должен ЗАРАБОТАТЬ!
     *
     * @param args аргументы командной строки
     */
    public static void main(String[] args) {
        TableModel tableModel = new TableModel();
        BookingView bookingView = new BookingView();
        BookingPresenter bookingPresenter = new BookingPresenter(tableModel, bookingView);
        bookingPresenter.loadTables();
        bookingPresenter.updateView();

        // Добавление бронирований
        bookingView.reservationTable(new Date(), 3, "Станислав");
        bookingView.reservationTable(new Date(), 3, "Daniil");
        bookingView.reservationTable(new Date(), 4, "Daria");
        bookingView.reservationTable(new Date(), 1, "Sveta");
        bookingView.reservationTable(new Date(), 5, "Maria");
        bookingView.reservationTable(new Date(), 6, "Petya");
        bookingView.reservationTable(new Date(), 1, "Aida");
        bookingPresenter.updateReservationsView();

        // Изменения и одна отмена бронирования
        bookingView.changeReservationTable(1001, new Date(), 2, "Станислав");
        bookingView.changeReservationTable(1004, new Date(), 4, "Sveta");
        bookingView.removeReservation(1006);
        bookingPresenter.updateReservationsView();
    }

}
