package data.local.event

object EventB {
        private val hostelEvent = Event(
            descriptionByLuck = mapOf(
                LuckLevel.LUCKY to listOf(
                    "After a lovely taxi ride conversation, welcoming you to the city, you arrive " +
                            "at your hostel just in time for check-in. It's super hip and modern" +
                            " just as you'd seen online. When you get to  your room, you hear " +
                            "friendly chatter. What do you decide to do?"),
                LuckLevel.NORMAL to listOf(
                    "After, hours of flying, you make it safely to your hostel and check in." +
                            "When you arrive at your room, you notice unpacking and friendly chatter in English." +
                            "Everyone seems to be around your age, too! What do you decide to do?"),
                LuckLevel.UNLUCKY to listOf(
                    "You can’t believe they lost your luggage at the airport! Not a great start to your adventure" +
                            "abroad. Luckily you still have your wallet and passport and managed to arrive safely" +
                            "to your hostel. It doesn't look as nice as it did online but it will do." +
                            "What do you decide to do now?")
            ),

            responses = listOf( "Go out into town", "Socialize at the hostel", "Take a nap"),

            outcomesByLuck = mapOf(
                LuckLevel.LUCKY to listOf(
                    "You head into town and discover the local tourist department store where you discover someone from Uni." +
                            "You end up getting your first Madrid sangria and tapas with them, and " +
                            "they invite you to an event later that evening. ",
                    "You socialize with some of the people in your room. They tell you about " +
                            "this cool rooftop event to RSVP for tonight. You decide to RSVP",
                    "You  decide to nap. Not sure if you needed it but you wake up just in " +
                            " time to go see th sunset at the Temple de Debod."),
                LuckLevel.NORMAL to listOf(
                    "You go out and check out all the shops. You try on the perfect fit at a clothing store." +
                            "You decide to get it. New country, new you!",
                    "You make some small talk with some of those staying there. Thanks to your charm " +
                            "they ask you to join them in sight-seeing. You go and somewhat enjoy yourself.",
                    "Frankly, you’re still tired from your trip. You decide to nap for a bit. " +
                            "You wake up in time to go out and enjoy the Madrid sunset."),
                LuckLevel.UNLUCKY to listOf(
                    "Screw the fact you lost your luggage! It's a great excuse to head into town for some local shopping." +
                            "You buy your first Spanish meal, a pair of sunglasses and some local helado." +
                            "Retail therapy cures all.",
                    "Congrats, you succeed gaining sympathy from others staying in your room." +
                            " They pass along recommendations they heard for cheap shops in the area. " +
                            "You decide to visit these shops to buy some necessities",
                    "Screw the events of the last few hours. A nap is just the reset you need!")
            )
        )


//MY GETTERS

    fun getHostelEventDescription(luckLevel: LuckLevel,index: Int): String {
        return EventB.hostelEvent.descriptionByLuck[luckLevel]?.getOrNull(index) ?: ""
    }

    fun getHostelResponse(index: Int): String {
        return EventB.hostelEvent.responses.getOrNull(index) ?: ""
    }
    //FOR EVENT ONE
    fun getLuckyResponseB(luckLevel: LuckLevel,index: Int): String {
        return EventB.hostelEvent.outcomesByLuck[luckLevel]?.getOrNull(index) ?: ""
    }


}