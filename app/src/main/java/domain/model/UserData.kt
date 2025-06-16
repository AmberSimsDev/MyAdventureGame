package domain.model
// PURPOSE: Another domain model.
// Simple representation of a user’s game data
// Could expand this later to include more fields like:
// currentEventId, chosenResponses, progress, etc.
data class UserData(
    val name: String,
    val score: Int
)


