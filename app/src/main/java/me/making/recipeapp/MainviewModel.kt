package me.making.recipeapp

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import java.lang.Exception


class MainviewModel:ViewModel() {

     private val _categorystate = mutableStateOf(recipeStatee());
     val categorytate:State <recipeStatee> = _categorystate;
     init {
         fectcategories()
     }
    private fun fectcategories(){
        viewModelScope.launch {

            try {
               val response= recipeService.getCategories();
                _categorystate.value=_categorystate.value.copy(
                    list=response.categories,
                    loading=false,
                    error=null,
                )

            }catch (e:Exception){

                _categorystate.value=_categorystate.value.copy(
                    loading = false,
                    error="there is problem  of ${e.message}",
                    )

            }

        }
    }



}
data class recipeStatee(
    var loading:Boolean=true,
    val list:List<category> = emptyList(),
    var error: String?=null,

    )
