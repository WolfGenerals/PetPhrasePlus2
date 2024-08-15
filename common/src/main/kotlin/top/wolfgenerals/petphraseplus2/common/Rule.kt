package top.wolfgenerals.petphraseplus2.common

data class Rule(
    val enable: Boolean = true,
    val regex: String = "",
    val template: String = "",
)

fun String.applySafe(rule: Rule): String {
    return try {
        replace(rule.regex.toRegex(), rule.template)
    } catch (e: Exception) {
        this
    }
}

fun String.applyRules(rules: List<Rule>): String {
    var result = this
    rules.forEach {
        result = result.applySafe(it)
    }
    return result
}