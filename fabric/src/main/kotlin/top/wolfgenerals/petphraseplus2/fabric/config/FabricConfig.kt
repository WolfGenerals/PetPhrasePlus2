package top.wolfgenerals.petphraseplus2.fabric.config

import me.shedaniel.autoconfig.ConfigData
import me.shedaniel.autoconfig.annotation.Config
import me.shedaniel.autoconfig.annotation.ConfigEntry.Gui.TransitiveObject
import top.wolfgenerals.petphraseplus2.common.config.GeneralConfig
import top.wolfgenerals.petphraseplus2.common.config.PetPhrasePlusConfig
import top.wolfgenerals.petphraseplus2.common.Rule

@Config(name = "petphraseplus2")
data class FabricConfig(
    @TransitiveObject
    override val generalConfig: GeneralConfig = GeneralConfig(),
    override val rules: List<Rule> = listOf(
        Rule(
            regex = "$",
            template = "喵~"
        )
    ),
) : ConfigData, PetPhrasePlusConfig

