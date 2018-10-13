package parcial

import grails.gorm.services.Service

@Service(Tarea)
interface TareaService {

    Tarea get(Serializable id)

    List<Tarea> list(Map args)

    Long count()

    void delete(Serializable id)

    Tarea save(Tarea tarea)

}