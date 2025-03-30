package data

object EventData {
    //val normalEvents = ArrayList<String>()

    //SETS GENERAL LUCK EVENT DESCRIPTIONS
    private val describeLuckyEvent = arrayListOf(
        "Today is the day your life changes forever as you decide to begin a new adventure in the " +
                "rich cultural city of Madrid.You make it  to your flight with the perfect seating arrangement.",

        "You arrive  at your hostel just in timer for check in. With your personality you make friends " +
                "with other attendies quite easily. What do you dedide to do?"
    )
    private val describeNormalEvent = arrayListOf(
        "Today is the day your life changes forever as you decide to begin a new adventure in the " +
                "rich cultural city of Madrid. You make it  to your flight with an okay seating no crying baby in sight.",

        "You make it safely and check in. There’s others at your hostel too! What do you decide to do?"
    )
    private val describeUnluckyEvent = arrayListOf(
        "Today is the day your life changes forever as you decide to begin a new adventure in the " +
                "rich cultural city of Madrid. YYour flight was delayed but you finally make it to your seat..." +
                "nex to a crying baby",

        "You can’t believe they lost your luggage! Luckily you still have your wallet and passport. What do you" +
                "decide to do?"
    )
    private val flightEventResponses = arrayListOf(
        "Take a nap",
        "Watch a movie",
        "Be social."
    )
    private val luckyResultOne = arrayListOf(
        "You decide to make nap to conserve your energy for the day ahead!",
        "You watch a movie about someone beginning a new adventure abroad.",
        "You instantly befriend the person in your row. They even offer you some of their in-flight food!"
    )
    private val normalResultOne = arrayListOf(
        "You decide to conserve your energy for th next day by taking a nap.",
        "You watch a movie. Afterwards you’re glad you didn’t pay to see it.",
        "You make light conversation with your seat buddy. They seem nice."
    )
    private val unLuckyResultOne = arrayListOf(
        "As soon as you can you take a nap. No baby is going to kill your in- flight vibe.",
        "You decide to drown out the sound of the baby with a film. Your attention helps you forget your discomfort",
        "You kindly socialize with the family next to you.  You end the interaction more exhuasted than you started"
    )

    //GETS GENERAL LUCK EVENTS
    fun getLuckyEventDescription(index: Int): String {
        return describeLuckyEvent.getOrNull(index) ?: ""
    }

    fun getNormalEventDescription(index: Int): String {
        return describeNormalEvent.getOrNull(index) ?: ""
    }

    fun getUnluckyEventDescription(index: Int): String {
        return describeUnluckyEvent.getOrNull(index) ?: ""
    }

    fun getFlightResponses(index: Int): String {
        return flightEventResponses.getOrNull(index) ?: ""
    }

    fun getLuckyResponseOne(index: Int): String {
        return luckyResultOne.getOrNull(index) ?: ""
    }

    fun getNormalResponseOne(index: Int): String {
        return normalResultOne.getOrNull(index) ?: ""
    }

    fun getUnluckyResponseOne(index: Int): String {
        return unLuckyResultOne.getOrNull(index) ?: ""
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
}

