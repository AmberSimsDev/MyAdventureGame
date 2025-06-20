package data.local.event

object EventC {
    private val firstNightEvent = Event(
        descriptionByLuck = mapOf(
            LuckLevel.LUCKY to listOf(
                "It’s now your first night in Madrid. After a marvelous afternoon, the sun has begun" +
                        "to set and the sun has gone down. You return to your hostel to rest a bit and " +
                        "decide what to do with the rest of your night. What do you decide to do?"
            ),
            LuckLevel.NORMAL to listOf(
                "It’s now your first night in Madrid. After a very long afternoon. " +
                        "The sun has gone down. What do you decide to"
            ),
            LuckLevel.UNLUCKY to listOf(
                "After a nice, long nap you notice the sun has begun to set. You have yet to explore Madrid. " +
                        "You yawn and taking the next few moments to decide what to do. "
            ),
        ),

        responses = listOf("Have a quiet night", "Get changed and go out", "Head to a bar"),

        outcomesByLuck = mapOf(
            LuckLevel.LUCKY to listOf(
                "Today’s been pretty great but you need to catch up on your socials. " +
                        "You enjoy the night on your tech devices. ",
                "You decide to get changed and go out to that rooftop bar you were told about. " +
                        "You enter with ease, immersing yourself instantly imn one of Madrid’s" +
                        " lively party scenes. Not only that, thanks to your charm, you score a free " +
                        "drink from the bartender and later meet someone interesting...!",
                "Despite being invited to a rooftop earlier, you opt for a local bar. Turns out there's this event happening " +
                        "to meet new people and practice languages. You notice not many people" +
                        " seem to be there to improve their language skills... Regardless, you meet some nice people."
            ),
            LuckLevel.NORMAL to listOf(
                "You’re pretty exhausted from the day, and despite invitations " +
                        "you decide to take it easy .and respect your body’s need for r&r",
                "As recommended to you earlier, you go out to the roof top you were told about. " +
                        "The music was chill and nice at times. The drinks were a bit expensive but decent. ",
                "Time to dive into some local drinks and local people! You accidentally find an " +
                        "event to meet new people and practice languages. You practice some Spanish " +
                        "and meet tons of cool people."
            ),
            LuckLevel.UNLUCKY to listOf(
                "You decide that today just hasn't been your day. You have a quiet night.. " +
                        "until your hostel-mates come in late making lots of noise and ruin your peace. ",
                "You decide to go out to your first club. You paid full price for entrance " +
                        "and a free drink with more ice than drink. You meet a group of people " +
                        "from various parts of the world. They all speak English, and you hang out with them for the " +
                        "rest of the night.",
                "You decide a drink is exactly what you need. You head to a local bar where you " +
                        "meet someone who speaks your language. They're nice...and very cool too!"
            )
        )

    )

//MY GETTERS

    fun getFirstNightEventDescription(luckLevel: LuckLevel, index: Int): String {
        return EventC.firstNightEvent.descriptionByLuck[luckLevel]?.getOrNull(index) ?: ""
    }

    fun getFirstNightResponse(index: Int): String {
        return EventC.firstNightEvent.responses.getOrNull(index) ?: ""
    }

    //FOR EVENT ONE
    fun getLuckyResponseC(luckLevel: LuckLevel, index: Int): String {
        return EventC.firstNightEvent.outcomesByLuck[luckLevel]?.getOrNull(index) ?: ""
    }


}

