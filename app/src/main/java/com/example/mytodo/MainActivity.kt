package com.example.mytodo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.mytodo.components.card.CardsScreen
import com.example.mytodo.components.card.CardsViewModel
import com.example.mytodo.ui.theme.MyToDoTheme

class MainActivity : ComponentActivity() {

    val cardsViewModel by viewModels<CardsViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            MyToDoTheme {
                CardsScreen(cardsViewModel)
                //    MyApp()

            }
        }
    }
}

@Composable
fun MyApp() {

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyToDoTheme {
        MyApp()
    }
}