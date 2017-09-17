package front;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class MoisiukTestBot extends TelegramLongPollingBot {
    @Override
    public void onUpdateReceived(Update update) {

        // We check if the update has a message and the message has text
        if (update.hasMessage() && update.getMessage().hasText()) {
            String command = update.getMessage().getText();
            long chat_id = update.getMessage().getChatId();

            if (command.startsWith("/start")) {
                sendMessage(Text.WELCOME, chat_id);

            } else if (command.startsWith("/add")) {
                String[] patricipantsList = (Parser.parsePatricipantsList(command));
                if (Objects.equals(patricipantsList[0], "")) {
                    sendMessage(Text.NO_PATRICIPANTS, chat_id);
                    return;
                }
                Set<String> patricipantsSet = new HashSet<>(Arrays.asList(patricipantsList));
                if (patricipantsList.length != patricipantsSet.size()) {
                    sendMessage(Text.NON_UNIQUE_PATRICIPANTS, chat_id);
                    return;
                }
                sendMessage(Text.patricipantsAdded(patricipantsList), chat_id);
            }
        }
    }

    @Override
    public String getBotUsername() {
        return "MoisiukTestBot";
    }

    @Override
    public String getBotToken() {
        return Config.TOKEN;
    }

    private void sendMessage(String messageText, long chat_id) {
        SendMessage message = new SendMessage()
                .setChatId(chat_id)
                .setText(messageText);
        try {
            sendMessage(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
