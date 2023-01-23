package com.company;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Date;
import java.util.stream.Collectors;

public class Manager {

    private java.util.List<Request> requests;
    private java.util.List<Reservation> reservations;

    public Manager() {
        this.requests = new LinkedList<>();
        this.reservations = new LinkedList<>();
    }

    public Reservation searchReservation() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Podaj kryterium filtrowania\n 0 - po dacie \n 1 - po ID klienta \n 2 - wszystkie rezerwacje");
        int decision = sc.nextInt();

        List<Reservation> temp = new LinkedList<>();
        if(decision == 0) {
            System.out.println("Jaka data cie interesuje? Podaj w formacie YYYY-MM-DD");
            String dataString = sc.nextLine();
            LocalDate filterDate = LocalDate.parse(dataString);
            temp = reservations.stream().filter(res -> res.getReservationDate().equals(filterDate)).collect(Collectors.toList());
        } else if(decision == 1) {
            System.out.println("Podaj ID klienta:");
            int clientId = sc.nextInt();
            temp = reservations.stream().filter(res -> res.getClientID() == clientId).collect(Collectors.toList());
        } else if (decision == 2) {
            temp = reservations;
        }

        int i = 0;
        for (Reservation res : temp) {
            System.out.println("[ "+ i + ". " + res + "]");
            i++;
        }
        System.out.println("Która rezerwacja cie interesuje? Podaj indeks.");
        decision = sc.nextInt();
        return temp.get(decision);
    }

    public Request searchRequest() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Podaj kryterium filtrowania\n 0 - po dacie \n 1 - po ID klienta \n 2 - wszystkie prośby");
        int decision = sc.nextInt();

        List<Request> temp = new LinkedList<>();
        if(decision == 0) {
            System.out.println("Jaka data cie interesuje? Podaj w formacie YYYY-MM-DD");
            String dataString = sc.nextLine();
            LocalDate filterDate = LocalDate.parse(dataString);
            temp = requests.stream().filter(res -> res.getReservationDate().equals(filterDate)).collect(Collectors.toList());
        } else if(decision == 1) {
            System.out.println("Podaj ID klienta:");
            int clientId = sc.nextInt();
            temp = requests.stream().filter(res -> res.getClientID() == clientId).collect(Collectors.toList());
        } else if (decision == 2) {
            temp = requests;
        }

        //System.out.println(temp);
        int i = 0;
        for (Request res : temp) {
            System.out.println("[ "+ i + ". " + res + "]");
            i++;
        }
        System.out.println("Która rezerwacja cie interesuje? Podaj indeks.");
        decision = sc.nextInt();
        return temp.get(decision);
    }

    void confirmRequest() {
        Request base = searchRequest();
        reservations.add(new Reservation(base.getSelectedRooms(), base.getReservationDate(),
                base.getClientID(), base.getGuestsAmount()));
        requests.remove(base);
    }

    void payReservation() {
        Scanner sc = new Scanner(System.in);
        List<Reservation> temp = new LinkedList<>();
        temp = reservations.stream().filter(res -> res.getClientID() == 1).collect(Collectors.toList());
        int i = 0;
        for (Reservation res : temp) {
            System.out.println("[ "+ i + ". " + res + "]");
            i++;
        }
        System.out.println("Ktora rezerwacje chcesz oplacic?");
        int decision = sc.nextInt();
        temp.get(decision).pay();
    }

    void confirmReservation() {
        searchReservation().confirm();
    }

    void cancelReservation() {
        Reservation res = searchReservation();
        reservations.remove(res);
    }

    void cancelRequest(){
        Request req = searchRequest();
        requests.remove(req);
    }

    public void showAll() {
        System.out.println("Requesty: ");
        int i = 0;
        for (Request res : requests) {
            System.out.println("[ "+ i + ". " + res + "]");
            i++;
        }
        System.out.println("Rezerwacje: " );
        i = 0;
        for (Reservation res : reservations) {
            System.out.println("[ "+ i + ". " + res + "]");
            i++;
        }

    }

    void addRequest(List<Room> rooms) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date;
        while (true) {
            System.out.print("Podaj datę w formacie yyyy-MM-dd: ");
            String dateInput = scanner.next();

            try {
                date = LocalDate.parse(dateInput, formatter);
                System.out.println("Data: " + date);
                break;
            } catch (DateTimeParseException e) {
                System.out.println("Niepoprawny format daty, spróbuj ponownie");
            }
        }

        System.out.println("Dla ilu osob chcesz zrobic rezerwacje?");
        int guests = scanner.nextInt();
        requests.add(new Request(rooms, date, 1, guests));
    }

}
