package me.making.recipeapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter


@Composable
fun recipeview(modifier: Modifier = Modifier){
   val recipeviewModel: MainviewModel= viewModel();
    val viewstate by recipeviewModel.categorytate;

    Box(modifier = Modifier.fillMaxSize()){

        when {
            viewstate.loading-> {
                CircularProgressIndicator(Modifier.align(Alignment.Center))
            }
            viewstate.error!=null-> { Text("Erroe occured",Modifier.align(Alignment.Center))}

            else-> {
                showcatagories(categories = viewstate.list)
            }
        }

    }
}
@Composable

fun showcatagories(categories:List<category>){

    LazyVerticalGrid(GridCells.Fixed(2),modifier =Modifier.fillMaxSize() ){

        items(categories){
                category ->
            CategoryItem(category = category);
        }

    }

}
@Composable
fun CategoryItem(category:category){
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally){

        Image(
            painter = rememberAsyncImagePainter(category.strCategoryThumb),
            contentDescription =null,
            Modifier.aspectRatio(1f)
            )
        Text(text = "${category.strCategory}",
            color = Color.Black,
            modifier =Modifier.padding(top=4.dp),
            style = TextStyle(fontWeight = FontWeight.Bold),

            )

    }
}