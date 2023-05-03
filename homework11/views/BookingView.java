package homework11.views;

import homework11.models.Reservation;
import homework11.models.Table;
import homework11.presenters.View;
import homework11.presenters.ViewObserver;

import java.util.Collection;
import java.util.Date;

public class BookingView implements View {

    private ViewObserver observer;

    /**
     * Отобразить список столиков
     * 
     * @param tables список столиков
     */
    public void showTables(Collection<Table> tables) {
        for (Table table : tables) {
            System.out.println(table);
        }
    }

    /**
     * Отобразить результат бронирования
     * 
     * @param reservationNo номер брони
     */
    @Override
    public void showReservationStatus(int reservationNo) {
        if (reservationNo > 0) {
            System.out.printf("Столик успешно забронирован. Номер брони: #%d\n", reservationNo);
        } else {
            System.out.println("Ошибка бронирования столика.");
        }
    }

    /**
     * Установить наблюдателя
     * 
     * @param observer наблюдатель (презентер)
     */
    @Override
    public void setObserver(ViewObserver observer) {
        this.observer = observer;
    }

    /**
     * Действие клиента (пользователь нажал на кнопку бронирования),
     * бронирование столика
     * 
     * @param date    дата бронирования
     * @param tableNo номер столика
     * @param name    имя клиента
     */
    public void reservationTable(Date date, int tableNo, String name) {
        observer.onReservationTable(date, tableNo, name);
    }

    /**
     * Действие клиента (пользователь нажал на кнопку бронирования), бронирование
     * столика
     * 
     * @param oldReservation  идентификатор бронирования (старый)
     * @param reservationDate дата бронирования
     * @param tableNo         номер столика
     * @param name            Имя
     */
    public void changeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name) {
        observer.onChangeReservationTable(oldReservation, reservationDate, tableNo, name);
    }

    @Override
    public void removeReservation(int oldReservation) {
        observer.onRemoveReservation(oldReservation);
    }

    @Override
    public void showRemovalResult(boolean result) {
        if (result)
            System.out.println("Бронь была отменена.");
        else
            System.out.println("Бронь не найдена.");
    }

    @Override
    public void showAllReservations(Collection<Table> tables) {
        for (Table table : tables)
            for (Reservation reservation : table.getReservations())
                System.out.printf("%s, %s\n", table, reservation);
    }

}
