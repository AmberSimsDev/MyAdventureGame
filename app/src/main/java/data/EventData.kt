package data

object EventData {

    //val normalEvents = ArrayList<String>()

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
}

