package com.company;

public class Reservation extends Request{

    private boolean isConfirmed;
    private boolean isPaid;
    private float advance;

    public void confirm() {
        // TODO - implement Reservation.confirm
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param selectedRooms
     * @param reservationDate
     * @param clientID
     * @param guestsAmount
     */
    public Reservation(java.util.List<Room> selectedRooms, java.util.Date reservationDate, int clientID, int guestsAmount) {
        super(selectedRooms, reservationDate, clientID, guestsAmount);
        this.isConfirmed = false;
        this.isPaid = false;
        //ToDo zaliczka
    }

//    public Reservation(Request request) {
//        return;
//    }


}
