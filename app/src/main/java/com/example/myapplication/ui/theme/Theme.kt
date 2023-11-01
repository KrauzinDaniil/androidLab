package com.example.myapplication.ui.theme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.sp

object AppTheme  {

 object BgColors {
    val primary = Color(android.graphics.Color.BLACK)
    val divider = Color(0xff1a1f29)
    val secondary = Color.Gray;
 }
 object ButtonColors {


 }
    object TextColors {
        val secondary = Color( 0xffeef2fb)

    }

    object TextStyle  {

        val Bold_48
         @Composable
         get() =
             TextStyle (
                fontFamily = com.example.myapplication.ui.theme.FontFamily,
                 fontWeight = FontWeight.Bold,
                 fontSize = 48.sp,
                 platformStyle = PlatformTextStyle(includeFontPadding = false),
                 lineHeightStyle = LineHeightStyle( LineHeightStyle.Alignment.Proportional, LineHeightStyle.Trim.None),
                     )


         val Regular_12_48
         @Composable
         get() =
             TextStyle (   fontFamily = com.example.myapplication.ui.theme.FontFamily,
                 fontWeight = FontWeight.Light,
                 fontSize = 12.sp,
                 letterSpacing = 0.8.sp,
                 lineHeight = 19.sp



             )
    }




}