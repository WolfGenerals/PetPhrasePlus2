package top.wolfgenerals.petphraseplus2.common

import top.wolfgenerals.petphraseplus2.common.config.ConfigProvider

fun String.clientPetPhrase(): String {
    return this.applyRules(
        ConfigProvider.config.rules
            .filter { it.enable }
    )
}
