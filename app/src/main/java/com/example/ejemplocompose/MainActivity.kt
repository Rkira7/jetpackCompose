package com.example.ejemplocompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.room.Delete
import coil.compose.rememberImagePainter
import com.example.ejemplocompose.Destinos.*
import com.example.ejemplocompose.model.User
import com.example.ejemplocompose.ui.theme.EjemplocomposeTheme
import com.valentinilk.shimmer.shimmer
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EjemplocomposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    NavigationHost()
                }
            }
        }
    }
}

@Composable
fun MyApp1(viewModel: UserViewModel = hiltViewModel(),
        navController: NavController
           //navegarInvetario:() -> Unit
) {

    val user by viewModel.users.observeAsState(arrayListOf())
    val isLoading by viewModel.isLoading.observeAsState(false)
    MyApp(onAddClick = {
        viewModel.addUser() },
        users = user,
        isLoading = isLoading,
        onDeleteClick = {
            viewModel.deleteUser(it)
        },
        navController = navController
        //navegarInvetario = navegarInvetario
    )


}

@Composable
fun MyApp(
    onAddClick: (()->Unit)? = null,
    onDeleteClick: ((toDelete: User)->Unit)? = null,
    users: List<User>,
    isLoading: Boolean,
    navController: NavController
    //navegarInvetario:() -> Unit
){
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Simple Rest + Room")},
                actions = {
                    IconButton(onClick = {
                        onAddClick?.invoke()

                    }){
                        Icon(Icons.Filled.Add, "Add")

                    }
                    IconButton(onClick = {
                        navController.navigate(PantallaInvetario.rutas)
                        //navegarInvetario()



                    }){
                        Icon(Icons.Filled.Home, "Home")

                    }
                }

            )

        }) {
            LazyColumn{
                var itemCount = users.size
                if(isLoading) itemCount++
                
                items(count = itemCount){ index ->
                    var auxIndex = index
                    if(isLoading){
                        if(auxIndex == 0)
                            return@items LoadingCard()
                        auxIndex--
                    }
                    val user = users[auxIndex]
                    Card(
                        shape = RoundedCornerShape(8.dp),
                        elevation = 1.dp,
                        modifier = Modifier
                            .padding(horizontal = 8.dp, vertical = 4.dp)
                            .fillMaxWidth())
                    {
                        Row(modifier = Modifier.padding(8.dp)) {
                            Image(
                                modifier = Modifier.size(50.dp),
                                painter = rememberImagePainter(
                                    data = user.thumbail,
                                    builder = {

                                    }),
                                contentDescription = null,
                                contentScale = ContentScale.FillHeight)
                            Spacer()
                            Column (
                                Modifier.weight(1f))
                            {
                                Text("${user.name} ${user.lastName}")
                                Text("${user.city}")

                            }
                            Spacer()

                            IconButton(onClick = {
                                onDeleteClick?.invoke(user)

                            }) {
                                Icon(Icons.Filled.Delete, "Remove")
                            }
                        }

                    }
                }

            }

    }
}

@Composable
fun LoadingCard(){
    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = 1.dp,
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 4.dp)
            .fillMaxWidth()
            .testTag("loadingCard")) 
    {
        Row(modifier = Modifier.padding(8.dp)) {
            ImageLoading()
            Spacer()
            Column {
                Box(modifier = Modifier
                    .height(15.dp)
                    .fillMaxWidth()
                    .background(Color.Gray))

                Spacer()

                Box(modifier = Modifier
                    .height(15.dp)
                    .fillMaxWidth()
                    .background(Color.Gray))

            }
        }

    }

}

@Composable
fun ImageLoading(){
    Box(modifier = Modifier.shimmer()){
        Box(modifier = Modifier
            .size(50.dp)
            .background(Color.Gray))
    }
}

@Composable
fun Spacer(size: Int = 8) = androidx.compose.foundation.layout.Spacer(modifier = Modifier.size(size.dp))

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    EjemplocomposeTheme {

    }
}