package top.wolfgenerals.petphraseplus2.forge

import top.wolfgenerals.petphraseplus2.forge.config.ForgeConfig
import me.shedaniel.autoconfig.AutoConfig
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer
import me.shedaniel.autoconfig.serializer.Toml4jConfigSerializer
import net.minecraft.client.Minecraft
import net.minecraft.client.gui.screens.Screen
import net.minecraftforge.client.ConfigScreenHandler
import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.ModLoadingContext
import net.minecraftforge.fml.common.Mod
import top.wolfgenerals.petphraseplus2.common.config.ConfigProvider
import top.wolfgenerals.petphraseplus2.forge.event.onClientChatEvent

@Mod("petphraseplus2")
class PetPhrasePlus {
    init {

        // Init config screen
        AutoConfig.register(ForgeConfig::class.java, ::Toml4jConfigSerializer)

        ModLoadingContext
            .get()
            .registerExtensionPoint(ConfigScreenHandler.ConfigScreenFactory::class.java) {
                ConfigScreenHandler.ConfigScreenFactory { _: Minecraft?, parent: Screen? ->
                    AutoConfig.getConfigScreen(
                        ForgeConfig::class.java,
                        parent,
                    ).get()
                }
            }

        MinecraftForge.EVENT_BUS.addListener(::onClientChatEvent)

        ConfigProvider.setProvider {
            AutoConfig.getConfigHolder(ForgeConfig::class.java).config
        }
    }
}
