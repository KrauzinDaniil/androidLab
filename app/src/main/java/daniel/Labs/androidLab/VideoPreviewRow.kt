package daniel.Labs.androidLab

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.myapplication.R
import io.sanghun.compose.video.VideoPlayer
import io.sanghun.compose.video.uri.VideoPlayerMediaItem

@Composable
fun VideoPreviewRow(previewResList: List<Int>, contentPadding: PaddingValues) {

    LazyRow(modifier = Modifier.padding(contentPadding)) {
        items(previewResList.size) { index ->

            Box(
                modifier = Modifier
                    .size(300.dp, 150.dp)
                    .padding(end = 15.dp)
                    .clip(shape = RoundedCornerShape(15.dp))
            ) {

                if (index == 0) {
                    VideoPlayer(
                        mediaItems = listOf(VideoPlayerMediaItem.RawResourceMediaItem(R.raw.dotatrailer)),
                        autoPlay = false,
                        modifier = Modifier.fillMaxSize(),

                        )
                } else {
                    Image(
                        painter = painterResource(previewResList[index]),
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                }
            }
        }
    }
}