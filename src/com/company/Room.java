package com.company;

public class Room {

    private String name;
    private int bedsTwin;
    private int bedsSingle;
    private int maxGuests;
    private int price;
    private RoomType type;
    private RoomStatus status;

    /**
     *
     * @param name
     * @param bedsTwin
     * @param bedsSingle
     * @param maxGuests
     * @param price
     * @param type
     * @param status
     */
    public Room(String name, int bedsTwin, int bedsSingle, int maxGuests, int price, RoomType type, RoomStatus status) {
        this.name = name;
        this.bedsSingle = bedsSingle;
        this.bedsTwin = bedsTwin;
        this.maxGuests = maxGuests;
        this.price = price;
        this.type = type;
        this.status = status;
    }

    public String getName() {
        return this.name;
    }

    public int getBedsSingle() {
        return this.bedsSingle;
    }

    public int getBedsTwin() {
        return this.bedsTwin;
    }

    public int getPrice() {
        return this.price;
    }

    public RoomType getRoomType() {
        return this.type;
    }

    public RoomStatus getRoomStatus() {
        return this.status;
    }
}
