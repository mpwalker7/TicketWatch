package org.mpwalker.ticketwatch.bot;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)

public class BotConfig {
    @Value("${webHookPath}")
    String webHookPath;
    @Value("${botName}")
    String userName;
    @Value("${botToken}")
    String botToken;
}
