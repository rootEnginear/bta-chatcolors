package rootenginear.chatcolors.mixin;

import net.minecraft.core.net.command.TextFormatting;
import net.minecraft.server.net.ChatEmotes;
import net.minecraft.server.net.handler.NetServerHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = {NetServerHandler.class}, remap = false)
public class NetServerHandlerMixin {
    @Redirect(
            method = "handleChat(Lnet/minecraft/core/net/packet/Packet3Chat;)V",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/server/net/ChatEmotes;process(Ljava/lang/String;)Ljava/lang/String;"
            )
    )
    private String formatMsg(String s) {
        String newS = ChatEmotes.process(s);
        newS = newS.replaceAll("&0", TextFormatting.WHITE.toString());
        newS = newS.replaceAll("&1", TextFormatting.ORANGE.toString());
        newS = newS.replaceAll("&2", TextFormatting.MAGENTA.toString());
        newS = newS.replaceAll("&3", TextFormatting.LIGHT_BLUE.toString());
        newS = newS.replaceAll("&4", TextFormatting.YELLOW.toString());
        newS = newS.replaceAll("&5", TextFormatting.LIME.toString());
        newS = newS.replaceAll("&6", TextFormatting.PINK.toString());
        newS = newS.replaceAll("&7", TextFormatting.GRAY.toString());
        newS = newS.replaceAll("&8", TextFormatting.LIGHT_GRAY.toString());
        newS = newS.replaceAll("&9", TextFormatting.CYAN.toString());
        newS = newS.replaceAll("&a", TextFormatting.PURPLE.toString());
        newS = newS.replaceAll("&b", TextFormatting.BLUE.toString());
        newS = newS.replaceAll("&c", TextFormatting.BROWN.toString());
        newS = newS.replaceAll("&d", TextFormatting.GREEN.toString());
        newS = newS.replaceAll("&e", TextFormatting.RED.toString());
        newS = newS.replaceAll("&f", TextFormatting.BLACK.toString());
        newS = newS.replaceAll("&g", TextFormatting.OBFUSCATED.toString());
        newS = newS.replaceAll("&h", TextFormatting.BOLD.toString());
        newS = newS.replaceAll("&i", TextFormatting.STRIKETHROUGH.toString());
        newS = newS.replaceAll("&j", TextFormatting.UNDERLINE.toString());
        newS = newS.replaceAll("&k", TextFormatting.ITALIC.toString());
        newS = newS.replaceAll("&l", TextFormatting.RESET.toString());
        return newS;
    }
}
