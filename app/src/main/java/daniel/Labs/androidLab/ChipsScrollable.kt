package daniel.Labs.androidLab

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.androidLab.ui.theme.AppTheme

@Composable
fun ScrollableChipsView(
    items: List<ChipData>,
    modifier: Modifier,
    contentPadding: PaddingValues,
    context: Context
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        contentPadding = contentPadding,
        modifier = modifier.offset(y = -10.dp)
    ) {
        items(items.size) { index ->
            Chip(items[index], context)

        }

    }
}

@Composable
fun Chip(itemToShow: ChipData, context: Context) {

    Box(modifier = Modifier
        .clip(shape = RoundedCornerShape(50.dp))
        .background(AppTheme.BgColors.chipBg)
        .padding(AppTheme.Paddings.PaddingValues_ChipsInside)
        .clickable(onClick = {
            Toast.makeText(
                context,
                itemToShow.description,
                Toast.LENGTH_LONG + 3
            ).show()
        })
    ) {
        Text(
            itemToShow.name, color = AppTheme.TextColors.chipElementColor,
            style = AppTheme.TextStyle.Regular_12
        )


    }
}