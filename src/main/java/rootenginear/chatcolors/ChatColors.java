package rootenginear.chatcolors;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ChatColors implements ModInitializer {
    public static final String MOD_ID = "chatcolors";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("ChatColors initialized.");
    }
}
