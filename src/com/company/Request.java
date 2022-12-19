package com.company;

public class Request{

    protected java.util.List<Room> selectedRooms;
    protected java.util.Date reservationDate;
    protected int clientID;
    protected int guestsAmount;

    /**
     *
     * @param selectedRooms
     * @param reservationDate
     * @param clientID
     * @param guestsAmount
     */
    public Request(java.util.List<Room> selectedRooms, java.util.Date reservationDate, int clientID, int guestsAmount) {

        this.selectedRooms = selectedRooms;
        this.reservationDate = reservationDate;
        this.clientID = clientID;
        this.guestsAmount = guestsAmount;
    }

    public void cancel() {
        // TODO - implement Manager.searchRequest
        throw new UnsupportedOperationException();
    }

}
