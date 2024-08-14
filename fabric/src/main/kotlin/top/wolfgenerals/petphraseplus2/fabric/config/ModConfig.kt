package top.wolfgenerals.petphraseplus2.fabric.config

import top.wolfgenerals.petphraseplus2.common.ModNameConfig
import me.shedaniel.autoconfig.ConfigData
import me.shedaniel.autoconfig.annotation.Config
import me.shedaniel.autoconfig.annotation.ConfigEntry

@Config(name = "petphraseplus2")
class ModConfig : ConfigData {
    // documentation: https://shedaniel.gitbook.io/cloth-config/auto-config/creating-a-config-class

    @ConfigEntry.Gui.CollapsibleObject
    val config = ModNameConfig()
}
