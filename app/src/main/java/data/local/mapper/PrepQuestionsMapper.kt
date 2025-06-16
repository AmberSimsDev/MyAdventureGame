package data.local.mapper

import data.local.entity.PrepQuestionsLocalEntity
import domain.model.PrepQuestions
//NO
// Mapping is not the repository's job
// it’s a transformation that can be reused and tested separately.

internal fun PrepQuestionsLocalEntity.toDomain(): PrepQuestions {
    return PrepQuestions(
        id = this.id,
        question = this.question,
        optionOne = this.optionOne,
        optionTwo = this.optionTwo,
        optionResponse = this.optionResponse
    )
}