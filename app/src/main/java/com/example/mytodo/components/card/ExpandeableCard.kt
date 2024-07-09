package com.example.mytodo.components.card

import android.annotation.SuppressLint
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@SuppressLint("UnusedTransitionTargetStateParameter")
@Composable
fun ExpandableCard(
    card: ExpandableCardModel,
    onCardArrowClick: () -> Unit,
    expanded: Boolean,
) {
    val transitionState = remember {
        MutableTransitionState(expanded).apply {
            targetState = !expanded
        }
    }
    val transition = updateTransition(transitionState)

    val cardBgColor by transition.animateColor({ tween(durationMillis = 500)}) { if (expanded) Color.Red else Color.Gray  }

    val cardPaddingHorizontal by transition.animateDp({ tween(durationMillis = 500)}) { if (expanded) 48.dp else 24.dp }

    val cardElevation by transition.animateDp({ tween(durationMillis = 500) }) { if (expanded) 24.dp else 4.dp  }

    val cardRoundedCorners by transition.animateDp({ tween( durationMillis = 500, easing = FastOutSlowInEasing )}) { if (expanded) 0.dp else 16.dp  }

    val arrowRotationDegree by transition.animateFloat({ tween(durationMillis = 500) }) { if (expanded) 0f else 180f }

    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color.Gray, //Card background color
            contentColor = Color.White  //Card content color,e.g.text
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
        shape = RoundedCornerShape(cardRoundedCorners),
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = cardPaddingHorizontal,
                vertical = 8.dp
            )
    ) {
        Column {
            Box {
                CardArrow(
                    degrees = arrowRotationDegree,
                    onClick = onCardArrowClick
                )
                CardTitle(title = card.title)
            }
            ExpandableContent(visible = expanded, initialVisibility = expanded)
        }
    }
}