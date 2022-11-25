package com.example.ejemplocompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter


@Composable
fun PantallaInventario(
){
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Inventario")},
                actions = {

                }
            )

        }) {
            Card(
                shape = RoundedCornerShape(8.dp),
                elevation = 1.dp,
                modifier = Modifier
                    .padding(horizontal = 8.dp, vertical = 4.dp)
                    .fillMaxWidth())
            {
                Row(modifier = Modifier.padding(8.dp)) {
                    Image(
                        modifier = Modifier.size(100.dp),
                        painter = rememberImagePainter(
                            data = "https://as01.epimg.net/meristation/imagenes/2021/10/09/noticias/1633762303_518152_1633762416_noticia_normal_recorte1.jpg",
                            builder = {

                            }),
                        contentDescription = null,
                        contentScale = ContentScale.FillHeight)

                    Spacer(size = 15)
                    Column (
                        Modifier.weight(1f))
                    {
                        Text("$ 1,521.00", color = Color.Blue, fontSize = 22.sp)
                        Spacer()
                        Text("Xiaomi Redmi Note 8 Pro", fontSize = 15.sp)
                        Spacer()
                        Row() {
                            Text("Disponibles: ", fontWeight = FontWeight.Bold)
                            Text("7")
                        }
                        Spacer()
                        Box(Modifier.size(20.dp)
                            .background(Color.Red, shape = RoundedCornerShape(30.dp))
                            .border(1.dp, Color.Gray, RoundedCornerShape(30.dp)))


                    }

                    Spacer()

                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                       )
                    {
                        Image(
                            modifier = Modifier.size(30.dp),
                            colorFilter = ColorFilter.lighting(Color.Gray, Color.Blue),
                            painter = rememberImagePainter(
                                data = "https://cdn.pixabay.com/photo/2013/07/12/14/53/cart-148964_960_720.png",
                                builder = {

                                }),
                            contentDescription = null,
                            contentScale = ContentScale.FillHeight)
                    }


                }

            }





    }
}
