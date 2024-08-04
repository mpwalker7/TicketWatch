package org.mpwalker.ticketwatch.config;

import org.mpwalker.ticketwatch.bot.BotFacade;
import org.mpwalker.ticketwatch.bot.TelegramBot;
import org.mpwalker.ticketwatch.bot.BotConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.api.methods.updates.SetWebhook;

@Configuration
public class AppConfig {
    private final BotConfig botConfig;

    public AppConfig(BotConfig botConfig) {
        this.botConfig = botConfig;
    }
    @Bean
    public SetWebhook setWebhookInstance() {
        return SetWebhook.builder().url(botConfig.getWebHookPath()).build();
    }

    @Bean
    public TelegramBot springWebhookBot(SetWebhook setWebhook, BotFacade botFacade) {
        return new TelegramBot(setWebhook, botConfig.getBotToken(), botFacade);
    }
}