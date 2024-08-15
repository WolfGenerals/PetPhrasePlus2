package top.wolfgenerals.petphraseplus2.fabric.mixins

import net.minecraft.client.gui.screen.ChatScreen
import org.spongepowered.asm.mixin.Mixin
import org.spongepowered.asm.mixin.injection.At
import org.spongepowered.asm.mixin.injection.ModifyArg
import top.wolfgenerals.petphraseplus2.common.clientPetPhrase
import top.wolfgenerals.petphraseplus2.common.config.ConfigProvider

@Suppress("NonJavaMixin")
@Mixin(ChatScreen::class)
abstract class ChatScreenMixin {
    @ModifyArg(
        method = ["sendMessage"],
        at = At(
            "INVOKE",
            target = "Lnet/minecraft/client/network/ClientPlayNetworkHandler;sendChatMessage(Ljava/lang/String;)V",
        ),
    )
    fun modifySendChatMessage(chatMessage: String) =
        if (ConfigProvider.config.generalConfig.modifyMessage)
            chatMessage.clientPetPhrase()
        else
            chatMessage
}