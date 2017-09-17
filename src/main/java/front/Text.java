package front;

public class Text {
    public static final String WELCOME = "Welcome message. Тут будет написано про HELP и список команд";
    public static final String PATRICIPANTS_ADDED = "В сессию были добавлены следующие участники:\n";
    public static final String NO_PATRICIPANTS = "введите имя хотя бы одного участника";
    public static final String NON_UNIQUE_PATRICIPANTS = "не уникальные";

    public static String patricipantsAdded(String[] participantsArray){
        StringBuilder builder = new StringBuilder(PATRICIPANTS_ADDED);
        for (String patricipant :
                participantsArray) {
            builder.append(patricipant).append("\n");
        }
        return builder.toString();
    }
}
