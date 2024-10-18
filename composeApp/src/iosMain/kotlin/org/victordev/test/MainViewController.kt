import androidx.compose.ui.window.ComposeUIViewController
import org.victordev.test.App
import org.victordev.test.data.database.getDataBaseBuilder
import org.victordev.test.di.initKoin

fun MainViewController() = ComposeUIViewController(
    configure = { initKoin()}
) {
    App()
}