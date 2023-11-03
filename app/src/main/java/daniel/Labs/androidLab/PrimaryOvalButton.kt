package daniel.Labs.androidLab

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.androidLab.ui.theme.AppTheme
import com.example.myapplication.R

@Composable
fun PrimaryOvalButton(
    onClick: () -> Unit,
    isLoading: Boolean,
    isTextVisible: Boolean,
    buttonColor: Color
) {


    Box() {
        Button(
            onClick = onClick,
            modifier = Modifier

                .padding(start = 24.dp, end = 24.dp, top = 40.dp, bottom = 60.dp)
                .wrapContentHeight(Alignment.CenterVertically)
                .fillMaxSize()
                .clip(shape = RoundedCornerShape(20.dp))
                .height(AppTheme.Sizes.ButtonSize),
            shape = RectangleShape,
            colors = ButtonDefaults.buttonColors(buttonColor),
        ) {
            AnimatedVisibility(visible = isTextVisible) {


                Text(
                    text = stringResource(R.string.buttonText),
                    color = AppTheme.TextColors.buttonTextColor,
                    style = AppTheme.TextStyle.Bold_20
                )
            }
        }
        AnimatedVisibility(
            visible = isLoading,
            Modifier
                .align(Alignment.Center)
                .padding(bottom = 15.dp)
        ) {
            CircularProgressIndicator(color = AppTheme.BgColors.screenColor)

        }
    }
}