package data.local

class UserNameLocalDataSource {
    private var name: String = ""
    //USER NAME SETTERS + GETTERS
    fun setName(newName: String) {
        name = newName
    }

    fun getName(): String {
        return name
    }

}