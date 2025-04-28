package com.example.sarapulcityguide.data

import com.example.sarapulcityguide.R
import com.example.sarapulcityguide.model.Category
import com.example.sarapulcityguide.model.Place

object SarapulDataSource {

    val categories = listOf(
        Category(
            id = 1,
            title = "Парки и природа",
            imageRes = R.drawable.ic_launcher_foreground // ставим временную картинку или иконку
        ),
        Category(
            id = 2,
            title = "Исторические места",
            imageRes = R.drawable.ic_launcher_foreground
        ),
        Category(
            id = 3,
            title = "Рестораны и кафе",
            imageRes = R.drawable.ic_launcher_foreground
        ),
        Category(
            id = 4,
            title = "Музеи",
            imageRes = R.drawable.ic_launcher_foreground
        )
    )

    val places = listOf(
        Place(
            id = 1,
            categoryId = 1,
            title = "Парк имени Горького",
            description = "Центральный городской парк для прогулок и отдыха.",
            imageRes = R.drawable.gorkiy_park // 👉 реальная фотка
        ),
        Place(
            id = 2,
            categoryId = 1,
            title = "Набережная Камы",
            description = "Живописная набережная с видами на реку Кама.",
            imageRes = R.drawable.kama_embankment
        ),
        Place(
            id = 3,
            categoryId = 2,
            title = "Церковь Николая Чудотворца",
            description = "Историческая церковь конца XIX века.",
            imageRes = R.drawable.tserkov_nikolaya
        ),
        Place(
            id = 4,
            categoryId = 2,
            title = "Дача Башенина",
            description = "Известный особняк дореволюционного Сарапула.",
            imageRes = R.drawable.dacha_bashenin
        ),
        Place(
            id = 5,
            categoryId = 3,
            title = "Кафе Чайка",
            description = "Популярное кафе с домашней кухней.",
            imageRes = R.drawable.cafe_chaika
        ),
        Place(
            id = 6,
            categoryId = 3,
            title = "Ресторан Старая башня",
            description = "Современный ресторан с европейской кухней.",
            imageRes = R.drawable.old_tower
        ),
        Place(
            id = 7,
            categoryId = 4,
            title = "Музей истории Сарапула",
            description = "Музей, посвящённый истории города.",
            imageRes = R.drawable.kraeved_museum
        ),
        Place(
            id = 8,
            categoryId = 4,
            title = "Дом-музей Корешева",
            description = "Дом известного купца, превращённый в музей.",
            imageRes = R.drawable.koreshev_house
        )
    )
}
