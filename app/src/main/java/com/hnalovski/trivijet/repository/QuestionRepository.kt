package com.hnalovski.trivijet.repository

import com.hnalovski.trivijet.data.DataOrException
import com.hnalovski.trivijet.model.QuestionItem
import com.hnalovski.trivijet.network.QuestionApi
import javax.inject.Inject

class QuestionRepository @Inject constructor(private val api: QuestionApi) {
    private val dataOrException = DataOrException<ArrayList<QuestionItem>, Boolean, Exception>()

    suspend fun getAllQuestions(): DataOrException<ArrayList<QuestionItem>, Boolean, Exception> {
        try {
            dataOrException.loading = true
            dataOrException.data = api.getAllQuestions()
            if (dataOrException.data.toString().isNotEmpty()) {
                dataOrException.loading = false
            }
        } catch (exception: Exception) {
            dataOrException.e = exception
        }
        return dataOrException
    }
}