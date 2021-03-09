import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;


//Birthday Syntax = mm/dd/yyyy
public class BirthdayCalc {
    private LocalDate birthday;

    private void setBirthday(LocalDate birthday)
    {
        this.birthday = birthday;
    }

    private DayOfWeek getDayOfWeek()
    {
        return birthday.getDayOfWeek();
    }

    private DayOfWeek getDayOfWeekThisYear()
    {
        LocalDate today = LocalDate.now();
        int year = today.getYear();
        LocalDate next = birthday.withYear(year);
        if (next.isBefore(today))
        {
            next = next.plusYears(1);
        }
        DayOfWeek day = next.getDayOfWeek();
        return day;
    }

    private LocalDate getToday()
    {
        LocalDate today = LocalDate.now();
        return today;
    }

    private long getDaysUntilNext()
    {
        LocalDate today = LocalDate.now();
        int year = today.getYear();
        LocalDate next = birthday.withYear(year);
        if (next.isBefore(today))
        {
            next = next.plusYears(1);
        }
        long days = ChronoUnit.DAYS.between(today, next);
        return days;
    }

    private int getComingAge()
    {
        LocalDate today = LocalDate.now();
        Period period = Period.between(birthday, today);
        return period.getYears()+1;
    }

    public static void main(String[] args)
    {
        System.out.println("What's your birthday?");
        Scanner myScanner = new Scanner(System.in);
        String birthday = myScanner.nextLine();
        String[] temp = birthday.split("/");
        int month = Integer.parseInt(temp[0]);
        int day = Integer.parseInt(temp[1]);
        int year = Integer.parseInt(temp[2]);
        LocalDate bDay =  LocalDate.of(year, month, day);
        BirthdayCalc person = new BirthdayCalc();
        person.setBirthday(bDay);
        System.out.println("This means you were born on a " + person.getDayOfWeek() + "!");
        System.out.println("This year it falls on a " + person.getDayOfWeekThisYear() + "...");
        System.out.println("and since today is " + person.getToday() + ",");
        System.out.println("there's only " + person.getDaysUntilNext() + " more days until the next one when you turn " + person.getComingAge() + "!");
    }

}