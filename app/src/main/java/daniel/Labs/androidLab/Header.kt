package daniel.Labs.androidLab

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androidLab.ui.theme.AppTheme
import com.example.myapplication.R


@Preview
@Composable
fun DotaScreenHeader(modifier: Modifier = Modifier) {

    HeaderBackground(
        painter = painterResource(R.drawable.headerdota),
        modifier = modifier
            .fillMaxWidth()
            .height(AppTheme.Sizes.MainPictureSize),
        contentScale = ContentScale.Crop
    )

    HeaderGroup()

}

@Composable
fun HeaderBackground(
    painter: Painter,
    modifier: Modifier = Modifier,
    contentScale: ContentScale
) {

    Box {
        Image(
            painter = painter,
            contentDescription = "",
            modifier = modifier,
            contentScale = contentScale
        );
    }

}

@Preview
@Composable
fun HeaderGroup() {
    Row(modifier = Modifier.offset(x = 20.dp, y = -35.dp)) {
        DotaLogo()

        DotaLine()
    }
}


@Preview
@Composable
fun DotaLogo() {
    Box(modifier = Modifier.size(AppTheme.Sizes.DotaLogoHeight, AppTheme.Sizes.DotaLogoWidth)) {


        Image(
            painter = painterResource(R.drawable.square),
            contentDescription = "",
            modifier = Modifier.fillMaxSize()
        );
        Box() {
            Image(
                painter = painterResource(R.drawable.dotalogo),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxSize()
                    .scale(0.6F)
            )
        }
    }
}

@Preview
@Composable
fun DotaLine() {
    Box(contentAlignment = Alignment.CenterEnd, modifier = Modifier.height(100.dp)) {
        Column(modifier = Modifier.padding(top = 35.dp, start = 15.dp)) {


            Text(
                text = stringResource(R.string.label),
                style = AppTheme.TextStyle.Bold_20,
                color = AppTheme.TextColors.logoColor
            )

            Row() {

                Image(
                    painter = painterResource(R.drawable.startsv),
                    modifier = Modifier
                        .padding(top = 5.dp)
                        .size(76.dp, 12.dp), contentDescription = null
                )

                Text(
                    text = stringResource(R.string.mill),
                    style = AppTheme.TextStyle.Regular_12,
                    color = AppTheme.TextColors.countColor,
                    modifier = Modifier.padding(start = 5.dp, top = 3.dp)
                )
            }

        }
    }

}


