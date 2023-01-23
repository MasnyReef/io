package com.company;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
public class App {

    private Manager manager;
    private List<Room> rooms;

    public App() {
        this.rooms = new LinkedList<Room>();
        this.manager = new Manager();
        rooms.add(new Room("Room1", 2, 3, 13, 1300, RoomType.Standard, RoomStatus.Free));
        rooms.add(new Room("Room2", 2, 3, 13, 1300, RoomType.Standard, RoomStatus.Free));
        rooms.add(new Room("Room3", 2, 3, 13, 1300, RoomType.Standard, RoomStatus.Free));
        rooms.add(new Room("Room4", 2, 3, 13, 1300, RoomType.Standard, RoomStatus.Free));
    }

    public void searchRooms() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj minimalną liczbę łóżek pojedynczych: ");
        int minBedsSingle = scanner.nextInt();
        System.out.print("Podaj minimanlą liczbę łóżek podwójnych: ");
        int minBedsDouble = scanner.nextInt();
        System.out.print("Podaj minimalną cenę: ");
        int minPrice = scanner.nextInt();
        System.out.print("Podaj maksymalną cenę: ");
        int maxPrice = scanner.nextInt();
        System.out.print("Podaj typ pokoju: ");
        RoomType type = RoomType.valueOf(scanner.next());
//        System.out.print("Podaj status pokoju: ");
//        RoomStatus status = RoomStatus.valueOf(scanner.next());

        List<Room> filteredRooms = filterRooms(rooms, minBedsSingle, minBedsDouble, minPrice, maxPrice, type);
        int i = 0;
        for (Room room : filteredRooms) {
            System.out.println(i + ". " + room);
            i++;
        }
        System.out.println("Czy chcialbys zarezerwowac ktorys pokoj? \n 0 - nie \n 1-tak\n");
        int decision = scanner.nextInt();
        if (decision == 1) {
            List<Room> selectedRooms = new LinkedList<>();
            while (true) {
                System.out.print("Wybierz pokój (wpisz numer lub wpisz 'koniec' aby zakończyć): ");
                String input = scanner.next();
                if (input.equals("koniec")) {
                    break;
                }
                int index = Integer.parseInt(input);
                if (index < 0 || index >= filteredRooms.size()) {
                    System.out.println("Niepoprawny numer pokoju, spróbuj ponownie");
                    continue;
                }
                if (!selectedRooms.contains(filteredRooms.get(index))) {
                    selectedRooms.add(filteredRooms.get(index));
                } else {
                    System.out.println("Ten pokój już został wybrany wczesniej!");
                }
            }
            manager.addRequest(selectedRooms);
        }

    }

    public List<Room> filterRooms(List<Room> rooms, int minBedsSingle, int minBedsDouble, int minPrice, int maxPrice, RoomType type) {
        return rooms.stream()
                .filter(r -> r.getBedsSingle() >= minBedsSingle)
                .filter(r->r.getBedsTwin() >= minBedsDouble)
                .filter(r -> r.getPrice() >= minPrice && r.getPrice() <= maxPrice)
                //.filter(r -> r.getRoomType() == type)
                .filter(r -> r.getRoomStatus().equals(RoomStatus.Free))
                .collect(Collectors.toList());
    }

    public boolean verifyUser() {
        Scanner sc = new Scanner(System.in);
        String pass;
        while (true){
            System.out.println("Podaj haslo:");
            pass = sc.nextLine();
            if(pass.equals("admin")){
                return true;
            } else if(pass.equals("user")){
                return false;
            }
        }
    }

    public void run() {
        while (true) {
            if (verifyUser()) {
                runAdmin();
            } else {
                runUser();
            }
        }
    }

    private void runAdmin(){
        int decision = -1;
        Scanner scanner = new Scanner(System.in);
        while (decision != 0) {
            System.out.println("Co chcesz zrobic?\n 1 - Nowa Rezerwacja\n 2 - Potwierdz Rezerwacje\n " +
                    "3 - Anuluj Rezerwacje\n 4 - Pokaz wszystko \n 5 - Nowy request\n 0 - Wyjdz");
            decision = scanner.nextInt();
            switch(decision){
                case 0:
                    break;
                case 1:
                    manager.confirmRequest();
                    break;
                case 2:
                    manager.confirmReservation();
                    break;
                case 3:
                    manager.cancelReservation();
                    break;
                case 4:
                    manager.showAll();
                    break;
                case 5:
                    searchRooms();
                    break;
                default:
                    System.out.println("Niewlasciwy wybor, sprobuj ponownie.");
                    break;
            }
        }
    }

    private void runUser(){
        int decision = -1;
        Scanner scanner = new Scanner(System.in);
        while (decision != 3){
            System.out.println("Co chcesz zrobic?\n 1 - Szukaj Pokoj\n 2 - Oplac rezerwacje\n 3- wyjdz");
            decision = scanner.nextInt();
            if(decision == 1) {
                searchRooms();
            } else if (decision == 2) {
                manager.payReservation();
            } else if(decision == 3) {
                return;
            }
        }
    }
}
