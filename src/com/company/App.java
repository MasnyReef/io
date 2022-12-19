package com.company;

import java.util.LinkedList;

public class App {

    private Manager manager;
    private java.util.List<Room> rooms;

    public App() {
        this.rooms = new LinkedList<Room>();
        rooms.add(new Room("Room1", 2, 3, 13, 1300, RoomType.Standard, RoomStatus.Free));
    }

    public void searchRooms() {
        // TODO - implement App.searchRooms
        throw new UnsupportedOperationException();
    }

    public void verifyUser() {
        // TODO - implement App.verifyUser
        throw new UnsupportedOperationException();
    }

    public void run() {
        // TODO - implement App.run
        throw new UnsupportedOperationException();
    }

}
