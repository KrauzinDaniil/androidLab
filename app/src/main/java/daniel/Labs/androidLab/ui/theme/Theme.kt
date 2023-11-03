package com.example.androidLab.ui.theme
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

object AppTheme {

    object BgColors {
        val primary = Color(android.graphics.Color.BLACK)
        val divider = Color(0xff1a1f29)
        val chipBg = Color(0xff14314c)
        val screenColor = Color(0Xff050b18);
    }

    object ButtonColors {
         val buttonColor = Color(0xfff4d144)
         val buttonColorActive = Color(0xffeba266)


    }

    object TextColors {
        val secondary = Color(0xffa9adb7)
        val logoColor = Color.White;
        val countColor = Color(0xff45454d)
        val chipElementColor = Color(0xff44a9f4)
        val colorReview = Color(0xffeef2fb)
        val colorNumberOfReviews = Color(0xffa8adb7)
        val dateColor = Color(	0xff5e6571)
        val buttonTextColor = Color(0xff050b18)

    }

    object Paddings {
         val PaddingValues_Chips
         @Composable
         get() =
              PaddingValues (start = 24.dp, end = 24.dp,)

         val PaddingValues_Text_Standart
         @Composable
         get() =
             PaddingValues(  start = 24.dp,
                 end = 24.dp,
                 top = 14.dp,
                 bottom = 14.dp)

         val PaddingValues_RatingBlock
         @Composable
         get() =
             PaddingValues(start = 24.dp, end = 24.dp, bottom = 16.dp)

         val PaddingValues_Divider
         @Composable
         get() =
             PaddingValues( top = 12.dp,
                 bottom = 10.dp,
                 start = 30.dp,
                 end = 30.dp)

         val PaddingValues_ChipsInside
         @Composable
         get() =
             PaddingValues ( start = 15.dp, top = 5.dp, bottom = 5.dp, end = 15.dp)

    }

    object Sizes  {
        val MainPictureSize

        get() = 400.dp


        val DotaLogoHeight

        get() = 100.dp

        val DotaLogoWidth

        get() = 100.dp

        val ButtonSize

        get() = 64.dp









    }

    object TextStyle {

        val Bold_48
            @Composable
            get() =
                TextStyle(
                    fontFamily = com.example.androidLab.ui.theme.FontFamily,
                    fontWeight = FontWeight.Bold,
                    fontSize = 48.sp,
                    platformStyle = PlatformTextStyle(includeFontPadding = false),
                    lineHeightStyle = LineHeightStyle(
                        LineHeightStyle.Alignment.Proportional,
                        LineHeightStyle.Trim.None
                    ),
                )


        val Regular_12_48
            @Composable
            get() =
                TextStyle(
                    fontFamily = com.example.androidLab.ui.theme.FontFamily,
                    fontWeight = FontWeight.Light,
                    fontSize = 12.sp,
                    letterSpacing = 0.6.sp,
                    lineHeight = 19.sp


                )

        val Regular_12_20
            @Composable
            get() =
                TextStyle(
                    fontFamily = com.example.androidLab.ui.theme.FontFamily,
                    fontWeight = FontWeight.Light,
                    fontSize = 12.sp,
                    letterSpacing = 0.6.sp,
                    lineHeight = 20.sp


                )

        val Bold_20
            @Composable
            get() =
                TextStyle(
                    fontFamily = com.example.androidLab.ui.theme.FontFamily,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    platformStyle = PlatformTextStyle(includeFontPadding = false),
                    lineHeightStyle = LineHeightStyle(
                        LineHeightStyle.Alignment.Proportional,
                        LineHeightStyle.Trim.None
                    ),
                    letterSpacing = 0.5.sp,
                    lineHeight = 26.sp

                )
        val Regular_12
            @Composable
            get() =
                TextStyle(
                    fontFamily = com.example.androidLab.ui.theme.FontFamily,
                    fontWeight = FontWeight.Light,
                    fontSize = 12.sp,
                    platformStyle = PlatformTextStyle(includeFontPadding = false),
                    lineHeightStyle = LineHeightStyle(
                        LineHeightStyle.Alignment.Proportional,
                        LineHeightStyle.Trim.None
                    ),
                    letterSpacing = 0.5.sp,
                    lineHeight = 13.sp
                )


        val Mono_10
            @Composable
            get() =
                TextStyle(
                    fontFamily = com.example.androidLab.ui.theme.FontFamily,
                    fontWeight = FontWeight.Medium,
                    fontSize = 10.sp,
                    platformStyle = PlatformTextStyle(includeFontPadding = false),
                    lineHeightStyle = LineHeightStyle(
                        LineHeightStyle.Alignment.Proportional,
                        LineHeightStyle.Trim.None
                    ),
                    letterSpacing = 0.6.sp,
                    lineHeight = 12.sp

                )

        val Bold_16
            @Composable
            get() =
                TextStyle(
                    fontFamily = com.example.androidLab.ui.theme.FontFamily,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    platformStyle = PlatformTextStyle(includeFontPadding = false),
                    lineHeightStyle = LineHeightStyle(
                        LineHeightStyle.Alignment.Proportional,
                        LineHeightStyle.Trim.None
                    ),
                    letterSpacing = 0.6.sp,
                    lineHeight = 19.sp
                )
        val Regular_16
        @Composable
        get() =
            TextStyle (
                fontFamily = com.example.androidLab.ui.theme.FontFamily,
                fontWeight = FontWeight.Light,
                fontSize = 16.sp,
                platformStyle = PlatformTextStyle(includeFontPadding = false),
                lineHeightStyle = LineHeightStyle(
                    LineHeightStyle.Alignment.Proportional,
                    LineHeightStyle.Trim.None
                ),
                letterSpacing = 0.6.sp,
                lineHeight = 19.sp
                    )


    }
}