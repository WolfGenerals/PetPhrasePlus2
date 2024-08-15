package top.wolfgenerals.petphraseplus2.fabric

import me.shedaniel.autoconfig.AutoConfig
import me.shedaniel.autoconfig.serializer.Toml4jConfigSerializer
import net.fabricmc.api.ModInitializer
import top.wolfgenerals.petphraseplus2.common.config.ConfigProvider
import top.wolfgenerals.petphraseplus2.fabric.config.FabricConfig

class PetPhrasePlus : ModInitializer {
    override fun onInitialize() {
        AutoConfig.register(FabricConfig::class.java, ::Toml4jConfigSerializer)

        ConfigProvider.setProvider {
            AutoConfig.getConfigHolder(FabricConfig::class.java).config
        }
    }
}
