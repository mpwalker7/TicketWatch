package org.mpwalker.ticketwatch.bot;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BotFacade {
    public BotApiMethod<?> handleUpdate(Update update) {
//        if (update.hasMessage()) {
//            CallbackQuery callbackQuery = update.getCallbackQuery();
//            return null;
//        }
//        else {
            Message message = update.getMessage();
            SendMessage sendMessage = new SendMessage();
            sendMessage.setChatId(String.valueOf(message.getChatId()));
            if(message.hasText()) {
                sendMessage.setText(String.valueOf(message.getText()));
                return sendMessage;
            }
//        }
        return null;
    }
}
