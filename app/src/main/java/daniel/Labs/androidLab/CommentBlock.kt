package daniel.Labs.androidLab

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.androidLab.UserUi
import com.example.androidLab.ui.theme.AppTheme

@Composable
fun CommentBlock(userUi: UserUi, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Row {
            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .size(36.dp)
            ) {
                Image(
                    painter = painterResource(userUi.user.image),
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )
            }
            Column(modifier = Modifier.padding(start = 20.dp)) {
                Text(
                    text = stringResource(userUi.user.username),
                    color = AppTheme.TextColors.logoColor,
                    style = AppTheme.TextStyle.Regular_16
                )
                Text(
                    text = stringResource(userUi.date),
                    color = AppTheme.TextColors.dateColor,
                    style = AppTheme.TextStyle.Regular_12,
                    modifier = Modifier.padding(top = 7.dp)
                )

            }
        }

        Box(modifier = Modifier.padding(top = 20.dp)) {
            Text(
                text = stringResource(userUi.text),
                color = AppTheme.TextColors.colorNumberOfReviews,
                style = AppTheme.TextStyle.Regular_12_20
            )
        }

    }


}