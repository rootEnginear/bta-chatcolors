package rootenginear.chatcolors.command;

import net.minecraft.core.net.command.*;
import net.minecraft.server.MinecraftServer;

import static net.minecraft.core.net.command.TextFormatting.FORMATTINGS;

public class CColorCommand extends ServerCommand {
    public CColorCommand(MinecraftServer server) {
        super(server, "ccolor", "ccolour", "cc");
    }

    @Override
    public boolean execute(CommandHandler handler, CommandSender sender, String[] args) {
        if (!sender.isPlayer()) {
            throw new CommandError("Must be used by a player!");
        }
        sender.sendMessage(TextFormatting.LIGHT_GRAY + "Available formatting:");
        int STYLE_LIMIT = 6;
        StringBuilder builder = new StringBuilder();
        int columnCount = 0;
        for (TextFormatting style : FORMATTINGS) {
            builder.append("§").append(style.code).append("&");
            if (style.code.equals("k")) {
                builder.append("§r");
            }
            builder.append(style.code).append("§r  ");
            if (++columnCount == STYLE_LIMIT) {
                sender.sendMessage(builder.toString());
                builder = new StringBuilder();
                columnCount = 0;
            }
        }
        sender.sendMessage(builder.toString());
        return true;
    }

    @Override
    public boolean opRequired(String[] args) {
        return false;
    }

    @Override
    public void sendCommandSyntax(CommandHandler handler, CommandSender sender) {
        sender.sendMessage("/ccolor");
    }
}
