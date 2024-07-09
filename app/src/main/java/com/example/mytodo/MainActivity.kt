package com.example.mytodo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.mytodo.tests.card1.CardsViewModel
import com.example.mytodo.tests.card1.card2.ExpandableCard
import com.example.mytodo.ui.theme.MyToDoTheme

class MainActivity : ComponentActivity() {

    val cardsViewModel by viewModels<CardsViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            MyToDoTheme {
                ExpandableCard("titulo","eu sei la")

            }
        }
    }
}

