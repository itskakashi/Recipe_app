package me.making.recipeapp

data class category(val idCategory:String,
                    val strCategory : String ,
                    val strCategoryThumb: String,
                    val strCategoryDescription: String,
    )


data class CategoriesResponse(val categories:List<category>)