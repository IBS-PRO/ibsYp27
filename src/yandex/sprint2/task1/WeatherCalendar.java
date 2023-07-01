package yandex.sprint2.task1;

class WeatherCalendar {
    String month;
    int numberOfDays;
    int rainyDays;
    int year = 2020;
    boolean isRainyMonth;

    WeatherCalendar (String monthName, int monthNumberOfDays) {
        month = monthName;
        numberOfDays = monthNumberOfDays;
    }

    // Увеличить переменную rainyDays на единицу
    public void addRainyDay() {
        rainyDays = rainyDays + 1;
    }
}