package rootenginear.chatcolors.mixin;

import net.minecraft.core.net.command.TextFormatting;
import net.minecraft.server.net.ChatEmotes;
import net.minecraft.server.net.handler.NetServerHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import static net.minecraft.core.net.command.TextFormatting.FORMATTINGS;

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
        for (TextFormatting style : FORMATTINGS) {
            newS = newS.replaceAll("&" + style.code, style.toString());
        }
        return newS + TextFormatting.RESET;
    }
}
