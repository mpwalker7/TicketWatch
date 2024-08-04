package org.mpwalker.ticketwatch.bot;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Value;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.updates.SetWebhook;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.starter.SpringWebhookBot;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TelegramBot extends SpringWebhookBot {
    private BotFacade botFacade;

    public TelegramBot(SetWebhook setWebhook, String botToken, BotFacade botFacade) {
       super(setWebhook, botToken);
        this.botFacade = botFacade;
    }

    @Override
    public BotApiMethod<?> onWebhookUpdateReceived(Update update) {
        return botFacade.handleUpdate(update);
    }

    @Override
    public String getBotPath() {
        return "";
    }

    @Override
    public String getBotUsername() {
        return "";
    }
}
