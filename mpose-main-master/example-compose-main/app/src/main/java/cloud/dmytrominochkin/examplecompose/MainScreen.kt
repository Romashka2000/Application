package cloud.dmytrominochkin.examplecompose

import androidx.activity.compose.BackHandler
import androidx.compose.animation.Crossfade
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import cloud.dmytrominochkin.examplecompose.model.User
import cloud.dmytrominochkin.examplecompose.ui.components.StatusBarColorProvider
import cloud.dmytrominochkin.examplecompose.ui.feed.Feed
import cloud.dmytrominochkin.examplecompose.ui.profile.Profile

@ExperimentalAnimationApi
@Composable
fun MainScreen() {
    StatusBarColorProvider()
    Surface(color = MaterialTheme.colors.onSurface) {
        var selectedId by rememberSaveable { mutableStateOf<String?>(null) }
        Crossfade(targetState = selectedId) { id ->
            if (id == null) {
                Feed(
                    users,
                    onSelected = { selectedId = it.id }
                )
            } else {
                Profile(users.first { it.id == id })
                BackHandler {
                    selectedId = null
                }
            }
        }
    }
}

private val users = mutableListOf(
    User(
        "1",
        "Сюмбюль-ага",
        "Man",
        R.drawable.an1,
        "60",
        "Евнух во дворце Топкапы",
        listOf("food", "fashion", "nature", "dogs", "people", "selfies", "style", "fashion", "cats"),

    ),
    User(
        "2",
        "Фирузе",
        "Woman",
        R.drawable.an2,
        "41",
        "родственница шаха Тахмаспа (или его шпионка) и фаворитка Сулеймана",
        listOf("people", "selfies", "style", "fashion"),

    ),
    User(
        "3",
        "Малкочоглу Бали-бей",
        "Man",
        R.drawable.an3,
        "26",
        "Сын наместника Семиндере, военачальник Османской Империи, позже хранитель султанских покоев",
        listOf("selife", "cats", "nature", "fashion"),

    )
)