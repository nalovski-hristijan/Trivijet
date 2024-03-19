package com.hnalovski.trivijet

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.hnalovski.trivijet.screens.QuestionsViewModel
import com.hnalovski.trivijet.ui.theme.TrivijetTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlin.math.log

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TrivijetTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                }
            }
        }
    }
}

@Composable
fun TriviaHome(viewModel: QuestionsViewModel = hiltViewModel()) {
    Questions(viewModel)
}

@Composable
fun Questions(viewModel: QuestionsViewModel) {
    val questions = viewModel.data.value.data?.toMutableList()
    if (viewModel.data.value.loading == true) {
        Log.d("LOADING", "Questions: loading ...")
    } else {
        Log.d("LOADING", "Questions: loading stopped ")
        questions?.forEach{questionItem ->
            Log.d("RESULT", "Questions: ${questionItem.question}")
        }
    }
    Log.d("SIZE", "Questions: ${questions?.size}")

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TrivijetTheme {

    }
}