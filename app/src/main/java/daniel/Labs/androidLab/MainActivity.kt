package com.example.androidLab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Divider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import com.example.androidLab.ui.theme.AppTheme
import com.example.myapplication.R
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import daniel.Labs.androidLab.ChipData
import daniel.Labs.androidLab.CommentBlock
import daniel.Labs.androidLab.DotaScreenHeader
import daniel.Labs.androidLab.PrimaryOvalButton
import daniel.Labs.androidLab.RatingBlock
import daniel.Labs.androidLab.ScrollableChipsView
import daniel.Labs.androidLab.VideoPreviewRow


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

        val userOne = User(R.string.firstUserName, R.drawable.firstuserphoto);
        val userTwo = User(R.string.secondUserName, R.drawable.usertwophoto);
        val userUiFirst = UserUi(R.string.comment, R.string.date, userOne);
        val userUiSecond = UserUi(R.string.comment, R.string.date, userTwo);
        val list = listOf(userUiFirst, userUiSecond);


        LazyColumn(
            state = lazyListState,
            modifier = Modifier
                .fillMaxSize()
                .background(AppTheme.BgColors.screenColor)
        ) {


            item {

                DotaScreenHeader(Modifier.background(Color.Gray))

            }

            item {


                val items = listOf(
                    ChipData(stringResource(R.string.MOBA), stringResource(R.string.MOBA_DESC)),
                    ChipData(
                        stringResource(R.string.STRATEGY),
                        stringResource(R.string.STRATEGY_DESC)
                    ),
                    ChipData(
                        stringResource(R.string.MULTIPLAYER),
                        stringResource(R.string.MULTIPLAYER_DESC)
                    )
                )

                ScrollableChipsView(
                    items,
                    modifier = Modifier.padding(bottom = 10.dp),
                    contentPadding = AppTheme.Paddings.PaddingValues_Chips,
                    context,


                    )

                Box() {
                    Text(
                        text = stringResource(R.string.dota_info),
                        style = AppTheme.TextStyle.Regular_12_48,
                        color = AppTheme.TextColors.secondary,
                        modifier = Modifier.padding(
                            AppTheme.Paddings.PaddingValues_Text_Standart)
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
                Text(
                    text = stringResource(R.string.bar),
                    modifier = Modifier.padding
                        (AppTheme.Paddings.PaddingValues_Text_Standart),
                    color = AppTheme.TextColors.colorReview,
                    style = AppTheme.TextStyle.Bold_16
                );
                RatingBlock(
                    4.9f,
                    "70M",
                    Modifier.padding(AppTheme.Paddings.PaddingValues_RatingBlock)
                )


            }

            //Комменты
            itemsIndexed(list) { index, item ->
                CommentBlock(
                    item,
                    modifier = Modifier.padding(AppTheme.Paddings.PaddingValues_Text_Standart)
                )

                if (index < list.lastIndex) {
                    Divider(
                        color = AppTheme.BgColors.divider,
                        thickness = 1.dp,
                        modifier = Modifier.padding(
                           AppTheme.Paddings.PaddingValues_Divider)
                        )
                }


            }

            //Кнопка
            item {

                var isLoading by remember { mutableStateOf(false) }
                var isTextVisible by remember { mutableStateOf(true) }
                var buttonColor by remember { mutableStateOf(AppTheme.ButtonColors.buttonColor) }

                PrimaryOvalButton(onClick = {
                    isLoading = !isLoading
                    isTextVisible = !isTextVisible
                    if (isLoading) {
                        buttonColor = AppTheme.ButtonColors.buttonColorActive;

                    } else buttonColor = AppTheme.ButtonColors.buttonColor
                }, isLoading, isTextVisible, buttonColor)
            }

        }


    }


    }




    //коммент




















   









