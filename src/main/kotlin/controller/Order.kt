package controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import model.Order
import org.springframework.validation.Errors
import org.springframework.web.bind.annotation.PostMapping
import javax.validation.Valid


@Controller
@RequestMapping("/orders")
class Order
{
    @GetMapping("/current")
    fun orderForm(model:Model) : String
    {
        model.addAttribute("order",Order())
        return "orderForm"
    }

    @PostMapping
    fun processOrder(@Valid order: Order, errors:Errors): String
    {
        if(errors.hasErrors())
            return "orderForm"
        
        println("Order submitted: $order")
        return "redirect:/"
    }
}