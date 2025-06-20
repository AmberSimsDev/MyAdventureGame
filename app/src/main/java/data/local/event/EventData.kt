package data.local.event

data class Event(
val descriptionByLuck: Map<LuckLevel, List<String>>,
val responses: List<String>,
val outcomesByLuck: Map<LuckLevel, List<String>> // Optional
)

data class Random(
    val descriptionByLuck: Map<LuckLevel, List<String>> // Optional
)

enum class LuckLevel { LUCKY, NORMAL, UNLUCKY }

