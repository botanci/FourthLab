package com.example.sarapulcityguide.ui

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.sarapulcityguide.data.SarapulDataSource

@Composable
fun PlaceListScreen(
    navController: NavController,
    categoryId: Int,
    categoryTitle: String?
) {
    val infiniteTransition = rememberInfiniteTransition(label = "Background Animation")
    val color1 by infiniteTransition.animateColor(
        initialValue = Color(0xFFBBDEFB),
        targetValue = Color(0xFF90CAF9),
        animationSpec = infiniteRepeatable(
            animation = tween(4000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "Color 1"
    )
    val color2 by infiniteTransition.animateColor(
        initialValue = Color(0xFFE1BEE7),
        targetValue = Color(0xFFCE93D8),
        animationSpec = infiniteRepeatable(
            animation = tween(4000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "Color 2"
    )

    val places = SarapulDataSource.places.filter { it.categoryId == categoryId }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(colors = listOf(color1, color2))
            )
            .padding(16.dp)
    ) {
        Column {
            // --- Заголовок категории и кнопка Назад ---
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                TextButton(
                    onClick = { navController.popBackStack() }
                ) {
                    Text(
                        text = "Назад",
                        color = Color.White
                    )
                }
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = categoryTitle ?: "Категория",
                    style = MaterialTheme.typography.titleLarge.copy(
                        fontSize = 24.sp,
                        color = Color.White
                    )
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            if (places.isEmpty()) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Нет доступных мест",
                        style = MaterialTheme.typography.titleLarge.copy(color = Color.White)
                    )
                }
            } else {
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    items(places) { place ->
                        Card(
                            onClick = {
                                navController.navigate("place_detail/${place.id}")
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(120.dp),
                            elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(8.dp)
                            ) {
                                Image(
                                    painter = painterResource(id = place.imageRes),
                                    contentDescription = place.title,
                                    modifier = Modifier
                                        .size(80.dp)
                                        .padding(8.dp)
                                )

                                Spacer(modifier = Modifier.width(8.dp))

                                Text(
                                    text = place.title,
                                    style = MaterialTheme.typography.titleMedium,
                                    color = Color.White // <-- теперь текст белый
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
