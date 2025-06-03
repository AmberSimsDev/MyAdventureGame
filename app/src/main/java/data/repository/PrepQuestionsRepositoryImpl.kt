package data.repository

import data.local.source.PrepQuestionsLocalDataSource
import data.local.entity.PrepQuestionsLocalEntity
import domain.model.PrepQuestions
import domain.repository.PrepQuestionsRepository

//PURPOSE: PREPARE DATA TO BE USED IN DOMAIN LAYER

//Step 1: Define a class using the logic necessary to access data for prepQuestions in the Domain
//Give it a variable of type PrepQuestionsLocalDataSource (Will hold its instance of the object)
//Will inherit from Domain's PrepQuestion Repository
class PrepQuestionsRepositoryImpl(val localDataSource: PrepQuestionsLocalDataSource): PrepQuestionsRepository {
    override suspend fun getPrepQuestions():List<PrepQuestions> {
        //The function has been override to return a list called "prepQuestions"
        return localDataSource.getPrepQuestions().map { it.toDomain() } // Mapping
        // Extension function to map PrepQuestionsLocalEntity to PrepQuestions
    }

    }


