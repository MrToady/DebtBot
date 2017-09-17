package front;

public class Parser {
    public static String[] parsePatricipantsList(String message) {
        return message.substring("/add".length())
                .trim()
                .replaceAll(","," ")
                .split(" +");
    }
}
