package com.example.androidLab

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import com.example.androidLab.ui.theme.AppTheme
import com.example.myapplication.R
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import io.sanghun.compose.video.VideoPlayer
import io.sanghun.compose.video.uri.VideoPlayerMediaItem


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false);
        setContent {
          MainScreen();
        }
    }


    //Главный экран
    @Composable
    fun MainScreen() {
            ApplySystemBarColors();

            Surface(
                color = AppTheme.BgColors.primary,
                modifier = Modifier.fillMaxSize()
            ) {
                DotaScreen();

            }

        }
    }

    @Composable
    private fun ApplySystemBarColors() {
    val systemUiController = rememberSystemUiController();

    SideEffect {
        systemUiController.setStatusBarColor(color = Color.Transparent);
        systemUiController.setStatusBarColor(color = Color.Transparent);
        }
    }


    @Composable
    fun DotaScreen() {
           val context = LocalContext.current
           val lazyListState = rememberLazyListState()

        val userOne = user(R.string.firstUserName, R.drawable.firstuserphoto);
        val userTwo = user(R.string.secondUserName, R.drawable.usertwophoto);
        val user_ui_first = userUi(R.string.comment, R.string.date, userOne);
        val user_ui_second = userUi(R.string.comment, R.string.date, userTwo);
        val list = listOf(user_ui_first, user_ui_second);

        //Главная Scroll-column
        LazyColumn(state = lazyListState,
                   modifier = Modifier
                       .fillMaxSize()
                       .background(AppTheme.BgColors.screenColor))  {

               //Хедер фото + лого с надписью
               item {

                    DotaScreenHeader(Modifier.background(Color.Gray))

                    }

               //chips
               item {
                   val items = listOf("MOBA", "MULTIPLAYER", "STRATEGY");
                   ScrollableChipsView(
                      items,
                      modifier = Modifier.padding(bottom = 10.dp),
                      contentPadding = PaddingValues(start = 24.dp, end = 24.dp)

                   )


                   //Информация об игре
                   Box() {
                       Text(
                           text = stringResource(R.string.dota_info),
                           style = AppTheme.TextStyle.Regular_12_48,
                           color = AppTheme.TextColors.secondary,
                           modifier = Modifier.padding(
                               start = 24.dp,
                               end = 24.dp,
                               top = 14.dp,
                               bottom = 14.dp,
                           )
                       )
                   }

               }

               //Превью видео
               item {

                   val items = listOf<Int>(R.drawable.imageone, R.drawable.imagetwo);
                   VideoPreviewRow(items, PaddingValues(start = 24.dp, end = 9.dp));
               }

               //Блок Рейтинга
               item {
                      Text(text = stringResource(R.string.bar), modifier = Modifier.padding
                          (start = 24.dp, end = 24.dp, top = 20.dp, bottom = 12.dp), color = AppTheme.TextColors.colorReview, style = AppTheme.TextStyle.Bold_16);
                      RatingBlock(4.9f, "70M", Modifier.padding(start = 24.dp, end = 24.dp, bottom = 16.dp))



                   
               }

               //Комменты
               itemsIndexed(list) {index, item ->
                           CommentBlock(item, modifier = Modifier.padding(start = 24.dp, end = 24.dp,top = 16.dp))

                   if(index < list.lastIndex) {
                     Divider(
                       color = AppTheme.BgColors.divider,
                       thickness = 1.dp,
                       modifier = Modifier.padding(top = 12.dp, bottom = 10.dp, start = 30.dp, end = 30.dp))
                     }



               }

               //Кнопка
               item  {

                  PrimaryOvalButton(onClick = { Toast.makeText(context, "CLICKED", Toast.LENGTH_LONG).show() }, modifier = Modifier )
               }

        }



    }

    @Preview
    @Composable
    fun DotaScreenHeader(modifier: Modifier = Modifier) {

               HeaderBackground (painter = painterResource(R.drawable.headerdota),
                                 modifier = modifier.fillMaxWidth().height(400.dp),
                                 contentScale = ContentScale.Crop)

               HeaderGroup()

    }

    //Главное фото
    @Composable
    fun HeaderBackground( painter: Painter, modifier: Modifier = Modifier, contentScale : ContentScale) {

                   Box {
                             Image(painter = painter, contentDescription = "", modifier = modifier, contentScale = contentScale );
                   }

    }

    //Лого + название игры
    @Composable
    fun HeaderGroup() {
             Row(modifier = Modifier.offset(x = 20.dp, y = -35.dp))  {
             DotaLogo()

             DotaLine()
             }
    }

    //Лого
    @Composable
    fun DotaLogo() {
             Box(modifier = Modifier.size(100.dp, 100.dp)) {


                   Image(painter = painterResource(R.drawable.square),
                         contentDescription = "",
                         modifier = Modifier.fillMaxSize());
                   Box() {
                   Image(painter = painterResource(R.drawable.dotalogo),
                         contentDescription = "",
                         modifier = Modifier.fillMaxSize().scale(0.6F))
                   }
             }
    }
    //Надписи и звезды
    @Composable
    fun DotaLine() {
             Box(contentAlignment = Alignment.CenterEnd, modifier = Modifier.height(100.dp) ) {
                    Column( modifier = Modifier.padding(top = 35.dp, start = 15.dp)) {


                            Text(text = stringResource(R.string.label), style = AppTheme.TextStyle.Bold_20, color = AppTheme.TextColors.logoColor)

                            Row() {

                                  Image(painter = painterResource(R.drawable.startsv),
                                        modifier = Modifier.padding(top = 5.dp).size(76.dp, 12.dp),contentDescription = null
                                  )

                                  Text(text = stringResource(R.string.mill), style = AppTheme.TextStyle.Regular_12,
                                       color = AppTheme.TextColors.countColor, modifier = Modifier.padding(start = 5.dp, top = 3.dp))
                            }

                    }
             }

    }
    //Scrollable chips
    @Composable
    fun ScrollableChipsView(items : List<String>, modifier: Modifier, contentPadding: PaddingValues) {
         LazyRow(horizontalArrangement = Arrangement.spacedBy(10.dp),
                 contentPadding = contentPadding,
                 modifier = modifier.offset(y = -10.dp)) {
                        items(items.size) { index ->
                                           Chip(items[index])

                        }

                 }
}


    //Chip
    @Composable
    fun Chip(itemToShow : String) {

         Box(modifier = Modifier.clip(shape = RoundedCornerShape(50.dp))
                                .background(AppTheme.BgColors.chipBg)
                                .padding(start = 15.dp, top = 5.dp, bottom = 5.dp, end = 15.dp) ) {
                         Text(itemToShow, color = AppTheme.TextColors.chipElementColor,
                                          style = AppTheme.TextStyle.Regular_12)
         }
}

//Видео
@Composable
fun VideoPreviewRow(previewResList : List<Int>, contentPadding : PaddingValues) {

    LazyRow(modifier = Modifier.padding(contentPadding)) {
        items(previewResList.size) { index ->

            Box(modifier = Modifier
                .size(300.dp, 150.dp)
                .padding(end = 15.dp)
                .clip(shape = RoundedCornerShape(15.dp))) {

                if(index == 0) {
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

    //Рейтинг игры
    @Composable
    fun RatingBlock(rating: Float, reviewsCount: String, modifier: Modifier) {
        Row(modifier = modifier) {
            Text(rating.toString(), color = AppTheme.TextColors.logoColor, style = AppTheme.TextStyle.Bold_48);
            Column(verticalArrangement = Arrangement.Center, modifier = Modifier
                .height(65.dp)
                .padding(start = 15.dp) ) {

                Image(painter = painterResource(R.drawable.reviews), contentDescription = null);

                Text(reviewsCount + " Reviews", color = AppTheme.TextColors.colorNumberOfReviews,
                    style = AppTheme.TextStyle.Regular_12, modifier = Modifier.padding(top = 10.dp))
                
            }
            
        }

    }









    //коммент
    @Composable
    fun CommentBlock (userUi: userUi, modifier: Modifier = Modifier ) {
        Column(modifier = modifier) {
            Row  {
                Box(modifier = Modifier
                    .clip(CircleShape)
                    .size(36.dp))  {
                    Image(painter = painterResource(userUi.user.image),contentDescription = null, contentScale = ContentScale.Crop)
                }
                Column(modifier = Modifier.padding(start = 20.dp)) {
                    Text(text = stringResource(userUi.user.username), color = AppTheme.TextColors.logoColor, style = AppTheme.TextStyle.Regular_16)
                    Text(text = stringResource(userUi.date), color = AppTheme.TextColors.dateColor, style = AppTheme.TextStyle.Regular_12,
                          modifier = Modifier.padding(top = 7.dp))

                }
            }

        Box(modifier = Modifier.padding(top = 20.dp))  {
            Text(text = stringResource(userUi.text), color = AppTheme.TextColors.colorNumberOfReviews, style = AppTheme.TextStyle.Regular_12_20)
        }
            
        }
        
        
    }

    //кнопка
    @Composable
    fun PrimaryOvalButton( onClick : () -> Unit, modifier: Modifier) {
        Button(
            onClick = onClick,
            modifier = Modifier

                .padding(start = 24.dp, end = 24.dp, top = 40.dp, bottom = 60.dp)
                .wrapContentHeight(Alignment.CenterVertically)
                .fillMaxSize()
                .clip(shape = RoundedCornerShape(20.dp))
                .height(64.dp),
            shape = RectangleShape,
            colors = ButtonDefaults.buttonColors(AppTheme.ButtonColors.buttonColor),
        ) { Text(text = stringResource(R.string.buttonText),
                 color = AppTheme.TextColors.buttonTextColor,
                 style = AppTheme.TextStyle.Bold_20) }
    }















   









