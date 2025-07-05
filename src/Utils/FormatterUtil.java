package Utils;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class FormatterUtil {
    public static String formatMoney(double amount) {
        return (amount == (int) amount) ?
                String.format("%d EGP", (int) amount) :
                String.format("%.2f EGP", amount);
    }

    public static String formatWeight(double weight) {
        return (weight < 1.0) ?
                String.format("%.0f g", weight * 1000) :
                String.format("%.1f kg", weight);
    }

    public static String formatDateTimeNow() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.now().format(formatter);
    }
}
