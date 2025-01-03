import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp

@Composable
actual fun getScreenWidth(): Float {
    return LocalConfiguration.current.screenWidthDp.dp.value
}

@Composable
actual fun getScreenHeight(): Float {
    return LocalConfiguration.current.screenHeightDp.dp.value
}