package top.wolfgenerals.petphraseplus2.common.config

import top.wolfgenerals.petphraseplus2.common.Rule

object ConfigProvider {
    private var provider: () -> PetPhrasePlusConfig = {
        throw NotImplementedError("Config provider not implemented")
    }

    val config: PetPhrasePlusConfig
        get() = provider()

    fun setProvider(provider: () -> PetPhrasePlusConfig) {
        this.provider = provider
    }
}

interface PetPhrasePlusConfig {
    val generalConfig: GeneralConfig
    val rules: List<Rule>
}

data class GeneralConfig(
    val modifyMessage: Boolean = true,
)
