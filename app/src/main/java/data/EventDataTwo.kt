package data

object EventDataTwo {


    private val hostelEventResponses = arrayListOf(
        "Go out into town",
        "Socialize at the hostel",
        "Take a nap"
    )

    private val luckyHostelResult = arrayListOf(
        "You head into town and discover the local tourist department store where you discover someone from Uni." +
                "You end up getting your first Madrid sangria and tapas with them, and " +
                "they invite you to an event later that evening. ",
        "You socialize with some of the people in your room. They tell you about " +
                "this cool rooftop event to RSVP for tonight. You decide to RSVP",
        "You  decide to nap. Not sure if you needed it but you wake up just in " +
                " time to go see th sunset at the Temple de Debod."
    )
    private val normalHostelResult = arrayListOf(
        "You go out and check out all the shops. You try on the perfect fit at a clothing store." +
                "You decide to get it. New country, new you!",
        "You make some small talk with some of those staying there. Thanks to your charm " +
                "they ask you to join them in sight-seeing. You go and somewhat enjoy yourself.",
        "Frankly, you’re still tired from your trip. You decide to nap for a bit. " +
                "You wake up in time to go out and enjoy the Madrid sunset."
    )
    private val unLuckyHostelResult = arrayListOf(
        "Screw the fact you lost your luggage! It's a great excuse to head into town for some local shopping." +
                "You buy your first Spanish meal, a pair of sunglasses and some local helado." +
                "Retail therapy cures all.",
        "Congrats, you succeed gaining sympathy from others staying in your room." +
                " They pass along recommendations they heard for cheap shops in the area. " +
                "You decide to visit these shops to buy some necessities",
        "Screw the events of the last few hours. A nap is just the reset you need!"
    )

//MY GETTERS
    fun getHostelEventResponses(index: Int): String {
        return hostelEventResponses.getOrNull(index) ?: " "
    }


    fun getLuckyHostelResponse(index: Int): String {
        return EventDataTwo.luckyHostelResult.getOrNull(index) ?: ""
    }

    fun getNormalHostelResponse(index: Int): String {
        return EventDataTwo.normalHostelResult.getOrNull(index) ?: ""
    }

    fun getUnluckyHostelResponse(index: Int): String {
        return EventDataTwo.unLuckyHostelResult.getOrNull(index) ?: ""
    }

}