package org.example;
import java.util.HashMap;
import java.util.Map;

class InvalidInnDataException extends Exception {
    public InvalidInnDataException(String message) {
        super(message);
    }
}

class InnNotFoundException extends Exception {
    public InnNotFoundException(String message) {
        super(message);
    }
}

class BookingException extends Exception {
    public BookingException(String message) {
        super(message);
    }
}

class Inn {
    private String name;
    private String location;
    private int rooms;
    private double pricePerNight;
    private double rating;

    private Map<String, Integer> bookings;

    public Inn(String name, String location, int rooms, double pricePerNight, double rating) throws InvalidInnDataException {
        if (name == null || name.isEmpty() || location == null || location.isEmpty()) {
            throw new InvalidInnDataException("Название и расположение гостиницы не могут быть пустыми!");
        }
        if (rooms <= 0) {
            throw new InvalidInnDataException("Количество комнат должно быть больше 0! Передано: " + rooms);
        }
        if (pricePerNight <= 0) {
            throw new InvalidInnDataException("Цена за ночь должна быть больше 0! Передано: " + pricePerNight);
        }
        if (rating < 1.0 || rating > 5.0) {
            throw new InvalidInnDataException("Рейтинг должен быть в диапазоне от 1 до 5! Передано: " + rating);
        }

        this.name = name;
        this.location = location;
        this.rooms = rooms;
        this.pricePerNight = pricePerNight;
        this.rating = rating;
        this.bookings = new HashMap<>();
    }

    public void bookRoom(String guest, int nights) throws BookingException, InvalidInnDataException {
        if (guest == null || guest.isEmpty()) {
            throw new InvalidInnDataException("Имя гостя не может быть пустым!");
        }
        if (nights <= 0) {
            throw new InvalidInnDataException("Количество ночей должно быть больше 0!");
        }

        int occupiedRooms = bookings.size();
        if (occupiedRooms >= rooms) {
            throw new BookingException("В гостинице \"" + name + "\" нет свободных комнат!");
        }
        if (bookings.containsKey(guest)) {
            throw new BookingException("Гость " + guest + " уже имеет активное бронирование в этой гостинице.");
        }

        bookings.put(guest, nights);
        System.out.println("Успешно забронирован номер для гостя: " + guest + " на " + nights + " ноч.(ей).");
    }

    public void checkOut(String guest) throws InnNotFoundException {
        if (guest == null || !bookings.containsKey(guest)) {
            throw new InnNotFoundException("Гость \"" + guest + "\" не найден среди активных бронирований гостиницы \"" + name + "\".");
        }

        bookings.remove(guest);
        System.out.println("Гость " + guest + " успешно выселен из гостиницы " + name + ".");
    }

    public String getName() { return name; }
    public int getAvailableRooms() { return rooms - bookings.size(); }
}

public class Main {
    public static void main(String[] args) {
        try {
            Inn hotel = new Inn("Уют", "Минск", 2, 100.0, 4.5);
            System.out.println("Гостиница \"" + hotel.getName() + "\" успешно создана.");

            hotel.bookRoom("Алексей", 3);
            hotel.bookRoom("Мария", 5);

            System.out.println("\nПопытка забронировать третью комнату (превышение лимита):");
            hotel.bookRoom("Иван", 2);

        } catch (InvalidInnDataException e) {
            System.out.println("Ошибка в данных гостиницы: " + e.getMessage());
        } catch (BookingException e) {
            System.out.println("Ошибка бронирования: " + e.getMessage());
        }

        try {
            System.out.println("Попытка создать гостиницу с неверной ценой (-50.0):");
            Inn badHotel = new Inn("Плохая", "Брест", 10, -50.0, 4.0);
        } catch (InvalidInnDataException e) {
            System.out.println("ПЕРЕХВАЧЕНО ИСКЛЮЧЕНИЕ В КОНСТРУКТОРЕ " + e.getMessage());
        }

        try {
            Inn resort = new Inn("Курорт", "Сочи", 5, 200.0, 4.8);
            resort.checkOut("НеизвестныйГость");
        } catch (InvalidInnDataException e) {
            System.out.println("Ошибка данных: " + e.getMessage());
        } catch (InnNotFoundException e) {
            System.out.println("ПЕРЕХВАЧЕНО ИСКЛЮЧЕНИЕ: " + e.getMessage());
        }
    }
}