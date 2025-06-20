package data.local.event

object EventA {
    private val flightEvent = Event(
        descriptionByLuck = mapOf(
            LuckLevel.LUCKY to listOf(
                " Today is the day your life changes forever as you decide to begin a new adventure " +
                        "in the rich, cultural city of Madrid.You make it  to your flight with the" +
                        " perfect seating arrangement."
            ),
            LuckLevel.NORMAL to listOf(
                "Today is the day your life changes forever as you decide to begin a new adventure " +
                        "in the rich, cultural city of Madrid. You make it to your flight with " +
                        "decent seating. No crying baby in sight!"
            ),
            LuckLevel.UNLUCKY to listOf(
                "Today is the day your life changes forever as you decide to begin a new adventure " +
                        "in the rich, cultural city of Madrid. Your flight was delayed, but you " +
                        "finally make it to your seat... next to a crying baby!"
            )
        ),

        responses = listOf("Take a nap", "Watch a movie", "Be social"),

        outcomesByLuck = mapOf(
            LuckLevel.LUCKY to listOf(
                "You decide to make nap to conserve your energy for the day ahead!",
                "You watch a movie about someone beginning a new adventure abroad. How inspiring!",
                "You instantly befriend the person in your row. They even offer you some of their in-flight food!"
            ),
            LuckLevel.NORMAL to listOf(
                "You decide now's about time for taking a nap.",
                "You watch a movie. Afterwards, you’re glad you didn't pay to see it.",
                "You make light conversation with your seat buddy. They seem nice!"
            ),
            LuckLevel.UNLUCKY to listOf(
                "As soon as you can, you take a nap. No baby is going to kill your in-flight vibe.",
                "You decide to drown out the sound of the baby with a film. Your attention helps you forget your discomfort",
                "You kindly socialize with the family next to you. You end the interaction more exhausted than you started!"
            )
        )
    )


    //GETTERS
    fun getLuckyEventDescription(luckLevel: LuckLevel, index: Int): String {
        return flightEvent.descriptionByLuck[luckLevel]?.getOrNull(index) ?: ""
    }

    fun getFlightResponses(index: Int): String {
        return flightEvent.responses.getOrNull(index) ?: ""
    }

    fun getLuckyResponseA(luckLevel: LuckLevel, index: Int): String {
        return flightEvent.outcomesByLuck[luckLevel]?.getOrNull(index) ?: ""
    }
}
