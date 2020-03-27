package controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/classes")
class ClassesController {

    @GetMapping("")
    fun getClasses(@PathVariable("day") day: Int,
                   @PathVariable("month") month: Int,
                   @PathVariable("year") year: Int): ClassesDTO {

    }

}