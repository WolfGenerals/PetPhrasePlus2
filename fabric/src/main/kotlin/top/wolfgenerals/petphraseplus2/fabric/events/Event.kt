package top.wolfgenerals.petphraseplus2.fabric.events

sealed interface Event

data class TickEvent(
    val something: String
) : Event
