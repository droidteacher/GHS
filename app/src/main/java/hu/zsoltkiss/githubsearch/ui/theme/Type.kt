package hu.zsoltkiss.githubsearch.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp
import hu.zsoltkiss.githubsearch.R

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)

val fonts = FontFamily(
    Font(R.font.exo_regular, FontWeight.Normal),
    Font(R.font.sfprotext_regular, FontWeight.Normal),
)

val screenTitle: TextStyle
    @Composable
    get() {
        return TextStyle(
            fontFamily = FontFamily(Font(R.font.exo_regular)),
            fontSize = 24.sp,
            color = PurpleGrey40,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold

        )}

val warningDialogTitle: TextStyle
    @Composable
    get() {
        return TextStyle(
            fontFamily = FontFamily(Font(R.font.exo_regular)),
            fontSize = 24.sp,
            color = Color.Black
        )}

val warningDialogText: TextStyle
    @Composable
    get() {
        return TextStyle(
            fontFamily = FontFamily(Font(R.font.exo_regular)),
            fontSize = 18.sp,
            color = Color(0xFF37474F)
        )}


val warningDialogButton: TextStyle
    @Composable
    get() {
        return TextStyle(
            fontFamily = FontFamily(Font(R.font.exo_regular)),
            fontSize = 18.sp,
            color = Color.Blue
        )}

val noResults: TextStyle
    @Composable
    get() {
        return TextStyle(
            fontFamily = fonts,
            fontWeight = FontWeight.Normal,
            fontSize = 22.sp,
            color = MaterialTheme.colorScheme.onBackground
        )
    }

val searchError: TextStyle
    @Composable
    get() {
        return TextStyle(
            fontFamily = fonts,
            fontWeight = FontWeight.Normal,
            fontSize = 22.sp,
            color = Color.Red
        )
    }

val cardTitleStyle: TextStyle
    @Composable
    get() {
        return TextStyle(
            fontFamily = FontFamily(Font(R.font.chicle_regular)),
            fontSize = 24.sp,
            color = Color(0xFF78909C)
        )}

val cardDescriptionStyle: TextStyle
    @Composable
    get() {
        return TextStyle(
            fontFamily = FontFamily(Font(R.font.exo_regular)),
            fontSize = 16.sp,
            color = Color(0xFF78909C)
        )}

val detailsLabel: TextStyle
    @Composable
    get() {
        return TextStyle(
            fontFamily = FontFamily(Font(R.font.sfprotext_regular)),
            fontSize = 14.sp,
            color = Color.White
        )}

val detailsValue: TextStyle
    @Composable
    get() {
        return TextStyle(
            fontFamily = FontFamily(Font(R.font.exo_regular)),
            fontSize = 16.sp,
            color = Color.Black
        )}


val hyperlink: TextStyle
    @Composable
    get() {
        return TextStyle(
            fontFamily = FontFamily(Font(R.font.exo_regular)),
            fontSize = 16.sp,
            textDecoration = TextDecoration.Underline,
            fontWeight = FontWeight.Bold,
            color = Color.Blue
        )}