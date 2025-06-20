package data.local.event

object RandomEvent {
    private val randomEvent = Random(

        descriptionByLuck = mapOf(
            LuckLevel.LUCKY to listOf(
                "To your astonishment, you find 20 euros on the ground! Things seem to be getting better.",
                "Someone you met while out sends you a text. They want to meet up for some drinks, one of them" +
                        "will be their treat ; )!",
                "As you go out for a casual stroll, you run into a local celebrity who you follow on social media. You " +
                        "politely get their attention anc compliment them on their online content. " +
                        "You manage to score a picture with them! You feel so lucky! What are the chances?! "
            ),
            LuckLevel.NORMAL to listOf(
                "You're running late and  decide to catch the metro to make it to a home viewing. " +
                        "Right as you make it to the platform, the train pulls up. Nice!",
                "Someone from your hostel tells you about a hidden restaurant with cheap food nearby. You check it out" +
                        "and order food and drink. It's pretty good! You happily post a pic of your meal on socials.",
                "Someone you met the previous night hits you up to hang out. They're Spanish,too! " +
                        "Could this be your first Spanish friend? Time to brush up on some es-pan-ol!"
            ),
            LuckLevel.UNLUCKY to listOf(
                "Some kind stranger tells you that your backpack is open. " +
                        "You thank them and go to zip up your backpack when you decide to check everything is in order." +
                        "To your horror, a couple of personal items have been stolen",
                "You go to grab your phone, only to discover its not there. Your heart starts to race as your frantically" +
                        "search your surroundings.",
                "You head to a bar for a while and catch a football match. Eventually, you go to the toilet " +
                        "and when you return, you're drink is gone. You were almost finished with it, too!" +
                        " The waiter must have thought so. You're very bummed out and consider whether to" +
                        "order another or leave the establishment. "
            ),
        )
    )

    fun getRandomEventDescription(luckLevel: LuckLevel, index: Int): String {
        val randomIndex = (0..2).random()
        return randomEvent.descriptionByLuck[luckLevel]?.getOrNull(randomIndex) ?: ""
    }
}
    /*
        //THE FOLLOWING FUNCTIONS ARE FOR RANDOM LUCK EVENTS
        private val normalEvents = arrayListOf(
            "You made breakfast",
            "You catch the metro",
            " You have change to leave a tip",
            "You went to Sevilla"
        )

        private val luckyEvents = arrayListOf(
            "A friend gives you their flat",
            "You find 20 euros",
            "You win the lottery",
            "You were invited to a drink"
        )
        private val unluckyEvents = arrayListOf(
            "You missed the last metro",
            "The girl who bought you a drink stole your wallet",
            "You've been robbed by your housemates",
            "The waiter took your drink before you finished it"
        )
    //END OF PRIVATE FUNCTIONS FOR RANDOM LUCK EVENTS

        //PUBLIC FUNS THE GET THE SETTERS ABOVE
        fun getLuckyEvent(): String {
            val randomIndex = (0..3).random()
            return luckyEvents[randomIndex]
            // return luckyEvents[(0..2).random()]   short hand version of above
        }

        fun getNormalEvent(): String {
            val randomIndex = (0..3).random()
            return normalEvents[randomIndex]
            // return normalEvents[(0..2).random()]   short hand version of above
        }

        fun getUnluckyEvent(): String {
            val randomIndex = (0..4).random()
            return unluckyEvents[randomIndex]
            // return normalEvents[(0..2).random()]   short hand version of above
        }
    */






