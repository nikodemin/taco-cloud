package controller

import model.Ingredient
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.ui.Model;
import model.Ingredient.Type
import model.Taco
import org.springframework.web.bind.annotation.PostMapping


@Controller
@RequestMapping("/design")
class DesignTaco
{
    @GetMapping
    fun showDesignForm(model:Model) : String
    {
        val ingradients = listOf<Ingredient>(
                Ingredient("FLTO", "Flour Tortilla", Type.WRAP),
                Ingredient("COTO", "Corn Tortilla", Type.WRAP),
                Ingredient("GRBF", "Ground Beef", Type.PROTEIN),
                Ingredient("CARN", "Carnitas", Type.PROTEIN),
                Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIES),
                Ingredient("LETC", "Lettuce", Type.VEGGIES),
                Ingredient("CHED", "Cheddar", Type.CHEESE),
                Ingredient("JACK", "Monterrey Jack", Type.CHEESE),
                Ingredient("SLSA", "Salsa", Type.SAUCE),
                Ingredient("SRCR", "Sour Cream", Type.SAUCE))
        val types = Type.values()

        for(type in types)
        {
            model.addAttribute(type.toString().toLowerCase(),filterByType(ingradients,type))
        }
        model.addAttribute("design", Taco())

        return "design"
    }

    @PostMapping
    fun processDesign (design:Taco) : String
    {
        println(design)
        return "redirect:/orders/current";
    }

    private fun filterByType(ingradients:List<Ingredient>, type:Type): List<Ingredient>
    {
        return ingradients.filter { i -> i.type == type}
    }
}