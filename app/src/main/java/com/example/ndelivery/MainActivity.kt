package com.example.ndelivery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ndelivery.ui.theme.NDeliveryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NDeliveryTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                }
            }
        }
    }
}

@Preview
@Composable
fun ProductItemPreview() {
    ProductItem()
}

@Composable
fun ProductItem() {
    Column(
        Modifier
            .width(200.dp)
            .height(250.dp)
    ) {
        Box(
            Modifier
                .width(200.dp)
                .height(100.dp)
                .background(Color.Green)
        )
        {

            Image(
                modifier = Modifier
                    .offset(x = 50.dp, y = 50.dp)
                    .width(100.dp)
                    .height(100.dp),
                painter = painterResource(R.drawable.ic_launcher_background),
                contentDescription = null
            )
        }

        Column(
            Modifier
                .padding(horizontal = 16.dp)
                .offset(y = 66.dp)
        ) {

            Text(
                modifier = Modifier
                    .width(168.dp)
                    .height(48.dp),
                text = "Lorem ipsum is placeholder text...",
                fontSize = 18.sp
            )

            Text(
                modifier = Modifier
                    .width(59.dp)
                    .height(17.dp),
                text = "R$ 14,99",
                fontSize = 14.sp,
            )
        }

    }
}

