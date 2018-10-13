package parcial

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class TareaController {

    TareaService tareaService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond tareaService.list(params), model:[tareaCount: tareaService.count()]
    }

    def show(Long id) {
        respond tareaService.get(id)
    }

    def create() {
        respond new Tarea(params)
    }

    def save(Tarea tarea) {
        if (tarea == null) {
            notFound()
            return
        }

        try {
            tareaService.save(tarea)
        } catch (ValidationException e) {
            respond tarea.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'tarea.label', default: 'Tarea'), tarea.id])
                redirect tarea
            }
            '*' { respond tarea, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond tareaService.get(id)
    }

    def update(Tarea tarea) {
        if (tarea == null) {
            notFound()
            return
        }

        try {
            tareaService.save(tarea)
        } catch (ValidationException e) {
            respond tarea.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'tarea.label', default: 'Tarea'), tarea.id])
                redirect tarea
            }
            '*'{ respond tarea, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        tareaService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'tarea.label', default: 'Tarea'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'tarea.label', default: 'Tarea'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
