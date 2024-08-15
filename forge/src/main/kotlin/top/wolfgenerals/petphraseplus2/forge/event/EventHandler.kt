package top.wolfgenerals.petphraseplus2.forge.event

import net.minecraftforge.client.event.ClientChatEvent
import top.wolfgenerals.petphraseplus2.common.clientPetPhrase
import top.wolfgenerals.petphraseplus2.common.config.ConfigProvider

fun onClientChatEvent(event: ClientChatEvent) {
    if (ConfigProvider.config.generalConfig.modifyMessage)
        event.message = event.message.clientPetPhrase()
}

