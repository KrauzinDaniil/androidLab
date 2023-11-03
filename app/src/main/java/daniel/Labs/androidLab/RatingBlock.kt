package daniel.Labs.androidLab

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.androidLab.ui.theme.AppTheme
import com.example.myapplication.R

@Composable
fun RatingBlock(rating: Float, reviewsCount: String, modifier: Modifier) {
    Row(modifier = modifier) {
        Text(
            rating.toString(),
            color = AppTheme.TextColors.logoColor,
            style = AppTheme.TextStyle.Bold_48
        );
        Column(
            verticalArrangement = Arrangement.Center, modifier = Modifier
                .height(65.dp)
                .padding(start = 15.dp)
        ) {

            Image(painter = painterResource(R.drawable.reviews), contentDescription = null);

            Text(
                reviewsCount + " Reviews", color = AppTheme.TextColors.colorNumberOfReviews,
                style = AppTheme.TextStyle.Regular_12, modifier = Modifier.padding(top = 10.dp)
            )

        }

    }

}