package com.example.myapplication

import android.inputmethodservice.Keyboard
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
import androidx.compose.foundation.magnifier
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.ModifierInfo
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import com.example.myapplication.ui.theme.AppTheme

import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import okhttp3.internal.http2.Header
import java.nio.file.WatchEvent
import java.util.Objects

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false);
        setContent {
          MainScreen();
        }
    }

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
    fun DotaScreen() {
           val context = LocalContext.current
           val lazyListState = rememberLazyListState()

        val userOne = user(R.string.firstUserName, R.drawable.firstuserphoto);
        val userTwo = user(R.string.secondUserName, R.drawable.usertwophoto);
        val user_ui_first = userUi(R.string.comment, R.string.date, userOne);
        val user_ui_second = userUi(R.string.comment, R.string.date, userTwo);

        val list = listOf(user_ui_first, user_ui_second);


           LazyColumn(state = lazyListState,
                   modifier = Modifier
                       .fillMaxSize()
                       .background(Color(0Xff050b18)),

                   ) {
               item {
                   DotaScreenHeader(Modifier.background(Color.Gray)) }
               item {
                   val  items = listOf("MOBA", "MULTIPLAYER", "STRATEGY");
                   ScrollableChipsView(
                      items,
                      modifier = Modifier.padding(top = 16.dp, bottom = 16.dp),
                      contentPadding = PaddingValues(start = 24.dp, end = 24.dp)

                   )



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

               item {

                   val items = listOf<Int>(R.drawable.imageone, R.drawable.imagetwo);
                   VideoPreviewRow(items, PaddingValues(start = 24.dp, end = 24.dp));
               }

               itemsIndexed(list) {index, item ->
                           CommentBlock(
                               item, modifier = Modifier.padding(start = 24.dp, end = 24.dp,top = 16.dp)
                           )
               if(index < list.lastIndex) {
                   Divider(
                       color = AppTheme.BgColors.divider,
                       thickness = 1.dp,
                       modifier = Modifier.padding(top = 12.dp, bottom = 10.dp, start = 30.dp, end = 30.dp)
                   )
               }



                       }
               item  {

                  PrimaryOvalButton(text = "Install", onClick = { Toast.makeText(context, "CLICKED", Toast.LENGTH_LONG).show() }, modifier = Modifier )
               }
               }


           }




    @Composable
    fun ScrollableChipsView(items : List<Any>, modifier: Modifier, contentPadding: PaddingValues) {
        LazyRow(horizontalArrangement = Arrangement.spacedBy(10.dp),
                contentPadding = contentPadding,
                 modifier = modifier) {
              items(items.size) { index ->

                 // Chip(
                   //   items[index],


                  //)

              }

        }
    }
    @Composable
    fun Chip(itemToShow : Any, paddingValues: PaddingValues, backgoundColor : Color) {



    }

    @Composable
    fun CommentBlock (userUi: userUi, modifier: Modifier = Modifier ) {
        Column(modifier = modifier) {
            Row  {
                Box(modifier = Modifier
                    .clip(CircleShape)
                    .size(36.dp))  {
                    Image(painter = painterResource(userUi.user.image),contentDescription = null, contentScale = ContentScale.Crop)
                }
                Column() {
                    Text(text = stringResource(userUi.user.username), color = Color.White)
                    Text(text = stringResource(userUi.date), color = Color.White)

                }
            }

        Box()  {
            Text(text = stringResource(userUi.text), color = Color.White)
        }
            
        }
        
        
    }

    @Composable
    fun PrimaryOvalButton(text : String, onClick : () -> Unit, modifier: Modifier) {
        Button(onClick = onClick, modifier = Modifier

            .padding(start = 24.dp, end = 24.dp, top = 20.dp, bottom = 40.dp)
            .wrapContentHeight(Alignment.CenterVertically)
            .fillMaxWidth()
            .height(40.dp),
                shape = RectangleShape
         ) { Text(text = text) }
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
    fun DotaScreenHeader(modifier: Modifier = Modifier) {

         HeaderBackground (painter = painterResource(R.drawable.headerdota), modifier = modifier
             .fillMaxWidth()
             .height(400.dp)
             , contentScale = ContentScale.Crop) {

         }
         HeaderGroup()


    }

    @Composable
    fun HeaderGroup() {
        Row(modifier = Modifier.offset(x = 20.dp, y = -35.dp)) {
            DotaLogo()

            DotaLine()

        }
    }

    @Composable
    fun DotaLine() {
        Box(contentAlignment = Alignment.CenterEnd, modifier = Modifier.height(100.dp) ) {
            Column( modifier = Modifier.padding(top = 20.dp, start = 15.dp)) {


                Text(text = stringResource(R.string.label), fontSize = 20.sp, color = Color.White)
                Row() {
                    Image(
                        painter = painterResource(R.drawable.startsv),
                        modifier = Modifier.size(76.dp, 12.dp),
                        contentDescription = null
                    )
                    Text(text = stringResource(R.string.mill), fontSize = 12.sp,color = Color.White )
                }

            }
        }

    }

    @Composable
    fun HeaderBackground(
        painter: Painter,
        modifier: Modifier = Modifier,
        contentScale : ContentScale,
        content: @Composable () -> Unit,
    ) {
       Box { Image(painter = painter, contentDescription = "", modifier = modifier, contentScale = contentScale );
               }

    }

    @Composable
    fun VideoPreviewRow(previewResList : List<Int>, contentPadding : PaddingValues) {

        LazyRow(modifier = Modifier.padding(contentPadding)) {
            items(previewResList.size) { index -> Image(painter = painterResource(previewResList[index]), contentDescription = null, modifier = Modifier
                .size(300.dp, 150.dp)
                .clip(
                    RoundedCornerShape(25.dp)
                )  )  }
        }

    }

   

    @Composable
    fun DotaLogo() {
        Box(modifier = Modifier
            .size(100.dp, 100.dp)
             ) {


            Image(
                painter = painterResource(R.drawable.square),
                contentDescription = "",
                modifier = Modifier.fillMaxSize(),


                );
            Box() {
                Image(
                    painter = painterResource(R.drawable.dotalogo),
                    contentDescription = "",
                    modifier = Modifier
                        .fillMaxSize()
                        .scale(0.6F),



                    )
            }
        }
    }







