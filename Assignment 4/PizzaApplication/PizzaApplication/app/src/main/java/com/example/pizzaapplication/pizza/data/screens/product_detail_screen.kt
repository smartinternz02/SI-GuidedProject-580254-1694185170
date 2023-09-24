package com.example.pizzaapplication.pizza.data.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.pizzaapplication.R
import com.example.pizzaapplication.pizza.data.components.AppIconComponent
import com.example.pizzaapplication.pizza.data.components.IconComponent
import com.example.pizzaapplication.pizza.data.components.LogoComponent
import com.example.pizzaapplication.ui.theme.Background
import com.example.pizzaapplication.ui.theme.DarkGray_1
import com.example.pizzaapplication.ui.theme.Gray_1
import com.example.pizzaapplication.ui.theme.LightRed
import com.example.pizzaapplication.ui.theme.Purple80
import com.example.pizzaapplication.ui.theme.TextColor


@Composable
fun ProductDetailScreen(
    navHostController: NavHostController
) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Background)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
        ) {
            ProductHeader {
                navHostController.navigateUp()
            }
            Spacer(modifier = Modifier.height(20.dp))
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                item {
                    ShowProduct()
                    ProductDescription()
                }
            }
        }

        ButtonComponent(
            modifier = Modifier
                .padding(20.dp)
                .align(Alignment.BottomCenter)
        )

    }

}

@Composable
fun ProductDescription(
    modifier: Modifier = Modifier
) {

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 15.dp)
    ) {

        Text(
            text = stringResource(id = R.string.veg_pizza), style = TextStyle(
                fontSize = 18.sp,
                color = Purple80,
                fontWeight = FontWeight.W400
            )
        )
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = stringResource(id = R.string.pizza_name),
                fontSize = 22.sp,
                fontWeight = FontWeight.W500,
                modifier = Modifier.weight(0.8f)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.2f)
            ) {
                IconComponent(
                    icon = R.drawable.star,
                    size = 20.dp,
                    modifier = Modifier
                        .align(CenterVertically)
                )
                Spacer(modifier = Modifier.width(5.dp))
                Text(
                    text = stringResource(id = R.string.rating),
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight.W400,
                        color = Gray_1
                    ),
                )
            }
        }

        Spacer(modifier = Modifier.height(15.dp))
        Text(
            text = stringResource(id = R.string.pizza_description),
            style = TextStyle(
                fontSize = 18.sp,
                color = DarkGray_1,
                fontWeight = FontWeight.W400
            )
        )
    }

}

@Composable
fun ShowProduct() {

    var couter by remember { mutableStateOf(0) }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                LightRed, RoundedCornerShape(14.dp)
            ),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .padding(vertical = 20.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                painter = painterResource(id = R.drawable.pizza_image), contentDescription = "",
                modifier = Modifier.size(200.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))
            Box(modifier = Modifier.background(Color.White, RoundedCornerShape(20.dp))) {
                Row {
                    AppIconComponent(icon = R.drawable.plus, background = Purple80) {
                        couter++
                    }
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        text = "$couter", style = TextStyle(
                            fontSize = 25.sp,
                            fontWeight = FontWeight.W500,
                            color = TextColor
                        ),
                        modifier = Modifier.align(CenterVertically)
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    AppIconComponent(icon = R.drawable.minus, background = Purple80) {
                        if (couter > 0)
                            couter--
                    }
                }
            }

        }
    }

}

@Composable
private fun ButtonComponent(
    modifier: Modifier = Modifier
) {

    Button(
        onClick = {},
        modifier = modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            contentColor = Color.White,
            containerColor = Purple80
        ),
        shape = RoundedCornerShape(37.dp),
        contentPadding = PaddingValues(vertical = 15.dp),
        elevation = ButtonDefaults.buttonElevation(0.dp)
    ) {

        Text(
            text = stringResource(id = R.string.add_to_bag), style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.W500
            )
        )
    }

}

@Composable
private fun ProductHeader(onClick: () -> Unit) {

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        AppIconComponent(icon = R.drawable.back) {
            onClick()
        }
        LogoComponent(size = 55.dp)
        AppIconComponent(icon = R.drawable.like_icon)
    }

}