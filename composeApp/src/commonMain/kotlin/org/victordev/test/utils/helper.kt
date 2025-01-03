import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp

const val SDP_BASE = 300.0

val Int.sdp: Dp
    @Composable
    get() = this.sdpGet()

val Int.ssp: TextUnit
    @Composable get() = this.sspGet()


@Composable
fun Int.sdpGet(): Dp {
    val minValue= kotlin.math.min(getScreenHeight(), getScreenWidth())
    val ratio = minValue / 300.0
    return (this * ratio).dp
}

@Composable
fun Int.sspGet(): TextUnit {
    return this.textSdp(density = LocalDensity.current)
}

@Composable
private fun Int.textSdp(density: Density): TextUnit = with(density) {
    this@textSdp.sdp.toSp()
}

@Composable
expect fun getScreenWidth(): Float

@Composable
expect fun getScreenHeight(): Float
