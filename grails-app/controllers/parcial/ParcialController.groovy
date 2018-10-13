package parcial

import org.springframework.web.servlet.ModelAndView

class ParcialController {

    def index() {

        lista = Tarea.findAllByCompletada(completada: false)

        return new ModelAndView("index", [nocomplete:lista])

    }

    def completadas(){

        completadas = Tarea.findAllByCompletada(completada: true)

        return new ModelAndView("completadas", [completada:completadas])

    }
}
