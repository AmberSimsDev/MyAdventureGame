package data.local.event

object EventD {

    private val pisoEvent = Event(
        descriptionByLuck = mapOf(
            LuckLevel.LUCKY to listOf(
                "Yesterday’s events were amazing and memorable, but now its " +
                        "back to reality. It's time to get started on finding a piso! You spent time searching " +
                        "on your own back in your home country. Now, you may know people who can help with your " +
                        "search. What do you do?"
            ),
            LuckLevel.NORMAL to listOf(
                "After a relatively decent first night, you're rested up and ready to " +
                        "get started on finding a piso! You spent a lot of time searching " +
                        "on your own back in your home country. Now, you may know people who can help with your " +
                        "search. What do you do?"
            ),
            LuckLevel.UNLUCKY to listOf(
                "Yesterday’s events have faded. Your first Madrid headache helps bring " +
                        "you back to reality. It's time to get started on finding a piso! You spent time searching " +
                        "on your own back in your home country. Now, you may know people who can help with your " +
                        "search. What do you do?"
            ),
        ),

        responses = listOf("Search online for pisos", "Text your contact", "Go for a walk"),

        outcomesByLuck = mapOf(
            LuckLevel.LUCKY to listOf(
                "You spend the afternoon fighting to uphold your standards as you search online for" +
                        " your dream piso. Great options seem bleak but you refuse to lose hope.",
                "You decide to hit up someone you met last night about available pisos. " +
                        "You have a feeling it will go well. You wait for their response.",

                "there's no better way to decide where to live then to visit the neighborhoods themselves. " +
                        "You head out for a stroll around the city, exploring neighborhoods like Lavapies and La Latina. " +
                        "Later, you stop for lunch at a local tapa resturant where you hear group of people speaking" +
                        " in your language. You join them and turns out they're also looking for a piso!"
            ),
            LuckLevel.NORMAL to listOf(
                "You get to searching for pisos online, learning a long the way that some are obvious scams. " +
                        "The search goes okay and you find some apartments to check out in the next few days.",
                "You decide to reach out to some of the people you've met, asking if they can help with your search. " +
                        "You wait for a response.",
                "You head out for a stroll around the city, exploring neighborhoods like Lavapies and La Latina. " +
                        "During your stroll you make not of the rent signs you find written down on apartments. " +
                        "You decide to call some of them."

            ),
            LuckLevel.UNLUCKY to listOf(
                "You spend the afternoon searching for pisos online. You manage to find  some places" +
                        " you like. There's one in particular located in the center that you love! And its  got super cheap rent too! " +
                        "This couldn't be a scam, could it? You text the landlord, who responds quickly" +
                        " and requests that you send a deposit immediately, as there's a lot of competition.",
                "You decide to hit up a contact. It's better to work smarter not harder, right? Maybe it leads" +
                        " where but it's definitely worth a shot!",
                "Rather than deal with the crushing anxiety of finding a place to live, you opt for a " +
                        "walk to clear your head. You can make good choices if your constantly anxious! You had to" +
                        " Parque de Oeste and lay on the grass for a while, taking in the sun."
            )
        )

    )

//MY GETTERS

    fun getPisoEventDescription(luckLevel: LuckLevel, index: Int): String {
        return EventD.pisoEvent.descriptionByLuck[luckLevel]?.getOrNull(index) ?: ""
    }

    fun getPisoResponse(index: Int): String {
        return EventD.pisoEvent.responses.getOrNull(index) ?: ""
    }

    //FOR EVENT ONE
    fun getLuckyResponseD(luckLevel: LuckLevel, index: Int): String {
        return EventD.pisoEvent.outcomesByLuck[luckLevel]?.getOrNull(index) ?: ""
    }


}



