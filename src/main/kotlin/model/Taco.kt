package model

data class Taco(var name:String, var ingradients:List<Ingredient>?)
{
    constructor():this("",ArrayList<Ingredient>())
}
